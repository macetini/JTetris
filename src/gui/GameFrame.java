package gui;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.ParallelGroup;
import javax.swing.JFrame;

import meta.Config;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {

	private MainPanel leftPanel;
	private MainPanel rightPanel;
	private Grid grid;

	public GameFrame() {
		super(Config.NAME);

		addKeyListener(this);

		addComponenets();

		int frameWidth = 1000;// Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING_DOUBLE;
		int frameHeight = 1000;// Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING_DOUBLE * 2;
		setSize(frameWidth, frameHeight);

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		// getContentPane().setBackground(Colors.BACKGROUND_COLOR);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addComponenets() {
		Container pane = getContentPane();

		GroupLayout layout = new GroupLayout(pane);
		layout.setAutoCreateGaps(true);
		layout.setAutoCreateContainerGaps(true);
		pane.setLayout(layout);

		leftPanel = new MainPanel();
		rightPanel = new MainPanel();

		grid = new Grid();

		GroupLayout.SequentialGroup hGroup = layout.createSequentialGroup();
		hGroup.addGroup(layout.createParallelGroup().addComponent(leftPanel));
		hGroup.addGroup(layout.createParallelGroup().addComponent(grid));
		hGroup.addGroup(layout.createParallelGroup().addComponent(rightPanel));
		layout.setHorizontalGroup(hGroup);

		GroupLayout.SequentialGroup vGroup = layout.createSequentialGroup();
		ParallelGroup parallelGroup = layout.createParallelGroup(GroupLayout.Alignment.CENTER);
		parallelGroup.addComponent(leftPanel);
		parallelGroup.addComponent(grid);
		parallelGroup.addComponent(rightPanel);		
		vGroup.addGroup(parallelGroup);
		layout.setVerticalGroup(vGroup);

		pack();
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
