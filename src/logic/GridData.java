package logic;

import data.MovingPiece;

public class GridData {

	private MovingPiece currentPiece;
	private int[][] data;
	private int[][] combinedData;

	public int[][] getData() {
		return data;
	}

	public void setData(int[][] data) {
		this.data = data;
	}

	public int[][] getCombinedData() {
		return combinedData;
	}

	public void setCombinedData(int[][] combinedData) {
		this.combinedData = combinedData;
	}

	public MovingPiece getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(MovingPiece currentPiece) {
		this.currentPiece = currentPiece;
	}

}
