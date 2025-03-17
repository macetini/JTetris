package data;

public class GridData {
	private MovingPieceData currentPiece;
	private int[][] data;
	private int[][] combinedData;
	private boolean dirty;

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

	public MovingPieceData getCurrentPiece() {
		return currentPiece;
	}

	public void setCurrentPiece(MovingPieceData currentPiece) {
		this.currentPiece = currentPiece;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

}
