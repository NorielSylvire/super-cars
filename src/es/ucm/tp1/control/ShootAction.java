package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Collider;

public class ShootAction implements InstantAction {

	public void executeIA(Game game) {
		Collider other;
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
