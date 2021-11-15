package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class ShootCommand extends Command implements InstantAction, Buyable{
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "Shoots a laser beam that fires instantly and costs one coin.";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		if(buy(game)) executeIA(game);
		return true;
	}
	
	@Override
	public void executeIA(Game game) {
		game.shoot();
		game.update();
	}

	@Override
	public int cost() {
		return 1;
	}
	
}
