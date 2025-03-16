package logic.timer;

import java.util.TimerTask;

public class DelayTask extends TimerTask {
	private boolean isDone = false;

	public boolean isDone() {
		return isDone;
	}

	@Override
	public void run() {
		isDone = true;
		//this.cancel();
	}
}
