package game.logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import game.logic.timer.TimeDelay;

public class Input implements KeyListener {
	private int xChange = 0;
	private boolean yChangeActive = false;	

	private boolean rotate = false;

	private TimeDelay horizontalDelay;
	private TimeDelay rotationDelay;

	public Input(long xDelayTime, long rDelayTime) {
		horizontalDelay = new TimeDelay(xDelayTime);
		rotationDelay = new TimeDelay(rDelayTime);
	}

	public boolean xDelayActive() {
		return horizontalDelay.isRunning();
	}

	public void xDelayStart() {		
		if (!horizontalDelay.isRunning()) {
			horizontalDelay.start();
		}
	}
	
	public boolean rDelayActive() {
		return rotationDelay.isRunning();
	}

	public void rDelayStart() {		
		if (!rotationDelay.isRunning()) {
			rotationDelay.start();
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
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_LEFT:
		case KeyEvent.VK_RIGHT:
			xChange = 0;
			break;
		case KeyEvent.VK_UP:
			rotate = false;
			break;
		case KeyEvent.VK_DOWN:			
			yChangeActive = false;
			break;
		}
	}

}
