package es.ucm.tp1.logic.gameobjects;
import es.ucm.tp1.logic.Game;

public abstract class GameObject implements Collider {
	protected int x, y;
	protected Game game;
	protected String symbol;
	
	public GameObject(Game game, int x, int y) {
		this. x = x;
		this. y = y;
		this. game = game;
	}
	
	protected String getSymbol() {
		return symbol;
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
	
	public abstract boolean isAlive();
	
	public String toString() {
		if(isAlive()) {
			return getSymbol();
		}
		return "";
	}
}
 	