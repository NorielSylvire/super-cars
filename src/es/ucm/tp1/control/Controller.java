package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.*;
import es.ucm.tp1.logic.gameobjects.*;
import es.ucm.tp1.logic.lists.*;
import java.util.Random;

public class Controller {

	private static final String PROMPT = "Command > ";

	private static final String UNKNOWN_COMMAND_MSG = "Unknown command\n";

	/* @formatter:off */
	private static final String HELP = (
		"Available commands:" +
		"\n[h]elp: show this help" +
		"\n[i]nfo: prints gameobjet info" +
		"\n[n]one | []: update" +
		"\n[q]: go up" +
		"\n[a]: go down" +
		"\n[e]xit: exit game" +
		"\n[r]eset: reset game" +
		"\n[t]est: enables test mode"
		);
	/* @formatter:off */

	private Game game;
	private GamePrinter gamePrinter;

	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(this.game, game.getLevel().getLength(), game.getLevel().getWidth());
	}

	public void printGame() {
		System.out.println(gamePrinter.toString());
	}

	public void run() {
		initialiseGame();
		while (!game.isFinished()) {
			printGame();
			System.out.println(PROMPT);
			String COMMAND = scanner.nextLine();
			runCommand(COMMAND);
			if(game.getPlayer().getPos()[0] == (game.getLevel().getLength()-game.getLevel().getVisibility()+2)) {
				game.setFinished(true);
			}
			if(game.getPlayer().getDead()) {
				game.setFinished(true);
			}
		}
		printGame();
		System.out.print("Game Over!");
	}
	
	private void runCommand(String COMMAND) {
		
		switch(parseCommand(COMMAND)) {
			case "h":
				System.out.print(HELP);
				break;
			case "i":
				System.out.print("\nPlayer:\n  - Alive: >\n  - Crashed: @\nObstacle: ░\nLane separator: -\nRoad delimiter: =\nFinish Line: |\nCoins: O\n");
				break;
			case "q":
				gamePrinter.clean(game.getPlayer().getPos());
				game.getPlayer().playerUp();
				game.getPlayer().update(gamePrinter, game);
				break;
			case "a":
				gamePrinter.clean(game.getPlayer().getPos());
				game.getPlayer().playerDown();
				game.getPlayer().update(gamePrinter, game);
				break;
			case "e":
				System.out.print("GAME OVER: Player has exited the game.\n");
				System.exit(0);
				break;
			case "r":
				System.out.print("RESETTED\n");
				break;
			case "t":
				System.out.print("I HATE TESTS\n");
				break;
			case "n":
			case "":
				gamePrinter.clean(game.getPlayer().getPos());
				game.getPlayer().update(gamePrinter, game);
				break;
			default:
				System.out.print(UNKNOWN_COMMAND_MSG);
			
		}
		
	}
	
	private String parseCommand(String COMMAND) {
		String parsedCommand;
		
		if (COMMAND.length() == 1) {
			parsedCommand = COMMAND.toLowerCase();
		} else if(COMMAND.equalsIgnoreCase("help")) {
			parsedCommand = "h";
		} else if(COMMAND.equalsIgnoreCase("info")) {
			parsedCommand = "i";
		} else if(COMMAND.equalsIgnoreCase("exit")) {
			parsedCommand = "e";
		} else if(COMMAND.equalsIgnoreCase("reset")) {
			parsedCommand = "r";
		} else if(COMMAND.equalsIgnoreCase("test")) {
			parsedCommand = "t";
		} else if(COMMAND.equalsIgnoreCase("none")) {
			parsedCommand = "n";
		} else if(COMMAND.length() == 0) {
			parsedCommand = "n";
		} else {
			parsedCommand = "k";
		}
		
		return parsedCommand;
	}
	
	private void initialiseGame() {
		for (int x = game.getLevel().getVisibility() / 2; x < game.getLevel().getLength()-game.getLevel().getVisibility(); x++) {
			tryToAddObstacle(new Obstacle(x, getRandomLane()), game.getLevel().getObstacleFrequency());
			tryToAddCoin(new Coin(x, getRandomLane()), game.getLevel().getCoinFrequency());
			}
	}
	
	private void tryToAddObstacle(Obstacle o, double obsFrequency) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= obsFrequency && checkPosition(o.getPosition())) {
			Obstacle[] obs = game.getObstacleList().getObstacles();
			obs[game.getObstacleList().getNumObstacles()] = o;
			game.getObstacleList().setNumObstacles(game.getObstacleList().getNumObstacles() + 1);
		}
	}
	
	private void tryToAddCoin(Coin c, double cFrequency) {
		Random rnd = new Random();
		if (rnd.nextDouble() >= cFrequency && checkPosition(c.getPosition())) {
			Coin[] cns = game.getCoinList().getCoins();
			cns[game.getCoinList().getNumCoins()] = c;
			game.getCoinList().setNumCoins(game.getCoinList().getNumCoins() + 1);
		}
	}
	
	private boolean checkPosition(int[] pos) {
		boolean ret = true;
		if (game.getPlayer().getPos() == pos) ret = false;
		for (int i = 0; i < game.getObstacleList().getNumObstacles(); i++) {
			if (pos == game.getObstacleList().getObstacles()[i].getPosition()) {
				ret = false;
				break;
			}
		}
		for (int i = 0; i < game.getCoinList().getNumCoins(); i++) {
			if (pos == game.getCoinList().getCoins()[i].getPosition()) {
				ret = false;
				break;
			}
		}
		return ret;
	}
	
	private int getRandomLane() {
		Random rnd = new Random();
		int ret = rnd.nextInt() % 3;
		if (ret < 0) ret = - ret;
		return ret;
	}

}
