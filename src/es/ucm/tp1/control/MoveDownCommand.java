package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.exceptions.*;

public class MoveDownCommand extends Command {
	private static final String NAME = "movedown";
	private static final String DETAILS = "[a]: go down.";
	private static final String SHORTCUT = "a";
	private static final String HELP = "Makes the player move down if possible.";

	public MoveDownCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	protected Command parse(String[] commandWords) throws CommandParseException{
		if ("movedown".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = "NOCOM";
		}
		return super.parse(commandWords);
	}
	@Override
	public boolean execute(Game game) {
		game.updatePlayer();
		game.updateCollision();
		game.movePlayer(false);
		return true;
	}

}
