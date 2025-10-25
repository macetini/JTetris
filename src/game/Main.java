package game;

import javax.swing.SwingUtilities; // Import the necessary utility
import game.logic.GameLoop;

/**
 * Entry point for the Tetris game application. Ensures the GUI components are
 * initialized on the Event Dispatch Thread (EDT).
 */
public class Main {

	/**
	 * Launches the Tetris game.
	 *
	 * @param args command-line arguments (not used)
	 */
	public static void main(String[] args) {
		// Use SwingUtilities.invokeLater to ensure that the creation and
		// initialization of the GameFrame (inside GameLoop) happens on the EDT.
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				// The GameLoop constructor will create the GameFrame here.
				GameLoop game = new GameLoop();

				// The game.run() method sets up a ScheduledExecutorService
				// which runs game logic off the EDT, which is acceptable
				// for the game update loop. It will call rendering methods
				// (like repaint) which will implicitly return to the EDT.
				game.run();
			}
		});
	}
}