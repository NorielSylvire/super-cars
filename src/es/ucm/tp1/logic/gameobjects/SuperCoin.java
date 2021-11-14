package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class SuperCoin extends GameObject{
	
	public static final String INFO = "[S]upercoin, objects to collect that give you 1000 coins.";

	
	public SuperCoin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		game.toggleSCoinIsPresent();
		this.alive = true;
		this.symbol = "$";
	}

	@Override
	public void showLife() {
		if(isAlive()) this.symbol = "$";
	}
	
	public void update() {
	}
	
	public void onDelete() {
		game.toggleSCoinIsPresent();
		this.alive = false;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		game.addCoins(1000);
		onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}
}
