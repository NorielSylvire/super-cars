package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class SuperCoin extends Coin{
	
	public static boolean isPresent;
	public static final String INFO = "[SUPERCOIN] gives 1000 coins.";
	
	public SuperCoin (Game game, int x, int y) {
		super(game, x, y);
	}
	
	@Override
	public void onEnter() {
		isPresent = true;
		this.reward = 1000;
		this.alive = true;
		this.symbol = "$";
	}
	
	@Override
	public void onDelete() {
		isPresent = false;
		this.alive = false;
	}

	@Override
	public void showLife() {
		if(isAlive()) this.symbol = "$";
	}
	
	public static boolean isPresent() {
		return isPresent;
	}
}
