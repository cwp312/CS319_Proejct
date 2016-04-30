package main.gom;

import main.EntityGrid;
import main.edm.FileManager;
import main.gmm.GameManager;

/**
 * When in contact, it will change the level
 * @author Arda Yucel
 *
 */
public class Key extends DependentObject {

	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Key(int dimType) {
		super(dimType);
	}

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		this.graphic = initGraphics(0, 0);
	}

	@Override
	protected void performBehavior(EntityGrid entities) {
		if(GameManager.getCurLevel() < (FileManager.getLevelCount() - 1)) {
			GameManager.setLevelChanged(true);
		} else {
			GameManager.setWin(true);
		}
	}

}
