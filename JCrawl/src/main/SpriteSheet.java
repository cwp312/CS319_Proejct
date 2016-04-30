package main;

import java.awt.image.BufferedImage;

/**
 * Simple utility tool used to crop spritesheets into smaller sprites
 * @author Cheol Woo Park
 * Imported from another existing personal project
 */
public class SpriteSheet {
	
	private BufferedImage sheet;
	private final int SIZE = 64;
	
	/**
	 * To be used in conjunction with ImageLoader class
	 * @param sheet
	 */
	public SpriteSheet(BufferedImage sheet) {
		this.sheet = sheet;
	}
	
	/**
	 * Crops 64 by 64 area with given x,y TILE coordinate (not arbitrary)
	 * @param x
	 * @param y
	 * @return BufferedImage
	 */
	public BufferedImage crop(int x, int y) {
		return sheet.getSubimage(x * SIZE, y * SIZE, SIZE, SIZE);
	}

}
