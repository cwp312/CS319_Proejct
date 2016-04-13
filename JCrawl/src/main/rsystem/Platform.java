package main.rsystem;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Map;

import javax.swing.JFrame;

import main.RenderData;
import main.gmm.GameManager;

public class Platform extends Canvas implements Runnable {

	private static final long serialVersionUID = -2068497138246194475L;
	
	private RenderData rd;
	private static int width = 1024, height = 768 + 24;
	private Map<String, String> settings; 
	private JFrame frame = new JFrame("JCrawl");
	private boolean isPaused, running = false;
	
	private Thread gameThread;

	private GameManager gm = new GameManager();
	
	public void run() {
		initializeGame();
		
		double one_tick = 1_000_000_000 / 24D;
		long last = System.nanoTime();
		double delta = 0;
		
		long counter = System.currentTimeMillis();
		int ups = 0, fps = 0;
		
		while(running) {	
			long now = System.nanoTime();
			
			delta += (now - last) / one_tick;
			last = now;
			
			if(delta >= 1) {
				update();
				delta--;
				ups++;
			}
			render();
			fps++;
			
			if(System.currentTimeMillis() - counter >= 1000) {
				frame.setTitle("JCrawl | UPS: " + ups + " | FPS: " + fps);
				ups = 0;
				fps = 0;
				counter = System.currentTimeMillis();
			}
		}
	}
	
	public void update() {
		
	}
	
	public void render() {
		RenderData rd = new RenderData();
		
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.fillRect(0, 0, width, height);
		
		// Render here
		rd = gm.render();
		for(int y = 0; y < rd.getTilesY(); y++) {
			for(int x = 0; x < rd.getTilesX(); x++) {
				g.drawImage(rd.getBackground()[x][y], x * rd.getSize(), y * rd.getSize(), rd.getSize(), rd.getSize(), null);
			}
		}
		
		bs.show();
		g.dispose();
	}
	
	public void initializeGame() {
		gm = new GameManager();
	}
	
	public void renderMenu() {
		
	}
	
	public void renderMenu(PanelType panelType) {
		
	}
	
	public void pauseGame() {
		
	}
	
	public synchronized void start() {
		running = true;
		
		gameThread = new Thread(this);
		gameThread.start();
	}
	
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
	
	public static void main(String args[]) {
		Platform game = new Platform();
		game.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		game.frame.setSize(new Dimension(width, height));
		game.frame.setVisible(true);
		game.frame.setResizable(false);
		game.frame.add(game);
		
		game.start();
	}
}
