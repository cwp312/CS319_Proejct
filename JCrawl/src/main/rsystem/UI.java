package main.rsystem;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import main.ImageLoader;
import main.SpriteSheet;
import main.gom.Player;

public class UI {
	private int health, num_of_hearts;
	private int size = 64;
	private LinkedList<BufferedImage> graphic = new LinkedList<BufferedImage>();
	private static int positionX = 0, positionY = 768 - 64;
	private boolean hasFraction = false;

	public void update() {
		health = Player.getHealth();
		graphic = new LinkedList<BufferedImage>();

		if ((health > 0)) {
			num_of_hearts = health / 4;
			if ((health % 4) > 0) {
				num_of_hearts++;
				hasFraction = true;
			} else {
				hasFraction = false;
			}

			for (int i = 0; i < num_of_hearts; i++) {
				if ((i == (num_of_hearts - 1)) && hasFraction) {
					int ssX = (health % 4);
					graphic.add(new SpriteSheet(new ImageLoader().load("heart"))
							.crop(4 - ssX, 0));
				} else {
					graphic.add(new SpriteSheet(new ImageLoader().load("heart"))
							.crop(0, 0));
				}
			}
		}
	}

	public void render(Graphics g) {
		for (int i = 0; i < graphic.size(); i++) {
			g.drawImage(graphic.get(i), positionX + i * size, positionY, size,
					size, null);
		}
	}
}
