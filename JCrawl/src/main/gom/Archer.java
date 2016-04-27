package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class Archer extends Enemy {
	private int counter = 0, attackSpeed = 2;

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		frontImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 3);
		backImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(1, 3);
	}

	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		counter += attackSpeed;
		if(counter >= 100) {
			entities.addData(this.createProjectile(xLoc, yLoc, dir, "projectile"));
			initializeIndex(entities);
			counter = 0;
		}

		if (detectProjectileCollision(collision, entities, "p_projectile")) {
			if(health > 0) {
				health--;
			} else {
				entities.destroy(indice);
			}
		}
	}
	@Override
	public void setDir(int dir){
		this.dir = dir;
		this.graphic = (dir == 0) ? backImage : frontImage;
	}

}
