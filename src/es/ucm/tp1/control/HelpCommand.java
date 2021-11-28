package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class HelpCommand extends Command {
	private static final String NAME = "help";
	private static final String DETAILS = "[h]elp: show this help.";
	private static final String SHORTCUT = "h";
	private static final String HELP = "Gives you information on the different available commands.";
	/* @formatter:off */
	private static final String HELP_MESSAGE = (
		"Available commands:" +
		"\n[h]elp: show this help." +
		"\n[i]nfo: prints gameobjet info." +
		"\n[n]one | []: update." +
		"\n[q]: go up." +
		"\n[a]: go down." +
		"\n[e]xit: exit game." +
		"\n[r]eset [<level> <seed>]: reset game." +
		"\n[t]est: enables test mode." +
		"\n[s]hoot: shoot bullet." +
		"\n[g]renade <x> <y>: add a grenade in position x, y." +
		"\n[w]ave: do wave." +
		"\nClear [0]: Clears the road." +
		"\nCheat [1..5]: Removes all elements of last visible column, and adds an Advanced Object."
		);
	/* @formatter:off */
	
	public HelpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		System.out.print(HELP_MESSAGE);
		return false;
	}

}
