package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class WaveAction implements InstantAction {

	@Override
	public void executeIA(Game game) {
		for(int i = gameObjects.size() - 1; i >= 0; i--) {
			GameObject thisGO = gameObjects.get(i);
			if(thisGO.getX() >= x && thisGO.getX() <= x + visibility) {
				thisGO.tryToMoveForward(getObjectInList(thisGO.getX()+1, thisGO.getY()));
			}
		}
	}

}
