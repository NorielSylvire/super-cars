package es.ucm.tp1.logic.gameobjects;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements Collider {
	protected int x, y;
	protected Game game;
	protected String symbol;
	protected boolean alive;
	protected int health;
	
	public GameObject(Game game, int x, int y) {
		this.x = x;
		this.y = y;
		this.game = game;
		this.health = 1;
		this.alive = true;
	}
	
	protected String getSymbol() {
		return symbol;
	}
	
	public void moveForward() {
		this.x++;
	}
	
	public void tryToMoveForward(GameObject nextGO) {
		if(nextGO == null) moveForward();
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public boolean isInPosition(int x, int y){
		return this.x == x && this.y == y;
	}
	
	public abstract void onEnter();
	
	public abstract void update();
	
	public abstract void onDelete();
	
	public abstract void showLife();
	
	public boolean isAlive() {
		if(health == 0) this.alive = false;
		return this.alive;
	}
	
	public String toString() {
		if(isAlive()) {
			return getSymbol();
		}
		return "";
	}
}
 	