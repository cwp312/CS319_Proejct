package main.gom;

import java.util.Random;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Slime extends Entity {
	private int movementSpeed = 2, counter = 0;
	private boolean moveComplete = true;

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 0);
		this.dir = 0;
	}

	public boolean destroy() {
		return false;
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		if(moveComplete) {
			dir = new Random().nextInt(4);
			counter = 0;
			moveComplete = false;
		}
		
		if(!moveComplete) {
			if(!collisionCheck(dir, collision, movementSpeed) && (counter / Entity.size < 1)) {
				counter += movementSpeed;
				updateMovement(dir, movementSpeed);
			} else {
				moveComplete = true;
			}
		}
	}

}
