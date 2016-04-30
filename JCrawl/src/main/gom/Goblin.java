package main.gom;

import main.CollisionGrid;
import main.EntityGrid;

/**
 * The goblin
 * @author Fatih Tas
 *
 */
public class Goblin extends Enemy {
	
	private int movementSpeed = 2, counter = 0;
	private int routeLength;
	private boolean moveComplete = false;
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Goblin(int dimType) {
		super(dimType);
	}
	
	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = animate(dir, 0, 4);
		health = 3;
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
				break;
			case 1:
				dir = 3;
				break;
			case 2:
				dir = 0;
				break;
			case 3:
				dir = 1;
				break;
			}

			this.graphic = animate(dir, 0, 4);
			moveComplete = false;
			counter = 0;
		}
		
		if(!moveComplete) {
			if(!collisionCheck(dir, collision, movementSpeed)
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
