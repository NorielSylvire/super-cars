package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class UpdateCommand extends Command {
	private static final String NAME = "none";
	private static final String DETAILS = "[n]one";
	private static final String SHORTCUT = "n";
	private static final String HELP = "Does nothing. Advances the game without moving up or down. The player still moves forward.";
	
	public UpdateCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	@Override
	protected Command parse(String[] commandWords) {
		if ("".equalsIgnoreCase(commandWords[0])) {
			commandWords[0] = SHORTCUT;
		}
		return super.parse(commandWords);
	}
	
	@Override
	public boolean execute(Game game) {
		game.update();
		game.removeDead();
		return true;
	}
	

}
