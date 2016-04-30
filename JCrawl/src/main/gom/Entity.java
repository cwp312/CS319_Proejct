package main.gom;

import java.awt.image.BufferedImage;

import main.CollisionGrid;
import main.EntityGrid;
import main.ImageLoader;
import main.SpriteSheet;

/**
 * Entity super class
 * @author Arda Yucel, Cheol Woo Park, Fatih Tas, Mustafa Fidan
 *
 */
public abstract class Entity {
	protected int xLoc, yLoc, dir;
	protected static int size;
	protected BufferedImage graphic;
	protected int indice;
	protected int x1, y1, dimType;
	protected String key;
	
	/**
	 * Initialization for the dimension type
	 * @param dimType
	 */
	public Entity(int dimType) {
		this.dimType = dimType;
		
		if(dimType == 0) {
			size = 64;
		} else {
			size = 50;
		}
	}

	/**
	 * Instead of the contructor, create method will be in charge of initialization
	 * @param xLoc
	 * @param yLoc
	 */
	public abstract void create(int xLoc, int yLoc);

	/**
	 * Destroys the entity
	 * @param entities
	 */
	public abstract void destroy(EntityGrid entities);

	/*
	 * Individual update methods will be called by update method of EntityManager
	 */
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

	/**
	 * Checks collision with the level elements (the tile map)
	 * When there is a collision, it will return true, and will return false if
	 * no collision was detected.
	 * @param dir
	 * @param collision
	 * @param movementSpeed
	 * @return boolean
	 */
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

	/**
	 * Moves the given entity to the direction given and by amount defined by movementSpeed
	 * @param dir
	 * @param movementSpeed
	 */
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

	/**
	 * Creates a new projectile
	 * @param x
	 * @param y
	 * @param dir
	 * @param key
	 * @return Projectile
	 */
	protected Entity createProjectile(int x, int y, int dir, String key) {
		Projectile e = new Projectile(dimType);
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

	/**
	 * Detects projectile collision with given specific String code
	 * @param collision
	 * @param entities
	 * @param type
	 * @return boolean
	 */
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

	/**
	 * Detects collision with other entities
	 * @param collision
	 * @param dir
	 * @param movementSpeed
	 * @return boolean
	 */
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

	/**
	 * Sets the index of the entity according to it's position in the grid
	 * @param entities
	 */
	protected void initializeIndex(EntityGrid entities) {
		int index = entities.getData().size() - 1;
		entities.getData().get(index).setIndex(index);
	}
	
	/**
	 * Changes the graphic of the given entity
	 * @param dir
	 * @param spritesheetX
	 * @param spritesheetY
	 * @return BufferedImage
	 */
	protected BufferedImage animate(int dir, int spritesheetX, int spritesheetY) {
		int y = spritesheetY;
		int x = spritesheetX;
		
		if(dir == 0) {
			x += 1;
		}
		return new SpriteSheet(new ImageLoader().load("monsters")).crop(x, y);
	}

	protected boolean checkXRange(int target, int recipient, int dir,
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

	protected boolean checkYRange(int target, int recipient, int dir,
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
	
	/**
	 * Creates "Scorched Earth" entity which is exclusive to Magmatrum
	 * @param x
	 * @param y
	 * @param dir
	 * @return Flame
	 */
	protected Entity generateFlame(int x, int y, int dir) {
		Flame e = new Flame(dimType);
		
		switch(dir) {
		case 0:
			e.create(x, y + Entity.size);
			break;
		case 1:
			e.create(x + Entity.size, y);
			break;
		case 2:
			e.create(x, y - Entity.size);
			break;
		case 3:
			e.create(x - Entity.size, y);
			break;
		}
		e.setKey("entity");
		return e;
	}
}
