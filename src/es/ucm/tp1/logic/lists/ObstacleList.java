package es.ucm.tp1.logic.lists;

import es.ucm.tp1.logic.gameobjects.Obstacle;

public class ObstacleList {
	private Obstacle[] obstacles;
	private int numObstacles;
	
	public ObstacleList() {
		this.obstacles = new Obstacle[100];
		this.numObstacles = 0;
	}
	
	public void addObstacle(int x, int y) {
		obstacles[numObstacles] = new Obstacle(x, y);
		numObstacles++;
	}
}
