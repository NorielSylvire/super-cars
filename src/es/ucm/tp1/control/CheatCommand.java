package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class CheatCommand extends Command {
	private static final String NAME = "cheat";
	private static final String DETAILS = "[h] de cheatr";
	private static final String SHORTCUT = "12345";
	private static final String HELP = "Cheezy boi.";
	private static final String UNKNOWN_NUMBER = "The number you introduced isn't a valid input.";
	private static int objectID;

	public CheatCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	public Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			System.out.println(WRONG_USAGE_MSG);
			return null;
		}
		else if(words[0].length() > 1) {
			return null;
		}
		else if(words[0].length() == 1) {
			int num = -1;
			try {
				  num = Integer.valueOf(words[0]);
				}
			catch (NumberFormatException nfe) {
					
					System.out.println(words[0] + " is not a number.");
				}
			if(num <= 0 || num > 5) {
				System.out.println(UNKNOWN_NUMBER);
			}
			objectID = num;
			return this;
		}
		return null;
	}

	@Override
	public boolean execute(Game game) {
		game.generateCheatObjects(objectID);
		return true;
	}

}
