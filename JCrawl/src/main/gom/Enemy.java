package main.gom;

import java.util.Random;

import main.CollisionGrid;
import main.EntityGrid;

public abstract class Enemy extends Entity {
	protected int health = 2, movementSpeed = 0, counter = 0, rem = 0;
	protected boolean moveComplete = true, buffer = false;

	protected boolean detectPlayerCollision() {
		return false;
	}

	protected void update(CollisionGrid collision, EntityGrid entities,
			String type, int x, int y) {
		if (type.equals("AI")) {
			
			if (moveComplete) {
				if(!detectCollision(collision, dir, movementSpeed)) {
					dir = new Random().nextInt(4);
				} else {
					reverseDir();
				}
				counter = 0;
				rem = 0;
				moveComplete = false;

				this.graphic = animate(dir, x, y);
			}

			if (!moveComplete) {
				if (!collisionCheck(dir, collision, movementSpeed)
						&& (counter / Entity.size + rem < 1)
						&& !detectCollision(collision, dir, movementSpeed)) {
						counter += movementSpeed;
						updateMovement(dir, movementSpeed);
				} else {
					if((counter % Entity.size) > 2) {
						rem = counter % Entity.size;
					}
					moveComplete = true;
				}
			}

			if (detectProjectileCollision(collision, entities, "p_projectile")) {
				if(health > 1) {
					health--;
				} else {
					entities.destroy(indice);
				}
			}
		}
	}
	
	protected void reverseDir() {
		dir = (dir + 2) % 3;
	}
}
