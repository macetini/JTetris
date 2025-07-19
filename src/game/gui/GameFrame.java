package game.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import game.meta.Config;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {

	private final Grid grid;

	public GameFrame() {
		super(Config.NAME);

		init();

		grid = new Grid();
		add(grid);

		setVisible(true);
	}

	private void init() {
		addKeyListener(this);

		int frameWidth = Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING * 4;
		int frameHeight = Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING * 6;
		setSize(frameWidth, frameHeight);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	public void dataProvider(int[][] data) {
		grid.setData(data);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// No implementation necessary. Not used.
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
			dispose();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// No implementation necessary. Not used.
	}
}
