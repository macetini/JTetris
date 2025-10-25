package game.data;

import game.meta.Config;

/**
 * Holds the state of the Tetris game grid, including the current moving piece,
 * the static grid data, the combined grid (with the moving piece), and a dirty flag.
 */
public class GridData {
    /** The currently active moving piece. */
    private MovingPieceData currentPiece;
    /** The static grid data (without the moving piece). */
    private int[][] data;
    /** The combined grid data (with the moving piece). */
    private int[][] combinedData;
    /** Indicates whether the grid data has changed and needs to be redrawn. */
    private boolean dirty;
    /** Indicates if the game is over. */
    private boolean gameOver;
    
    /**
     * Initializes a new GridData instance with empty grid data.
     */
    public void initNewData() {
    	int[][] emptyData = new int[Config.ROWS][Config.COLUMNS];
    	setData(emptyData);
    	
    	dirty = false;
    	gameOver = false;
    }

    /**
     * Gets the static grid data (without the moving piece).
     *
     * @return the 2D array representing the grid state
     */
    public int[][] getData() {
        return data;
    }

    /**
     * Sets the static grid data (without the moving piece).
     *
     * @param data the 2D array representing the grid state
     */
    public void setData(int[][] data) {
        this.data = data;
    }

    /**
     * Gets the combined grid data (with the moving piece).
     *
     * @return the 2D array representing the combined grid state
     */
    public int[][] getCombinedData() {
        return combinedData;
    }

    /**
     * Sets the combined grid data (with the moving piece).
     *
     * @param combinedData the 2D array representing the combined grid state
     */
    public void setCombinedData(int[][] combinedData) {
        this.combinedData = combinedData;
    }

    /**
     * Gets the currently active moving piece.
     *
     * @return the current moving piece
     */
    public MovingPieceData getCurrentPiece() {
        return currentPiece;
    }

    /**
     * Sets the currently active moving piece.
     *
     * @param currentPiece the moving piece to set
     */
    public void setCurrentPiece(MovingPieceData currentPiece) {
        this.currentPiece = currentPiece;
    }

    /**
     * Checks if the grid data is marked as dirty (needs redraw).
     *
     * @return true if the grid data is dirty, false otherwise
     */
    public boolean isDirty() {
        return dirty;
    }

    /**
     * Sets the dirty flag for the grid data.
     *
     * @param dirty true if the grid data needs to be redrawn, false otherwise
     */
    public void setDirty(boolean dirty) {
        this.dirty = dirty;
    }
    
    public boolean isGameOver() {
    	return gameOver;
    }
    
    public void setGameOver() {
    	gameOver = true;
    }

}
