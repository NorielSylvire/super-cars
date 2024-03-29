package es.ucm.tp1.control;

public enum Level {

	TEST(10, 3, 8, 0.5, 0, 0), EASY(30, 3, 8, 0.5, 0.5, 0), HARD(100, 5, 6, 0.7, 0.3, 0), ADVANCED(100, 3, 8, 0.3, 0.3, 0.1);

	private int length;

	private int width;

	private int visibility;

	private double coinFrequency;

	private double obstacleFrequency;
	
	private double advancedObjectsFrequency;

	private Level(int length, int width, int visibility, double obstacleFrequency, double coinFrequency, double advancedObjectsFrequency) {
		this.length = length;
		this.width = width;
		this.visibility = visibility;
		this.obstacleFrequency = obstacleFrequency;
		this.coinFrequency = coinFrequency;
		this.advancedObjectsFrequency = advancedObjectsFrequency;
	}

	public static Level valueOfIgnoreCase(String inputString) {
		for (Level level : Level.values()) {
			if (level.name().equalsIgnoreCase(inputString)) {
				return level;
			}
		}
		return null;
	}

	public static String all(String separator) {
		StringBuilder buffer = new StringBuilder();
		int levelCount = 0;
		for (Level level : Level.values()) {
			if (levelCount > 0) {
				buffer.append(separator);
			}
			buffer.append(level.name());
			levelCount++;
		}
		return buffer.toString();
	}	
	
	public int getLength() {
		return this.length;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getVisibility() {
		return this.visibility;
	}
	
	public double getObstacleFrequency() {
		return this.obstacleFrequency;
	}
	
	public double getCoinFrequency() {
		return this.coinFrequency;
	}

	public double getAdvancedObjectsFrequency() {
		return advancedObjectsFrequency;
	}

	public boolean isTestMode() {
		return (length == 10);
	}
	
	public boolean isAdvanced() {
		return (advancedObjectsFrequency != 0);
	}
	
	public String getLevelName() {
		if(isTestMode()) return "TEST";
		else if(isAdvanced()) return "ADVANCED";
		else if(this.getLength() == 30) return "EASY";
		else return "HARD";
	}
	
	public static boolean levelExists(String level) {
		if (level.equalsIgnoreCase("HARD") || level.equalsIgnoreCase("EASY") || level.equalsIgnoreCase("TEST") || level.equalsIgnoreCase("ADVANCED"))
			return true;
		else return false;
	}
}