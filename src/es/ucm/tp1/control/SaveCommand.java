package es.ucm.tp1.control;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import es.ucm.tp1.control.exceptions.CommandExecuteException;
import es.ucm.tp1.control.exceptions.CommandParseException;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.GameSerializer;

public class SaveCommand extends Command {
	private static final String NAME = "save";
	private static final String DETAILS = "Save [s]: Saves the game.";
	private static final String SHORTCUT = "x";
	private static final String HELP = "Saves the game to a file.";
	private static String fileName = "";
	private static boolean userInputName = true;

	public SaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException {
		userInputName = true;
		if (matchCommandName(words[0])) {
			if (words.length > 2) {
				throw new CommandParseException(String.format("[ERROR]:Command %s: %s",
						NAME,
						INCORRECT_NUMBER_OF_ARGS_MSG));
			} else if(words.length == 2) {
				fileName = words[1];
				return this;
			} else if(words.length == 1) {
				userInputName = false;
				return this;
			}
		}
		return null;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		this.game = game;
		if(!userInputName) fileName = saveFileName(game);
		try(PrintWriter out  = new PrintWriter(new BufferedWriter(new FileWriter(fileName + ".txt")))) {
			out.append(GameSerializer.serializeGame(game));
			out.close();
		}
		catch(IOException ex) {
			
		}
		return false;
	}
	
	private String saveFileName(Game game) {
		String ret = game.getLevel().getLevelName();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("-yyyy-MM-dd-HH-mm-ss");  
		LocalDateTime now = LocalDateTime.now();
		ret += dtf.format(now);
		return ret;
	}

}
