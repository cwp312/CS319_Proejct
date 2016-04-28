package main.gom;

import java.awt.image.BufferedImage;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

public abstract class DependentObject extends Entity {

	public void destroy(EntityGrid entities) {
		entities.destroy(indice);
	}
	
	public void update(CollisionGrid collision, EntityGrid entities) {
		for(int i = 0; i < 4; i++) {
			if(detectPlayerCollision(collision, i, 0)) {
				performBehavior(entities);
			}
		}
	}
	
	protected abstract void performBehavior(EntityGrid entities);
	
	protected BufferedImage initGraphics(int x, int y) {
		return new SpriteSheet(new ImageLoader().load("objects")).crop(x, y);
	}
	
	protected boolean detectPlayerCollision(CollisionGrid collision, int dir,
			int movementSpeed) {
		boolean b = false;
		int compX = 0, compY = 0;

		for (int i = 0; i < collision.getPixelCollision().size(); i++) {
			if (collision.getPixelCollision().get(i).getKey().equals("player")) {
				compX = collision.getPixelCollision().get(i).getX();
				compY = collision.getPixelCollision().get(i).getY();

				if ((compX != xLoc) && (compY != yLoc)) {
					switch (dir) {
					case 0:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					case 1:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					case 2:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					case 3:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					}
				}
			}
		}

		return b;
	}
}
