package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;

public class Projectile extends Entity {

	private int movementSpeed = 8, dir;
	private static int size = 16;
	
	public Projectile(int dimType) {
		super(dimType);
		// TODO Auto-generated constructor stub
	}
	
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
	public void destroy(EntityGrid entities) {
		entities.destroy(indice);
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		if (collisionCheck(dir, collision, movementSpeed)) {
			destroy(entities);
		} else {
			updateMovement(dir, movementSpeed);
		}
	}

	public static int getSize() {
		return size;
	}
}
