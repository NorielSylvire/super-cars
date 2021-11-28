package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GamePrinter;

public class InfoCommand extends Command {
	
	private static final String NAME = "info";
	private static final String DETAILS = "[i]nfo: prints gameobject info";
	private static final String SHORTCUT = "i";
	/* @formatter:off */
	private static final String HELP = "Gives you some extra information about the game.";


	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		System.out.println(GamePrinter.description(game.getLevel()));
		return false;
	}

}
