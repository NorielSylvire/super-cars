package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;

public class Game {
	private Long seed;
	private Level level;
	private int coins;
	private boolean finished;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.coins = 0;
	}
	
	public void toggleTest() {
		
	}
	
	public String getGameStatus() {
		
		return "Hola";
		
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public int getCoins() {
		return this.coins;
	}

}
