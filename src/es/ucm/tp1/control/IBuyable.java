package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.*;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public interface IBuyable {
	
	public int cost();
	
	public default boolean buy(Game game) throws NotEnoughCoinsException{
		if(game.getPlayerCoins() >= cost()) {
			game.addCoins(-cost());
			return true;
		}
		else throw new NotEnoughCoinsException("Not enough coins.");
	}
}
