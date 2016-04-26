package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Magmatrum extends Enemy {

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 0);
		this.movementSpeed = 2;
	}

	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		update(collision, entities, "AI");
	}


}
