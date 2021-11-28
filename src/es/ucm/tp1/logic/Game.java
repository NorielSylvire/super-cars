package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.ThunderAction;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.logic.gameobjects.SuperCoin;
import es.ucm.tp1.logic.gameobjects.GameObjectContainer;
import es.ucm.tp1.control.InstantAction;
import es.ucm.tp1.view.GamePrinter;
import es.ucm.tp1.utils.Vector2;

public class Game {
	private Long seed;
	private int cycles;
	private Level level;
	private Player player;
	private long start;
	private long record;
	private boolean isExit;
	private GameObjectContainer container;
	
	public Game(Long seed, Level level) {
		this.seed = seed;
		this.level = level;
		this.isExit = false;
		this.record = 0;
		this.record = Integer.MAX_VALUE;
	}
	
	public void initialiseGame() {
		this.cycles = 0;
		this.player = new Player(this, 0, getRoadWidth()/2);
		this.container = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
		this.start = System.currentTimeMillis();
	}
	
	public void changeLevel(Level level, long seed) {;
		this.level = level;
		this.seed = seed;
	}
	
	public void addCoins(int amount) {
		player.addCoins(amount);
	}
	
	public int getPlayerCoins() {
		return player.getPlayerCoins();
	}

	public void deleteCoins() {
		player.deleteCoins();
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
		this.container.update();
		this.player.updateCollision();
	}
	
	public void movePlayer(boolean up) {
		if(up) player.playerUp();
		else player.playerDown();
		update();
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

	public GameObject getObjectInPositionLoop(int x, int y) {
		return container.getObjectInListLoop(x, y);
	}
	
	public void addGameObject(GameObject gameObject) {
		this.container.addObject(gameObject);
	}
	
	public void removeAllObjects() {
		this.container.reset();
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
	
	public int getCycle() {
		return cycles;
	}
	public boolean isFinished() {
		return (isUserExit() || hasArrived() || hasCrashed());
	}

	public void printInfo() {
		System.out.println(GamePrinter.description(level));
	}
	
	public void printNotEnoughCoins() {
		System.out.println(GamePrinter.notEnoughCoins());
	}
	
	public boolean isSuperCoinPresent() {
		return SuperCoin.isPresent();
	}
	
	public Vector2 getThunderPosition() {
		return ThunderAction.getPosition();
	}

	public void updateCollision() {
		player.updateCollision();
	}
	
	public void execute(InstantAction IA) {
		IA.executeIA(this);
	}

	public void generateCheatObjects(int objectID) {
		GameObjectGenerator.generateCheatObjects(this, getPlayerX() + getVisibility() - 1, objectID);
	}

	public void removeGameObject(GameObject gameObject) {
		container.deleteObject(gameObject);
	}

	public boolean hasAdvancedObjects() {
		return level.isAdvanced();
	}
}
