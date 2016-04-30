package main.gom;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

/**
 * Simple, non moving entity which will simply damage the player on contact
 * @author Mustafa Fidan
 *
 */
public class Flame extends Entity {

	private int life = 0, frame = 0, frameCounter = 0;
	private SpriteSheet ss = new SpriteSheet(new ImageLoader().load("flame"));
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Flame(int dimType) {
		super(dimType);
	}
	
	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		this.graphic = ss.crop(frame, 0);
	}

	@Override
	public void destroy(EntityGrid entities) {
		entities.destroy(indice);
	}

	public void update(CollisionGrid collision, EntityGrid entities) {	
		if(life > 120) {
			destroy(entities);
		} else {
			life++;
		}
		
		frameCounter++;
		if(frameCounter >= 4) {
			frameCounter = 0;
			if(frame < 11) {
				frame++;
			} else {
				frame = 0;
			}
			this.graphic = ss.crop(frame, 0);
		}
	}
}
