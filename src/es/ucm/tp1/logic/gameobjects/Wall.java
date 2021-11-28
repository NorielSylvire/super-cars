package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends GameObject {	
	public static final String INFO = "[WALL] hard obstacle.";
	
	public Wall (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.health = 3;
		showLife();
	}
	
	public void onDelete() {
		game.addCoins(5);
		this.health = 0;
		this.alive = false;
		showLife();
	}
	
	public void showLife() {
		if(health == 3) {
			this.symbol = "█";
		}
		if(health == 2) {
			this.symbol = "▒";
		}
		if(health == 1) {
			this.symbol = "░";
		}
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	public boolean receiveShoot() {
		this.health--;
		showLife();
		return true;
	}

	public boolean receiveExplosion() {
		this.onDelete();
		return true;
	}

	public boolean receiveThunder() {
		this.onDelete();
		System.out.println(" -> " + this.getSymbol());
		return true;
	}
	
}