package game.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.meta.Colors;
import game.meta.Config;

/**
 * A Swing component that displays the Tetris game grid.
 * Handles rendering of the grid, filled cells, and debug overlays.
 */
public class Grid extends JPanel {

    /**
     * Constructs a new Grid panel and sets its background color.
     */
    public Grid() {
        setBackground(Colors.BACKGROUND_COLOR);
    }

    /**
     * The 2D array representing the current state of the grid.
     * Each cell contains an integer indicating the color index or 0 for empty.
     */
    private int[][] data;

    /**
     * Draws a debug grid overlay to visualize cell boundaries.
     *
     * @param g2 the Graphics2D context to draw on
     */
    // @SuppressWarnings("unused")
    private void drawDebugGrid(Graphics2D g2) {
        g2.setColor(Colors.DEBUG_GRID_COLOR);

        for (int i = 0; i < Config.ROWS; i++) {
            for (int j = 0; j < Config.COLUMNS; j++) {
                int cellX = j * Config.CELL_SIZE + Config.GRID_PADDING;
                int cellY = i * Config.CELL_SIZE + Config.GRID_PADDING;

                g2.drawRect(cellX, cellY, Config.CELL_SIZE, Config.CELL_SIZE);
            }
        }
    }

    /**
     * Fills all rectangles in the grid that match the specified color index.
     *
     * @param g2        the Graphics2D context to draw on
     * @param colorIndex the color index to fill
     */
    private void fillAllRectangles(Graphics2D g2, int colorIndex) {
        g2.setColor(Colors.getColors()[colorIndex - 1]);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                int cellData = data[i][j];
                if (cellData == colorIndex) {
                    int cellX = j * Config.CELL_SIZE + Config.GRID_PADDING;
                    int cellY = i * Config.CELL_SIZE + Config.GRID_PADDING;
                    g2.fillRect(cellX, cellY, Config.CELL_SIZE, Config.CELL_SIZE);
                }
            }
        }
    }

    /**
     * Draws the outlines of all non-empty rectangles in the grid.
     *
     * @param g2 the Graphics2D context to draw on
     */
    private void drawAllRectangles(Graphics2D g2) {
        g2.setColor(Colors.SHAPE_RECT_COLOR);

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] != 0) {
                    int cellX = j * Config.CELL_SIZE + Config.GRID_PADDING;
                    int cellY = i * Config.CELL_SIZE + Config.GRID_PADDING;
                    g2.drawRect(cellX, cellY, Config.CELL_SIZE, Config.CELL_SIZE);
                }
            }
        }
    }

    /**
     * Draws all filled and outlined rectangles based on the current grid data.
     *
     * @param g2 the Graphics2D context to draw on
     */
    private void drawData(Graphics2D g2) {
        if (data != null) {
            for (int i = 1; i <= Colors.getColors().length; i++) {
                fillAllRectangles(g2, i);
            }
            drawAllRectangles(g2);
        }
    }

    /**
     * Paints the grid component, including the debug grid and cell data.
     *
     * @param g the Graphics context to paint on
     */
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        super.paintComponent(g);

        drawDebugGrid(g2);
        drawData(g2);
    }

    /**
     * Sets the grid data and triggers a repaint.
     *
     * @param data a 2D array representing the grid's state
     */
    public void setData(int[][] data) {
        this.data = data;
        repaint(getVisibleRect());
    }

}