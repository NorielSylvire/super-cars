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
	
	private Random rnd = new Random();
	private Game game;
	private GamePrinter gamePrinter;
	private boolean firstCycle = true;
	

	private Scanner scanner;

	public Controller(Game game, Scanner scanner) {
		this.game = game;
		this.scanner = scanner;
		this.gamePrinter = new GamePrinter(this.game, game.getRoadLength(), game.getRoadWidth());
	}

	public void printGame() {
		if(firstCycle) firstCycle=!firstCycle;
		else clearConsole();
		System.out.println(gamePrinter.toString());
		
	}

	public void run() {
		boolean refreshDisplay = true;
		game.initialiseGame();
		while (!game.isFinished()){
			if (refreshDisplay ) {
			printGame();
			}
			refreshDisplay = false;
			System.out.println(PROMPT);
			String s = scanner.nextLine();
			String[] parameters = s.toLowerCase().trim().split(" ");
			System.out.println("[DEBUG] Executing: " + s);
			Command command = Command.getCommand(parameters);
			if (command != null) {
			refreshDisplay = command.execute(game);
			} else {
			System.out.println("[ERROR]: "+ UNKNOWN_COMMAND_MSG);
			}

		}
		printGame();
		System.out.print("Game Over!");
		//TODO
		if(game.isDead()) System.out.print(" Player has crashed!");
		else System.out.print(" Player wins!");
	}
	
	public final static void clearConsole() {
		for (int i = 0; i < 50; ++i) System.out.println();
	}

}
