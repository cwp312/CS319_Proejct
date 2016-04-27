package main;

public class Coordinates {
	private int x, y;
	private static int size = 64;
	private String key;
	
	public Coordinates(int x, int y, String key) {
		this.x = x;
		this.y = y;
		this.key = key;
	}
	
	public static int getSize() {
		return size;
	}
	public void setSize(int size) {
		Coordinates.size = size;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}
}
