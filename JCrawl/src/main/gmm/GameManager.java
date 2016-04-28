package main.gmm;

import main.CollisionGrid;
import main.EntityGrid;
import main.ExternalData;
import main.GraphicGrid;
import main.RenderData;
import main.edm.FileManager;
import main.gem.CollisionManager;
import main.gom.EntityManager;
import main.lm.LevelManager;
import main.rsystem.Platform;

public class GameManager {

	private GraphicGrid gfx;
	private EntityGrid entities;
	private CollisionGrid collision;
	private ExternalData data;
	private GraphicsAssembler ga = new GraphicsAssembler();

	private static boolean levelChanged = false;
	private static boolean keyPressed[] = { false, false, false, false, false,
			false, false };
	private int curLevel = 0;

	private FileManager file = new FileManager();
	private LevelManager level = new LevelManager();
	private EntityManager entity = new EntityManager();
	private CollisionManager collisionM = new CollisionManager();

	public GameManager() {
		initialize("level.txt");
	}

	/*
	 * Update the game
	 */
	public void update() {
		if (keyPressed[6]) {
			Platform.pauseGame();
		}
		if (!Platform.getIsPaused()) {
			collision = collisionM.update(entities, gfx);
			entity.update(collision, keyPressed);
		}
		if(levelChanged) {
			curLevel++;
			initialize("level" + curLevel + ".txt");
			levelChanged = false;
		}
	}
	
	/*
	 * Compile the data it holds into actual graphical data through GraphicsAssembler
	 */
	public RenderData render() {
		return ga.render(gfx, entities);
	}

	// Initialization methods
	public void initializeLevel() {
		gfx = level.initializeLevel(data);
	}

	public void initializeEntities() {
		entities = entity.initializeEntities(data);
	}

	public void initializeCollision() {
		collision = collisionM.initializeCollision(entities, gfx);
	}
	//

	public static void setKeyPressed(boolean[] keyPressed) {
		GameManager.keyPressed = keyPressed;
	}

	public static void setLevelChanged(boolean levelChanged) {
		GameManager.levelChanged = levelChanged;
	}
	
	private void initialize(String level) {
		file.getFile("res/" + level);
		data = file.parseFile();

		initializeLevel();
		initializeEntities();
		initializeCollision();
	}
}
