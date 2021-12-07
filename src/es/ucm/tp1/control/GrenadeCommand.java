package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.*;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable {
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade <x> <y>: add a grenade in position x, y.";
	private static final String SHORTCUT = "g";
	private static final String HELP = "Launches a grenade that explodes after four cycles.";
	private static final String FAILED_MSG = "Failed to add granade.";
	private int posX, posY;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) throws CommandParseException{
		if (matchCommandName(words[0])) {
			if (words.length < 3 || words.length > 3) {
				System.out.println("[ERROR]: Command " + NAME + ":" + INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			}
			else {
				try {
					posX = Integer.valueOf(words[1]);
					posY = Integer.valueOf(words[2]);
					return this;
				}
				catch(NumberFormatException ex) {
					System.out.println(ex.getMessage());
					throw new CommandParseException("");
				}
			}
		}
		return null;
	}

	@Override
	public int cost() {
		return 3;
	}

	@Override
	public boolean execute(Game game) throws CommandExecuteException{
		try {
			if (buy(game)) {
				Grenade grenade = new Grenade(game, posX + game.getPlayerX(), posY);
				game.addGameObject(grenade);
				game.updateCycles();
				return true;
			}
		}
		catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
		return false;
	}

}
