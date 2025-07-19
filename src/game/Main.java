package game;

import game.logic.GameLoop;

/**
 * Entry point for the Tetris game application.
 */
public class Main {

    /**
     * Launches the Tetris game.
     *
     * @param args command-line arguments (not used)
     */
    public static void main(String[] args) {
        GameLoop game = new GameLoop();
        game.run();
    }
}