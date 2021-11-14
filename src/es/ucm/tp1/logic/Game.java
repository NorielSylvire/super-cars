package es.ucm.tp1.logic;

import java.util.Scanner;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.*;
import es.ucm.tp1.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.view.GamePrinter;

public class Game {
	private Long seed;
	private int cycles;
	private Level level;
	private int coins;
	private boolean finished;
	private Player player;
	private long start;
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
		this.coins = 0;
		this.cycles = 0;
		this.player = new Player(this, 0, getRoadWidth()/2);
		this.container = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
		this.start = System.currentTimeMillis();
	}
	
	public void changeLevel() {
		String inputString;
		System.out.print("Choose a difficulty: ");
		Scanner s;
		s = new Scanner(System.in);
		inputString = s.nextLine();
		level = level.valueOfIgnoreCase(inputString);
		System.out.print("Choose a seed: ");
		seed = s.nextLong();
		System.out.println();
	}
	
	public void addCoins() {
		this.coins++;
	}
	
	public void removeDead() {
		container.removeDead();
	}
	
	public void nextCycle() {
		this.cycles++;
	}
	
	public void update() {
		nextCycle();
		this.player.update();
	}
	
	public void movePlayer(boolean up) {
		if(up) player.playerUp();
		else player.playerDown();
		player.update();
	}
	
	public int getPlayerY() {
		return player.getY();
	}
	
	public int getPlayerX() {
		return player.getX();
	}
	
	public String getPlayerSymbol() {
		return player.toString();
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
	
	public void addGameObject(GameObject gameObject) {
		container.addObject(gameObject);
	}
	
	public long seed() {
		return this.seed;
	}
	
	public long getRecord() {
		return this.record;
	}
	public long elapsedTime() {
		return System.currentTimeMillis()-start;
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
		return level.getLength() - player.getX();
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

	public void printInfo() {
		System.out.println(GamePrinter.description(level));
	}
	
	public void addSuperCoins() {
		this.coins += 100;
	}

	public void shoot() {
		player.shoot();
	}
}
