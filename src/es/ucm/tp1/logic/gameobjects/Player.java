package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Player {
	private int posX;
	private int posY;
	
	
	private int monedas;
	
	public void PlayerUp(Game partida, Player player) {
		
	
		player.posY--;
		
		return;
	}
	public void PlayerDown(Game partida, Player player) {
	
		player.posY++;
		
		return;
	}
	
	public void Upadte(Game partida,Player player) {
	
		player.posX++;
		
	}
	
}
