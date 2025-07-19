package game.logic.timer;

import java.util.TimerTask;

/**
 * A TimerTask that signals completion of a delay for a {@link TimeDelay} owner.
 */
public class DelayTask extends TimerTask {
    private boolean isDone = false;
    private final TimeDelay owner;

    /**
     * Constructs a DelayTask associated with the given TimeDelay owner.
     *
     * @param owner the TimeDelay instance that owns this task
     */
    public DelayTask(TimeDelay owner) {
        this.owner = owner;
    }

    /**
     * Returns whether the delay task has completed.
     *
     * @return true if the task is done, false otherwise
     */
    public boolean isDone() {
        return isDone;
    }
    
    /**
     * Marks the task as done and notifies the owner.
     * This method is called when the timer expires.
     */
    @Override
    public void run() {
        isDone = true;
        owner.taskDone();
    }
}
