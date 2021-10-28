package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class InfoCommand extends Command {
	
	private static final String NAME = "help";
	private static final String DETAILS = "[h]elp";
	private static final String SHORTCUT = "h";
	/* @formatter:off */
	private static final String HELP = "";
	private final String INFO_MESSAGE = "\nPlayer:\n  - Alive: >\n  - Crashed: @\nObstacle: ░\nLane separator: -" + 
			"\nRoad delimiter: =\nFinish Line: |\nCoins: O\n";


	public InfoCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		System.out.print(INFO_MESSAGE);
		return true;
	}

}
