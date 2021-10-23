package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	private int posX;
	private int posY;
	private boolean dead;
	
	public Player() {
		this.posX = 0;
		this.posY = 1;
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
		if(gamePrinter.getBoard()[posY][posX+1] == "O" && !game.getTest()) {
			game.addCoins();
		}
		this.posX++;
		
		gamePrinter.clean(this.posX, this.posY);
		
		game.nextCycle();
	}
	
	public boolean isPlayerOut(Level level) {
		return (posX == level.getLength()-level.getVisibility()+2 || dead);
	}
	
}
