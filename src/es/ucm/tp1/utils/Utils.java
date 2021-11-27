package es.ucm.tp1.utils;

/**
 * 
 * @author Flaviu E. Hongu
 *
 */

public class Utils {
	
	public static int clamp(int n, int min, int max) {
		//return (n > max ? (n < min ? min : n) : n); WHYYYY WHY DOESNT IT WORRRRKKK
		if (n < min) n = min;
		if (n > max) n = max;
		return n;
	}
	
	public static int abs(int num) {
		if (num < 0) return -num;
		else return num;
	}

}
