package main;

import java.util.ArrayList;

/**
 * Data storage class used for holding collision
 * @author Arda Yucel
 *
 */
public class CollisionGrid {
	private boolean[][] tileCollision = new boolean[16][12];
	private ArrayList<Coordinates> pixelCollision = new ArrayList<Coordinates>();
	private static int size = 64;
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public CollisionGrid(int dimType) {
		if(dimType == 0) {
			size = 64;
		} else {
			size = 50;
		}
	}
	
	public boolean[][] getTileCollision() {
		return tileCollision;
	}
	
	public void setTile(int x, int y, boolean b) {
		tileCollision[x][y] = b;
	}

	public ArrayList<Coordinates> getPixelCollision() {
		return pixelCollision;
	}

	public void setPixelCollision(ArrayList<Coordinates> pixelCollision) {
		this.pixelCollision = pixelCollision;
	}

	public int getSize() {
		return size;
	}	
}
