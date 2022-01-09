package es.ucm.tp1.control;

import java.io.FileReader;
import java.io.IOException;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.logic.Game;

public class ShowRecordCommand extends Command {
	private static final String NAME = "record";
	private static final String DETAILS = "Show Record [o]: Shows the records of each difficulty level.";
	private static final String SHORTCUT = "o";
	private static final String HELP = "Shows the records of each difficulty level.";
	private static final String FAILED_MSG = "Failed to show record.";

	public ShowRecordCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		try(FileReader fileReader = new FileReader("record.txt")){

		    int data = fileReader.read();
		    while(data != -1) {
		        System.out.print((char) data);
		        data = fileReader.read();
		    }
		}
		catch (IOException ex) {
			ex.printStackTrace();
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
		return false;
	}

}
