package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class MoveUpCommand extends Command {
	private static final String NAME = "moveup";
	private static final String DETAILS = "[q]: go up.";
	private static final String SHORTCUT = "q";
	private static final String HELP = "Makes the player move upward if possible.";

	public MoveUpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	protected Command parse(String[] commandWords) {
		if ("moveup".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = "NOCOM";
		}
		return super.parse(commandWords);
	}
	@Override
	public boolean execute(Game game) {
		game.updatePlayer();
		game.updateCollision();
		game.movePlayer(true);
		return true;
	}

}
