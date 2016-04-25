package main.im;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.gmm.GameManager;

public class InputManager implements KeyListener {
	/*
	 * 0 - W 1 - A 2 - S 3 - D
	 */
	private boolean keyPressed[] = { false, false, false, false, false, false,
			false };

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			keyPressed[0] = true;
			break;
		case KeyEvent.VK_A:
			keyPressed[1] = true;
			break;
		case KeyEvent.VK_S:
			keyPressed[2] = true;
			break;
		case KeyEvent.VK_D:
			keyPressed[3] = true;
			break;
		case KeyEvent.VK_Z:
			keyPressed[4] = true;
			break;
		case KeyEvent.VK_ESCAPE:
			keyPressed[6] = true;
			break;
		}
		GameManager.setKeyPressed(keyPressed);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_W:
			keyPressed[0] = false;
			break;
		case KeyEvent.VK_A:
			keyPressed[1] = false;
			break;
		case KeyEvent.VK_S:
			keyPressed[2] = false;
			break;
		case KeyEvent.VK_D:
			keyPressed[3] = false;
			break;
		case KeyEvent.VK_Z:
			keyPressed[4] = false;
			break;
		case KeyEvent.VK_ESCAPE:
			keyPressed[6] = false;
			break;
		}
		GameManager.setKeyPressed(keyPressed);
	}

	public void keyTyped(KeyEvent arg0) {
	}
}
