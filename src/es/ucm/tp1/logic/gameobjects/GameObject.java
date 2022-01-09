package es.ucm.tp1.logic.gameobjects;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements ICollider {
	protected int x, y;
	protected Game game;
	protected String symbol;
	protected boolean alive;
	protected boolean alreadyPrinted;
	protected int health;
	
	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.health = 1;
		this.alive = true;
		this.alreadyPrinted = false;
	}
	
	public abstract void onEnter();
	
	public abstract void onDelete();
	
	public abstract void showLife();
	
	public void update() {
		this.alreadyPrinted = false;
		showLife();
	}
	
	public boolean getAlreadyPrinted() {
		return this.alreadyPrinted;
	}
	
	public void printedThisTurn() {
		this.alreadyPrinted = true;
	}
	
	protected String getSymbol() {
		return symbol;
	}
	
	public String toStringSerialize() {
		return this.toString() + " (" + this.x + ", " + this.y + ")";
	}
	
	public String toString() {
		if(isAlive()) {
			return getSymbol();
		}
		return "";
	}
	
	public boolean isAlive() {
		if(health <= 0) this.alive = false;
		return this.alive;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean receiveWave() {
		this.x++;
		return true;
	}
	
	public void tryToMoveForward(GameObject nextGO) {
		if(nextGO == null) receiveWave();
	}
	
	public boolean isInPosition(int x, int y){
		return this.x == x && this.y == y;
	}
}
 	