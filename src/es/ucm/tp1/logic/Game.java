package es.ucm.tp1.logic;

import java.util.Scanner;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.Collider;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.logic.lists.CoinList;
import es.ucm.tp1.logic.lists.ObstacleList;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	private Long seed;
	private int cycles;
	private Level level;
	private int coins;
	private boolean finished;
	private Player player;
	private long start;
	private long finish;
	private long record;
	private boolean isExit;
	private GamePrinter gamePrinter;
	private GameObjectContainer container;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.coins = 0;
		this.isExit = false;
		this.record = 0;
		this.gamePrinter = new GamePrinter(this);
	}
	
	public void initialiseGame() {
		coins = 0;
		cycles = 0;
		GameObjectGenerator.generateGameObjects(this, level);
		start = System.currentTimeMillis();
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
		return level.getVisibility();
	}
	
	public int getRoadLength() {
		return level.getLength();
	}
	
	public int getRoadWidth() {
		return level.getWidth();
	}
	
	public GameObject getObjectInPosition(int x, int y) {
		return container.getObjectInList(x, y);
	}
	
	public void addGameObject(GameObject go) {
		container.addObject(go);
	}
	
	public long seed() {
		return this.seed;
	}
	
	public long getRecord() {
		return this.record;
	}
	public long elapsedTime() {
		return finish-start;
	}
	public boolean isNewRecord(long timeElapsed) {
		boolean isRecord = false;
		if(timeElapsed < this.record) {
			this.record = timeElapsed;
			isRecord = true;
		}
		return isRecord;
	}
	public boolean isTestMode(){
		return level.isTestMode();
	}
	public boolean hasArrived() {
		return player.hasArrived(level);
	}
	public boolean isUserExit() {
		return isExit;
	}
	public void toggleExit() {
		this.isExit = !this.isExit;
	}
	public boolean hasCrashed() {
		return !player.isAlive();
	}
	public int distanceToGoal() {
		return player.distanceToGoal(level);
	}
	public int playerCoins() {
		return coins;
	}
	public int getCycle() {
		return cycles;
	}
	public boolean isFinished() {
		return (isUserExit() || hasArrived() || hasCrashed());
	}
}
