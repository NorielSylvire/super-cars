package es.ucm.tp1.logic.gameobjects;

public class Coin {
	private int posX;
	private int posY;

	public Coin(int x, int y) {
		this.posX = x;
		this.posY = y;
	}
	
	public int[] getPosition() {
		int[] pos = {posX, posY};
		return pos;
	}
}
