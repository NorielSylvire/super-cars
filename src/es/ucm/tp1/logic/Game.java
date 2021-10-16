package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.lists.CoinList;
import es.ucm.tp1.logic.lists.GameObjectList;
import es.ucm.tp1.logic.lists.ObstacleList;

public class Game {
	private Long seed;
	private int cycles;
	private Level level;
	private int coins;
	private boolean finished;
	private GameObjectList gameObjectList;
	private Player player;
	private ObstacleList obstacleList;
	private CoinList coinList;
	private long start;
	private long finish;
	private boolean test;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.coins = 0;
		this.player = new Player(0, 1);
		this.obstacleList = new ObstacleList();
		this.coinList = new CoinList();
		this.test = false;
	}
	
	public void toggleTest() {
		this.test = !this.test;
	}
	
	public StringBuilder getGameStatus() {
		StringBuilder gameStatus = new StringBuilder();
		
		gameStatus.append("Level: ");
		gameStatus.append(level.getName());
		
		gameStatus.append("\nSeed: ");
		gameStatus.append(seed);
		
		gameStatus.append("\nCoins: ");
		gameStatus.append(coins);
		
		gameStatus.append("\nTotal obstacles: ");
		gameStatus.append(obstacleList.getNumObstacles());
		
		gameStatus.append("\nTotal coins: ");
		gameStatus.append(coinList.getNumCoins());
		
		gameStatus.append("\nCycles: ");
		gameStatus.append(cycles);

		if (!this.test) {
			gameStatus.append("\nTime Elapsed: ");
			finish = System.currentTimeMillis();
			gameStatus.append(finish - start);
			gameStatus.append(" ms");
		}
		
		return gameStatus;
		
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(boolean end) {
		this.finished = end;
	}
	
	public void setCoins(int coins) {
		this.coins = coins;
	}
	
	public int getCoins() {
		return this.coins;
	}
	
	public boolean getTest() {
		return this.test;
	}
	
	public void setTest(boolean test) {
		this.test = test;
	}
	
	public void setStart(long start) {
		this.start = start;
	}
	
	public long getStart() {
		return this.start;
	}
	
	public long getSeed() {
		return this.seed;
	}
	
	public int getCycles() {
		return this.cycles;
	}
	
	public void setCycles(int cycles) {
		this.cycles = cycles;
	}
	
	public Level getLevel() {
		return this.level;
	}
	
	public GameObjectList getGameObjectList() {
		return gameObjectList;
	}
	
	public void setGameObjectList(GameObjectList newGameObjectList) {
		this.gameObjectList = newGameObjectList;
	}
	
	public Player getPlayer() {
		return this.player;
	}
	
	public void setPlayer(Player p) {
		this.player = p;
	}
	
	public ObstacleList getObstacleList() {
		return this.obstacleList;
	}
	
	public void setObstacleList(ObstacleList o) {
		this.obstacleList = o;
	}
	
	public CoinList getCoinList() {
		return this.coinList;
	}
	
	public void setCoinList(CoinList c) {
		this.coinList = c;
	}

}
