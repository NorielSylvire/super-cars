package es.ucm.tp1.logic;

import java.util.Random;
import java.util.Scanner;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.gameobjects.GameObjectContainer;
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
	private long start;
	private long finish;
	private boolean test;
	private Random rnd;
	private GamePrinter gamePrinter;
	private GameObjectContainer container;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.coins = 0;
		//this.player = new Player();
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
		coins = 0;
		rnd = new Random();
		rnd.setSeed(seed);
		String[][] s = new String[5][100];
		for(int i= 0; i< 100; i++ ) {
			for(int j=0; j<5; j++) {
				s[j][i] = "";
			}
		}
		GameObjectGenerator.generateGameObjects(this, level);
		gamePrinter.setBoard(s);
		cycles = 0;
		start = System.currentTimeMillis();
	}
	

	
	public void tryToAddObject(GameObject gameobject,  double frequency) {
		if (rnd.nextDouble() <= frequency) {
			//gameobjectlist ADD//
		}
	}
	
	public void changeLevel() {
			String inputString;
			
			System.out.print("Choose a difficulty: ");
			Scanner s;
			s = new Scanner(System.in);
			inputString = s.nextLine();
			level = level.valueOfIgnoreCase(inputString);
			System.out.print("\nChoose a seed: ");
			seed = s.nextLong();
			System.out.println();
			s.close();
	}
	
	//BUMP Can we do level.getWidth()
	public int getRandomLane() {
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
		this.player.update();
	}
	
	public void movePlayer(boolean up) {
		if(up) player.playerUp();
		else player.playerDown();
		player.update();
	}
	
	public int getVisibility() {
		//preguntar al profe
		return level.getVisibility();
	}
	
	public int getRoadLength() {
		return level.getLength();
	}
	
	public int getRoadWidth() {
		return level.getWidth();
	}
	
	public void getObjectInPosition(int x, int y) {
		
	}
	
}
