package es.ucm.tp1.control;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;

public class DumpCommand extends Command {
	private static final String NAME = "dump";
	private static final String DETAILS = "Dump [d]: Dumps the contents of a savefile to the console.";
	private static final String SHORTCUT = "d";
	private static final String HELP = "Dumps the contents of a savefile to the console.";
	private static final String FAILED_MSG = "Failed to dump save file into the console.";
	private static String fileName = "";

	public DumpCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		if (matchCommandName(words[0])) {
			if (words.length > 2 || words.length < 2) {
				throw new CommandParseException(String.format("[ERROR]:Command %s: %s",
						NAME,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			} else if(words.length == 2) {
				fileName = words[1];
				return this;
			}
		}
		return null;
	}
	
	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try(FileReader fileReader = new FileReader(fileName + ".txt")){
			    int data = fileReader.read();
			    while(data != -1) {
			        System.out.print((char) data);
			        data = fileReader.read();
			    }
			}
		catch (IOException e) {
			e.printStackTrace();
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
		return false;
	}

}
