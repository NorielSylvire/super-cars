package es.ucm.tp1.view;

import es.ucm.tp1.utils.StringUtils;
import es.ucm.tp1.logic.Game;

public class GamePrinter {

	private static final String SPACE = " ";

	private static final String ROAD_BORDER_PATTERN = "═";

	private static final String LANE_DELIMITER_PATTERN = "—";

	private static final int CELL_SIZE = 7;

	private static final int MARGIN_SIZE = 2;
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	private Game game;

	private int numRows;

	private int numCols;

	private String indentedRoadBorder;

	private String indentedLanesSeparator;

	private String margin;

	private String[][] board = new String[5][100];
	
	public GamePrinter(Game game, int cols, int rows) {
		this.game = game;
		this.numRows = rows;
		this.numCols = cols;
		

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {
				board[i][j] = "";
			}
		}

		this.margin = StringUtils.repeat(SPACE, MARGIN_SIZE);

		String roadBorder = ROAD_BORDER_PATTERN + StringUtils.repeat(ROAD_BORDER_PATTERN, (CELL_SIZE + 1) * game.getLevel().getVisibility());
		this.indentedRoadBorder = String.format("%n%s%s%n", margin, roadBorder);

		String laneDelimiter = StringUtils.repeat(LANE_DELIMITER_PATTERN, CELL_SIZE);
		String lanesSeparator = SPACE + StringUtils.repeat(laneDelimiter + SPACE, game.getLevel().getVisibility() - 1) + laneDelimiter + SPACE;

		this.indentedLanesSeparator = String.format("%n%s%s%n", margin, lanesSeparator);

	}

	private void encodeGame(Game game) {
		board[0][game.getRoadLength()-game.getVisibility()+2] = "|";
		board[1][game.getRoadLength()-game.getVisibility()+2] = "|";
		board[2][game.getRoadLength()-game.getVisibility()+2] = "|";
		//Esto se haria solo con el GameObjectList??
		for (int i = 0; i < game.getObstacleList().getNumObstacles(); i++) {
			board[game.getObstacleList().getObstacles()[i].getPosition()[1]][game.getObstacleList().getObstacles()[i].getPosition()[0]] = "░░░░░";
		}
		for (int j = 0; j < game.getCoinList().getNumCoins(); j++) {
			board[game.getCoinList().getCoins()[j].getPosition()[1]][game.getCoinList().getCoins()[j].getPosition()[0]] = "O";
		}
		//¿Que hiciste con esta funcion?//
		int[] pos = game.getPlayer().getPos();
		if(!game.getPlayer().getDead()) board[pos[1]][pos[0]] = ">";
		else board[pos[1]][pos[0]] = "░░@░░";
	}
	
	public void clean(int[] pos) {
		board[pos[1]][pos[0]] = "";
	}
	
	public void clean(int x, int y) {
		board[x][y] = "";
	}

	@Override
	public String toString() {
		encodeGame(game);
		
		StringBuilder str = new StringBuilder();

		// Game Status
		str.append(game.getGameStatus());

		// Print game

		str.append(indentedRoadBorder);

		String verticalDelimiter = SPACE;

		for (int y = 0; y < numRows; y++) {
			str.append(this.margin).append(verticalDelimiter);
			for (int x = 0; x < game.getVisibility(); x++) {
				if (game.getPlayer().getPos()[0] < game.getRoadLength() - game.getVisibility()) {
					str.append(StringUtils.centre(board[y][x+game.getPlayer().getPos()[0]], CELL_SIZE)).append(verticalDelimiter);
				}
				else {
					str.append(StringUtils.centre(board[y][x+game.getRoadLength() - game.getVisibility()], CELL_SIZE)).append(verticalDelimiter);
				}
			}
			if (y < numRows - 1) {
				str.append(this.indentedLanesSeparator);
			}
		}
		str.append(this.indentedRoadBorder);

		return str.toString();
	}
	
	public String[][] getBoard() {
		return board;
	}
	
	public void setBoard(String[][] newBoard) {
		this.board = newBoard;
	}
}
