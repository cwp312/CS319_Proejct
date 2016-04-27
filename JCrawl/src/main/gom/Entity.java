package main.gom;

import java.awt.image.BufferedImage;

import main.CollisionGrid;
import main.EntityGrid;

public abstract class Entity {
	protected int xLoc, yLoc, dir;
	protected static int size = 64;
	protected BufferedImage graphic;
	protected int indice;
	protected int x1, y1;
	protected String key;

	public abstract void create(int xLoc, int yLoc);

	public abstract void destroy(EntityGrid entities);

	public abstract void update(CollisionGrid collision, EntityGrid entities);

	public BufferedImage getGraphic() {
		return graphic;
	}

	public int getXLoc() {
		return xLoc;
	}

	public int getYLoc() {
		return yLoc;
	}

	public void setIndex(int i) {
		indice = i;
	}

	public int getIndex() {
		return indice;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

	public void setDestination(int x1, int y1) {
		this.x1 = x1;
		this.y1 = y1;
	}

	public int getX1() {
		return x1;
	}

	public int getY1() {
		return y1;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	protected boolean collisionCheck(int dir, CollisionGrid collision,
			int movementSpeed) {
		boolean b = false;
		boolean calcB0 = false, calcB1 = false;
		int calcX = 0;
		int calcY = 0;

		switch (dir) {
		case 0:
			calcX = xLoc / collision.getSize();
			calcY = (yLoc - movementSpeed + (movementSpeed / 2))
					/ collision.getSize();

			calcB0 = collision.getTileCollision()[calcX][calcY];
			if (xLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX + 1][calcY];
			}
			if (calcB0 | calcB1) {
				b = true;
			}
			break;
		case 1:
			calcX = (xLoc - movementSpeed + (movementSpeed / 2))
					/ collision.getSize();
			calcY = yLoc / collision.getSize();

			calcB0 = collision.getTileCollision()[calcX][calcY];
			if (yLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX][calcY + 1];
			}
			if (calcB0 | calcB1) {
				b = true;
			}
			break;
		case 2:
			calcX = xLoc / collision.getSize();
			calcY = (yLoc + movementSpeed - (movementSpeed / 2))
					/ collision.getSize() + 1;

			calcB0 = collision.getTileCollision()[calcX][calcY];
			if (xLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX + 1][calcY];
			}
			if (calcB0 | calcB1) {
				b = true;
			}
			break;
		case 3:
			calcX = (xLoc + movementSpeed - (movementSpeed / 2))
					/ collision.getSize() + 1;
			calcY = yLoc / collision.getSize();

			calcB0 = collision.getTileCollision()[calcX][calcY];
			if (yLoc % collision.getSize() > movementSpeed) {
				calcB1 = collision.getTileCollision()[calcX][calcY + 1];
			}
			if (calcB0 | calcB1) {
				b = true;
			}
			break;
		}
		return b;
	}

	protected void updateMovement(int dir, int movementSpeed) {
		switch (dir) {
		case 0:
			yLoc -= movementSpeed;
			break;
		case 1:
			xLoc -= movementSpeed;
			break;
		case 2:
			yLoc += movementSpeed;
			break;
		case 3:
			xLoc += movementSpeed;
			break;
		}
	}

	protected Entity createProjectile(int x, int y, int dir, String key) {
		Projectile e = new Projectile();
		switch (dir) {
		case 0:
			e.create(x, y - Entity.size);
			break;
		case 1:
			e.create(x - Entity.size, y);
			break;
		case 2:
			e.create(x, y + Entity.size);
			break;
		case 3:
			e.create(x + Entity.size, y);
			break;
		}
		e.setDir(dir);
		e.setKey(key);
		return e;
	}

	protected boolean detectProjectileCollision(CollisionGrid collision,
			EntityGrid entities, String type) {
		boolean b = false;
		int compX, compY;

		for (int i = 0; i < collision.getPixelCollision().size(); i++) {
			if (collision.getPixelCollision().get(i).getKey().equals(type)) {
				compX = collision.getPixelCollision().get(i).getX();
				compY = collision.getPixelCollision().get(i).getY();

				if (Math.abs(xLoc - compX) <= 24) {
					if (Math.abs(yLoc - compY) <= 24) {
						b = true;
						entities.destroy(i - 1);
					}
				}
			}
		}
		return b;
	}

	// TODO
	// TODO
	// TODO
	// FIX THIS
	protected boolean detectCollision(CollisionGrid collision, int dir,
			int movementSpeed) {
		boolean b = false;
		int compX = 0, compY = 0;

		for (int i = 0; i < collision.getPixelCollision().size(); i++) {
			if (collision.getPixelCollision().get(i).getKey().equals("entity")) {
				compX = collision.getPixelCollision().get(i).getX();
				compY = collision.getPixelCollision().get(i).getY();

				if ((compX != xLoc) && (compY != yLoc)) {
					switch (dir) {
					case 0:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					case 1:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					case 2:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					case 3:
						if (checkXRange(compX, xLoc, dir, movementSpeed)) {
							if (checkYRange(compY, yLoc, dir, movementSpeed)) {
								b = true;
							}
						}
						break;
					}
				}
			}
		}

		return b;
	}

	protected void initializeIndex(EntityGrid entities) {
		int index = entities.getData().size() - 1;
		entities.getData().get(index).setIndex(index);
	}

	private boolean checkXRange(int target, int recipient, int dir,
			int movementSpeed) {
		// If the difference between the target X coordinate and recipient X
		// coordinate is less than the size
		// it is within the collision range if the direction is vertical
		if ((dir == 0) || (dir == 2)) {
			if (Math.abs(target - recipient) < Entity.size) {
				return true;
			} else {
				return false;
			}
		} else {
			if ((Math.abs(target - recipient) - movementSpeed) < Entity.size) {
				return true;
			} else {
				return false;
			}
		}
	}

	private boolean checkYRange(int target, int recipient, int dir,
			int movementSpeed) {
		if ((dir == 0) || (dir == 2)) {
			if ((Math.abs(target - recipient) - movementSpeed) < Entity.size) {
				return true;
			} else {
				return false;
			}
		} else {
			if (Math.abs(target - recipient) < Entity.size) {
				return true;
			} else {
				return false;
			}
		}
	}
}
