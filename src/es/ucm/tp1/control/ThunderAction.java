package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.ICollider;
import es.ucm.tp1.utils.Utils;
import es.ucm.tp1.utils.Vector2;

import java.util.Random;

public class ThunderAction implements IInstantAction {
	
	private Vector2 position = new Vector2(0,0);
	private Random rnd = new Random(System.currentTimeMillis());
	
	@Override
	public void executeIA(Game game) {
		position.x = Utils.abs(rnd.nextInt()%game.getVisibility()) + game.getPlayerX();
		position.y = Utils.abs(rnd.nextInt()%game.getRoadWidth());
		
		String formattedPosition = "(" + (this.getPosition().x - game.getPlayerX()) + " , " + this.getPosition().y + ")";
		System.out.print("Thunder hit position: " + formattedPosition);
		ICollider gameObject = game.getObjectInPosition(position.x, position.y);
		if (gameObject != null) gameObject.receiveThunder();
		else System.out.println();
	}
	
	public Vector2 getPosition() {
		return position;
	}
}
