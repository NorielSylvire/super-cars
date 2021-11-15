package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Pedestrian extends GameObject {
	private static int numObstacles;
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	
	public Pedestrian (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		numObstacles++;
		this.symbol = "☺";
	}
	
	public static int getObstaclesCount(){
		return numObstacles;
	}
	
	public void update() {
		//Dos ifs para el tope de arriba  y el tope de abajo
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
		return true;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showLife() {
		
	}
	
}
