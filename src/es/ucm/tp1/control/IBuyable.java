package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.*;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public interface IBuyable {
	
	public int cost();
	
	public default void buy(Game game) throws NotEnoughCoinsException{
		if(game.getPlayerCoins() >= cost()) {
			game.addCoins(-cost());
		}
		else throw new NotEnoughCoinsException("[ERROR] Not enough coins.\n");
	}
}
