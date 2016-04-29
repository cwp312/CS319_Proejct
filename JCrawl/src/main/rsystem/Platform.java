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

public class Platform extends Canvas implements Runnable {

	private static final long serialVersionUID = -2068497138246194475L;

	private static int width = 1024, height = 768 + 24;
	private Map<String, String> settings;
	private JFrame frame = new JFrame("JCrawl");
	private static boolean isPaused = false, isDead = false;
	private boolean running = false;

	private Thread gameThread;

	private GameManager gm = new GameManager();
	private UI ui = new UI();

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
	 * Game data update
	 */
	public void update() {
		gm.update();
		ui.update();
		if(Player.getHealth() <= 0) {
			isDead = true;
			isPaused = true;
		}
	}
	
	/*
	 * Actual render
	 */
	public void render() {
		RenderData rd = new RenderData();

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
		int size = rd.getSize();

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
		if(isDead) {
			BufferedImage deadscreen = new ImageLoader().load("gameover");
			g.drawImage(deadscreen, 0, 0, width, height, null);
			g.setColor(Color.WHITE);
			g.drawString("GAMEOVER", 480, 340);
		}

		bs.show();
		g.dispose();
	}
	
	/*
	 * Initialize the game
	 */
	public void initializeGame() {
		this.addKeyListener(new InputManager());
		gm = new GameManager();
	}
	
	/*
	 * 
	 */
	public void renderMenu() {

	}

	/*
	 * 
	 */
	public void renderMenu(PanelType panelType) {

	}

	/*
	 * Pause the game
	 */
	public static void pauseGame() {
		isPaused = !isPaused;
	}

	/**
	 * Start the thread
	 */
	public synchronized void start() {
		running = true;

		gameThread = new Thread(this);
		gameThread.start();
	}

	/**
	 * Stop the thread
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

	public void saveGameSettings(Map<String, String> settings) {
		this.settings = settings;
	}

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
}
