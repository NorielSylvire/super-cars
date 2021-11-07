package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	
	public Player (Game game2, int x2, int y2) {
		super(game2, x2, y2);
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

	public boolean hasArrived(Level level) {
		return x == level.finishLine();
	}
	
	public void onEnter() {
		this.x = 0;
		this.y = 1;
		this.symbol = ">";
		this.alive = true;
	}
	
	public void onDelete() {
		this.symbol = "@";
		this.alive = false;	
	}
	
	public boolean isAlive() {
		return this.alive;
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
	public int distanceToGoal(Level level) {
		return level.finishLine() - x;
	}
	
}
