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
		gameobjects.add(go);
	}
	
	public void deleteObject(GameObject go) {
		gameobjects.remove(go);
	}
	
	public GameObject getObjectInList(int x, int y) {
		for(int i= 0; i<gameobjects.size();i++) {
			if(gameobjects.get(i).isInPosition(x, y)) {
				return gameobjects.get(i);
			}
		}
		return null;
	}
	
	
}
