package game.meta;

import java.awt.Point;

/**
 * Configuration constants for the Tetris game.
 * This class cannot be instantiated.
 */
public final class Config {

    /**
     * Private constructor to prevent instantiation.
     */
    private Config() {
    }

    /** The name of the game. */
    public static final String NAME = "JTetris";
    
    public static final int RENDER_TIMEOUT = 25; 

    /** Number of rows in the game grid. */
    public static final int ROWS = 23;
    /** Number of columns in the game grid. */
    public static final int COLUMNS = 14;

    /** Size of each cell in pixels. */
    public static final int CELL_SIZE = 35;

    /** Padding around the grid in pixels. */
    public static final int GRID_PADDING = 10;

    /** Initial position of a new tetromino. */
    protected static final Point INIT_POSITION = new Point(6, 0);

    /** Delay time for horizontal movement (milliseconds). */
    public static final int X_DELAY_TIME = 130;
    /** Delay time for rotation (milliseconds). */
    public static final int R_DELAY_TIME = 100;

    /** Timeout for soft drop (milliseconds). */
    public static final int PULL_TIMEOUT = 1000;
    /** Timeout for hard drop (milliseconds). */
    public static final int PULL_STRONGER_TIMEOUT = 35;
    
    /**
     * Returns a clone of the initial position for a new tetromino.
     *
     * @return a clone of the initial position {@link Point}
     */
    public static Point getInitPosition() {
        return (Point)INIT_POSITION.clone();
    }
}