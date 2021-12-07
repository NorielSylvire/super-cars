package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.*;
import es.ucm.tp1.logic.Game;

public class WaveCommand extends Command implements  Buyable {
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave: do wave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "Pushes all visible objects forward.";
	private static final String FAILED_MSG = "Failed to launch a wave.";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			if(buy(game))  {
				game.execute(new WaveAction());
				game.updateCycles();
				return true;
			}
		}
		catch(NotEnoughCoinsException ex) {
			System.out.println(ex.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
		return false;
	}


	@Override
	public int cost() {
		return 3;
	}

}
