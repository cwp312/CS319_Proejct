package main.gom;

import java.util.Scanner;

import main.CollisionGrid;
import main.EntityGrid;
import main.ExternalData;

public class EntityManager {
	EntityGrid entities;
	
	public EntityGrid update(CollisionGrid collision, boolean[] keyPressed) {
		entities.getPlayer().update(collision, keyPressed, entities);
		
		for(int i = 0; i < entities.getData().size(); i++) {
			entities.getData().get(i).update(collision, entities);
		}
		return entities;
	}
	
	public EntityGrid initializeEntities(ExternalData data) {
		entities = new EntityGrid();
		int offset = 1;
		
		for(int i = offset; i < data.getTag().size(); i++) {
			String tag = data.getTag().get(i);
			
			if(tag.equals("Player")) {
				parsePlayerData(data, i);
			} else if(tag.equals("AI")) {
				parseAIData(data, i);
			} else if(tag.equals("stationary")) {
				parseStationaryData(data, i);
			} else if(tag.equals("patrol")) {
				parsePatrolData(data, i);
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
	
	private void parseAIData(ExternalData data, int indice) {
		String eData = data.getData().get(indice);
		Entity e = null;
		
		// AI entity data = type, xLoc, yLoc
		Scanner s = new Scanner(eData);
		s.useDelimiter(",");
		
		String type = s.next();
		int xLoc = Integer.parseInt(s.next());
		int yLoc = Integer.parseInt(s.next());
		
		switch(type) {
		case "slime":
			e = new Slime();
			e.create(xLoc * Entity.size, yLoc * Entity.size);
			break;
		case "orc":
			e = new Orc();
			e.create(xLoc * Entity.size, yLoc * Entity.size);
			break;
		case "magmatrum":
			e = new Magmatrum();
			e.create(xLoc * Entity.size, yLoc * Entity.size);
			break;
		case "wolf":
			e = new Wolf();
			e.create(xLoc * Entity.size, yLoc * Entity.size);
			break;
		}
		
		entities.addData(e);
		initializeIndex(entities);
		s.close();
	}
	
	private void parseStationaryData(ExternalData data, int indice) {
		String eData = data.getData().get(indice);
		Entity e = null;
		
		// AI entity data = type, xLoc, yLoc
		Scanner s = new Scanner(eData);
		s.useDelimiter(",");
		
		String type = s.next();
		int xLoc = Integer.parseInt(s.next());
		int yLoc = Integer.parseInt(s.next());
		
		switch(type) {
		case "archer":
			e = new Archer();
			e.create(xLoc * Entity.size, yLoc * Entity.size);
			e.setDir(Integer.parseInt(s.next()));
			break;
		}
		
		entities.addData(e);
		initializeIndex(entities);
		s.close();
	}
	
	private void parsePatrolData(ExternalData data, int indice) {
		String eData = data.getData().get(indice);
		Entity e = null;
		
		// AI entity data = type, xLoc, yLoc
		Scanner s = new Scanner(eData);
		s.useDelimiter(",");
		
		String type = s.next();
		int xLoc = Integer.parseInt(s.next());
		int yLoc = Integer.parseInt(s.next());
		
		switch(type) {
		case "goblin":
			e = new Goblin();
			int x1 = Integer.parseInt(s.next());
			int y1 = Integer.parseInt(s.next());
			e.setDestination(x1 * Entity.size, y1 * Entity.size);
			e.create(xLoc * Entity.size, yLoc * Entity.size);
			break;
		}
		
		entities.addData(e);
		initializeIndex(entities);
		s.close();
	}
	
	private void initializeIndex(EntityGrid entities) {
		int index = entities.getData().size() - 1;
		entities.getData().get(index).setIndex(index);
	}
}
