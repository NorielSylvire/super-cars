package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Pedestrian extends GameObject {
	public static final String INFO = "[PEDESTRIAN] person crossing the road up and down.";
	public boolean bordearriba = true;
	
	public Pedestrian (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		this.alive = true;
		this.health = 1;
		this.symbol = "☺";
	}
	
	public void onDelete() {
		this.health --;
		game.deleteCoins();
		showLife();
	}
	
	@Override
	public void update() {
		super.update();
		checkBorde();
		if(this.bordearriba == true) this.y++;
		if(this.bordearriba == false) this.y--;
	}
	
	public void showLife() {
		if(isAlive()) {
			this.symbol = "☺";
		}
		else this.symbol = "";
	}
	
	@Override
	public String toStringSerialize() {
		String ret = this.toString() + " (" + this.x + ", " + this.y + ")";
		if(this.bordearriba == true) ret += " down";
		else ret += " up";
		return ret;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		this.onDelete();
		return true;
	}

	public boolean receiveShoot() {
		this.onDelete();
		return true;
	}

	public boolean receiveExplosion() {
		this.onDelete();
		return false;
	}

	public boolean receiveThunder() {
		System.out.println();
		return false;
	}
	
	public void checkBorde() {
		if(this.y == 0) this.bordearriba = true ;
		if(this.y == (game.getRoadWidth()-1)) this.bordearriba = false;
	}
	
}
