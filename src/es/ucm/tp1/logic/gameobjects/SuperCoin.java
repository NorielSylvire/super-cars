package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class SuperCoin extends GameObject{
	
	public static boolean isPresent;
	public static final String INFO = "[S]upercoin, objects to collect that give you 1000 coins.";

	
	public SuperCoin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		isPresent = true;
		this.alive = true;
		this.symbol = "$";
	}
	
	public void onDelete() {
		isPresent = false;
		this.alive = false;
	}

	public void showLife() {
		if(isAlive()) this.symbol = "$";
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		game.addCoins(1000);
		onDelete();
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
	
	public static boolean isPresent() {
		return isPresent;
	}
}
