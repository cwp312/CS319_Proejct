package main.gom;

import main.CollisionGrid;
import main.EntityGrid;

/**
 * The one and only player
 * @author Cheol Woo Park
 *
 */
public class Player extends Entity {

	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Player(int dimType) {
		super(dimType);
	}

	private int movementSpeed = 8, attackSpeed = 10,
			energy = 0, dir = 0, buffer = 0;
	private static int health = 0;

	// private Ability abilities[] = new Abilities[];

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = animate(dir, 0, 0);
		health = 8;
		indice = -1;
	}

	@Override
	public void destroy(EntityGrid entities) {
	}

	/**
	 * Unlike other entities, requires an array of booleans
	 * @param collision
	 * @param keyPressed
	 */
	public void update(CollisionGrid collision, boolean[] keyPressed,
			EntityGrid entities) {
		if(buffer < 24) {
			buffer++;
		}
		
		if(energy < 120) {
			energy += attackSpeed;
		}
		
		if (keyPressed[0]) {
			if (!collisionCheck(0, collision, movementSpeed)) {
				updateMovement(0, movementSpeed);
				dir = 0;
				this.graphic = animate(dir, 0, 0);
			}
		}
		if (keyPressed[1]) {
			if (!collisionCheck(1, collision, movementSpeed)) {
				updateMovement(1, movementSpeed);
				dir = 1;
			}
		}
		if (keyPressed[2]) {
			if (!collisionCheck(2, collision, movementSpeed)) {
				updateMovement(2, movementSpeed);
				dir = 2;
				this.graphic = animate(dir, 0, 0);
			}
		}
		if (keyPressed[3]) {
			if (!collisionCheck(3, collision, movementSpeed)) {
				updateMovement(3, movementSpeed);
				dir = 3;
			}
		}
		if (keyPressed[4]) {
			if (energy >= 120) {
				energy = 0;
				entities.addData(createProjectile(xLoc, yLoc, dir, "p_projectile"));
				initializeIndex(entities);
			}
		}
		
		if(detectCollision(collision, dir, movementSpeed) && buffer == 24) {
			health--;
			buffer = 0;
		}
		
		if(detectProjectileCollision(collision, entities, "projectile") && buffer == 24) {
			health--;
			buffer = 0;
		}
	}

	/*
	 * (non-Javadoc)
	 * @see main.gom.Entity#update(main.CollisionGrid, main.EntityGrid)
	 */
	public void update(CollisionGrid collision, EntityGrid entities) {
	}
	
	public static int getHealth() {
		return health;
	}
}
