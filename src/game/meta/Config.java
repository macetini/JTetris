package game.meta;

import java.awt.Point;

public final class Config {

	private Config() {
	}

	public static final String NAME = "JTetris";

	public static final int ROWS = 23;
	public static final int COLUMNS = 14;

	public static final int CELL_SIZE = 35;

	public static final int GRID_PADDING = 10;

	protected static final Point INIT_POSITION = new Point(6, 0);

	public static final int X_DELAY_TIME = 130;
	public static final int R_DELAY_TIME = 100;

	public static final int PULL_TIMEOUT = 1000;
	public static final int PULL_STRONGER_TIMEOUT = 35;
	
	public static Point getInitPosition() {
		return (Point)INIT_POSITION.clone();
	}
}
