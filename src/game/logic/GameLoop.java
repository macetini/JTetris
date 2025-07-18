package game.logic;

import java.awt.Point;
import java.util.Arrays;

import data.GridData;
import data.MovingPieceData;
import game.gui.GameFrame;
import game.logic.timer.PullDelay;
import game.meta.Colors;
import game.meta.Config;
import game.meta.Tetraminos;

public class GameLoop {
	private GameFrame gameFrame;
	private Input input;
	private PullDelay pullDelay;
	private Collision collision;

	public GameLoop() {
		gameFrame = new GameFrame();
		
		input = new Input(Config.X_DELAY_TIME, Config.R_DELAY_TIME);
		gameFrame.addKeyListener(input);

		pullDelay = new PullDelay(Config.PULL_TIMEOUT, Config.PULL_STRONGER_TIMEOUT);
		pullDelay.start();

		collision = new Collision();

		run();
	}

	private MovingPieceData getNewMovingPiece() {
		MovingPieceData newPiece = new MovingPieceData();
		
		int randIndex = (int) Math.floor(Math.random() * Tetraminos.SHAPES.length);
		newPiece.setShapes(Tetraminos.SHAPES[randIndex]);
		
		int colorIndex = (int) Math.floor(Math.random() * Colors.SHAPE_COLORS.length);
		newPiece.setColor(colorIndex);
		
		newPiece.setPosition(Config.INIT_POSITION);

		return newPiece;
	}

	private int[][] addMovingPieceToData(MovingPieceData piece, int[][] data) {
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

	private boolean checkHorizontalMovement(MovingPieceData newPiece, int[][] data) {
		int xChange = input.getXInput();
		if (xChange != 0 && !input.xDelayActive()) {
			input.xDelayStart();
			newPiece.getPosition().x += xChange;
			return collision.checkHorizontalCoalision(newPiece, data);
		}
		return false;
	}

	private boolean checkVerticalMovement(MovingPieceData newPiece, int[][] data) {
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

		MovingPieceData currentPiece = gridData.getCurrentPiece();
		MovingPieceData newPiece = new MovingPieceData(currentPiece);
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
				newPiece =  new MovingPieceData(currentPiece);
			}
		}

		boolean collidedHorizontaly = checkHorizontalMovement(newPiece, data);
		if (collidedHorizontaly) {
			return gridData;
		}

		boolean collidedVerticaly = checkVerticalMovement(newPiece, data);

		gridData.setDirty(true);
		if (currentPiece.getPosition().y != 0 && currentPiece.isIdentical(newPiece)) {
			gridData.setDirty(false);
			return gridData;
		}

		if (!collidedVerticaly) {
			currentPiece = newPiece;
			gridData.setCurrentPiece(currentPiece);
			
			int[][] combinedData = addMovingPieceToData(currentPiece, data);
			gridData.setCombinedData(combinedData);
		} else {
			int[][] combinedData = addMovingPieceToData(currentPiece, data);
			gridData.setCombinedData(combinedData);
			
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

		MovingPieceData currentPiece = getNewMovingPiece();
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