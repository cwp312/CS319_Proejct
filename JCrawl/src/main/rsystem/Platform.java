package main.rsystem;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.Map;

import javax.swing.JFrame;

import main.ImageLoader;
import main.RenderData;
import main.gmm.GameManager;
import main.gom.Player;
import main.im.InputManager;

/**
 * Rendering, FPS/UPS control, general purpose platform for JCrawl
 * @author Cheol Woo Park
 *
 */
public class Platform extends Canvas implements Runnable {

	private static final long serialVersionUID = -2068497138246194475L;

	private static int width = 1024, height = 768 + 24;
	@SuppressWarnings("unused")
	private Map<String, String> settings;
	private JFrame frame = new JFrame("JCrawl");
	private static boolean isPaused = false, isDead = false;

	private static int dimType = 0, deathCounter = 0;
	private boolean running = false;

	private Thread gameThread;

	private GameManager gm = new GameManager(dimType);
	private UI ui = new UI(dimType);

	/*
	 * Main game loop
	 */
	public void run() {
		initializeGame();

		double one_tick = 1_000_000_000 / 24D;
		long last = System.nanoTime();
		double delta = 0;

		long counter = System.currentTimeMillis();
		int ups = 0, fps = 0;

		while (running) {
			long now = System.nanoTime();

			delta += (now - last) / one_tick;
			last = now;

			if (delta >= 1) {
				update();
				delta--;
				ups++;
			}
			render();
			fps++;

			if (System.currentTimeMillis() - counter >= 1000) {
				frame.setTitle("JCrawl | UPS: " + ups + " | FPS: " + fps);
				ups = 0;
				fps = 0;
				counter = System.currentTimeMillis();
			}
		}
	}

	/*
	 * Game data update methods should be included here
	 */
	public void update() {
		gm.update();
		ui.update();
		if (Player.getHealth() <= 0) {
			isDead = true;
			isPaused = true;
		}

		if (isDead) {
			deathCounter++;
			if (deathCounter > 72) {
				MainFrame.frame.setVisible(true);
				frame.dispose();
				isDead = false;
				isPaused = false;
				deathCounter = 0;
				this.stop();
			}
		}
		
		if(GameManager.isWin()) {
			deathCounter++;
			if (deathCounter > 72) {
				MainFrame.frame.setVisible(true);
				frame.dispose();
				isDead = false;
				isPaused = false;
				GameManager.setWin(false);
				deathCounter = 0;
				this.stop();
			}
		}
	}

	/*
	 * Render related methods should be included in here
	 */
	public void render() {
		RenderData rd = new RenderData(dimType);

		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, width, height);

		// Render menus here

		// Render here
		rd = gm.render();
		int size;
		if (dimType == 0) {
			size = 64;
		} else {
			size = 50;
		}

		for (int y = 0; y < rd.getTilesY(); y++) {
			for (int x = 0; x < rd.getTilesX(); x++) {
				g.drawImage(rd.getBackground()[x][y], x * size, y * size, size,
						size, null);
			}
		}
		for (int i = 0; i < rd.getForeground().size(); i++) {
			g.drawImage(rd.getForeground().get(i), rd.getCoordinateX().get(i),
					rd.getCoordinateY().get(i), size, size, null);
		}

		// Render UI here
		ui.render(g);

		// Pause Menu rendered here
		if (isPaused && !isDead) {
			BufferedImage deadscreen = new ImageLoader().load("gameover");
			g.drawImage(deadscreen, 0, 0, width, height, null);
			g.setColor(Color.WHITE);
			g.drawString("GAME PAUSED", width / 2 - 20, height / 2 - 10);
		}

		if (isDead) {
			BufferedImage deadscreen = new ImageLoader().load("gameover");
			g.drawImage(deadscreen, 0, 0, width, height, null);
			g.setColor(Color.WHITE);
			g.drawString("GAMEOVER", width / 2 - 20, height / 2 - 10);
		}
		
		if(GameManager.isWin()) {
			BufferedImage deadscreen = new ImageLoader().load("gameover");
			g.drawImage(deadscreen, 0, 0, width, height, null);
			g.setColor(Color.WHITE);
			g.drawString("CONGRATULATIONS", width / 2 - 30, height / 2 - 10);
		}

		bs.show();
		g.dispose();
	}

	/*
	 * Initialize the game
	 */
	private void initializeGame() {
		this.addKeyListener(new InputManager());
		gm = new GameManager(dimType);
	}

	/**
	 * @deprecated
	 */
	public void renderMenu() {

	}

	/**
	 * @deprecated
	 */
	public void renderMenu(PanelType panelType) {

	}

	/**
	 * Pause the game loop
	 */
	public static void pauseGame() {
		isPaused = !isPaused;
	}

	/**
	 * Starts the thread
	 * This method should be called right after the initialization of the parent JFrame
	 */
	public synchronized void start() {
		running = true;

		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * Stops the thread
	 * Although closing the JFrame will automatically stop the thread, this method can be called prematurely
	 * to stop the thread.
	 */
	public synchronized void stop() {
		running = false;

		try {
			gameThread.join();
		} catch (InterruptedException e) {
			// TODO(Cheol Woo) Error Logging system here maybe?
			e.printStackTrace();
		}
	}

	/**
	 * @deprecated
	 */
	public void saveGameSettings(Map<String, String> settings) {
		this.settings = settings;
	}
	
	/**
	 * Initializes the JFrame
	 */
	public Platform() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(new Dimension(width, height));
		frame.setVisible(true);
		frame.setResizable(false);
		frame.add(this);

		start();
	}

	public static boolean getIsPaused() {
		return isPaused;
	}

	/**
	 * Sets the width of the JFrame
	 * This must be called before the Constructor is called, hence the static type
	 * @param newWidth
	 */
	public static void setWidth(int newWidth) {
		Platform.width = newWidth;
	}

	/**
	 * Sets the height of the JFrame
	 * This must be called before the Constructor is called, hence the static type
	 * @param newHeight
	 */
	public static void setHeight(int newHeight) {
		Platform.height = newHeight;
	}

	/**
	 * Sets the dimension type
	 * @param dimType
	 */
	public static void setDimType(int dimType) {
		Platform.dimType = dimType;
	}

	/**
	 * Returns the dimension type
	 * @return dimType
	 */
	public static int getDimType() {
		return dimType;
	}
}
