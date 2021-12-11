package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.exceptions.*;

public abstract class Command {
	
	private final String name;
	private final String shortcut;
	private final String details;
	private final String help;
	protected static final String WRONG_USAGE_MSG = "This is not how to use this command. Type \"help YOURCOMMAND\" to know more. ";
	protected static final String UNKNOWN_COMMAND_MSG = "Unknown command.";
	protected static final String INCORRECT_NUMBER_OF_ARGS_MSG = " Incorrect number of parameters.";
	protected static final Command[] AVAILABLE_COMMANDS = {
		new HelpCommand(),
		new InfoCommand(),
		new ExitCommand(),
		new ResetCommand(),
		new MoveUpCommand(),
		new MoveDownCommand(),
		new UpdateCommand(),
		new ShootCommand(),
		new WaveCommand(),
		new ClearCommand(),
		new GrenadeCommand(),
		new ShowRecordCommand(),
		new DumpCommand(),
		new SerializeCommand(),
		new SaveCommand(),
		new CheatCommand()
	};
	protected Game game;

	public Command(String name, String shortcut, String details, String help) {
	this. name = name;
	this. shortcut = shortcut;
	this. details = details;
	this. help = help;
	}

	
	public static Command getCommand(String[] commandWords) throws CommandParseException {
		for(int i = 0; i < AVAILABLE_COMMANDS.length; i++) {
			if (AVAILABLE_COMMANDS[i].parse(commandWords) != null) return AVAILABLE_COMMANDS[i].parse(commandWords);
		}
		System.out.println(UNKNOWN_COMMAND_MSG);
		throw new CommandParseException(String.format("[ERROR]: %s", UNKNOWN_COMMAND_MSG));
	}
	
	protected boolean matchCommandName(String name) {
		return this.shortcut.equalsIgnoreCase(name) || this.name.equalsIgnoreCase(name);
	}
	
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length != 1) {
				throw new CommandParseException(String.format("[ERROR]:Command %s: %s",
						name,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			} else {
				return this;
			}
		}
		return null;
	}

	
	public abstract boolean execute(Game game) throws CommandExecuteException;

	
}
