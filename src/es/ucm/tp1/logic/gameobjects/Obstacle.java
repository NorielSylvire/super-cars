package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle extends GameObject {
	private int numObstacle;
	
	public Obstacle (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public  void onEnter() {
		
	}
	
	public void update() {
		
	}
	
	public  void onDelete() {
		
	}
	
	public boolean isAlive() {
		return true;
	}
	public static void reset() {
		this.numObstacle = 0;
	}
}
