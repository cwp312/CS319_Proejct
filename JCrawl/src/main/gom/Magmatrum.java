package main.gom;

import java.util.Random;

import main.CollisionGrid;
import main.EntityGrid;

public class Magmatrum extends Enemy {

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = animate(dir, 0, 5);
		this.movementSpeed = 2;
	}

	
	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		update(collision, entities, "AI", 0, 5);
	}
	
	@Override
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
					entities.addData(generateFlame(xLoc, yLoc, dir));
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
}
