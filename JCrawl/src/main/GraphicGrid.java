package main;

import java.awt.image.BufferedImage;

public class GraphicGrid {
	private final static int tilesX = 16, tilesY = 12;
	
	private BufferedImage[][] tiles = new BufferedImage[tilesX][tilesY];
	private int[][] tileCode = new int[tilesX][tilesY];
	private static int size = 64;
	
	public int getSize() {
		return size;
	}

	public BufferedImage[][] getTiles() {
		return tiles;
	}

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
