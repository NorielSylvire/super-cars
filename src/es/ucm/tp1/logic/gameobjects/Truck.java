package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Truck extends GameObject {
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
		this.health--;
		this.alive = false;
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

	@Override
	public boolean receiveExplosion() {
		this.onDelete();
		return true;
	}

	@Override
	public boolean receiveThunder() {
		this.onDelete();
		System.out.println(" -> Thunder hit.");
		return true;
	}
	
}