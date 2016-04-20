package main.gom;

import java.util.Random;

import main.CollisionGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Slime extends Entity {
	private int movementSpeed = 2, dir = 0, counter = 0;
	private boolean moveComplete = true;

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 0);
	}

	public void destroy() {
	}

	public void update(CollisionGrid collision) {
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
