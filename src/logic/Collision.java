package logic;

import java.awt.Point;

import data.MovingPieceData;
import meta.Config;

public class Collision {

	public boolean collidesWithGridData(MovingPieceData newPiece, int[][] data) {
		Point newPosition = newPiece.getPosition();
		int[][] currentShape = newPiece.getShape();

		for (int i = 0; i < currentShape.length; i++) {
			for (int j = 0; j < currentShape[i].length; j++) {
				if (currentShape[i][j] != 0) {
					int cellData = data[newPosition.y + i][newPosition.x + j];
					if (cellData != 0) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean collidesWithFloor(MovingPieceData newPiece) {
		Point newPosition = newPiece.getPosition();
		int[][] currentShape = newPiece.getShape();
		
		for (int i = 0; i < currentShape.length; i++) {
			for (int j = 0; j < currentShape[i].length; j++) {
				int cellData = currentShape[i][j];
				if (cellData != 0) {
					int shapePiecePosition = newPosition.y + i;
					if (shapePiecePosition >= Config.ROWS) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkVerticalCoalision(MovingPieceData newPiece, int[][] data) {
		return (collidesWithFloor(newPiece) || collidesWithGridData(newPiece, data));
	}

	public boolean collidesWithWall(MovingPieceData newPiece) {
		Point newPosition = newPiece.getPosition();
		int[][] currentShape = newPiece.getShape();

		for (int i = 0; i < currentShape.length; i++) {
			for (int j = 0; j < currentShape[i].length; j++) {
				int cellData = currentShape[i][j];
				if (cellData != 0) {
					int shapePiecePosition = newPosition.x + j;
					if (shapePiecePosition < 0 || shapePiecePosition >= Config.COLUMNS) {
						return true;
					}
				}
			}
		}
		return false;
	}

	public boolean checkHorizontalCoalision(MovingPieceData newPiece, int[][] data) {
		return (collidesWithWall(newPiece) || collidesWithGridData(newPiece, data));
	}
}
