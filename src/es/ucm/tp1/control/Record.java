package es.ucm.tp1.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import es.ucm.tp1.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.logic.Game;

public class Record {
	private static long hard = Long.MAX_VALUE;
	private static long easy = Long.MAX_VALUE;
	private static long test = Long.MAX_VALUE;
	private static long advanced = Long.MAX_VALUE;
	private static String[] lines = new String[4];
	
	public static void readRecord() throws InputOutputRecordException{
		try(BufferedReader br = new BufferedReader(new FileReader("record.txt"))) {
		    lines[0] = br.readLine();
		    lines[1] = br.readLine();
		    lines[2] = br.readLine();
		    lines[3] = br.readLine();
		}
		catch(IOException ex) {
			throw new InputOutputRecordException("[ERROR]: File not found or corrupted.");
		}
		int i = 0;
		while(i<lines.length) {
			if(lines[i].substring(0, 4).equalsIgnoreCase("HARD")) {
				hard = Long.parseLong(lines[i].substring(5, lines[i].length()));
			}
			else if(lines[i].substring(0, 4).equalsIgnoreCase("EASY")) {
				easy = Long.parseLong(lines[i].substring(5, lines[i].length()));
			}
			else if(lines[i].substring(0, 4).equalsIgnoreCase("TEST")) {
				test = Long.parseLong(lines[i].substring(5, lines[i].length()));
			}
			else if(lines[i].substring(0, 8).equalsIgnoreCase("ADVANCED")) {
				advanced = Long.parseLong(lines[i].substring(9, lines[i].length()));
			}
			i++;
		}
	}
	
	public static void writeRecord(Game game) throws InputOutputRecordException{
		try {
			readRecord();
		}
		catch(InputOutputRecordException ex) {
			lines[0] = "HARD:" + hard + "\n";
			lines[1] = "EASY:" + easy + "\n";
			lines[2] = "TEST:" + test + "\n";
			lines[3] = "ADVANCED:" + advanced + "\n";
		}
		
		String difficultyLevel = game.getLevel().getLevelName();
		
		if(difficultyLevel.equalsIgnoreCase("HARD") && game.getElapsedTime() < hard && exists()) hard = game.getElapsedTime();
		else if(difficultyLevel.equalsIgnoreCase("EASY") && game.getElapsedTime() < easy && exists()) easy = game.getElapsedTime();
		else if(difficultyLevel.equalsIgnoreCase("TEST") && game.getElapsedTime() < test && exists()) test = game.getElapsedTime();
		else if(difficultyLevel.equalsIgnoreCase("ADVANCED") && game.getElapsedTime() < advanced && exists()) advanced = game.getElapsedTime();
		
	    try(BufferedWriter writer = new BufferedWriter(new FileWriter("record.txt"))) {
	    	int i = 0;
	    	while(i<lines.length) {
	    		if(lines[i].substring(0, 4).equalsIgnoreCase("HARD")) writer.write("HARD:" + hard + "\n");
				else if(lines[i].substring(0, 4).equalsIgnoreCase("EASY")) writer.write("EASY:" + easy + "\n");
				else if(lines[i].substring(0, 4).equalsIgnoreCase("TEST")) writer.write("TEST:" + test + "\n");
				else if(lines[i].substring(0, 8).equalsIgnoreCase("ADVANCED")) writer.write("ADVANCED:" + advanced + "\n");
				i++;
			}
	    }
	    catch(IOException ex) {
			throw new InputOutputRecordException("[ERROR]: File not found or corrupted.");
	    }
	}

	private static boolean exists() {
		File recordFile = new File("record.txt");
		return recordFile.exists();
	}
}
