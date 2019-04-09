/*
 * Abel Acosta
 * Saul Hernandez
 * 
 * April 9 2019
 * 
 * This program utilizes maps in order to calculate the amount
 * of Scrabble points for words that start with "q" but do not
 * have "u" as the next letter. The program will calculate the
 * ammount of points and tell the user how much time reading
 * and search a certain type of map took.
 * 
 * Inputs: User enters in "treemap" or "hashmap" into args field
 * to deteremine the type of map used. Program also takes input
 * from a .txt file with words and a .txt file saying how much
 * points each letter is worth.
 * 
 * Outputs: How many points a certain word is worth and the time
 * it took for loading into a map and for how long it took to search a map.
 */

import java.util.Map;
import java.util.Scanner;
import java.io.File;
import java.util.HashMap;
import java.util.TreeMap;
import java.util.Iterator;

public class Main {
	
	public static Map<String, Integer> hashMapQWords;
	public static Map<String, Integer> hashMapPoints;
	public static Map<String, Integer> treeMapQWords;
	public static Map<String, Integer> treeMapPoints;
	public static long time1, time2;

	public static void main(String[] args) {
		
		// Make sure user passes in data structure option.
		if(args.length == 0) {
			System.out.println("Specify \"treemap\" or \"hashmap\".");
			return;
		}
		
		init();
		
		long time1, time2;
		time1 = System.currentTimeMillis();
		
		switch(args[0]) {
		case "hashmap":
			readValues(treeMapQWords, treeMapPoints);
			printValues(treeMapQWords);
			break;
		case "treemap":
			readValues(hashMapQWords, hashMapPoints);
			printValues(hashMapQWords);
			break;
		default:
			System.out.println(args[0] + " not an option.");
			break;
		}
		
	}
	
	private static void printValues(Map<String, Integer> map) {
		Iterator<Map.Entry<String, Integer>> iter = map.entrySet().iterator();
		while(iter.hasNext()) 
        { 
             Map.Entry<String, Integer> entry = iter.next(); 
             System.out.println("Key = " + entry.getKey() +  
                                ", Value = " + entry.getValue()); 
        }
	}

	// Initialize data structures
	public static void init() {
		treeMapQWords = new TreeMap<String, Integer>();
		treeMapPoints = new TreeMap<String, Integer>();
		hashMapQWords = new HashMap<String, Integer>();
		hashMapPoints = new HashMap<String, Integer>();
	}
	
	public static void readValues(Map<String, Integer> qwords, Map<String, Integer> points) {
		Scanner qwordsFile = null;
		Scanner pointsFile = null;
		
		// Open files
		try {
			qwordsFile = new Scanner(new File("QWords.txt"));
			pointsFile = new Scanner(new File("Points.txt"));
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		int value = 0;
		String word;
		
		String letters;
		time1 = System.nanoTime();
		while (pointsFile.hasNext()) {
			value = Integer.parseInt(pointsFile.nextLine());
			letters = pointsFile.nextLine();
			
			for (int i = 0; i < letters.length(); i++) {
				points.put(letters.substring(i, i + 1), value);
			}
			
		}
		time2 = System.nanoTime();
		System.out.println("Time to store point values: " + (time2 - time1) + " nanoseconds");
		time1 = System.nanoTime();
		while (qwordsFile.hasNext()) {
			value = 0;
			word = qwordsFile.nextLine();

			for (int i = 0; i < word.length(); i++) {
					value += points.get(word.substring(i, i + 1));

			}
			qwords.put(word, value);
		}
		time2 = System.nanoTime();
		System.out.println("Time to search for point values: " + (time2 - time1) + " nanoseconds");
		qwordsFile.close();
		pointsFile.close();
	}
}
