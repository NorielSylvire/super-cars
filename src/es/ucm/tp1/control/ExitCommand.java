package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class ExitCommand extends Command {
	private static final String NAME = "exit";
	private static final String DETAILS = "[e]xit: exit game.";
	private static final String SHORTCUT = "e";
	private static final String HELP = "Closes the game.";

	public ExitCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.toggleExit();
		return false;
	}

}
