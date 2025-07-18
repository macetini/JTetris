package game.logic.timer;

public class PullDelay extends TimeDelay {
	private boolean pullReady;
	private long originalTimeOut;
	private long speedUpTimeout;
	private boolean speedUpActive;

	public boolean isSpeedUpActive() {
		return speedUpActive;
	}

	public PullDelay(long timeOut, long speedUpTimeout) {
		super(timeOut);
		this.speedUpTimeout = speedUpTimeout;
	}

	@Override
	public void start() {
		pullReady = false;
		super.start();
	}

	public boolean isPullReady() {
		return pullReady;
	}

	public void speedUp() {
		originalTimeOut = getTimeOut();
		speedUpActive = true;
		setTimeOut(speedUpTimeout);		
		start();
	}

	public void slowDown() {
		speedUpActive = false;
		setTimeOut(originalTimeOut);
	}
	
	@Override
	protected void taskDone() {		
		pullReady = true;
	}
}
