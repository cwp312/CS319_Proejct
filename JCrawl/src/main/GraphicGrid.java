package main;

import java.awt.image.BufferedImage;

public class GraphicGrid {
	private final static int tilesX = 16, tilesY = 12;
	
	private BufferedImage[][] tiles = new BufferedImage[tilesX][tilesY];
	private static final int SIZE = 64;
	
	public int getSize() {
		return SIZE;
	}

	public BufferedImage[][] getTiles() {
		return tiles;
	}

	public void setTile(BufferedImage tile, int x, int y) {
		tiles[x][y] = tile;
	}
}
