package main;

import java.util.ArrayList;

public class CollisionGrid {
	private boolean[][] tileCollision = new boolean[16][12];
	private ArrayList<Coordinates> pixelCollision = new ArrayList<Coordinates>();
	private static int size = 64;
	
	public boolean[][] getTileCollision() {
		return tileCollision;
	}
	
	public void setTile(int x, int y, boolean b) {
		tileCollision[x][y] = b;
	}

	public ArrayList<Coordinates> getPixelCollision() {
		return pixelCollision;
	}

	public void addPixelCollision(Coordinates c) {
		pixelCollision.add(c);
	}

	public int getSize() {
		return size;
	}	
}
