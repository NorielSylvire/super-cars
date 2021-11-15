package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class WaveCommand extends Command implements InstantAction, Buyable {
	private static final String NAME = "wave";
	private static final String DETAILS = "[w]ave";
	private static final String SHORTCUT = "w";
	private static final String HELP = "Pushes all visible objects forward.";

	public WaveCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(buy(game)) executeIA(game);
		return true;
	}

	@Override
	public void executeIA(Game game) {
		game.moveVisibleForward();
		game.update();
	}

	@Override
	public int cost() {
		return 3;
	}

}
