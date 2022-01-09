package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class CheatCommand extends Command {
	private static final String NAME = "cheat";
	private static final String DETAILS = "Cheat [1..5]: Removes all elements of last visible column, and adds an Advanced Object.";
	private static final String SHORTCUT = "12345";
	private static final String HELP = "Cheezy boi.";
	private static final String UNKNOWN_NUMBER = "The number you introduced isn't a valid input.";
	private static int objectID;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			throw new CommandParseException("[ERROR]" + WRONG_USAGE_MSG);
		}
		else if(words[0].length() > 1) {
			throw new CommandParseException("[ERROR] The number you introduced is invalid.\n");
		}
		else if(words[0].length() == 1) {
			int num = -1;
			try {
				  num = Integer.valueOf(words[0]);
				}
			catch (NumberFormatException nfe) {	
					throw new CommandParseException("[ERROR] " + words[0] + " is not a number.\n");
				}
			if(num <= 0 || num > 5) {
				throw new CommandParseException("[ERROR] " + UNKNOWN_NUMBER + "\n");
			}
			objectID = num;
			return this;
		}
		return null;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		game.generateCheatObjects(objectID);
		return true;
	}

}
