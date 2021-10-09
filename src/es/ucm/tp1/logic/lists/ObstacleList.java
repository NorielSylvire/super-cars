package es.ucm.tp1.logic.lists;

import es.ucm.tp1.logic.gameobjects.Obstacle;

public class ObstacleList {
	private Obstacle[] obstacles;
	private int numObstacles;
	
	public ObstacleList() {
		obstacles = new Obstacle[100];
		this.numObstacles = 0;
	}
	
	public Obstacle[] getObstacles() {
		return obstacles;
	}
	
	public void setObstacles(Obstacle[] o) {
		this.obstacles = o;
	}
	
	public int getNumObstacles() {
		return numObstacles;
	}
	
	public void setNumObstacles(int num) {
		this.numObstacles = num;
	}
}
