package game.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

import game.meta.Config;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {

	private Grid grid;

	public GameFrame() {
		super(Config.NAME);

		addKeyListener(this);

		int frameWidth = Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING * 4;
		int frameHeight = Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING * 6;
		setSize(frameWidth, frameHeight);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		grid = new Grid();
		add(grid);

		setVisible(true);
	}

	public void dataProvider(int[][] data) {
		grid.setData(data);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_ESCAPE:
			dispose();
			break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}
}
