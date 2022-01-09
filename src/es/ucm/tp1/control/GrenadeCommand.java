package es.ucm.tp1.control;

import es.ucm.tp1.control.exceptions.*;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements IBuyable {
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade <x> <y>: add a grenade in position x, y.";
	private static final String SHORTCUT = "g";
	private static final String HELP = "Launches a grenade that explodes after four cycles.";
	private static final String FAILED_MSG = "Failed to add grenade.";
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
					if(posX < 0 || posX >= game.getVisibility()) throw new InvalidPositionException(String.format("[ERROR]: %s", FAILED_MSG));
					posY = Integer.valueOf(words[2]);
					return this;
				}
				catch(NumberFormatException ex) {
					System.out.println(ex.getMessage());
					throw new CommandParseException("");
				} catch (InvalidPositionException e) {
					e.printStackTrace();
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
			buy(game);
			Grenade grenade = new Grenade(game, posX + game.getPlayerX(), posY);
			try {
				game.addGameObject(grenade);
			} catch(InvalidPositionException ex) {
				throw new CommandExecuteException("[ERROR] Unable to execute command.\n");
			}
			game.updateCycles();
			return true;
		}
		catch (NotEnoughCoinsException e) {
			System.out.println(e.getMessage());
			throw new CommandExecuteException(String.format("[ERROR]: %s", FAILED_MSG));
		}
	}

}
