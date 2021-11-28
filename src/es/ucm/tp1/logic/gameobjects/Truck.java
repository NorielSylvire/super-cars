package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class Truck extends GameObject {
	public static final String INFO = "[T]ruck, if the car collides with it the Game ENDS.";
	
	public Truck (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		showLife();
	}
	
	public void onDelete() {
		this.health--;
		this.alive = false;
	}
	
	@Override
	public void update() {
		super.update();
		this.x--;
	}

	public void showLife() {
		if(this.alive) this.symbol = "←";
		else this.symbol = "";
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	public boolean receiveShoot() {
		return false;
	}

	public boolean receiveExplosion() {
		this.onDelete();
		return true;
	}

	public boolean receiveThunder() {
		this.onDelete();
		GamePrinter.thunderHitAnObject("Truck");
		return true;
	}
	
}