/*
 * Abel Acosta
 * Saul Hernandez
 */

import java.util.Map;
import java.util.Scanner;
import java.util.HashMap;
import java.util.TreeMap;

public class Main {
	
	public static Map<String, Integer> treeMap;
	public static Map<String, Integer> hashMap;
	public static long time1, time2;

	public static void main(String[] args) {
		init();
		
		long time1, time2;
		time1 = System.currentTimeMillis();
		
		switch(args[0]) {
		case "hashmap":
			readValues(hashMap);
		case "treemap":
			readValues(treeMap);
		}
		
		time2 = System.currentTimeMillis();
		System.out.println("Time for this operation: " + (time2 - time1));
	}
	
	// Initialize data structures
	public static void init() {
		treeMap = new TreeMap<String, Integer>();
		hashMap = new HashMap<String, Integer>();
	}
	
	public static void readValues(Map<String, Integer> map) {
		Scanner qwords = new Scanner("QWords.txt");
		Scanner points = new Scanner("Points.txt");
		Integer value = 0;
		Integer pointTotals = 0;
		String word;
		
		String letters;
		time1 = System.currentTimeMillis();
		while (points.hasNext()) {
			if (points.hasNextInt())
				value = points.nextInt();
			letters = points.nextLine();
			
			for (int i = 0; i < letters.length(); i++) {
				map.put(letters.substring(i, i + 1), value);
			}
		}
		time2 = System.currentTimeMillis();
		System.out.println("Time to store point values: " + (time2 - time1));

		while (qwords.hasNext()) {
			word = qwords.nextLine();
			for (int i = 0; i < word.length(); i++) {
				word.substring(i, i + 1)
			}
		}
		qwords.close();
		points.close();
	}

}
