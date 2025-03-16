package logic.timer;

import java.util.Timer;

public class TimeDelay extends Timer {
	private DelayTask task;
	private long timeOut;

	public boolean isRunning() {
		return task != null && !task.isDone();
	}

	public TimeDelay(long timeOut) {
		this.timeOut = timeOut;
	}

	public void start() {
		if (task != null) {
			task.cancel();
			task = null;
		}
		purge();

		task = new DelayTask();
		schedule(task, timeOut);
	}

}
