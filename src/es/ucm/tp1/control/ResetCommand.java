package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;

public class ResetCommand extends Command {
	private static final String NAME = "reset";
	private static final String DETAILS = "[r]eset [<level> <seed>]: reset game.";
	private static final String SHORTCUT = "r";
	private static final String HELP = "Restart the game. Lets you change difficulty and seed.";
	private static String levelName;
	private static long seed;

	public ResetCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length < 3 || words.length > 3) {
				throw new CommandParseException("[ERROR]: Command " + NAME + ":" + INCORRECT_NUMBER_OF_ARGS_MSG);
			}
			else {
				levelName = words[1];
				if(!difficultyExists(levelName)) throw new CommandParseException("[ERROR] " + levelName + " is not a valid difficulty level.\n");
				try {
				  seed = Integer.valueOf(words[2]);
				} catch (NumberFormatException nfe) {
					throw new CommandParseException("[ERROR]" + words[2] + " is not a number.\n");
				}
				return this;
			}
		}
		return null;
	}
	
	private boolean difficultyExists(String difficultyLevel) {
		return game.getLevel().levelExists(difficultyLevel);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		Level level = Level.valueOfIgnoreCase(levelName);
		game.changeLevel(level, seed);
		GameObjectGenerator.reset();
		try {
			game.initialiseGame();
		} catch(InputOutputRecordException ex) {
			System.out.print(ex.getMessage());
			throw new CommandExecuteException("[ERROR] Could not reset the game.");
		}
		return true;
	}

}
