package game.logic.timer;

import java.util.Timer;

/**
 * A timer utility for managing delays in the Tetris game.
 * Supports starting, stopping, and checking the status of a timed delay.
 */
public class TimeDelay extends Timer {
    private DelayTask task;
    private long timeOut;

    /**
     * Gets the current timeout value in milliseconds.
     *
     * @return the timeout duration in milliseconds
     */
    public long getTimeOut() {
        return timeOut;
    }

    /**
     * Sets the timeout value in milliseconds.
     *
     * @param timeOut the timeout duration in milliseconds
     */
    public void setTimeOut(long timeOut) {
        this.timeOut = timeOut;
    }
    
    /**
     * Checks if the delay is currently running.
     *
     * @return true if the delay is running, false otherwise
     */
    public boolean isRunning() {
        return task != null && !task.isDone();
    }

    /**
     * Constructs a TimeDelay with the specified timeout.
     *
     * @param timeOut the timeout duration in milliseconds
     */
    public TimeDelay(long timeOut) {
        this.timeOut = timeOut;
    }
    
    /**
     * Stops the current delay and cancels any scheduled task.
     */
    public void stop() {
        if (task != null) {
            task.cancel();
            task = null;
        }
        purge();
    }

    /**
     * Starts the delay timer. Stops any existing delay before starting a new one.
     */
    public void start() {
        stop();
        task = new DelayTask(this);
        schedule(task, timeOut);
    }
    
    /**
     * Called when the delay task completes.
     * Can be overridden by subclasses to provide custom behavior.
     */
    protected void taskDone() {	
        // Called when timeout runs out. To be overridden. 
    }
}
