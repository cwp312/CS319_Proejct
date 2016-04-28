package main;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	
	private BufferedImage sheet;
	private final int SIZE = 64;
	
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	public BufferedImage crop(int x, int y) {
		return sheet.getSubimage(x * SIZE, y * SIZE, SIZE, SIZE);
	}

}
