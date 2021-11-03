package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class NoneCommand extends Command {
	private static final String NAME = "none";
	private static final String DETAILS = "[n]one";
	private static final String SHORTCUT = "n";
	private static final String HELP = "";
	
	public NoneCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	
	@Override
	public boolean execute(Game game) {
		// TODO Auto-generated method stub
		return false;
	}
	

}
