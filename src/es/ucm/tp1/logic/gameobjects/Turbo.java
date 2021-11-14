package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Turbo extends GameObject {
	private static int numObstacles;
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	
	public Turbo (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		showLife();
	}
	
	public static int getObstaclesCount(){
		return numObstacles;
	}

	@Override
	public void showLife() {
		if (isAlive()) {
			this.symbol = ">>>";
		}
		else this.symbol = "";
	}
	
	public void update() {
		
	}
	
	public void onDelete() {
		showLife();
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.turboAdvance();
		player.onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}
	
}
