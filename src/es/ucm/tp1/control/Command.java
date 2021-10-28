package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public abstract class Command {
	
	private final String name;
	private final String shortcut;
	private final String details ;
	private final String help;
	private static final String UNKNOWN_COMMAND_MSG = "Unknown command.";
	private static final String INCORRECT_NUMBER_OF_ARGS_MSG = " Incorrect number of parameters.";
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new ExitCommand(),
		new ResetCommand(),
		new MoveUpCommand(),
		new MoveDownCommand()
	};
	protected Game game;

	public Command(String name, String shortcut, String details, String help) {
	this. name = name;
	this. shortcut = shortcut;
	this. details = details;
	this. help = help;
	}

	
	public static Command getCommand(String[] commandWords) {
		for(int i = 0; i < 6; i++) {
			if (AVAILABLE_COMMANDS[i].parse(commandWords) != null) return AVAILABLE_COMMANDS[i].parse(commandWords);
		}
		return null;
	}
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}
	
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				System.out.format("[ERROR]: Command %s: %s %n %n", name,
									INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			} else {
				return this;
			}
		}
		return null;
	}

	
	public abstract boolean execute(Game game);

	
}
