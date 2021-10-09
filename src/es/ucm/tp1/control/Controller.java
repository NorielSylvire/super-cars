package es.ucm.tp1.control;

import java.util.Scanner;

import es.ucm.tp1.logic.Game;
import es.ucm.tp1.view.*;

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
	private GamePrinter gameprinter;

	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gameprinter = new GamePrinter(this.game, game.getLevel().getLength(), game.getLevel().getWidth());
	}

	public void printGame() {
		System.out.println(gameprinter.toString());
	}

	public void run() {
		while (!game.isFinished()) {
			printGame();
			System.out.println(PROMPT);
			String COMMAND = scanner.nextLine();
			runCommand(COMMAND);
		}
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
				System.out.print("GONE UP\n");
				break;
			case "a":
				System.out.print("GONE SOMEWHERE\n");
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
	
	for (int x = getVisibility() / 2; x < roadLength; x++) {
		tryToAddObstacle(new Obstacle(game, x, getRandomLane()), level.obstacleFrequency());
		tryToAddCoin(new Coin(game, x, getRandomLane()), level.coinFrequency());
		}


}
