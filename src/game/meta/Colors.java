package game.meta;

import java.awt.Color;

/**
 * Utility class for color definitions used in the Tetris game.
 */
public class Colors {
    
    /**
     * Private constructor to prevent instantiation.
     */
    private Colors() {}
                                                    
    /** Background color of the game grid (Timberwolf Gray). */
    public static final Color BACKGROUND_COLOR = new Color(219,215,210);
    
    /**
     * Array of colors for the tetromino shapes.
     * Includes: Lightsabre Blue, Grass Green, Dark Yellow, Burnt Orange, Amaranth Red, Plum Purple.
     */
    protected static final Color[] SHAPE_COLORS = { 
        new Color(46,103,248),    // Lightsabre Blue
        new Color(0, 154, 23),    // Grass Green
        new Color(246, 190, 0),   // Dark Yellow
        new Color(203, 96, 21),   // Burnt Orange
        new Color(244, 54, 76),   // Amaranth Red
        new Color(156, 80, 182)   // Plum Purple
    };
    
    /** Outline color for tetromino shapes. */
    public static final Color SHAPE_RECT_COLOR = Color.BLACK;
    
    /** Color for the debug grid overlay. */
    public static final Color DEBUG_GRID_COLOR = Color.LIGHT_GRAY;
    
    /**
     * Returns a clone of the array of tetromino shape colors.
     *
     * @return a clone of the shape colors array
     */
    public static Color[] getColors() {
        return SHAPE_COLORS.clone();
    }
}
