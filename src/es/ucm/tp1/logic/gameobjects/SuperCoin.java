package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class SuperCoin extends GameObject{
	
	private static int numCoins = 0;
	public static final String INFO = "[C]oins, objects to collect";
	private boolean isInGame = false;

	
	public SuperCoin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public static int getCoinsCount() {
		return numCoins;
	}
	
	public void onEnter() {
		this.alive = true;
		increaseNumCoins();
		this.symbol = "$";
	}
	public String apears() {
		if( symbol == "$") {
			isInGame = true;
			return " Supercoin is present.";
		}
		else {
			isInGame = false;
		}
		
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
	
	private void addSuperCoins(Game game) {
		game.addSuperCoins();
	}
	
	public boolean receiveCollision(Player player) {
		addSuperCoins(game);
		onDelete();
		return true;
	}
}
