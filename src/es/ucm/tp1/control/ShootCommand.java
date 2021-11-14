package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Collider;
import es.ucm.tp1.logic.gameobjects.Player;

public class ShootCommand extends Command implements InstantAction{
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot";
	private static final String SHORTCUT = "s";
	private static final String HELP = "Shoots a laser beam that fires instantly and costs one coin.";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		game.shoot();
		game.nextCycle();
		return false;
	}

	@Override
	public void execute(Game game) {
		
	}
	
}
