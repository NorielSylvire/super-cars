package es.ucm.tp1.logic.gameobjects;

public interface Collider{
	
	boolean doCollision();
	boolean receiveCollision(Player player);
	boolean receiveShoot();
	boolean receiveExplosion();
	boolean receiveThunder();
	
}
