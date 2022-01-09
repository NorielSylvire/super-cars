package es.ucm.tp1.logic;

import es.ucm.tp1.control.Level;
import es.ucm.tp1.control.Record;
import es.ucm.tp1.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.control.exceptions.InvalidPositionException;
import es.ucm.tp1.logic.gameobjects.ICollider;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Player;
import es.ucm.tp1.control.IInstantAction;

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
	
	public boolean initialiseGame() throws InputOutputRecordException {
		this.cycles = 0;
		this.player = new Player(this, 0, getRoadWidth()/2);
		this.container = new GameObjectContainer();
		GameObjectGenerator.generateGameObjects(this, level);
		this.start = System.currentTimeMillis();
		try {
			Record.readRecord();
		} catch (InputOutputRecordException e) {
			e.printStackTrace();
			Record.writeRecord(this);
			toggleExit();
			return false;
		}
		return true;
	}
	
	public void updateCycles() {
		nextCycle();
		GameObjectGenerator.generateRuntimeObjects(this);
		player.doCollision();
		container.update();
	}
	
	public void updatePlayer() {
		player.update();
	}
	
	public void updateCollision() {
		player.doCollision();
	}
	
	public void movePlayer(boolean up) {
		if(up) player.playerUp();
		else player.playerDown();
		updateCycles();
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
	
	public void changeLevel(Level level, long seed) {
		this.level = level;
		this.seed = seed;
	}
	
	public void addCoins(int amount) {
		player.addCoins(amount);
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
	
	public long getSeed() {
		return this.seed;
	}

	public Level getLevel() {
		return this.level;
	}
	
	public int getPlayerCoins() {
		return player.getPlayerCoins();
	}

	public int getCycle() {
		return cycles;
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
	
	public ICollider getObjectInPosition(int x, int y) {
		return container.getObjectInList(x, y);
	}

	public StringBuilder getAllSymbolsInPosition(int x, int y) {
		return container.getAllSymbolsInPosition(x, y);
	}

	public StringBuilder getAllSymbolsInPositionSerialize(int x, int y) {
		return container.getAllSymbolsInPositionSerialize(x, y);
	}
	
	public long getRecord() {
		return this.record;
	}
	public long getElapsedTime() {
		return System.currentTimeMillis()-start;
	}
	
	public void addGameObject(GameObject gameObject) throws InvalidPositionException {
		if(gameObject.getX() < 0 || gameObject.getX() > getRoadLength() || gameObject.getY() < 0 || gameObject.getY() > getRoadWidth())
			throw new InvalidPositionException("[ERROR] The position you have entered is invalid. \n");
		this.container.addObject(gameObject);
	}
	
	public void removeAllObjects() {
		this.container.reset();
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
	
	public boolean isFinished() {
		return (isUserExit() || hasArrived() || hasCrashed());
	}
	
	public void execute(IInstantAction IA) {
		IA.executeIA(this);
	}

	public void generateCheatObjects(int objectID) {
		GameObjectGenerator.generateCheatObjects(this, getPlayerX() + getVisibility() - 1, objectID);
	}

	public void removeGameObject(ICollider gameObject) {
		container.deleteObject(gameObject);
	}

	public boolean hasAdvancedObjects() {
		return level.isAdvanced();
	}
}
