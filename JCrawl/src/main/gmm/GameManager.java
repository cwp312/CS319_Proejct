package main.gmm;

import main.CollisionGrid;
import main.EntityGrid;
import main.ExternalData;
import main.GraphicGrid;
import main.RenderData;
import main.edm.FileManager;
import main.lm.LevelManager;

public class GameManager {
	
	// TODO(Cheol Woo) Finish the data storage class implementation
	private GraphicGrid gfx;
	private EntityGrid entities;
	private CollisionGrid collision;
	private ExternalData data;
	private GraphicsAssembler ga = new GraphicsAssembler();
	
	private boolean levelChanged = false;
	private static boolean keyPressed[] = {false, false, false, false, false, false, false};
	
	private FileManager file = new FileManager();
	private LevelManager level = new LevelManager();
	
	public GameManager() {
		file.getFile("res/level.txt");
		data = file.parseFile();
		
		initializeLevel();
		initializeEntities();
		initializeCollision();
	}
	
	public void update() {
		
	}
	
	public RenderData render() {
		return ga.render(gfx, entities);
	}
	
	public void initializeLevel() {
		gfx = level.initializeLevel(data);
	}
	
	public void initializeEntities() {
		
	}
	
	public void initializeCollision() {
		
	}
	
	public static void setKeyPressed(boolean[] keyPressed) {
		GameManager.keyPressed = keyPressed;
	}
}
