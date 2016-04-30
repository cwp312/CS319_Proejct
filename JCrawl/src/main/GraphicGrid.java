package main;

import java.awt.image.BufferedImage;

/**
 * Data Storage class for level data
 * @author Fatih Tas
 *
 */
public class GraphicGrid {
	private final static int tilesX = 16, tilesY = 12;
	
	private BufferedImage[][] tiles = new BufferedImage[tilesX][tilesY];
	private int[][] tileCode = new int[tilesX][tilesY];
	private static int size = 64;
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public GraphicGrid(int dimType) {
		if(dimType == 0) {
			size = 64;
		} else {
			size = 50;
		}
	}
	
	public int getSize() {
		return size;
	}

	/**
	 * Returns the tile map
	 * @return tiles
	 */
	public BufferedImage[][] getTiles() {
		return tiles;
	}

	/**
	 * Sets a single tile to given coordinate and give tile image
	 * @param tile
	 * @param x
	 * @param y
	 */
	public void setTile(BufferedImage tile, int x, int y) {
		tiles[x][y] = tile;
	}
	
	public static int getX() {
		return tilesX;
	}
	
	public static int getY() {
		return tilesY;
	}
	
	public void setCode(int code, int x, int y) {
		tileCode[x][y] = code;
	}
	
	public int[][] getTileCode() {
		return tileCode;
	}
}
