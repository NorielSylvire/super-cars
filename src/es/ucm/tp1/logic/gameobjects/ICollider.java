package es.ucm.tp1.logic.gameobjects;

public interface ICollider{
	
	boolean doCollision();
	boolean receiveCollision(Player player);
	boolean receiveShoot();
	boolean receiveExplosion();
	boolean receiveThunder();
	boolean receiveWave();
	
}
