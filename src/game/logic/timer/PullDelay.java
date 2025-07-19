package game.logic.timer;

/**
 * A specialized TimeDelay for handling the soft and hard drop timing in Tetris.
 * Supports speeding up and slowing down the drop interval.
 */
public class PullDelay extends TimeDelay {
    private boolean pullReady;
    private long originalTimeOut;
    private final long speedUpTimeout;
    private boolean speedUpActive;

    /**
     * Checks if the speed-up mode is currently active.
     *
     * @return true if speed-up is active, false otherwise
     */
    public boolean isSpeedUpActive() {
        return speedUpActive;
    }

    /**
     * Constructs a PullDelay with normal and speed-up timeouts.
     *
     * @param timeOut        the normal timeout duration in milliseconds
     * @param speedUpTimeout the speed-up timeout duration in milliseconds
     */
    public PullDelay(long timeOut, long speedUpTimeout) {
        super(timeOut);
        this.speedUpTimeout = speedUpTimeout;
    }

    /**
     * Starts the pull delay and resets the pull-ready flag.
     */
    @Override
    public void start() {
        pullReady = false;
        super.start();
    }

    /**
     * Returns whether the pull delay has completed and is ready for the next action.
     *
     * @return true if the pull delay is ready, false otherwise
     */
    public boolean isPullReady() {
        return pullReady;
    }

    /**
     * Activates speed-up mode, reducing the timeout to the speed-up value and restarting the timer.
     */
    public void speedUp() {
        originalTimeOut = getTimeOut();
        speedUpActive = true;
        setTimeOut(speedUpTimeout);		
        start();
    }

    /**
     * Deactivates speed-up mode and restores the original timeout value.
     */
    public void slowDown() {
        speedUpActive = false;
        setTimeOut(originalTimeOut);
    }
    
    /**
     * Called when the delay task completes. Sets the pull-ready flag to true.
     */
    @Override
    protected void taskDone() {		
        pullReady = true;
    }
}
