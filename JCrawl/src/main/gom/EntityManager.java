package main.gom;

import java.util.Scanner;

import main.CollisionGrid;
import main.EntityGrid;
import main.ExternalData;

public class EntityManager {
	EntityGrid entities = new EntityGrid();
	
	public EntityGrid update(CollisionGrid collision, boolean[] keyPressed) {
		entities.getPlayer().update(collision, keyPressed);
		
		for(int i = 0; i <= entities.getData().size(); i++) {
			
		}
		return entities;
	}
	
	public EntityGrid initializeEntities(ExternalData data) {
		int offset = 1;
		
		for(int i = offset; i < data.getTag().size(); i++) {
			String tag = data.getTag().get(i);
			
			if(tag.equals("Player")) {
				parsePlayerData(data, i);
			} // TODO other entity types
		}
		return entities;
	}
	
	private void parsePlayerData(ExternalData data, int indice) {
		String pData = data.getData().get(indice);
		
		// pData = "xLoc,yLoc"
		Scanner s = new Scanner(pData);
		s.useDelimiter(",");
		
		int xLoc = Integer.parseInt(s.next());
		int yLoc = Integer.parseInt(s.next());
		
		Player p = new Player();
		p.create(xLoc * Entity.size, yLoc * Entity.size);
		
		entities.setPlayer(p);
		s.close();
	}
}
