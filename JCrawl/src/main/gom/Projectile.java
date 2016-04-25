package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;

public class Projectile extends Entity {
	private int movementSpeed = 8, dir;
	private static int size = 16;
	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.graphic = new ImageLoader().load("projectile");
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	@Override
	public boolean destroy() {
		return true;
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		if (collisionCheck(dir, collision, movementSpeed)) {
			entities.destroy(indice);
		} else {
			updateMovement(dir, movementSpeed);
		}
	}

	public static int getSize() {
		return size;
	}
}
