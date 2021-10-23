package es.ucm.tp1.logic.lists;

import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.Obstacle;

public class CoinList{//No voy a usar extends GameObjectList porque supongo que es de prácticas posteriores.
	private Coin[] coins;
	private int numCoins;
	
	public CoinList() {
		coins = new Coin[100];
		this.numCoins = 0;
	}
	
	public void addCoin(int x, int y) {
		coins[numCoins] = new Coin(x, y);
		numCoins++;
	}

}
