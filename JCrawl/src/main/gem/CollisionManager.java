package main.gem;

import java.util.ArrayList;

import main.CollisionGrid;
import main.Coordinates;
import main.EntityGrid;
import main.GraphicGrid;

/**
 * Compiles graphics and entity data into collision data
 * @author Arda Yucel
 *
 */
public class CollisionManager {
	CollisionGrid collision;
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public CollisionManager(int dimType) {
		collision = new CollisionGrid(dimType);
	}
	
	/*
	 * Updates the collision grid
	 */
	public CollisionGrid update(EntityGrid entities, GraphicGrid gfx) {
		ArrayList<Coordinates> newCollision = new ArrayList<Coordinates>();
		
		newCollision.add(new Coordinates(entities.getPlayer().getXLoc(), entities.getPlayer().getYLoc(), "player"));
		for(int i = 0; i < entities.getData().size(); i++) {
			int x = entities.getData().get(i).getXLoc();
			int y = entities.getData().get(i).getYLoc();
			String key = entities.getData().get(i).getKey();
			//Debug.output("CollisionGrid : Coordinate #" + i, "x: " + x + " y: " + y + " key: " + key);
			
			newCollision.add(new Coordinates(x, y, key));
		}
		collision.setPixelCollision(newCollision);
		
		return collision;
	}
	
	/**
	 * Initializes the collision grid when the Game Manager is first initialized
	 * @param entities
	 * @param gfx
	 * @return collision
	 */
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
	
	/**
	 * Unused due to change in design
	 * @deprecated
	 * @return false
	 */
	public boolean hasCollided() {
		boolean b = false;
		
		return b;
	}
}
