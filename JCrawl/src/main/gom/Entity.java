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
}
