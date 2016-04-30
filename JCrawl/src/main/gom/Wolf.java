package main.gom;

import main.CollisionGrid;
import main.EntityGrid;

/**
 * The wolf
 * @author Mustafa Fidan
 *
 */
public class Wolf extends Enemy {
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Wolf(int dimType) {
		super(dimType);
	}

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = animate(dir, 0, 2);
		this.movementSpeed = 4;
		health = 2;
	}

	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		update(collision, entities, "AI", 0 , 2);	
	}


}
