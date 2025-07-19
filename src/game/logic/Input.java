package game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.logic.timer.TimeDelay;

/**
 * Handles keyboard input for the Tetris game, including movement and rotation.
 * Implements {@link KeyListener} to process key events.
 */
public class Input implements KeyListener {
    private int xChange = 0;
    private boolean yChangeActive = false;

    private boolean rotate = false;

    private final TimeDelay horizontalDelay;
    private final TimeDelay rotationDelay;

    /**
     * Constructs an Input handler with specified delay times for movement and rotation.
     *
     * @param xDelayTime delay time for horizontal movement in milliseconds
     * @param rDelayTime delay time for rotation in milliseconds
     */
    public Input(long xDelayTime, long rDelayTime) {
        horizontalDelay = new TimeDelay(xDelayTime);
        rotationDelay = new TimeDelay(rDelayTime);
    }

    /**
     * Checks if the horizontal movement delay is active.
     *
     * @return true if the horizontal delay is running, false otherwise
     */
    public boolean xDelayActive() {
        return horizontalDelay.isRunning();
    }

    /**
     * Starts the horizontal movement delay if not already running.
     */
    public void xDelayStart() {
        if (!horizontalDelay.isRunning()) {
            horizontalDelay.start();
        }
    }

    /**
     * Checks if the rotation delay is active.
     *
     * @return true if the rotation delay is running, false otherwise
     */
    public boolean rDelayActive() {
        return rotationDelay.isRunning();
    }

    /**
     * Starts the rotation delay if not already running.
     */
    public void rDelayStart() {
        if (!rotationDelay.isRunning()) {
            rotationDelay.start();
        }
    }

    /**
     * Gets the current horizontal input direction.
     *
     * @return -1 for left, 1 for right, 0 for no movement
     */
    public int getXInput() {
        return xChange;
    }

    /**
     * Checks if the downward movement (soft drop) is active.
     *
     * @return true if the down key is pressed, false otherwise
     */
    public boolean getYInput() {
        return yChangeActive;
    }

    /**
     * Checks if the rotate action was triggered.
     * Resets the rotate flag after returning.
     *
     * @return true if rotate was triggered, false otherwise
     */
    public boolean getRotate() {
        boolean retVal = rotate;
        rotate = false;

        return retVal;
    }

    /**
     * Not used. Required by {@link KeyListener}.
     */
    @Override
    public void keyTyped(KeyEvent e) {
        //Required for KeyListener interface. Not used.  
    }

    /**
     * Handles key press events for movement and rotation.
     *
     * @param e the KeyEvent triggered by a key press
     */
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
            xChange = -1;
            break;
        case KeyEvent.VK_RIGHT:
            xChange = 1;
            break;
        case KeyEvent.VK_UP:
            rotate = true;
            break;
        case KeyEvent.VK_DOWN:
            yChangeActive = true;
            break;
        default:
        }
    }

    /**
     * Handles key release events for movement and rotation.
     *
     * @param e the KeyEvent triggered by a key release
     */
    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
        case KeyEvent.VK_LEFT:
        case KeyEvent.VK_RIGHT:
            xChange = 0;
            break;
        case KeyEvent.VK_UP:
            rotate = false;
            break;
        case KeyEvent.VK_DOWN:
            yChangeActive = false;
            break;
        default:
        }
    }

}
