package main.lm;

import java.util.Scanner;

import main.ExternalData;
import main.GraphicGrid;
import main.ImageLoader;
import main.SpriteSheet;

public class LevelManager {
	GraphicGrid gfx = new GraphicGrid();
	
	/**
	 * 
	 * @param levelChanged
	 * @return 
	 */
	public GraphicGrid update(boolean levelChanged) {
		if(levelChanged) {
			
		}
		return gfx;
	}
	
	public GraphicGrid initializeLevel(ExternalData data) {
		String level = data.getData().get(0);
		Scanner newLevel = new Scanner(level);
		SpriteSheet ss;
		
		newLevel.useDelimiter(",");
		
		ss = new SpriteSheet(new ImageLoader().load("terrain1"));
		
		int x = 0, y = 0;
		while(newLevel.hasNext()) {
			String tile = newLevel.next();
			switch(tile) {
				case "0":
					gfx.setTile(ss.crop(0, 0), x, y);
					break;
				case "1":
					gfx.setTile(ss.crop(1, 0), x, y);
					break;
				case "2":
					gfx.setTile(ss.crop(2, 0), x, y);
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
