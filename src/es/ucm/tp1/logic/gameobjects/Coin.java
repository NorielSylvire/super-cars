package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Coin extends GameObject{
	
	private static int numCoins = 0;
	public static final String INFO = "[C]oins, objects to collect";

	
	public Coin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public static int getCoinsCount() {
		return numCoins;
	}
	
	public void onEnter() {
		this.alive = true;
		numCoins++;
		this.symbol = "¢";
	}
	
	public void showLife() {
		if(isAlive()) this.symbol = "¢";
		else this.symbol = "";
	}
	
	public void update() {}
	
	public void onDelete() {
		numCoins--;
		health--;
		this.alive = false;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public static void reset() {
		numCoins = 0;
	}
	
	public boolean doCollision() {
		return false;
	}

	private void addCoins(Game game) {
		game.addCoins(1);
	}
	
	public boolean receiveCollision(Player player) {
		onDelete();
		addCoins(game);
		return true;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

	@Override
	public boolean receiveThunder() {
		System.out.println();
		return false;
	}
}
