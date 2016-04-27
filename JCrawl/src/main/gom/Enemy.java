package main.gom;

import java.awt.image.BufferedImage;
import java.util.Random;

import main.CollisionGrid;
import main.EntityGrid;

public abstract class Enemy extends Entity {
	protected int health = 4, movementSpeed = 0, counter = 0, rem = 0;
	protected boolean moveComplete = true, buffer = false;
	protected BufferedImage frontImage, backImage;
	private boolean isLookingDown = true;
	protected boolean detectPlayerCollision() {
		return false;
	}

	protected void update(CollisionGrid collision, EntityGrid entities,
			String type) {
		if (type.equals("AI")) {
			
			if (moveComplete) {
				dir = new Random().nextInt(4);
				//Update the graphics only if current one is wrong
				if(dir == 0 && isLookingDown){
					this.graphic = backImage;
					isLookingDown = false;
				}
				if(dir == 2 && !isLookingDown){
					this.graphic = frontImage;
					isLookingDown = true;
				}
				
				counter = 0;
				rem = 0;
				moveComplete = false;
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
	
}
