package es.ucm.tp1.logic.lists;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Obstacle;

public class ObstacleList {
	private Obstacle[] obstacles;
	private int numObstacles;
	private Game game;
	
	public ObstacleList() {
		this.obstacles = new Obstacle[100];
		this.numObstacles = 0;
	}
	
	public void addObstacle(Game game,int x, int y) {
		obstacles[numObstacles] = new Obstacle(game,x, y);
		numObstacles++;
	}
}
