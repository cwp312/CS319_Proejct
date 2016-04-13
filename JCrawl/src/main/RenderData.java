package main;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class RenderData {
	private final static int tilesX = 16, tilesY = 12;
	private final static int SIZE = 64;
	
	private BufferedImage[][] background = new BufferedImage[tilesX][tilesY];
	private ArrayList<BufferedImage> foreground = new ArrayList<BufferedImage>();
	private ArrayList<Integer> coordinateX = new ArrayList<Integer>();
	private ArrayList<Integer> coordinateY = new ArrayList<Integer>();

	public BufferedImage[][] getBackground() {
		return background;
	}

	public void setBackground(BufferedImage[][] background) {
		this.background = background;
	}

	public ArrayList<BufferedImage> getForeground() {
		return foreground;
	}

	public ArrayList<Integer> getCoordinateY() {
		return coordinateY;
	}

	public void addCoordinateY(int y) {
		coordinateY.add(y);
	}

	public ArrayList<Integer> getCoordinateX() {
		return coordinateX;
	}

	public void addCoordinateX(int x) {
		coordinateX.add(x);
	}

	public int getSize() {
		return SIZE;
	}
	
	public int getTilesX() {
		return tilesX;
	}
	
	public int getTilesY() {
		return tilesY;
	}
}
