package es.ucm.tp1.utils;

public class Vector2 {
	public int x, y;
	
	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Vector2() {
		this.x = 0;
		this.y = 0;
	}
	
	public Vector2(int n) {
		this.x = n;
		this.y = this.x;
	}
}