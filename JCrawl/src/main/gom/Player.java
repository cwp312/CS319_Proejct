package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.PlayerData;

public class Player extends Entity {

	private int health = 0, movementSpeed = 8, attackSpeed = 10,
			energy = 0, dir = 0;
	private PlayerData playerInfo = new PlayerData();

	// private Ability abilities[] = new Abilities[];

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new ImageLoader().load("player");
		indice = -1;
	}

	@Override
	public boolean destroy() {
		return true;
	}

	/**
	 * 
	 * @param collision
	 * @param keyPressed
	 */
	public void update(CollisionGrid collision, boolean[] keyPressed,
			EntityGrid entities) {
		if(energy < 120) {
			energy += attackSpeed;
		}
		
		if (keyPressed[0]) {
			if (!collisionCheck(0, collision, movementSpeed)) {
				updateMovement(0, movementSpeed);
				dir = 0;
			}
		}
		if (keyPressed[1]) {
			if (!collisionCheck(1, collision, movementSpeed)) {
				updateMovement(1, movementSpeed);
				dir = 1;
			}
		}
		if (keyPressed[2]) {
			if (!collisionCheck(2, collision, movementSpeed)) {
				updateMovement(2, movementSpeed);
				dir = 2;
			}
		}
		if (keyPressed[3]) {
			if (!collisionCheck(3, collision, movementSpeed)) {
				updateMovement(3, movementSpeed);
				dir = 3;
			}
		}
		if (keyPressed[4]) {
			if (energy >= 120) {
				energy = 0;
				entities.addData(createProjectile(xLoc, yLoc, dir));
				initializeIndex(entities);
			}
		}
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
	}
}
