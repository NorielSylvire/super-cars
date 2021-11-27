package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Turbo extends GameObject {
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	
	public Turbo (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.alive = true;
		showLife();
	}
	@Override
	public void showLife() {
		if (isAlive()) {
			this.symbol = ">>>";
		}
		else this.symbol = "";
	}
	
	public void update() {
		
	}
	
	public void onDelete() {
		showLife();
		this.alive = false;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.turboAdvance();
		this.onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public boolean receiveExplosion() {
		return false;
	}

	@Override
	public boolean receiveThunder() {
		System.out.println();
		return false;
	}
	
}
