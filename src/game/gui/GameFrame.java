package game.gui;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JRootPane;
import javax.swing.KeyStroke;

import game.meta.Config;

/**
 * Main game window for the Tetris game.
 * Handles rendering the grid and processing window-level key events.
 */
public class GameFrame extends JFrame {

    /**
	 * */
	private static final long serialVersionUID = -2315685653973684988L;
	private  Grid grid;

    /**
     * Constructs the main game frame, initializes the window, and adds the grid component.
     */
    public GameFrame() {
        super(Config.NAME);

        init();

        grid = new Grid();
        add(grid);
        
        // Setup Key Bindings for reliable window-level input
        setupKeyBindings();

        setVisible(true);
        
    }

    /**
     * Initializes the frame size, listeners, and default close operation.
     */
    private void init() {
        int frameWidth = Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING * 4;
        int frameHeight = Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING * 6;
        setSize(frameWidth, frameHeight);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    
    /**
     * Configures a key binding to reliably handle the ESC key press 
     * for closing the window, regardless of which component has focus.
     */
    private void setupKeyBindings() {
        JRootPane rootPane = this.getRootPane();
        InputMap inputMap = rootPane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = rootPane.getActionMap();
        
        KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
        String escapeActionName = "closeWindow";
        inputMap.put(escapeKeyStroke, escapeActionName);

        actionMap.put(escapeActionName, new AbstractAction() {
            private static final long serialVersionUID = 1L;
            @Override
            public void actionPerformed(ActionEvent e) {                
                dispose(); 
            }
        });
    }

    /**
     * Provides grid data to the grid component for rendering.
     *
     * @param data the 2D array representing the current grid state
     */
    public void dataProvider(int[][] data) {
        grid.setData(data);
    }
}