package es.ucm.tp1.view;

import es.ucm.tp1.utils.StringUtils;
import es.ucm.tp1.control.Level;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.Coin;
import es.ucm.tp1.logic.gameobjects.GameObject;
import es.ucm.tp1.logic.gameobjects.Obstacle;
import es.ucm.tp1.logic.gameobjects.SuperCoin;

public class GamePrinter {

	private static final String SPACE = " ";
	private static final String ROAD_BORDER_PATTERN = "═";
	private static final String LANE_DELIMITER_PATTERN = "—";
	private static final int CELL_SIZE = 7;
	private static final int MARGIN_SIZE = 2;
	public static final String DO_EXIT_MSG = "You have exited the game correctly.";
	public static final String CRASH_MSG =  "The player has crashed!";
	public static final String NEW_RECORD_MSG =  "You made a new record! Time: ";
	public static final String RECORD_MSG = "You didn't break the record. Highscore: ";
	public static final String WIN_MSG = "You have won the game! Hoorray! ";
	public static final String DISTANCE_MSG = "Distance is: ";
	public static final String COINS_MSG = "Coins: ";
	public static final String CYCLE_MSG = "Cycle: ";
	public static final String TOTAL_OBSTACLES_MSG = "Total Obstacles: ";
	public static final String TOTAL_COINS_MSG = "Total Coins: ";
	public static final String ELAPSED_TIME_MSG = "Elapsed time: ";
	public static final String GAME_OVER_MSG = "GAME OVER ";
	public static final String SUPERCOIN_IS_PRESENT_MSG = "Super coin is present.";
	public static final String NOT_ENOUGH_COINS_MSG = "Not enough coins!";
	public static final String THUNDER_HIT_MSG = "Thunder hit position: ";
	
	public static boolean thunderHitThisTurn;
	public static String objectHitByThunder;

	private Game game;
	private String indentedRoadBorder;
	private String indentedLanesSeparator;
	private String margin;

	public GamePrinter(Game game) {
		this.game = game;
		
		thunderHitThisTurn = false;
		objectHitByThunder = "";
		
		margin = StringUtils.repeat(SPACE, MARGIN_SIZE);
	
		String roadBorder = ROAD_BORDER_PATTERN
		+ StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) * game.getVisibility());
		indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);
	
		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE, game.getVisibility() - 1)
		+ laneDelimiter + SPACE;
	
		indentedLanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);

	}


	protected String getInfo() {
		StringBuilder buffer = new StringBuilder();
		/* @formatter:off */
		String formattedThunderPosition = "(" + (game.getThunderPosition().x - game.getPlayerX()) + " , " + game.getThunderPosition().y + ")";
		buffer.append(THUNDER_HIT_MSG).append(formattedThunderPosition)
		.append(thunderVictim()).append(StringUtils.LINE_SEPARATOR)
		.append(DISTANCE_MSG).append(game.distanceToGoal()).append(StringUtils.LINE_SEPARATOR)
		.append(COINS_MSG).append(game.getPlayerCoins()).append(StringUtils.LINE_SEPARATOR)
		.append(CYCLE_MSG).append(game.getCycle()).append(StringUtils.LINE_SEPARATOR)
		.append(TOTAL_OBSTACLES_MSG).append(Obstacle.getObstaclesCount()).append(StringUtils.LINE_SEPARATOR)
		.append(TOTAL_COINS_MSG).append(Coin.getCoinsCount()).append(StringUtils.LINE_SEPARATOR);
		
		if(game.isSuperCoinPresent()) {
			buffer.append(SUPERCOIN_IS_PRESENT_MSG).append(StringUtils.LINE_SEPARATOR);
		}
		/* @formatter:on */
		
		if (!game.isTestMode()) {
			/* @formatter:off */
			buffer.append(StringUtils.LINE_SEPARATOR)
			.append(ELAPSED_TIME_MSG).append(formatTime(game.elapsedTime()));
			/* @formatter:on */
		}
		
		thunderHitThisTurn = false;

		return buffer.toString();
	}
	
	@Override
    public String toString() {
		StringBuilder str = new StringBuilder();

		// Game Status

		str.append(getInfo());

		// Print Game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;
		String nextSlot = "";
		Boolean alreadyOccupied = false;
		Boolean thereIsNothing = true;

		for (int y = 0; y < game.getRoadWidth(); y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < game.getVisibility(); x++) {
				if (game.getPlayerY() == y && x == 0) {
					nextSlot+=game.getPlayerSymbol();
					thereIsNothing = false;
				}
				GameObject gameObject = game.getObjectInPositionLoop(x + game.getPlayerX(), y);
				while(gameObject != null) {
					thereIsNothing = false;
					nextSlot+=gameObject.toString();
					gameObject = game.getObjectInPositionLoop(x + game.getPlayerX(), y);
				}
				if(x == game.getThunderPosition().x - game.getPlayerX() && y == game.getThunderPosition().y) {
					nextSlot = "🗲";
					thereIsNothing = false;
				}
				if (game.distanceToGoal() <= game.getVisibility() && game.distanceToGoal() == x) {
					str.append(StringUtils.centre("|", CELL_SIZE)).append(verticalDelimiter);
					thereIsNothing = false;
				} 
				if(thereIsNothing) {
					nextSlot+= verticalDelimiter;
				}

				
				
				str.append(StringUtils.centre(nextSlot, CELL_SIZE)).append(verticalDelimiter);
				nextSlot = "";
				thereIsNothing = true;
			}
			if (y < game.getRoadWidth() - 1) {
				str.append(this.indentedLanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}

	public String endMessage() {
		StringBuilder buffer = new StringBuilder(GAME_OVER_MSG);

		if (game.isUserExit()) {
			return buffer.append(DO_EXIT_MSG).toString();
		}

		if (game.hasArrived()) {
			buffer.append(WIN_MSG);
			if (!game.isTestMode()) {
				if (game.isNewRecord(game.elapsedTime())) {
					buffer.append(NEW_RECORD_MSG).append(formatTime(game.elapsedTime()));
				} 
				else {
					buffer.append(RECORD_MSG).append(formatTime(game.getRecord()));
				}	
			}	
		}
		else {
			buffer.append(CRASH_MSG);
		}

		return buffer.toString();
	}

	private String formatTime(long elapsedTime) {
		StringBuilder buffer = new StringBuilder();
		long seconds = elapsedTime/1000;
		long minutes = 0;
		long hours = 0;
		long days = 0;
		if (seconds >= 60) {
			minutes = seconds/60;
			seconds = seconds%60;
			
			if (minutes >= 60) {
				hours = minutes/60;
				minutes = minutes%60;
				if (hours >= 24) {
					days = hours/24;
					hours = hours%24;
				}
			}
		}
		if (days != 0) {
			buffer.append(days).append(" days ");
			if(hours != 0) {
				buffer.append(hours).append(" hours ");
				if (minutes != 0) {
					buffer.append(minutes).append(" min ");
				}
			}
		}
		buffer.append(seconds).append(" s");
		
		return buffer.toString();
	}


	public static String description(Level level) {
		StringBuilder buffer = new StringBuilder("[Car] the racing car");
		/* @formatter:off */
		buffer.append(StringUtils.LINE_SEPARATOR).append(Coin.INFO)
		.append(StringUtils.LINE_SEPARATOR).append(Obstacle.INFO);
		/* @formatter:on */
		return buffer.toString();
	}


	public static String notEnoughCoins() {
		return NOT_ENOUGH_COINS_MSG;
	}
	
	public static void thunderHitThisTurn() {
		thunderHitThisTurn = true;
	}
	
	public static void thunderHitAnObject(String name) {
		thunderHitThisTurn();
		objectHitByThunder = name;
	}
	
	private String thunderVictim() {
		if(thunderHitThisTurn) return " -> " + objectHitByThunder + " hit.";
		else return "";
	}
	
}
