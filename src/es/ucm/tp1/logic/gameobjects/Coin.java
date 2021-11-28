package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	private static int numCoins = 0;
	public static final String INFO = "[Coin] gives 1 coin to the player.";
	protected int reward = 1;

	
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
		addCoins();
		return true;
	}

	public boolean receiveShoot() {
		return false;
	}

	public boolean receiveExplosion() {
		return false;
	}

	public boolean receiveThunder() {
		System.out.println();
		return false;
	}
	
	public static int getCoinsCount() {
		return numCoins;
	}
	
	public static void reset() {
		numCoins = 0;
	}

	protected void addCoins() {
		game.addCoins(reward);
	}
}
