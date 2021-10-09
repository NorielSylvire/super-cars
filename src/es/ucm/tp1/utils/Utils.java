package es.ucm.tp1.utils;

public class Utils {
	
	public static int clamp(int n, int min, int max) {
		//return (n > max ? (n < min ? min : n) : n); WHYYYY WHY DOESNT IT WORRRRKKK
		if (n < min) n = min;
		if (n > max) n = max;
		return n;
	}

}
