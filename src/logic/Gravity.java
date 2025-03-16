package logic;

public class Gravity extends Thread {
	private boolean pull = false;
	private long timeoutDuration;
	
	public Gravity(long timeoutDuration) {		
		this.timeoutDuration = timeoutDuration;
	}
	
	public boolean isPullingDown() {
		if(pull) {
			pull = false;
			return true;
		}
		return false;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(timeoutDuration);
				pull = true;				
			} catch (InterruptedException e) {
				//System.out.println(e.getMessage());
			}
		}
	}

}
