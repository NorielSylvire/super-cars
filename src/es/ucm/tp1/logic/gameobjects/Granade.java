package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.ExplosionAction;

public class Granade extends GameObject {
	public static final String INFO = "[T]ruck, if the car collides with it the Game ENDS.";
	
	
	public Granade(Game game, int x, int y) {
			super(game,x,y);
	}

	public void onEnter() {
		this.health =4;
		showLife();
		
		
	}
	
	@Override
	public void update() {
		this.health--;
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
		if(health == 3) {
			this.symbol = "█";
		}
		if(health == 2) {
			this.symbol = "▒";
		}
		if(health == 1) {
			this.symbol = "░";
		}
		else{
			game.execute(new ExplosionAction(this.x,this.y));
		};
	}
	public boolean receiveExplosion() {
		return false;
	}

}
