package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Archer extends Entity {
	private int counter = 0, attackSpeed = 2;

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 0);
	}

	public boolean destroy() {
		return false;
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		counter += attackSpeed;
		if(counter >= 100) {
			entities.addData(this.createProjectile(xLoc, yLoc, dir));
			initializeIndex(entities);
			counter = 0;
		}
	}

}
