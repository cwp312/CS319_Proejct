package main.gom;

import main.CollisionGrid;
import main.EntityGrid;

/**
 * The skeleton archer
 * @author Arda Yucel
 *
 */
public class Archer extends Enemy {

	private int counter = 0, attackSpeed = 2;
	private boolean init = false;

	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Archer(int dimType) {
		super(dimType);
	}

	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = animate(dir, 0, 3);
		health = 3;
	}

	public void destroy(EntityGrid entities) {
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
		if (!init) {
			init = true;
			this.graphic = animate(dir, 0, 3);
		}

		counter += attackSpeed;
		if (counter >= 100) {
			entities.addData(this.createProjectile(xLoc, yLoc, dir,
					"projectile"));
			initializeIndex(entities);
			counter = 0;
		}

		if (detectProjectileCollision(collision, entities, "p_projectile")) {
			if (health > 0) {
				health--;
			} else {
				entities.destroy(indice);
			}
		}
	}

}
