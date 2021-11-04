package es.ucm.tp1.logic.lists;

import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.Game;

public class CoinList{//No voy a usar extends GameObjectList porque supongo que es de prácticas posteriores.
	private Coin[] coins;
	private int numCoins;
	private Game game;
	
	public CoinList() {
		coins = new Coin[100];
		this.numCoins = 0;
	}
	
	public void addCoin(Game game,int x, int y) {
		coins[numCoins] = new Coin(game, x, y);
		numCoins++;
	}

}
