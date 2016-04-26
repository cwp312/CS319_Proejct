package main;

public class Debug {
	
	public static void output(String parentClass, String arg) {
		System.out.println("at class:" + parentClass + " - " + arg);
	}
	
	public static void output(String parentClass, int arg) {
		System.out.println("at class:" + parentClass + " - " + arg);
	}
}
