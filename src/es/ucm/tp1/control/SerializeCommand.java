package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.logic.Game;

public class SerializeCommand extends Command {
	private static final String NAME = "serialize";
	private static final String DETAILS = "Serialize [z]: Serializes the game.";
	private static final String SHORTCUT = "z";
	private static final String HELP = "Clears the game of any objects other than the player.";

	public SerializeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		System.out.println("---- ROAD FIGHTER SERIALIZED ----");
		StringBuilder buffer = new StringBuilder();
		buffer.append("Level: ").append(game.getLevel()).append("\n")
		.append(game.getCycle()).append("\n")
		.append(game.getElapsedTime()).append("\n")
		.append("Game Objects:\n")
		.append(getVisibleObjects(game));
		return false;
	}

	private StringBuilder getVisibleObjects(Game game) {
		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i < game.getRoadWidth(); i++) {
			for(int j = 0; j < game.getVisibility(); j++)  {
				
			}
		}
		
		return buffer;
	}
}
