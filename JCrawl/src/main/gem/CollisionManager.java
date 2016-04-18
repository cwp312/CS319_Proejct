package main.gem;

import main.CollisionGrid;
import main.EntityGrid;
import main.GraphicGrid;

public class CollisionManager {
	CollisionGrid collision = new CollisionGrid();
	
	public CollisionGrid update(boolean levelChanged, EntityGrid entities, GraphicGrid gfx) {
		
		return collision;
	}
	
	public CollisionGrid initializeCollision(EntityGrid entities, GraphicGrid gfx) {
		for(int y = 0; y < GraphicGrid.getY(); y++) {
			for(int x = 0; x < GraphicGrid.getX(); x++) {
				int temp = gfx.getTileCode()[x][y];
				switch(temp) {
				case 0:
					collision.setTile(x, y, true);
					break;
				case 1:
					collision.setTile(x, y, false);
					break;
				default:
					collision.setTile(x, y, false);
					break;
				}
			}
		}
		return collision;
	}
	
	public boolean hasCollided() {
		boolean b = false;
		
		return b;
	}
}
