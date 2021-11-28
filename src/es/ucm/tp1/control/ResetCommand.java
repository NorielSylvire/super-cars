package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.GameObjectGenerator;
import java.util.Scanner;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.Obstacle;

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
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length < 3 || words.length > 3) {
				System.out.println("[ERROR]: Command " + NAME + ":" + INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			}
			else {
				levelName = words[1];
				try {
				  seed = Integer.valueOf(words[2]);
				} catch (NumberFormatException nfe) {
					
					System.out.println(words[2] + " is not a number.");
				}
				return this;
			}
		}
		return null;
	}

	@Override
	public boolean execute(Game game) {
		Level level = Level.valueOfIgnoreCase(levelName);
		game.changeLevel(level, seed);
		GameObjectGenerator.reset();
		game.initialiseGame();
		return true;
	}

}
