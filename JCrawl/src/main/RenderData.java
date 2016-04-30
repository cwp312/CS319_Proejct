package main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * The actual, final render data storage class that Platform class will work with
 * @author Cheol Woo Park
 *
 */
public class RenderData {
	private final static int tilesX = 16, tilesY = 12;
	private static int size = 64;
	
	private BufferedImage[][] background = new BufferedImage[tilesX][tilesY];
	private ArrayList<BufferedImage> foreground = new ArrayList<BufferedImage>();
	private ArrayList<Integer> coordinateX = new ArrayList<Integer>();
	private ArrayList<Integer> coordinateY = new ArrayList<Integer>();
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public RenderData(int dimType) {
		if(dimType == 0) {
			size = 64;
		} else {
			size = 50;
		}
	}
	
	/**
	 * Returns the tile map
	 * @return background
	 */
	public BufferedImage[][] getBackground() {
		return background;
	}
	
	/**
	 * Sets the tile map
	 * @param background
	 */
	public void setBackground(BufferedImage[][] background) {
		this.background = background;
	}

	/**
	 * Returns the list of actual entities
	 * @return foreground
	 */
	public ArrayList<BufferedImage> getForeground() {
		return foreground;
	}
	
	/**
	 * Returns the list containing y positions of the entities
	 * @return coordinateY
	 */
	public ArrayList<Integer> getCoordinateY() {
		return coordinateY;
	}
	
	/**
	 * Adds an entity to the Foreground
	 * @param graphic
	 */
	public void addForeground(BufferedImage graphic) {
		foreground.add(graphic);
	}

	/**
	 * Add another y coordinate
	 * @param y
	 */
	public void addCoordinateY(int y) {
		coordinateY.add(y);
	}

	/**
	 * Returns the list containing x positions of the entities
	 * @return coordinateX
	 */
	public ArrayList<Integer> getCoordinateX() {
		return coordinateX;
	}

	/**
	 * Add another x coordinate
	 * @param x
	 */
	public void addCoordinateX(int x) {
		coordinateX.add(x);
	}

	public int getSize() {
		return size;
	}
	
	public int getTilesX() {
		return tilesX;
	}
	
	public int getTilesY() {
		return tilesY;
	}
}
