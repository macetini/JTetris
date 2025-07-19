package game.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import game.meta.Config;

/**
 * Main game window for the Tetris game.
 * Handles rendering the grid and processing window-level key events.
 */
public class GameFrame extends JFrame implements KeyListener {

    private final Grid grid;

    /**
     * Constructs the main game frame, initializes the window, and adds the grid component.
     */
    public GameFrame() {
        super(Config.NAME);

        init();

        grid = new Grid();
        add(grid);

        setVisible(true);
    }

    /**
     * Initializes the frame size, listeners, and default close operation.
     */
    private void init() {
        addKeyListener(this);

        int frameWidth = Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING * 4;
        int frameHeight = Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING * 6;
        setSize(frameWidth, frameHeight);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    /**
     * Provides grid data to the grid component for rendering.
     *
     * @param data the 2D array representing the current grid state
     */
    public void dataProvider(int[][] data) {
        grid.setData(data);
    }

    /**
     * Not used. Required by {@link KeyListener}.
     *
     * @param e the key event
     */
    @Override
    public void keyTyped(KeyEvent e) {
        // No implementation necessary. Not used.
    }

    /**
     * Handles key press events for the frame.
     * Closes the window if the Escape key is pressed.
     *
     * @param e the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            dispose();
        }
    }

    /**
     * Not used. Required by {@link KeyListener}.
     *
     * @param e the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        // No implementation necessary. Not used.
    }
}
