package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Pedestrian extends GameObject {
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	public boolean bordearriba = true;
	
	public Pedestrian (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.symbol = "☺";
	}
	
	public void checkBorde() {
		if(this.y == 0) this.bordearriba = true ;
		if(this.y == (game.getRoadWidth()-1)) this.bordearriba = false;
	}
	
	public void update() {
		checkBorde();
		if(this.bordearriba == true) this.y++;
		if(this.bordearriba == false) this.y--;
	}
	
	public void onDelete() {
		this.health --;
		this.alive = false;
		showLife();
	}
	
	public boolean isAlive() {
		return this.alive;
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
		onDelete();
		game.deleteCoins();
		return true;
	}

	
	@Override
	public void showLife() {
		if(isAlive()) {
			this.symbol = "☺";
		}
		else this.symbol = "";
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
