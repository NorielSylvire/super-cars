package es.ucm.tp1.logic;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.Coin;
public class GameObjectGenerator {

	
	public static void generateGameObjects(Game game, Level level) {
		for(int x = game.getVisibility() /2; x < game.getRoadLength(); x ++) {
		game.tryToAddObject(new Obstacle(game, x, game.getRandomLane()), level.getObstacleFrequency());
		game.tryToAddObject(new Coin(game, x, game.getRandomLane()), level.getCoinFrequency());
		}
	}
		public static void reset(Level level ) {
		Obstacle.reset ();
		Coin.reset ();
	}
}
