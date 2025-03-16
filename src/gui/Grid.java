package gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import meta.Config;

@SuppressWarnings("serial")
public class Grid extends JPanel {

	private int[][] data;

	private void drawGrid(Graphics2D g2) {
		g2.setColor(Color.LIGHT_GRAY);

		for (int i = 0; i < Config.ROWS; i++) {
			for (int j = 0; j < Config.COLUMNS; j++) {
				int cellX = j * Config.CELL_SIZE + Config.GRID_PADDING;
				int cellY = i * Config.CELL_SIZE + Config.GRID_PADDING;

				g2.drawRect(cellX, cellY, Config.CELL_SIZE, Config.CELL_SIZE);
			}
		}
	}

	private void drawData(Graphics2D g2) {
		if (data != null) {
			for (int i = 0; i < data.length; i++) {
				for (int j = 0; j < data[i].length; j++) {
					if (data[i][j] != 0) {
						int cellX = j * Config.CELL_SIZE + Config.GRID_PADDING;
						int cellY = i * Config.CELL_SIZE + Config.GRID_PADDING;

						g2.setColor(Color.BLUE);
						g2.fillRect(cellX, cellY, Config.CELL_SIZE, Config.CELL_SIZE);

						g2.setColor(Color.WHITE);
						g2.drawRect(cellX, cellY, Config.CELL_SIZE, Config.CELL_SIZE);
					}
				}
			}
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);

		drawGrid(g2);
		drawData(g2);
	}
	
	public void dataProvider(int[][] data) {
		this.data = data;
		repaint(getVisibleRect());
	}
}
