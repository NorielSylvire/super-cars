package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.WaveAction;

public class WaveCommand extends Command implements  Buyable {
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "Pushes all visible objects forward.";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(buy(game))  {
		game.execute(new WaveAction());
		game.update();
		game.removeDead();
		return true;
		}
		else false;
	}


	@Override
	public int cost() {
		return 3;
	}

}
