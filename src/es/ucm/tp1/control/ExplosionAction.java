package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.utils.Vector2;

public class ExplosionAction implements InstantAction {

	private int x,y;
	private Vector2[] positions = {new Vector2(0, 1), new Vector2(1, 1), new Vector2(1, 0), new Vector2(1, -1),
								new Vector2(0, -1), new Vector2(-1, -1), new Vector2(-1, 0), new Vector2(-1, 1)};
	
	public ExplosionAction(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void executeIA(Game game) {
		for (int i = 0; i < 8; i++) {
			if(isPositionInBounds(game.getRoadLength(), game.getRoadWidth(), this.x + positions[i].x, this.y + positions[i].y)) {
				GameObject gameObject = game.getObjectInPosition(this.x + positions[i].x, this.y + positions[i].y);
				if(gameObject != null) gameObject.receiveExplosion();
			}
		}
	}

	private boolean isPositionInBounds(int sizeX, int sizeY, int x, int y) {
		if(x < 0 || y < 0 || x >= sizeX || y >= sizeY) return false;
		return true;
	}
}
