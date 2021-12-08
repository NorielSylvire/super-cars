package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class SerializeCommand extends Command {
	private static final String NAME = "serialize";
	private static final String DETAILS = "Serialize [z]: Serializes the game.";
	private static final String SHORTCUT = "z";
	private static final String HELP = "Serializes the game.";

	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		System.out.print(GameSerializer.serializeGame(game));
		return false;
	}
}
