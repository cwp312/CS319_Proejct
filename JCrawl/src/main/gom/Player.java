package main.gom;

import java.awt.image.BufferedImage;

import main.CollisionGrid;
import main.Debug;
import main.EntityGrid;
import main.ImageLoader;
import main.PlayerData;
import main.SpriteSheet;

public class Player extends Entity {

	private int health = 0, movementSpeed = 8, attackSpeed = 10,
			energy = 0, dir = 0, buffer = 0;
	private PlayerData playerInfo = new PlayerData();
	private BufferedImage backImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(1, 0);
	private BufferedImage frontImage = new SpriteSheet(new ImageLoader().load("monsters")).crop(0, 0);
	// private Ability abilities[] = new Abilities[];

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		this.graphic = frontImage;
		health = 10;
		indice = -1;
	}

	@Override
	public void destroy(EntityGrid entities) {
	}

	/**
	 * 
	 * @param collision
	 * @param keyPressed
	 */
	public void update(CollisionGrid collision, boolean[] keyPressed,
			EntityGrid entities) {
		if(buffer < 48) {
			buffer++;
		}
		
		if(energy < 120) {
			energy += attackSpeed;
		}
		
		if (keyPressed[0]) {
			if (!collisionCheck(0, collision, movementSpeed)) {
				updateMovement(0, movementSpeed);
				dir = 0;
				updateGraphics(false);
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
				updateGraphics(true);
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
		
		if(detectCollision(collision, dir, movementSpeed) && buffer == 48) {
			health--;
			buffer = 0;
			Debug.output("Player", health);
		}
		
		if(detectProjectileCollision(collision, entities, "projectile") && buffer == 48) {
			health--;
			buffer = 0;
			Debug.output("Player", health);
		}
		
		if(health < 1) {
			// TODO gameover
		}
	}

	public void update(CollisionGrid collision, EntityGrid entities) {
	}
	
	private void updateGraphics(boolean isLookingDown){
		this.graphic = isLookingDown ? frontImage : backImage;
	}
}
