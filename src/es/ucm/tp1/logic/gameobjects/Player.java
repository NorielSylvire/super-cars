package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.view.GamePrinter;

public class Player extends GameObject{
	
	private boolean immune;
	private int coins;
	
	public Player (Game game, int x, int y) {
		super(game, x, y);
		this.onEnter();
	}
	
	public void onEnter() {
		this.coins = 0;
		showLife();
		this.immune = true;
	}
	
	public void onDelete() {
		this.alive = false;	
		showLife();
	}
	
	public void showLife() {
		if(isAlive()) this.symbol = ">";
		else this.symbol = "@";
	}
	
	@Override
	public void update() {
		moveForward();
	}
	
	public void updateCollision() {
		if(!this.immune) doCollision();
		else this.immune = false;
	}
	
	public boolean doCollision() {
		Collider other = game.getObjectInPosition(x, y);
		if (other != null) {
		return other.receiveCollision(this);
		}
		return false;
	}

	public boolean receiveCollision(Player player) {
		return false;
	}
	
	public boolean receiveShoot() {
		return false;
	}

	public boolean receiveExplosion() {
		return false;
	}

	public boolean receiveThunder() {
		return false;
	}
	
	public void playerUp() {
		this.y = Utils.clamp(y-1, 0, 2);
	}
	
	public void playerDown() {
		this.y = Utils.clamp(y+1, 0, 2);
	}

	public void turboAdvance() {
		this.x += 3;
		this.immune = true;
	}
	
	public void addCoins(int amount) {
		this.coins += amount;
	}
	
	public int getPlayerCoins() {
		return this.coins;
	}

	public void deleteCoins() {
		this.coins = 0;
	}

	public boolean hasArrived(Level level) {
		return x == level.getLength();
	}
}
