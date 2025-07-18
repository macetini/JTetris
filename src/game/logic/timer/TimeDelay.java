package game.logic.timer;

import java.util.Timer;

public class TimeDelay extends Timer {
	private DelayTask task;
	private long timeOut;

	public long getTimeOut() {
		return timeOut;
	}

	public void setTimeOut(long timeOut) {
		this.timeOut = timeOut;
	}
	
	public boolean isRunning() {
		return task != null && !task.isDone();
	}

	public TimeDelay(long timeOut) {
		this.timeOut = timeOut;
	}
	
	public void stop() {
		if (task != null) {
			task.cancel();
			task = null;
		}
		purge();
	}

	public void start() {
		stop();
		task = new DelayTask(this);
		schedule(task, timeOut);
	}
	
	protected void taskDone() {
	}
}
