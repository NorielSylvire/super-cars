package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.ExplosionAction;

public class Grenade extends GameObject implements Collider {
	public static final String INFO = "[GRENADE] Explodes in 3 cycles, harming everyone around.";
	
	
	public Grenade(Game game, int x, int y) {
		super(game,x,y);
	}

	public void onEnter() {
		this.health = 3;
		this.alive = true;
		this.symbol = "ð";
		showLife();
	}
	
	public void onDelete() {
		game.execute(new ExplosionAction(this.x,this.y));
		this.alive = false;
	}
	
	@Override
	public void update() {
		super.update();
		this.health--;
		if (this.health == 0) onDelete();
	}

	public void showLife() {
		if(this.health > 0){
			this.symbol = "ð [" + this.health + "]";
		}
		else this.symbol = "";
	}
	
	@Override
	public String toStringSerialize() {
		return this.toString() + " (" + this.x + ", " + this.y + ") " + this.health;
	}
	
	public boolean isAlive() {
		return this.alive;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		return false;
	}

	public boolean receiveShoot() {
		return false;
	}
	
	public boolean receiveExplosion() {
		this.health = 0;
		return false;
	}

	public boolean receiveThunder() {
		return false;
	}

}
