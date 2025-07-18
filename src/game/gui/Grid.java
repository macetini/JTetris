package game.gui;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import game.meta.Colors;
import game.meta.Config;

@SuppressWarnings("serial")
public class Grid extends JPanel {

	public Grid() {
		setBackground(Colors.BACKGROUND_COLOR);
	}

	private int[][] data;

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

	private void fillAllRectangles(Graphics2D g2, int colorIndex) {
		g2.setColor(Colors.SHAPE_COLORS[colorIndex - 1]);

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

	private void drawData(Graphics2D g2) {
		if (data != null) {
			for (int i = 1; i <= Colors.SHAPE_COLORS.length; i++) {
				fillAllRectangles(g2, i);
			}
			drawAllRectangles(g2);
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		super.paintComponent(g);

		drawDebugGrid(g2);
		drawData(g2);
	}

	public void setData(int[][] data) {
		this.data = data;
		repaint(getVisibleRect());
	}

}