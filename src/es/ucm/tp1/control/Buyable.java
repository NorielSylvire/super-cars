package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public interface Buyable {
	
	public int cost();
	
	public default boolean buy(Game game) {
		if(game.getPlayerCoins() >= cost()) {
			game.addCoins(-cost());
			return true;
		}
		else {
			game.printNotEnoughCoins();
			return false;
		}
	}

}
