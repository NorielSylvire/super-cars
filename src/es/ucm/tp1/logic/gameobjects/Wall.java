package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends GameObject {
	private static int numWalls;
	public static final String INFO = "[W]all, if the car crush with him the Game ENDS";
	
	public Wall (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		numWalls++;
		this.health = 3;
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
	public static int getObstaclesCount(){
		return numWalls;
	}
	
	public void update() {
		showLife();
	}
	
	public void onDelete() {
		numWalls--;
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public static void reset() {
		numWalls = 0;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		//añadir 5 coins al player;
		return true;
	}
	
}