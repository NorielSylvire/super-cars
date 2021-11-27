package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.ExplosionAction;

public class Grenade extends GameObject implements Collider {
	public static final String INFO = "[G]ruck, if the car collides with it the Game ENDS.";
	
	
	public Grenade(Game game, int x, int y) {
		super(game,x,y);
	}

	public void onEnter() {
		this.health = 3;
		this.alive = true;
		this.symbol = "ð";
		showLife();
	}
	
	@Override
	public void update() {
		this.health--;
		System.out.println("Estoy en " + this.x + " , " + this.y + " y tengo " + this.health + " puntos de vida.");
		this.showLife();
		if (this.health == 0) onDelete();
	}
	
	public void onDelete() {
		game.execute(new ExplosionAction(this.x,this.y));
		this.alive = false;
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

	@Override
	public boolean receiveShoot() {
		return false;
	}

	@Override
	public void showLife() {
		if(this.health > 0){
			this.symbol = "ð [" + this.health + "]";
		}
		else this.symbol = "";
	}
	public boolean receiveExplosion() {
		this.health = 0;
		return false;
	}

	@Override
	public boolean receiveThunder() {
		System.out.println();
		return false;
	}

}
