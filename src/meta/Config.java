package meta;

import java.awt.Point;

public final class Config {

	public static final String NAME = "JTetris";

	public static final int ROWS = 20;
	public static final int COLUMNS = 15;

	public static final int CELL_SIZE = 25;

	public static final int GRID_PADDING = 10;
	public static final int GRID_PADDING_DOUBLE = 20;

	public static final Point INIT_POSITION = new Point(6, 0);
	
	public static final int X_DELAY_TIME = 110;	
	public static final int R_DELAY_TIME = 100;	
	 
	public static final int PULL_TIMEOUT = 1000;
	public static final int PULL_STRONGER_TIMEOUT = 35;
}
