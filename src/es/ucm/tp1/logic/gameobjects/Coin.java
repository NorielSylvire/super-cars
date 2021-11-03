package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;






public class Coin extends GameObject{
	
	private int numCoins;
	
	public Coin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	
	public  void onEnter() {
		
	}
	
	public void update() {
		
	}
	
	public  void onDelete() {
		game.addCoin();
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public static void reset() {
		this.numCoins = 0;
	}
}
