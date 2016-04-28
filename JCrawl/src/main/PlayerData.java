package main;

public class PlayerData {
	private static int health = 0;
	
	public static void setHealth(int health) {
		PlayerData.health = health;
	}
	
	public static int getHealth() {
		return health;
	}
}
