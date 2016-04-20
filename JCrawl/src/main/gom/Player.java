package main.gom;

import main.CollisionGrid;
import main.ImageLoader;
import main.PlayerData;

public class Player extends Entity {

	private int health = 0, movementSpeed = 8, attackSpeed = 0;
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
			if (!collisionCheck(0, collision, movementSpeed)) {
				updateMovement(0, movementSpeed);
			}
		}
		if (keyPressed[1]) {
			if (!collisionCheck(1, collision, movementSpeed)) {
				updateMovement(1, movementSpeed);
			}
		}
		if (keyPressed[2]) {
			if (!collisionCheck(2, collision, movementSpeed)) {
				updateMovement(2, movementSpeed);
			}
		}
		if (keyPressed[3]) {
			if (!collisionCheck(3, collision, movementSpeed)) {
				updateMovement(3, movementSpeed);
			}
		}
	}

	public void update(CollisionGrid collision) {
	}
}
