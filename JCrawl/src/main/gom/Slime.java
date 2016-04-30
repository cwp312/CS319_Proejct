package main.gom;

import main.CollisionGrid;
import main.EntityGrid;

/**
 * The slime
 * @author Cheol Woo Park
 *
 */
public class Slime extends Enemy {

	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Slime(int dimType) {
		super(dimType);
	}

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = animate(dir, 0, 1);
		this.movementSpeed = 2;
		health = 3;
	}

	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		update(collision, entities, "AI", 0, 1);
	}

}
