package gui;

import java.awt.Insets;

import javax.swing.JFrame;

import meta.Config;

@SuppressWarnings("serial")
public class Main extends JFrame {
	
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
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);

		grid = new Grid();
		add(grid);		
	}
	
	public void dataProvider(int[][] data) {
		grid.dataProvider(data);
	}

}
