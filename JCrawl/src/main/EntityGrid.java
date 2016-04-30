package main;

import java.util.ArrayList;

import main.gom.Entity;
import main.gom.Player;

/**
 * Data storage class for Entities
 * @author Cheol Woo Park
 *
 */
public class EntityGrid {
	private Player p;
	private ArrayList<Entity> data = new ArrayList<Entity>();
	
	public EntityGrid(int dimType) {
		p = new Player(dimType);
	}
	
	public ArrayList<Entity> getData() {
		return data;
	}

	public void addData(Entity newEntity) {
		data.add(newEntity);
	}

	public Player getPlayer() {
		return p;
	}

	public void setPlayer(Player p) {
		this.p = p;
	}
	
	public void destroy(int index) {
		data.remove(index);
		for(int i = 0; i < data.size(); i++) {
			data.get(i).setIndex(i);
		}
	}
}
