package gui;

import java.awt.Insets;

import javax.swing.JFrame;

import meta.Colors;
import meta.Config;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

@SuppressWarnings("serial")
public class Main extends JFrame implements KeyListener {

	private Grid grid = new Grid();

	@Override
	public Insets getInsets() {
		return new Insets(Config.GRID_PADDING_DOUBLE, 0, 0, 0);
	}

	public Main() {
		super(Config.NAME);
		init();
	}

	private void init() {
		int frameWidth = Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING_DOUBLE;
		int frameHeight = Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING_DOUBLE * 2;

		setSize(frameWidth, frameHeight);
		
		addKeyListener(this);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		getContentPane().setBackground(Colors.BACKGROUND_COLOR);

		grid = new Grid();
		add(grid);
	}

	public void dataProvider(int[][] data) {
		grid.dataProvider(data);
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
