/*
 * Abel Acosta
 * Saul Hernandez
 * April 9, 2019
 * Purpose: This program demonstrates the use of maps. We will use both
 * tree maps and hash maps to store words from a file and search for
 * the word 100 times.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main2 {
	
	public static Map<Integer, String> treeMap;
	public static Map<Integer, String> hashMap;

	public static void main(String[] args) {
		init();
		
		// Make sure user passes in data structure option.
		if(args.length == 0) {
			System.out.println("Specify \"treemap\" or \"hashmap\".");
			return;
		}
		
		switch(args[0]) {
		case "treemap":
			insertData(treeMap);
			break;
		case "hashmap":
			insertData(hashMap);
			break;
		}
	}
	
	// Initialize data structures
	public static void init() {
		treeMap = new TreeMap<Integer, String>();
		hashMap = new HashMap<Integer, String>();
	}
	
	public static void insertData(Map<Integer, String> map) {
		// Open file
		Scanner fileInput = null;
		try {
			fileInput = new Scanner(new File("alice.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		long time1 = System.currentTimeMillis();
		// Add words to map
		while(fileInput.hasNextLine()) {
			String word = fileInput.nextLine();
			map.put(word.hashCode(), word);
		}
		System.out.println("Time for words to add in map: " + (System.currentTimeMillis() - time1) + " ms");
		System.out.println();
		
		long t1 = System.currentTimeMillis();
		// Look up "Alice" 100 times
		System.out.println("Searching for word: Alice");
		int count = 0;
		for(int i = 0; i < 100; i++) {
			Iterator iter = map.values().iterator();
			while(iter.hasNext()) {
				String word = (String) iter.next();
				if(word.contentEquals("Alice")) {
					count ++;
				}
			}
		}
		System.out.println("Search operation took " + (System.currentTimeMillis() - t1) + " ms");

		
	}

}
