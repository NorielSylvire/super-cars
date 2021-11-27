package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends GameObject {
	private static int numWalls;
	public static final String INFO = "[W]all, if the car crush with him the Game ENDS";
	
	public Wall (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.health = 3;
		this.symbol = "█";
		showLife();
	}
	
	public void showLife() {
		System.out.println(this.symbol + "<---- HERE");
		if(health == 3) {
			this.symbol = "█";
		}
		if(health == 2) {
			this.symbol = "▒";
		}
		if(health == 1) {
			this.symbol = "░";
		}
		else this.symbol = "";
	}
	
	public static int getObstaclesCount(){
		return numWalls;
	}
	
	public void update() {
		showLife();
	}
	
	public void onDelete() {
		numWalls--;
		showLife();
		game.addCoins(5);
		this.health = 0;
		this.alive = false;
	}
	
	public static void reset() {
		numWalls = 0;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		this.health--;
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		this.onDelete();
		return true;
	}

	@Override
	public boolean receiveThunder() {
		this.onDelete();
		System.out.println(" -> Wall hit.");
		return true;
	}
	
}