package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	private static int numCoins = 0;
	public static final String INFO = "[C]oins, objects to collect";

	
	public Coin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.alive = true;
		numCoins++;
		this.symbol = "¢";
	}
	
	public void onDelete() {
		numCoins--;
		health--;
		this.alive = false;
	}
	
	public void showLife() {
		if(isAlive()) this.symbol = "¢";
		else this.symbol = "";
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		onDelete();
		addCoins(game);
		return true;
	}

	public boolean receiveShoot() {
		return false;
	}

	public boolean receiveExplosion() {
		return false;
	}

	public boolean receiveThunder() {
		return false;
	}
	
	public static int getCoinsCount() {
		return numCoins;
	}
	
	public static void reset() {
		numCoins = 0;
	}

	private void addCoins(Game game) {
		game.addCoins(1);
	}
}
