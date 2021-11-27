package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class WaveAction implements InstantAction {

	@Override
	public void executeIA(Game game) {
		for(int i = game.getRoadLength(); i >= 0; i--) {
			for(int j = game.getRoadWidth(); j >= 0; j--) {
				GameObject thisGO = game.getObjectInPosition(i, i);
				if(thisGO.getX() >= game.getPlayerX() && thisGO.getX() <= game.getPlayerX() + game.getVisibility()) {
					thisGO.tryToMoveForward(game.getObjectInPosition(thisGO.getX()+1, thisGO.getY()));
				}
			}
		}
	}

}
