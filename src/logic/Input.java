package logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import logic.timer.TimeDelay;

public class Input implements KeyListener {
	private int xChange = 0;
	private boolean yChangeActive = false;

	private boolean rotate = false;

	private TimeDelay verticalDelay;
	private TimeDelay horizontalDelay;

	public Input(long xDelayTime, long yDelayTime) {
		verticalDelay = new TimeDelay(xDelayTime);
		horizontalDelay = new TimeDelay(yDelayTime);
	}

	public boolean xDelayActive() {
		return verticalDelay.isRunning();
	}

	public void xDelayStart() {		
		if (!verticalDelay.isRunning()) {
			verticalDelay.start();
		}
	}

	public boolean yDelayActive() {
		return horizontalDelay.isRunning();
	}

	public void yDelayStart() {		
		if (!horizontalDelay.isRunning()) {
			horizontalDelay.start();
		}
	}

	public int getXInput() {
		return xChange;
	}

	public boolean getYInput() {
		return yChangeActive;
	}

	public boolean getRotate() {
		boolean retVal = rotate;
		rotate = false;

		return retVal;
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

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
		case KeyEvent.VK_SPACE:
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_DOWN:			
			yChangeActive = false;
			break;
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			xChange = 0;
			break;
		}
	}

}
