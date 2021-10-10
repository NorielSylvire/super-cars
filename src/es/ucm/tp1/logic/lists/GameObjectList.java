package es.ucm.tp1.logic.lists;

import es.ucm.tp1.logic.gameobjects.*;
import es.ucm.tp1.control.Level;
import java.util.*;

//ESTO PARA LUEGOOOOO

public class GameObjectList {
	//private ArrayList<GameObject> gameObjects;
	private int numObjects;
	
	/*public GameObjectList(Level l) {
		this.gameObjects = new ArrayList<GameObject>();
		this.numObjects = 0;
		
	}
	
	public void add(GameObject obj) {
		gameObjects.add(obj);
		numObjects++;
	}*/
	
	public GameObjectList() {
		this.numObjects = 0;
	}
	
	public int getNumObjects() {
		return this.numObjects;
	}
}