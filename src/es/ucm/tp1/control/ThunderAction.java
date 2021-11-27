package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.utils.Vector2;

import java.util.Random;

public class ThunderAction implements InstantAction {
	
	private static Vector2 position = new Vector2(0,0);

	@Override
	public void executeIA(Game game) {
	}
	
	public static void staticExecuteIA(Game game) {
		Random rnd = new Random(System.currentTimeMillis());
		
		position.x = Utils.abs(rnd.nextInt()%game.getVisibility()) + game.getPlayerX();
		position.y = Utils.abs(rnd.nextInt()%game.getRoadWidth());
		game.updateThunder(position);
		
		String formattedPosition = "(" + (position.x - game.getPlayerX()) + " , " + position.y + ")";
		System.out.print("Thunder hit position: ");
		System.out.print(formattedPosition);
		
		GameObject gameObject = game.getObjectInPosition(position.x, position.y);
		if (gameObject != null) gameObject.receiveThunder();
		else System.out.println();
		
	}
}
