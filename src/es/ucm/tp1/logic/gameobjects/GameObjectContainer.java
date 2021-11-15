package es.ucm.tp1.logic.gameobjects;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.logic.gameobjects.GameObject;

public class GameObjectContainer {
	
	private List<GameObject> gameObjects;
	public GameObjectContainer() {
		gameObjects = new ArrayList<>();
	}
	
	public void addObject(GameObject go) {
		go.onEnter();
		gameObjects.add(go);
	}
	
	public void deleteObject(GameObject go) {
		gameObjects.remove(go);
	}
	
	public GameObject getObjectInList(int x, int y) {
		for(int i= 0; i<gameObjects.size();i++) {
			if(gameObjects.get(i).isInPosition(x, y)) {
				return gameObjects.get(i);
			}
		}
		return null;
	}

	public void removeDead() {
		for(int i= 0; i<gameObjects.size();i++) {
			if(!gameObjects.get(i).isAlive()) {
				gameObjects.remove(i);
			}
		}
	}

	public void moveVisibleForward(int x, int visibility) {
		for(int i = gameObjects.size() - 1; i >= 0; i--) {
			GameObject thisGO = gameObjects.get(i);
			if(thisGO.getX() >= x && thisGO.getX() <= x + visibility) {
				thisGO.tryToMoveForward(getObjectInList(thisGO.getX()+1, thisGO.getY()));
			}
		}
	}
	
	public void reset() {
		gameObjects.removeAll(gameObjects);
	}

	public void update() {
		for(int i = 0; i < gameObjects.size(); i++) {
			gameObjects.get(i).update();
		}
	}
	
}
