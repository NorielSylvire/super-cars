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
		this.alive = true;
		increaseNumCoins();
		this.symbol = "O";
	}
	
	public void update() {}
	
	public void onDelete() {
		decreaseNumCoins();
		this.alive = false;
	}
	
	public boolean isAlive() {
		return this.alive;
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

	private void addCoins(Game game) {
		game.addCoins();
	}
	
	public boolean receiveCollision(Player player) {
		addCoins(game);
		onDelete();
		return true;
	}
}
