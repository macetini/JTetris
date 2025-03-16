package logic;

import java.awt.Point;
import java.util.Arrays;

import data.MovingPiece;
import gui.Main;
import logic.timer.PullDelay;
import logic.timer.TimeDelay;
import meta.Config;
import meta.Tetraminos;

public class Loop {
	private Main gameFrame;
	private Input input;
	private PullDelay pullDelay;
	private Collision collision;

	public Loop() {
		gameFrame = new Main();
		input = new Input(Config.X_DELAY_TIME, Config.R_DELAY_TIME);
		gameFrame.addKeyListener(input);

		pullDelay = new PullDelay(Config.PULL_TIMEOUT, Config.PULL_STRONGER_TIMEOUT);
		pullDelay.start();

		collision = new Collision();

		run();
	}

	private MovingPiece getNewMovingPiece() {
		MovingPiece newPiece = new MovingPiece();

		int randIndex = (int) Math.floor(Math.random() * Tetraminos.DATA.length);
		newPiece.setShapes(Tetraminos.DATA[randIndex]);

		newPiece.setPosition(Config.INIT_POSITION);

		return newPiece;
	}

	private int[][] addMovingPieceToData(MovingPiece piece, int[][] data) {
		Point currentPosition = piece.getPosition();
		int[][] currentShape = piece.getShape();

		int[][] combinedData = new int[Config.ROWS][Config.COLUMNS];
		for (int i = 0; i < data.length; i++) {
			combinedData[i] = Arrays.copyOf(data[i], data[i].length);
		}

		for (int i = 0; i < currentShape.length; i++) {
			for (int j = 0; j < currentShape[i].length; j++) {
				if (currentShape[i][j] != 0) {
					combinedData[currentPosition.y + i][currentPosition.x + j] = currentShape[i][j];
				}
			}
		}
		return combinedData;
	}

	private boolean checkHorizontalMovement(MovingPiece newPiece, int[][] data) {
		int xChange = input.getXInput();
		if (xChange != 0 && !input.xDelayActive()) {
			input.xDelayStart();
			newPiece.getPosition().x += xChange;
			return collision.checkHorizontalCoalision(newPiece, data);
		}
		return false;
	}

	private boolean checkVerticalMovement(MovingPiece newPiece, int[][] data) {
		if (input.getYInput()) {			
			if (!pullDelay.isSpeedUpActive()) {
				pullDelay.speedUp();
			}
		} else {
			if (pullDelay.isSpeedUpActive()) {
				pullDelay.slowDown();
			}
		}

		return collision.checkVerticalCoalision(newPiece, data);
	}

	private GridData updateAndGetGridData(GridData gridData) {
		int[][] data = gridData.getData();

		MovingPiece currentPiece = gridData.getCurrentPiece();
		MovingPiece newPiece = currentPiece.clone();
		if (pullDelay.isPullReady()) {
			if (!pullDelay.isRunning()) {
				pullDelay.start();
			}
			newPiece.moveDown();
		}

		if (input.getRotate() && !input.rDelayActive()) {
			input.rDelayStart();
			newPiece.rotatate();

			boolean rotationCollides = collision.collidesWithFloor(newPiece) || collision.collidesWithWall(newPiece)
					|| collision.collidesWithGridData(newPiece, data);

			if (rotationCollides) {
				newPiece = currentPiece.clone();
			}
		}

		boolean collidedHorizontaly = checkHorizontalMovement(newPiece, data);
		if (collidedHorizontaly) {
			return gridData;
		}

		boolean collidedVerticaly = checkVerticalMovement(newPiece, data);

		gridData.setDirty(true);
		if (currentPiece.getPosition().y != 0 && currentPiece.identical(newPiece)) {
			gridData.setDirty(false);
			return gridData;
		}

		if (!collidedVerticaly) {
			currentPiece = newPiece;
			gridData.setCurrentPiece(currentPiece);
		}

		int[][] combinedData = addMovingPieceToData(currentPiece, data);
		gridData.setCombinedData(combinedData);

		if (collidedVerticaly) {
			currentPiece = getNewMovingPiece();
			gridData.setCurrentPiece(currentPiece);
			gridData.setData(combinedData);
			return gridData;
		}

		gridData.setData(data);
		return gridData;
	}

	private GridData removeFullRows(GridData gridData) {
		int[][] data = gridData.getData();
		int[][] cleanData = new int[Config.ROWS][Config.COLUMNS];

		int k = data.length - 1;

		for (int i = data.length - 1; i >= 0; i--) {
			boolean fullRow = true;

			for (int j = data[i].length - 1; j >= 0; j--) {
				int cellData = data[i][j];
				if (cellData == 0) {
					fullRow = false;
					break;
				}
			}

			if (!fullRow) {
				for (int m = 0; m < data[i].length; m++) {
					cleanData[k][m] = data[i][m];
				}
				k--;
			}
		}
		gridData.setData(cleanData);
		return gridData;
	}

	private void renderGridData(GridData gridData) {
		if (gridData.isDirty()) {
			gameFrame.dataProvider(gridData.getCombinedData());
		}
	}

	private void run() {
		GridData gridData = new GridData();

		MovingPiece currentPiece = getNewMovingPiece();
		gridData.setCurrentPiece(currentPiece);

		int[][] emptyData = new int[Config.ROWS][Config.COLUMNS];
		gridData.setData(emptyData);

		while (true) {
			gridData = removeFullRows(gridData);
			gridData = updateAndGetGridData(gridData);
			renderGridData(gridData);
		}
	}
}
