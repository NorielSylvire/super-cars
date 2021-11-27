package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends GameObject {
	private static int numObstacles;
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	
	public Obstacle (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.alive = true;
		numObstacles++;
		this.symbol = "░";
		this.health = 1;
	}
	
	public static int getObstaclesCount(){
		return numObstacles;
	}
	
	public void showLife() {
		if(isAlive()) {
			this.symbol = "░";
		}
		else this.symbol = "";
	}
	
	public void update() {
		showLife();
	}
	
	public void onDelete() {
		this.health--;
		this.alive = false;
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
		return true;
	}

	@Override
	public boolean receiveShoot() {
		onDelete();
		update();
		return true;
	}

	@Override
	public boolean receiveExplosion() {
		System.out.println("oof");
		this.onDelete();
		return true;
	}

	@Override
	public boolean receiveThunder() {
		this.onDelete();
		System.out.println(" -> Obstacle hit.");
		return true;
	}
	
}
