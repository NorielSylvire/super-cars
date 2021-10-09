package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;

public class Player extends GameObject{
	private int posX;
	private int posY;
	
	
	private int monedas;
	
	public Player(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
	}
	
	public void playerUp() {
		this.posY--;
		this.posY = Utils.clamp(posY, 0, 2);;
	}
	public void playerDown() {
		this.posY++;
		this.posY = Utils.clamp(posY, 0, 2);;
	}
	
	public void update() {
		this.posX++;
	}
	
	public int[] getPos() {
		int[] pos = {posX, posY};
		return pos;
	}
	
}
