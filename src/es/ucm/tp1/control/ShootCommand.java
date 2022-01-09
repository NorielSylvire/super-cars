package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.control.exceptions.*;

public class ShootCommand extends Command implements  IBuyable{
	private static final String NAME = "shoot";
	private static final String DETAILS = "[s]hoot: shoot bullet.";
	private static final String SHORTCUT = "s";
	private static final String HELP = "Shoots a laser beam that fires instantly and costs one coin.";
	private static final String FAILED_MSG = "Failed to shoot.";

	public ShootCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			boolean shot = buy(game);
			if(shot) {
				game.execute(new ShootAction());
				game.updateCycles();
			}
			return shot;
		}
		catch (NotEnoughCoinsException ex) {
			System.out.println(ex.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
	}
	
	

	@Override
	public int cost() {
		return 1;
	}
	
}
