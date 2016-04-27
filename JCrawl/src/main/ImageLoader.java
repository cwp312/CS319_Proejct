package main;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public BufferedImage load(String fileName) {
		try {
			return ImageIO.read(getClass().getResource("/" + fileName + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
