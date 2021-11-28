package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Turbo extends GameObject {
	public static final String INFO = "[TURBO] pushes the car 3 columns.";
	
	public Turbo (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.alive = true;
		showLife();
	}
	
	public void onDelete() {
		showLife();
		this.alive = false;
	}
	
	public void showLife() {
		if (isAlive()) {
			this.symbol = ">>>";
		}
		else this.symbol = "";
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.turboAdvance();
		this.onDelete();
		return true;
	}

	public boolean receiveShoot() {
		return false;
	}

	public boolean receiveExplosion() {
		return false;
	}

	public boolean receiveThunder() {
		System.out.println();
		return false;
	}
	
}
