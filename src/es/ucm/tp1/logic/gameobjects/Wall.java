package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Wall extends GameObject {
	private static int numObstacles;
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	private static int life = 3;
	
	public Wall (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		numObstacles++;
		this.symbol = "█";
	}
	public void showLife() {
		if(life == 3) {
			this.symbol = "█";
		}
		if(life == 2) {
			this.symbol = "▒";
		}
		if(life == 1) {
			this.symbol = "░";
		}
		
	}
	public static int getObstaclesCount(){
		return numObstacles;
	}
	
	public void update() {
		showLife();
	}
	
	public void onDelete() {
		numObstacles--;
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public static void increaseNumObstacles() {
		numObstacles++;
	}
	
	public static void decreaseNumObstacles() {
		numObstacles--;
	}
	
	public static void reset() {
		numObstacles = 0;
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