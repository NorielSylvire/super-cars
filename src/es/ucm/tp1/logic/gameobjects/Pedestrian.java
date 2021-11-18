package es.ucm.tp1.logic.gameobjects;

import es.ucm.tp1.logic.Game;

public class Pedestrian extends GameObject {
	private static int numObstacles;
	public static final String INFO = "[O]bstacle, if the car crush with him the Game ENDS";
	public boolean bordearriba = true;
	
	public Pedestrian (Game game, int x, int y) {
		super(game, x, y);
	}
	
	public void onEnter() {
		numObstacles++;
		this.symbol = "☺";
	}
	
	public void checkBorde() {
		if(this.y == 0) this.bordearriba = true ;
		if(this.y == (game.getRoadWidth()-1)) this.bordearriba = false;
	}
	
	public static int getObstaclesCount(){
		return numObstacles;
	}
	
	public void update() {
		checkBorde();
		if(this.bordearriba == true) this.y++;
		if(this.bordearriba == false) this.y--;
	}
	
	public void onDelete() {
		numObstacles--;
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public static void increaseNumObstacles() {
		numObstacles++;
	}
	
	public static void decreaseNumObstacles() {
		numObstacles--;
	}
	
	public static void reset() {
		numObstacles = 0;
	}
	
	public boolean doCollision() {
		return false;
	}
	
	public boolean receiveCollision(Player player) {
		player.onDelete();
		return true;
	}

	@Override
	public boolean receiveShoot() {
		System.out.println("AUUU ME HAS DISPARADO");
		this.health --;
		showLife();
		game.deleteCoins();
		return true;// TODO Auto-generated method stub
	}

	
	@Override
	public void showLife() {
		if(isAlive()) {
			this.symbol = "☺";
		}
		else this.symbol = "";
	}
	
}
