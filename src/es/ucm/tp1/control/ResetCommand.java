package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class ResetCommand extends Command {
	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset";
	private static final String SHORTCUT = "r";
	private static final String HELP = "Restart the game. Lets you change difficulty and seed.";

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.changeLevel();
		
		game.initialiseGame();
		return false;
	}

}
