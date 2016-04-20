package main.gom;

import java.awt.image.BufferedImage;

import main.CollisionGrid;

public abstract class Entity {
	protected int xLoc, yLoc;
	protected static int size = 64;
	protected BufferedImage graphic;
	
	public abstract void create(int xLoc, int yLoc);
	public abstract void destroy();
	public abstract void update(CollisionGrid collision);
	public BufferedImage getGraphic() {
		return graphic;
	}
	public int getXLoc() {
		return xLoc;
	}
	public int getYLoc() {
		return yLoc;
	}	
	
	protected boolean collisionCheck(int dir, CollisionGrid collision, int movementSpeed) {
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
	
	protected void updateMovement(int dir, int movementSpeed) {
		switch (dir) {
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
}
