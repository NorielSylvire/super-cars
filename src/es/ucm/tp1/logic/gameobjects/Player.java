package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	
	private boolean alive;
	
	public Player (Game game, int x, int y) {
		super(game, x, y);
	}
	//Ponerlo mas bonito//
	public void playerUp() {
		this.y = Utils.clamp(y-1, 0, 2);
	}
	public void playerDown() {
		this.y = Utils.clamp(y+1, 0, 2);
	}
	
	
	public void update() {
		this.x++;
		game.nextCycle();
	}
	
	public boolean isPlayerOut(Level level) {
		return (x == level.getLength()-level.getVisibility()+2 || !isAlive());
	}
	
	public void onEnter() {
		this.x = 0;
		this.y = 1;
		this.alive = true;
	}
	
	public void onDelete() {
		this.alive = false;	
	}
	
	public boolean isAlive() {
		return alive;
	}
	
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision (this);
		}
		return false;
	}

	public boolean receiveCollision(Player player) {
		return false;
	}
	
}
