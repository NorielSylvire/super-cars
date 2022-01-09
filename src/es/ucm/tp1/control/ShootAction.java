package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.ICollider;

public class ShootAction implements IInstantAction {

	public void executeIA(Game game) {
		ICollider other;
		for (int i = 1; i < game.getVisibility(); i++) {
			other = game.getObjectInPosition(game.getPlayerX()+i, game.getPlayerY());
			if (other != null) {
				if(other.receiveShoot()) {
					break;
				}
			}
		}
	}
		
}
