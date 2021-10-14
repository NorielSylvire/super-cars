package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	private int posX;
	private int posY;
	private boolean dead;
	
	public Player(int posX, int posY) {
		this.posX = posX;
		this.posY = posY;
		this.dead = false;
	}
	
	public void playerUp() {
		this.posY--;
		this.posY = Utils.clamp(posY, 0, 2);;
	}
	public void playerDown() {
		this.posY++;
		this.posY = Utils.clamp(posY, 0, 2);;
	}
	
	public void update(GamePrinter gamePrinter, Game game) {
		if(gamePrinter.getBoard()[posY][posX+1] == "░░░░░") {
			this.dead = true;
		}
		if(gamePrinter.getBoard()[posY][posX+1] == "O") {
			game.setCoins(game.getCoins()+1);
		}
		this.posX++;
		
		game.setCycles(game.getCycles()+1);
	}
	
	public int[] getPos() {
		int[] pos = {posX, posY};
		return pos;
	}
	
	
	public boolean getDead() {
		return this.dead;
	}
	
}
