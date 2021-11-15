package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	
	private boolean immune;
	
	public Player (Game game, int x, int y) {
		super(game, x, y);
		onEnter();
	}
	
	public void playerUp() {
		this.y = Utils.clamp(y-1, 0, 2);
	}
	
	public void playerDown() {
		this.y = Utils.clamp(y+1, 0, 2);
	}

	public void turboAdvance() {
		this.x += 3;
		this.immune = true;
	}
	
	public void showLife() {
		if(isAlive()) this.symbol = ">";
		else this.symbol = "@";
	}
	
	public void update() {
		moveForward();
		updateCollision();
	}
	
	public void updateCollision() {
		if(!this.immune) doCollision();
		else this.immune = false;
	}

	public boolean hasArrived(Level level) {
		return x == level.getLength();
	}
	
	public void onEnter() {
		showLife();
		this.immune = true;
	}
	
	public void onDelete() {
		this.alive = false;	
		showLife();
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
		Collider other;
		for (int i = 1; i < game.getVisibility() + 1; i++) {
			other = game.getObjectInPosition(x+i, y);
			if (other != null) {
				if(other.receiveShoot()) {
					break;
				}
			}
		}
	}
	
	@Override
	public boolean receiveShoot() {
		return false;
	}
}
