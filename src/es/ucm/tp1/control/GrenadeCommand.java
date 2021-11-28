package es.ucm.tp1.control;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Grenade;

public class GrenadeCommand extends Command implements Buyable {
	private static final String NAME = "grenade";
	private static final String DETAILS = "[g]renade <x> <y>: add a grenade in position x, y.";
	private static final String SHORTCUT = "g";
	private static final String HELP = "Launches a grenade that explodes after four cycles.";
	private int posX, posY;

	public GrenadeCommand() {
		super(NAME, SHORTCUT, DETAILS, HELP);
	}
	
	@Override
	protected Command parse(String[] words) {
		if (matchCommandName(words[0])) {
			if (words.length < 3 || words.length > 3) {
				System.out.println("[ERROR]: Command " + NAME + ":" + INCORRECT_NUMBER_OF_ARGS_MSG);
				return null;
			}
			else {
				try {
				  posX = Integer.valueOf(words[1]);
				  posY = Integer.valueOf(words[2]);
				} catch (NumberFormatException nfe) {
					
					System.out.println(words[1] + " and " + words[2] + " are not numbers.");
				}
				return this;
			}
		}
		return null;
	}

	@Override
	public int cost() {
		return 3;
	}

	@Override
	public boolean execute(Game game) {
		Grenade grenade = new Grenade(game, posX + game.getPlayerX(), posY);
		game.addGameObject(grenade);
		game.updateCycles();
		return true;
	}

}
