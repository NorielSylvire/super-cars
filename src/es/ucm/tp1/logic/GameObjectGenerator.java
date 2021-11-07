package es.ucm.tp1.logic;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.*;
import java.util.Random;

public class GameObjectGenerator {
	private static Random rnd;
	
	public static void generateGameObjects(Game game, Level level) {
		Player player = new Player(game, 0, 1);
		game.addGameObject(player);
		System.out.print("HOLA");
		
		rnd = new Random();
		rnd.setSeed(game.seed());
		
		for(int x = game.getVisibility() / 2; x < game.getRoadLength() - game.getVisibility(); x++) {
		tryToAddObject(new Obstacle(game, x, getRandomLane(level)), level.getObstacleFrequency(), game);
		tryToAddObject(new Coin(game, x, getRandomLane(level)), level.getCoinFrequency(), game);
		}
	}
	public static void reset(Level level ) {
		Obstacle.reset();
		Coin.reset();
	}
	
	private static void tryToAddObject(GameObject gameobject,  double frequency, Game game) {
		//No sabíamos si esto rompía o no la encapsulación
		if (rnd.nextDouble() <= frequency && game.getObjectInPosition(gameobject.getX(), gameobject.getY()) == null) {
			game.addGameObject(gameobject);
		}
	}
	
	private static int getRandomLane(Level level) {
		int ret = rnd.nextInt() % level.getWidth();
		if (ret < 0) ret = - ret;
		return ret;
	}
}
