package main.gom;

import main.EntityGrid;
import main.gmm.GameManager;

public class Key extends DependentObject {

	@Override
	public void create(int xLoc, int yLoc) {
		this.xLoc = xLoc;
		this.yLoc = yLoc;
		
		this.graphic = initGraphics(0, 0);
	}

	@Override
	protected void performBehavior(EntityGrid entities) {
		GameManager.setLevelChanged(true);
	}

}
