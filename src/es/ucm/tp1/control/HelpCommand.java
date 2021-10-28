package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class HelpCommand extends Command {
	private static final String NAME = "help";
	private static final String DETAILS = "[h]elp";
	private static final String SHORTCUT = "h";
	private static final String HELP = "";
	/* @formatter:off */
	private static final String HELP_MESSAGE = (
		"Available commands:" +
		"\n[h]elp: show this help" +
		"\n[i]nfo: prints gameobjet info" +
		"\n[n]one | []: update" +
		"\n[q]: go up" +
		"\n[a]: go down" +
		"\n[e]xit: exit game" +
		"\n[r]eset: reset game" +
		"\n[t]est: enables test mode"
		);
	/* @formatter:off */
	
	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		System.out.print(HELP_MESSAGE);
		return true;
	}

}
