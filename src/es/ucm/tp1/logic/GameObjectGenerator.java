package es.ucm.tp1.logic;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.*;
import es.ucm.tp1.utils.Vector2;

import java.util.Random;

public class GameObjectGenerator {
	private static Random rnd;
	
	public static void generateGameObjects(Game game, Level level) {		
		rnd = new Random();
		rnd.setSeed(game.seed());
		
		for(int x = game.getVisibility() / 2; x < game.getRoadLength() - game.getVisibility() / 2; x++) {
			tryToAddObject(new Obstacle(game, x, getRandomLane(game.getRoadWidth())), level.getObstacleFrequency(), game);
			tryToAddObject(new Coin(game, x, getRandomLane(game.getRoadWidth())), level.getCoinFrequency(), game);
			
			if (game.hasAdvancedObjects()) {
				tryToAddObject(new Wall(game, x, getRandomLane(game.getRoadWidth())), level.advancedObjectsFrequency(), game);
				
				tryToAddObject(new Turbo(game, x, getRandomLane(game.getRoadWidth())), level.advancedObjectsFrequency(), game);
				
				if (!game.isSuperCoinPresent()) {
					tryToAddObject(new SuperCoin(game, x, getRandomLane(game.getRoadWidth())),level.advancedObjectsFrequency(), game);
				}
				
				tryToAddObject(new Truck(game, x, getRandomLane(game.getRoadWidth())), level.advancedObjectsFrequency(), game);
				
				tryToAddObject(new Pedestrian(game, x, 0), level.advancedObjectsFrequency(), game);
				
			}
		}
	}
	
	public static void reset() {
		Obstacle.reset();
		Coin.reset();
	}
	
	private static void tryToAddObject(GameObject gameobject,  double frequency, Game game) {
		if (rnd.nextDouble() <= frequency && game.getObjectInPosition(gameobject.getX(), gameobject.getY()) == null) {
			game.addGameObject(gameobject);
		}
	}
	
	private static int getRandomLane(int width) {
		int ret = rnd.nextInt() % width;
		if (ret < 0) ret = - ret;
		return ret;
	}
	public static void generateCheatObjects(Game game, int x, int objectID) {
		GameObject o = null;
		Vector2 pos = new Vector2(x, getRandomLane(game.getRoadWidth()));
		int i = 0;
		while(i < game.getRoadWidth()) {
			if(game.getObjectInPosition(pos.x, i) != null) {
				game.removeGameObject(game.getObjectInPosition(pos.x, i));
			}
			i++;
		}
		
		switch (objectID) {
			case 1:
				o = new Wall(game, pos.x, pos.y);
				break;
			case 2:
				o = new Turbo(game, pos.x, pos.y);
				break;
			case 3:
				o = new SuperCoin(game, pos.x, pos.y);
				break;
			case 4:
				o = new Truck(game, pos.x, pos.y);
				break;
			case 5:
				o = new Pedestrian(game, pos.x, 0);
				break;
		}
		
		game.addGameObject(o);
	}
}
