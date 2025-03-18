package gui;

import java.awt.Container;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.JFrame;

import meta.Colors;
import meta.Config;

@SuppressWarnings("serial")
public class GameFrame extends JFrame implements KeyListener {

	private MainPanel leftPanel;
	private MainPanel rightPanel;
	private Grid grid;

//	@Override
//	public Insets getInsets() {
//		return new Insets(Config.GRID_PADDING_DOUBLE, 0, 0, 0);
//	}

	public GameFrame() {
		super(Config.NAME);

		addKeyListener(this);

		addComponenets();

		int frameWidth = 1000;// Config.CELL_SIZE * Config.COLUMNS + Config.GRID_PADDING_DOUBLE;
		int frameHeight = 1000;// Config.CELL_SIZE * Config.ROWS + Config.GRID_PADDING_DOUBLE * 2;
		setSize(frameWidth, frameHeight);

		setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
		//getContentPane().setBackground(Colors.BACKGROUND_COLOR);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addComponenets() {
		leftPanel = new MainPanel();
		rightPanel = new MainPanel();

		Container pane = getContentPane();
		
		GroupLayout groupLayout = new GroupLayout(pane);
		groupLayout.setAutoCreateGaps(true);
		groupLayout.setAutoCreateContainerGaps(true);
        pane.setLayout(groupLayout); 

		grid = new Grid();

		groupLayout.setHorizontalGroup(
				groupLayout.createSequentialGroup()
					.addComponent(leftPanel)
					.addComponent(grid)
					.addComponent(rightPanel)	
					
//						.addGroup
//						(
//							groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
//							.addComponent(grid)
//							//.addComponent(mainPanel)
//						)
					);

		groupLayout.setVerticalGroup(
				groupLayout.createParallelGroup()
					.addComponent(leftPanel)
					.addComponent(grid)
					.addComponent(rightPanel)
					
//					.addGroup
//					(
//							groupLayout.createParallelGroup(GroupLayout.Alignment.CENTER)
//							.addComponent(grid)
//							//.addComponent(mainPanel)
//					)
				);
		
		pack();

//		mainPanel.setLayout(groupLayout);
//		getContentPane().add(mainPanel, BorderLayout.CENTER);
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
