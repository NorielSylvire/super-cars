package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class InfoCommand extends Command {
	
	private static final String NAME = "info";
	private static final String DETAILS = "[i]nfo";
	private static final String SHORTCUT = "i";
	/* @formatter:off */
	private static final String HELP = "Gives you some extra information about the game.";


	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.printInfo();
		return true;
	}

}
