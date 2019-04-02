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

	public static void main(String[] args) {
		init();
		
		switch(args[0]) {
		case "hashmap":
			readValues(hashMap);
		case "treemap":
			readValues(treeMap);
		}
	}
	
	// Initialize data structures
	public static void init() {
		treeMap = new TreeMap<String, Integer>();
		hashMap = new HashMap<String, Integer>();
	}
	
	public static void readValues(Map<String, Integer> map) {
		Scanner input = new Scanner("QWords.txt");
		//TODO: Read file and store in map
		input.close();
	}

}
