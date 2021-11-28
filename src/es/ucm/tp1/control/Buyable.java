package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public interface Buyable {
	
	public int cost();
	
	public default boolean buy(Game game) {
		if(game.getPlayerCoins() >= cost()) {
			game.addCoins(-cost());
			return true;
		}
		else {
			System.out.println(GamePrinter.notEnoughCoins());
			return false;
		}
	}

}
