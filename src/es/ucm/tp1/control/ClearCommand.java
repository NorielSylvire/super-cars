package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;

public class ClearCommand extends Command {
	private static final String NAME = "clear";
	private static final String DETAILS = "Clear [0]: Clears the road.";
	private static final String SHORTCUT = "c";
	private static final String HELP = "Clears the game of any objects other than the player.";

	public ClearCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		GameObjectGenerator.reset();
		game.removeAllObjects();
		return false;
	}

}
