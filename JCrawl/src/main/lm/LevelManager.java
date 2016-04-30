package main.lm;

import java.util.Scanner;

import main.ExternalData;
import main.GraphicGrid;
import main.ImageLoader;
import main.SpriteSheet;

/**
 * Class in charge of compiling the external data into graphics data
 * @author Fatih Tas
 *
 */
public class LevelManager {
	GraphicGrid gfx;
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public LevelManager(int dimType) {
		gfx = new GraphicGrid(dimType);
	}
	
	/*
	 * Update method to be called
	 */
	public GraphicGrid update(boolean levelChanged) {
		/*
		 * The levelChanged if statement is deprecated
		 */
		if(levelChanged) {
			
		}
		return gfx;
	}
	
	/**
	 * Initializes the graphic grid when the Game Manager is first initialized
	 * @param data
	 * @return gfx
	 */
	public GraphicGrid initializeLevel(ExternalData data) {
		String level = data.getData().get(0);
		Scanner newLevel = new Scanner(level);
		SpriteSheet ss;
		
		newLevel.useDelimiter(",");
		
		ss = new SpriteSheet(new ImageLoader().load("terrain"));
		
		int x = 0, y = 0;
		while(newLevel.hasNext()) {
			String tile = newLevel.next();
			switch(tile) {
				case "0":
					gfx.setTile(ss.crop(0, 0), x, y);
					gfx.setCode(0, x, y);
					break;
				case "1":
					gfx.setTile(ss.crop(1, 0), x, y);
					gfx.setCode(1, x, y);
					break;
				default:
					
					break;
			}
			if(x + 1 > 15) {
				x = 0;
				y++;
			} else {
				x++;
			}
			
			// TODO(Cheol Woo) Handle the case when the level file is invalid
		}
		
		newLevel.close();
		return gfx;
	}
}
