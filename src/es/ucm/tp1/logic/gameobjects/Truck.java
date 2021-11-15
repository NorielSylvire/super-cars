package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Truck extends GameObject implements Collider{
	public static final String INFO = "[T]ruck, if the car collides with it the Game ENDS.";
	
	public Truck (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		showLife();
	}
	
	@Override
	public void update() {
		this.x--;
	}
	
	public void onDelete() {
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void showLife() {
		if(this.alive) this.symbol = "←";
		else this.symbol = "";
	}
	
}