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

/**
 * Control class for all other sub control classes
 * 
 * @author Cheol Woo Park
 *
 */
public class GameManager {

	private GraphicGrid gfx;
	private EntityGrid entities;
	private CollisionGrid collision;
	private ExternalData data;
	private GraphicsAssembler ga;

	private static boolean levelChanged = false, win = false;
	private static boolean keyPressed[] = { false, false, false, false, false,
			false, false };
	private static int curLevel = 0;

	private FileManager file = new FileManager();
	private LevelManager level;
	private EntityManager entity;
	private CollisionManager collisionM;

	/**
	 * Initializes all other sub managers associated
	 * 
	 * @param dimType
	 */
	public GameManager(int dimType) {
		entity = new EntityManager(dimType);
		level = new LevelManager(dimType);
		ga = new GraphicsAssembler(dimType);
		collisionM = new CollisionManager(dimType);
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
		
		if (levelChanged) {
			curLevel++;
			initialize("level" + curLevel + ".txt");
			levelChanged = false;
		}
	}

	/*
	 * Compile the data it holds into actual graphical data through
	 * GraphicsAssembler
	 */
	public RenderData render() {
		return ga.render(gfx, entities);
	}

	// Initialization methods
	private void initializeLevel() {
		gfx = level.initializeLevel(data);
	}

	private void initializeEntities() {
		entities = entity.initializeEntities(data);
	}

	private void initializeCollision() {
		collision = collisionM.initializeCollision(entities, gfx);
	}

	//

	/**
	 * Called extensively by InputManager class.
	 * 
	 * @param keyPressed
	 */
	public static void setKeyPressed(boolean[] keyPressed) {
		GameManager.keyPressed = keyPressed;
	}

	/**
	 * Changes flag levelChanged
	 * 
	 * @param levelChanged
	 */
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

	public static boolean isWin() {
		return win;
	}

	public static void setWin(boolean win) {
		GameManager.win = win;
	}
	
	public static int getCurLevel() {
		return curLevel;
	}
}
