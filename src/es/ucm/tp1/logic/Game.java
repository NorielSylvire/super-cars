package es.ucm.tp1.logic;

import java.util.Random;
import java.util.Scanner;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.lists.CoinList;
import es.ucm.tp1.logic.lists.GameObjectList;
import es.ucm.tp1.logic.lists.ObstacleList;
import es.ucm.tp1.view.GamePrinter;

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
	private Random rnd;
	private GamePrinter gamePrinter;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.coins = 0;
		this.player = new Player();
		this.obstacleList = new ObstacleList();
		this.coinList = new CoinList();
		this.test = false;
		//BUMP
		this.gamePrinter = new GamePrinter(this, level.getLength(), level.getWidth());
	}
	
	public void toggleTest() {
		this.test = !this.test;
		
		if(test) coins = 0;
		else start = System.currentTimeMillis();
	}
	
	public StringBuilder getGameStatus() {
		StringBuilder gameStatus = new StringBuilder();
		
		gameStatus.append("Level: ");
		gameStatus.append(level.name());
		
		gameStatus.append("\nSeed: ");
		gameStatus.append(seed);
		
		gameStatus.append("\nCoins: ");
		gameStatus.append(coins);
		
		//BUMP
		gameStatus.append("\nTotal obstacles: ");
		//gameStatus.append(obstacleList.getNumObstacles());
		
		gameStatus.append("\nTotal coins: ");
		//gameStatus.append(coinList.getNumCoins());
		
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
	
	public void initialiseGame() {
		if(level.name().equalsIgnoreCase("test")) test=true;
		
		rnd = new Random();
		rnd.setSeed(seed);
		String[][] s = new String[5][100];
		for(int i= 0; i< 100; i++ ) {
			for(int j=0; j<5; j++) {
				s[j][i] = "";
			}
		}	
		
		coins = 0;
		
		//BUMP 
		
		gamePrinter.setBoard(s);
		//BUMP getters y setters, y como calcular la longitud sin usar un get
		for (int x = level.getVisibility() / 2; x < level.getLength()-level.getVisibility(); x++) {
			tryToAddObstacle(x, getRandomLane(), level.getObstacleFrequency());
			tryToAddCoin(x, getRandomLane(), level.getCoinFrequency());
			}
		
		cycles = 0;
		start = System.currentTimeMillis();
	}
	

	
	private void tryToAddObstacle(int x, int y, double obsFrequency) {
		if (rnd.nextDouble() <= obsFrequency && checkPosition(x, y)) {
			obstacleList.addObstacle(x, y);
		}
	}
	
	private void tryToAddCoin(int x, int y, double cFrequency) {
		if (rnd.nextDouble() <= cFrequency && checkPosition(x, y)) {
			coinList.addCoin(x, y);
		}
	}
	//TODO checkear colisiones
	private boolean checkPosition(int x, int y) {
		boolean ret = true;
		if (game.getPlayer().getPos() == pos) ret = false;
		for (int i = 0; i < game.getObstacleList().getNumObstacles(); i++) {
			if (pos == game.getObstacleList().getObstacles()[i].getPosition()) {
				ret = false;
				break;
			}
		}
		for (int i = 0; i < game.getCoinList().getNumCoins(); i++) {
			if (pos == game.getCoinList().getCoins()[i].getPosition()) {
				ret = false;
				break;
			}
		}
		return ret;
	}
	
	public void changeLevel() {
		
			String leveleado;
			Double semillita;
			
			System.out.print("Escoge dificultad");
			Scanner s;
			s = new Scanner(System.in);
			leveleado = s.nextLine();
			level = level.valueOfIgnoreCase(leveleado);
			
			System.out.print("Escoge la semilla");
			semillita = s.nextDouble();
	}
	
	//BUMP Can we do level.getWidth()
	private int getRandomLane() {
		int ret = rnd.nextInt() % level.getWidth();
		if (ret < 0) ret = - ret;
		return ret;
	}
	
	public void addCoins() {
		this.coins++;
	}
	
	public void nextCycle() {
		this.cycles++;
	}
	
	public void update() {
		this.player.update(gamePrinter, this);
	}
	
	public void movePlayer(boolean up) {
		if(up) player.playerUp();
		else player.playerDown();
		
		player.update(gamePrinter, this);
	}
	
	public void finishGame() {
		this.finished = true;
	}
	
	public boolean isPlayerOut() {
		return player.isPlayerOut(level);
	}
	
	public boolean isFinished() {
		return this.finished;
	}
	
	public void setFinished(boolean end) {
		this.finished = end;
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
