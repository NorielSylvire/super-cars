package es.ucm.tp1.control.exceptions;

public abstract class GameException extends Throwable {
	
	private static String MESSAGE;
	
	public GameException(String msg) {
		MESSAGE = msg;
	}

	public String getMessage() {
		return MESSAGE;
	}
}
