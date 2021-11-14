package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	
	public Player (Game game, int x, int y) {
		super(game, x, y);
		onEnter();
	}
	//Ponerlo mas bonito//
	public void playerUp() {
		this.y = Utils.clamp(y-1, 0, 2);
	}
	public void playerDown() {
		this.y = Utils.clamp(y+1, 0, 2);
	}
	
	public void showLife() {
		if(isAlive()) this.symbol = ">";
		else this.symbol = "@";
	}
	
	public void update() {
		this.x++;
		doCollision();
	}

	public boolean hasArrived(Level level) {
		return x == level.getLength();
	}
	
	public void onEnter() {
		this.alive = true;
	}
	
	public void onDelete() {
		this.alive = false;	
	}
	
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision(this);
		}
		return false;
	}

	public boolean receiveCollision(Player player) {
		return false;
	}
	@Override
	public String toString() {
		return getSymbol();
	}
	
	public void shoot() {
		
	}
}
