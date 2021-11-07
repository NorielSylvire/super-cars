package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	private static int numCoins;
	public static final String INFO = "[C]oins, objects to collect";

	
	public Coin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public static int getCoinsCount() {
		return numCoins;
	}
	
	public void onEnter() {
		increaseNumCoins();
	}
	
	public void update() {}
	
	public void onDelete() {
		decreaseNumCoins();
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public static void increaseNumCoins() {
		numCoins++;
	}
	
	public static void decreaseNumCoins() {
		numCoins--;
	}
	
	public static void reset() {
		numCoins = 0;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		return false;
	}
}
