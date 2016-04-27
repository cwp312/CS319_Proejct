package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Orc extends Enemy {
	
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		frontImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 6);
		backImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(1, 6);
		this.graphic = frontImage;
		this.movementSpeed = 2;
	}

	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		update(collision, entities, "AI");
	}


}
