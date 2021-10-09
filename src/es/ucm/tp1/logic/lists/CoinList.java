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
	
	public Coin[] getCoins() {
		return this.coins;
	}
	
	public void setCoins(Coin[] c) {
		this.coins = c;
	}
	
	public int getNumCoins() {
		return this.numCoins;
	}
	
	public void setNumCoins(int num) {
		this.numCoins = num;
	}

}
