package main.gom;

import main.CollisionGrid;
import main.ImageLoader;
import main.PlayerData;

public class Player extends Entity {

	private int health = 0, movementSpeed = 4, attackSpeed = 0;
	private PlayerData playerInfo = new PlayerData();

	// private Ability abilities[] = new Abilities[];

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new ImageLoader().load("player");
	}

	@Override
	public void destroy() {
		// TODO Implement it
	}

	/**
	 * 
	 * @param collision
	 * @param keyPressed
	 */
	public void update(CollisionGrid collision, boolean[] keyPressed) {
		if (keyPressed[0]) {
			updateMovement(0);
		}
		if (keyPressed[1]) {
			updateMovement(1);
		}
		if (keyPressed[2]) {
			updateMovement(2);
		}
		if (keyPressed[3]) {
			updateMovement(3);
		}
	}

	public void update(CollisionGrid collision) {
	}

	private void updateMovement(int keyCode) {
		switch (keyCode) {
		case 0:
			this.yLoc -= movementSpeed;
			break;
		case 1:
			this.xLoc -= movementSpeed;
			break;
		case 2:
			this.yLoc += movementSpeed;
			break;
		case 3:
			this.xLoc += movementSpeed;
			break;
		}
	}
}
