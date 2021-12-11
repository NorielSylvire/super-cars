package es.ucm.tp1.control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import es.ucm.tp1.control.exceptions.InputOutputRecordException;
import es.ucm.tp1.logic.Game;

public class Record {
	private static long hard = 0;
	private static long easy = 0;
	private static long test = 0;
	private static long advanced = 0;
	private static String[] lines = new String[4];
	
	public static void readRecord() throws InputOutputRecordException{
		try(BufferedReader br = new BufferedReader(new FileReader("record.txt"))) {
		    lines[0] = br.readLine();
		    lines[1] = br.readLine();
		    lines[2] = br.readLine();
		    lines[3] = br.readLine();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			throw new InputOutputRecordException("[ERROR]: File not found or corrupted.");
		}
		int i = 0;
		while(i<lines.length) {
			if(lines[i].charAt(0) == 'H') hard = Long.valueOf(lines[i].substring(4, lines[i].length()));
			else if(lines[i].charAt(0) == 'E') easy = Long.valueOf(lines[i].substring(4, lines[i].length()));
			else if(lines[i].charAt(0) == 'T') test = Long.valueOf(lines[i].substring(4, lines[i].length()));
			else if(lines[i].charAt(0) == 'A') advanced = Long.valueOf(lines[i].substring(8, lines[i].length()));
			i++;
		}
	}
	
	public static void writeRecord(Game game) throws InputOutputRecordException{
		try {
			readRecord();
		}
		catch(InputOutputRecordException ex) {
			
		}
		
		String difficultyLevel = game.getLevel().getLevelName();
	    try(BufferedWriter writer = new BufferedWriter(new FileWriter("record.txt"))) {
	    	int i = 0;
	    	while(i<lines.length) {
				if(lines[i].charAt(0) == 'H') writer.write("HARD:" + hard + "\n");
				else if(lines[i].charAt(0) == 'E') writer.write("EASY:" + easy + "\n");
				else if(lines[i].charAt(0) == 'T') writer.write("TEST:" + test + "\n");
				else if(lines[i].charAt(0) == 'A') writer.write("ADVANCED:" + advanced + "\n");
				i++;
			}
	    }
	    catch(IOException ex) {
			ex.printStackTrace();
			throw new InputOutputRecordException("[ERROR]: File not found or corrupted.");
	    }
	}
}
