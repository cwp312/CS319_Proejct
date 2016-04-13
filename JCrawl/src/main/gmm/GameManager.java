package main.gmm;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import main.CollisionGrid;
import main.EntityGrid;
import main.ExternalData;
import main.GraphicGrid;
import main.RenderData;
import main.edm.FileManager;

public class GameManager {
	
	// TODO(Cheol Woo) Finish the data storage class implementation
	private GraphicGrid gfx;
	private EntityGrid entities;
	private CollisionGrid collision;
	private ExternalData data;
	private GraphicsAssembler ga = new GraphicsAssembler();
	
	private boolean keyPressed = false, levelChanged = false;
	
	private FileManager file = new FileManager();
	
	public GameManager() {
		initializeLevel();
		initializeEntities();
		initializeCollision();
		
		// DEBUG
		file.getFile("res/level.txt");
		data = file.parseFile();
	}
	
	public void update() {
		
	}
	
	public RenderData render() {
		return ga.render(gfx, entities);
	}
	
	public void initializeLevel() {
		
	}
	
	public void initializeEntities() {
		
	}
	
	public void initializeCollision() {
		
	}
}
