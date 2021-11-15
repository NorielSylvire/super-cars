package es.ucm.tp1.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {
	
	private List<GameObject> gameobjects;
	public GameObjectContainer() {
		gameobjects = new ArrayList<>();
	}
	
	public void addObject(GameObject go) {
		go.onEnter();
		gameobjects.add(go);
	}
	
	public void deleteObject(GameObject go) {
		gameobjects.remove(go);
	}
	
	public GameObject getObjectInList(int x, int y) {
		for(int i= 0; i<gameobjects.size();i++) {
			if(gameobjects.get(i).isInPosition(x, y)) {

				/*System.out.print("HOLA, estoy en ");
				System.out.print(gameobjects.get(i).getX());
				System.out.print(" ");
				System.out.println(gameobjects.get(i).getY());*/
				return gameobjects.get(i);
			}
		}
		return null;
	}

	public void removeDead() {
		for(int i= 0; i<gameobjects.size();i++) {
			if(!gameobjects.get(i).isAlive()) {
				gameobjects.remove(i);
			}
		}
	}

	public void moveVisibleForward(int x, int visibility) {
		for(int i = gameobjects.size() - 1; i >= 0; i--) {
			GameObject thisGO = gameobjects.get(i);
			if(thisGO.getX() >= x && thisGO.getX() <= x + visibility) {
				thisGO.tryToMoveForward(getObjectInList(thisGO.getX()+1, thisGO.getY()));
			}
		}
	}
	
	public void reset() {
		gameobjects.removeAll(gameobjects);
	}
	
}
