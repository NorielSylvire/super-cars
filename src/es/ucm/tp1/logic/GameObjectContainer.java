package es.ucm.tp1.logic;

import java.util.ArrayList;
import java.util.List;

import es.ucm.tp1.logic.gameobjects.ICollider;
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
	
	public void deleteObject(ICollider go) {
		gameObjects.remove(go);
	}
	
	public ICollider getObjectInList(int x, int y) {
		for(int i= 0; i<gameObjects.size();i++) {
			if(gameObjects.get(i).isInPosition(x, y)) {
				return gameObjects.get(i);
			}
		}
		return null;
	}
	
	public StringBuilder getAllSymbolsInPosition(int x, int y) {
		StringBuilder symbols = new StringBuilder();
		for(int i= 0; i<gameObjects.size();i++) {
			if(gameObjects.get(i).isInPosition(x, y) && !gameObjects.get(i).getAlreadyPrinted()) {
				gameObjects.get(i).printedThisTurn();
				symbols.append(gameObjects.get(i).toString());
				
			}
		}
		return symbols;
	}
	
	public StringBuilder getAllSymbolsInPositionSerialize(int x, int y) {
		StringBuilder symbols = new StringBuilder();
		for(int i= 0; i<gameObjects.size();i++) {
			if(gameObjects.get(i).isInPosition(x, y) && !gameObjects.get(i).getAlreadyPrinted()) {
				gameObjects.get(i).printedThisTurn();
				symbols.append(gameObjects.get(i).toStringSerialize());
				symbols.append("\n");
			}
		}
		return symbols;
	}

	public void removeDead() {
		for(int i= 0; i<gameObjects.size();i++) {
			if(!gameObjects.get(i).isAlive()) {
				gameObjects.remove(i);
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
