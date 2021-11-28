package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Obstacle extends GameObject {
	private static int numObstacles;
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	
	public Obstacle (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		numObstacles++;
		this.alive = true;
		this.symbol = "░";
		this.health = 1;
	}
	
	public void onDelete() {
		this.health--;
		this.alive = false;
		numObstacles--;
	}
	
	public void showLife() {
		if(isAlive()) {
			this.symbol = "░";
		}
		else this.symbol = "";
	}
	
	public static int getObstaclesCount(){
		return numObstacles;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	public boolean receiveShoot() {
		onDelete();
		update();
		return true;
	}

	public boolean receiveExplosion() {
		System.out.println("oof");
		this.onDelete();
		return true;
	}

	public boolean receiveThunder() {
		this.onDelete();
		GamePrinter.thunderHitAnObject("Obstacle");
		return true;
	}
	
	public static void reset() {
		numObstacles = 0;
	}
	
}
