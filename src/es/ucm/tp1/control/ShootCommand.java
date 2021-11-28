package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;

public class ShootCommand extends Command implements  Buyable{
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot: shoot bullet.";
	private static final String SHORTCUT = "s";
	private static final String HELP = "Shoots a laser beam that fires instantly and costs one coin.";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) {
		boolean shot = buy(game);
		if(shot) {
			game.execute(new ShootAction());
			game.updateCycles();
		}
		return shot;
	}
	
	

	@Override
	public int cost() {
		return 1;
	}
	
}
