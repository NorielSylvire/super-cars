package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Obstacle {
	private int posX;
	private int posY;
	
	public Obstacle(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int[] getPosition() {
		int[] pos = {posX, posY};
		return pos;
	}
}
