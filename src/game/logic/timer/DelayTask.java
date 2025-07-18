package game.logic.timer;

import java.util.TimerTask;

public class DelayTask extends TimerTask {
	private boolean isDone = false;
	private TimeDelay owner;
	
	public DelayTask(TimeDelay owner) {
		this.owner = owner;
	}

	public boolean isDone() {
		return isDone;
	}
	
	@Override
	public void run() {
		isDone = true;
		owner.taskDone();
	}
}
