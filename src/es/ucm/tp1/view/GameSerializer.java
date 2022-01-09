package es.ucm.tp1.view;

import es.ucm.tp1.utils.StringUtils;
import es.ucm.tp1.logic.Game;
import es.ucm.tp1.logic.gameobjects.GameObject;

public class GameSerializer {
	
	public static StringBuilder serializeGame(Game game) {
		StringBuilder buffer = new StringBuilder();
		buffer.append("---- ROAD FIGHTER SERIALIZED ----").append(StringUtils.LINE_SEPARATOR)
		.append("Level: ").append(game.getLevel().getLevelName()).append(StringUtils.LINE_SEPARATOR)
		.append(game.getCycle()).append(StringUtils.LINE_SEPARATOR)
		.append(game.getElapsedTime()).append(StringUtils.LINE_SEPARATOR)
		.append("Game Objects:").append(StringUtils.LINE_SEPARATOR)
		.append(getVisibleObjects(game)).append(StringUtils.LINE_SEPARATOR);
		return buffer;
	}

	public static StringBuilder getVisibleObjects(Game game) {
		StringBuilder buffer = new StringBuilder();
		for(int i = 0; i < game.getRoadWidth(); i++) {
			for(int j = 0; j < game.getRoadLength(); j++)  {
				StringBuilder symbols = game.getAllSymbolsInPositionSerialize(j, i);
				if(game.getObjectInPosition(j, i) != null) buffer.append(symbols);
			}
		}
		return buffer;
	}
}
