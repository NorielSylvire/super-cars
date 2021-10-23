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
	
	private Random rnd = new Random();
	private Game game;
	private GamePrinter gamePrinter;
	private boolean firstCycle = true;
	

	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(this.game, game.getLevel().getLength(), game.getLevel().getWidth());
	}

	public void printGame() {
		if(firstCycle) firstCycle=!firstCycle;
		else clearConsole();
		System.out.println(gamePrinter.toString());
		
	}

	public void run() {
		game.initialiseGame();
		
		while (!game.isFinished()) {
			printGame();
			
			System.out.println(PROMPT);
			
			String COMMAND = scanner.nextLine();
			
			runCommand(COMMAND);
			
			if(game.isPlayerOut()) {
				
				game.finishGame();
				
			}
			
		}
		
		
		printGame();
		System.out.print("Game Over!");
		//TODO
		if(game.isDead()) System.out.print(" Player has crashed!");
		else System.out.print(" Player wins!");
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
				game.movePlayer(true);
				break;
			case "a":
				game.movePlayer(false);
				break;
			case "e":
				System.out.print("GAME OVER: Player has exited the game.\n");
				System.exit(0);
				break;
			case "r":
				game.initialiseGame();
				break;
			case "t":
				game.toggleTest();
				break;
			case "n":
			case "":
				game.update();
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
	
	public final static void clearConsole() {
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
