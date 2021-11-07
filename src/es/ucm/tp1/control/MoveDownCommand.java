package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class MoveDownCommand extends Command {
	private static final String NAME = "movedown";
	private static final String DETAILS = "[a]";
	private static final String SHORTCUT = "a";
	private static final String HELP = "Games the player move down if possible.";

	public MoveDownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	protected Command parse(String[] commandWords) {
		if ("movedown".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = "NOCOM";
		}
		return super.parse(commandWords);
	}
	@Override
	public boolean execute(Game game) {
		game.movePlayer(false);
		return true;
	}

}
