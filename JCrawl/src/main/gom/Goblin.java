package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Goblin extends Enemy {
	private int movementSpeed = 2, counter = 0;
	private int routeLength;
	private boolean moveComplete = false;
	
	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		frontImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 4);
		backImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(1, 4);
		
		if(this.xLoc == getX1()) {
			if(yLoc > getY1()) {
				dir = 0;
			} else {
				dir = 2;
			}
		} else if(this.yLoc == getY1()) {
			if(xLoc > getX1()) {
				dir = 1;
			} else {
				dir = 3;
			}
		}
		
		//setting initial graphics
		this.graphic = (dir == 0) ? backImage : frontImage;
		
		if(dir == 1 || dir == 3) {
			routeLength = Math.abs(xLoc - getX1());
		} else {
			routeLength = Math.abs(yLoc - getY1());
		}
	}

	@Override
	public void destroy(EntityGrid entities) {
	}

	@Override
	public void update(CollisionGrid collision, EntityGrid entities) {
		if(moveComplete) {
			switch(dir) {
			case 0:
				dir = 2;
				this.graphic = frontImage;
				break;
			case 1:
				dir = 3;
				break;
			case 2:
				dir = 0;
				this.graphic = backImage;
				break;
			case 3:
				dir = 1;
				break;
			}
			moveComplete = false;
			counter = 0;
		}
		
		if(!moveComplete) {
			if(collisionCheck(dir, collision, movementSpeed)
					|| ((counter / routeLength) < 1)
					&& !detectCollision(collision, dir, movementSpeed)) {
				counter += movementSpeed;
				updateMovement(dir, movementSpeed);
			} else {
				moveComplete = true;
			}
		}

		if (detectProjectileCollision(collision, entities, "p_projectile")) {
			if(health > 0) {
				health--;
			} else {
				entities.destroy(indice);
			}
		}
	}

}
