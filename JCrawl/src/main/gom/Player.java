package main.gom;

import main.CollisionGrid;
import main.ImageLoader;
import main.PlayerData;

public class Player extends Entity {

	private int health = 0, movementSpeed = 4, attackSpeed = 0;
	private PlayerData playerInfo = new PlayerData();

	// private Ability abilities[] = new Abilities[];

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		// TODO SpriteSheet support
		this.graphic = new ImageLoader().load("player");
	}

	@Override
	public void destroy() {
		// TODO Implement it
	}

	/**
	 * 
	 * @param collision
	 * @param keyPressed
	 */
	public void update(CollisionGrid collision, boolean[] keyPressed) {
		if (keyPressed[0]) {
			if (!collisionCheck(0, collision)) {
				updateMovement(0);
			}
		}
		if (keyPressed[1]) {
			if (!collisionCheck(1, collision)) {
				updateMovement(1);
			}
		}
		if (keyPressed[2]) {
			if (!collisionCheck(2, collision)) {
				updateMovement(2);
			}
		}
		if (keyPressed[3]) {
			if (!collisionCheck(3, collision)) {
				updateMovement(3);
			}
		}
	}

	public void update(CollisionGrid collision) {
	}

	private void updateMovement(int keyCode) {
		switch (keyCode) {
		case 0:
			yLoc -= movementSpeed;
			break;
		case 1:
			xLoc -= movementSpeed;
			break;
		case 2:
			yLoc += movementSpeed;
			break;
		case 3:
			xLoc += movementSpeed;
			break;
		}
	}

	private boolean collisionCheck(int dir, CollisionGrid collision) {
		boolean b = false;
		boolean calcB0 = false, calcB1 = false;
		int calcX = 0;
		int calcY = 0;
		
		switch(dir) {
		case 0:
			calcX = xLoc / collision.getSize();
			calcY = (yLoc - movementSpeed + (movementSpeed/2)) / collision.getSize();
			
			calcB0 = collision.getTileCollision()[calcX][calcY];
			if(xLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX+1][calcY];
			}
			if(calcB0 | calcB1) {
				b = true;
			}
			break;
		case 1:
			calcX = (xLoc - movementSpeed + (movementSpeed/2)) / collision.getSize();
			calcY = yLoc / collision.getSize();
			
			calcB0 = collision.getTileCollision()[calcX][calcY];
			if(yLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX][calcY+1];
			}
			if(calcB0 | calcB1) {
				b = true;
			}
			break;
		case 2:
			calcX = xLoc / collision.getSize();
			calcY = (yLoc + movementSpeed - (movementSpeed/2)) / collision.getSize() + 1;
			
			calcB0 = collision.getTileCollision()[calcX][calcY];
			if(xLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX+1][calcY];
			}
			if(calcB0 | calcB1) {
				b = true;
			}
			break;
		case 3:
			calcX = (xLoc + movementSpeed - (movementSpeed/2)) / collision.getSize() + 1;
			calcY = yLoc / collision.getSize();
			
			calcB0 = collision.getTileCollision()[calcX][calcY];
			if(yLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX][calcY+1];
			}
			if(calcB0 | calcB1) {
				b = true;
			}
			break;
		}
		
		System.out.println(calcX + " " + calcY);
		return b;
	}
}
