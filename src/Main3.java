/*
 * Abel Acosta
 * Saul Hernandez
 * April 9, 2019
 * Purpose: This program simulates a scavenger hunt.
 * Our challenge is to find the best data structure to store the results of the hunt. 
 * 
 * Recommendation: It is better to use ArrayList
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main3 {
	
	public static ArrayList<String> arrayList;
	public static LinkedList<String> linkedList;

	public static void main(String[] args) {
		
		init();
		
		// Make sure user passes in data structure option.
		if(args.length == 0) {
			System.out.println("Specify \"arraylist\" or \"linkedlist\".");
			return;
		}
		
		switch(args[0]) {
		case "arraylist":
			processList(arrayList);
			break;
		case "linkedlist":
			processList(linkedList);
			break;
		default:
			System.out.println(args[0] + " option not found.");
			return;
		}

	}
	
	public static void processList(List<String> list) {
		addToList(list);
		traverseList(list);
		playGame(list);
	}
	
	public static void playGame(List<String> list) {
		System.out.println("how many teams will play the game?");
		Scanner input = new Scanner(System.in);
		
		int numOfTeams = 0;
		
		String response = input.nextLine();
		
		try {  
			numOfTeams = Integer.parseInt(response); 
		} catch(NumberFormatException e){  
			numOfTeams = 3;
		}
		
		// Creating teams
		Team[] teams = new Team[numOfTeams];
		for(int i = 0; i < numOfTeams; i++) {
			teams[i] = new Team(list);
		}
		
		long t1 = System.currentTimeMillis();
		// load items from list to each team
		for(int i = 0; i < numOfTeams; i++) {
			for(int j = 0; j < list.size(); j++) {
				teams[i].load(list.get(j));
			}
		}
		System.out.println("Time for loading items to all teams: " + (System.currentTimeMillis() - t1));
		System.out.println();
		
		System.out.println(" what position in the list to be used for retrieving and inserting elements?");
		int position = 0;
		response = input.nextLine();
		
		try {  
			position = Integer.parseInt(response); 
		} catch(NumberFormatException e){  
			position = 23;
		}
		
		// Retrieving items from each team
		t1 = System.currentTimeMillis();
		for(int i = 0; i < numOfTeams; i++) {
			System.out.println(teams[i].list.get(position));
		}
		System.out.println("Total time for retrieving: " + (System.currentTimeMillis() - t1));
		
		// Inserting item in each team
		t1 = System.currentTimeMillis();
		for(int i = 0; i < numOfTeams; i++) {
			teams[i].list.add(position, "Tea from grandma");
		}
		System.out.println("Total time for insertion: " + (System.currentTimeMillis() - t1));
		
		// Retrieve item with random position
		t1 = System.currentTimeMillis();
		position = new Random().nextInt(100);
		String item = list.get(position);
		for(int i = 0; i < numOfTeams; i++) {
			for(int j = 0; j < teams[i].list.size(); j++) {
				if(teams[i].list.get(j).equals(item)) {
					System.out.println("Found in position: " + j);
				}
			}
		}
		System.out.println("Time it took to find item with random gen: " + (System.currentTimeMillis() - t1));
		
		input.close();
	}
	
	public static void addToList(List<String> list) {
		Scanner input = null;
		try {
			input = new Scanner(new File("items.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		while(input.hasNextLine()) {
			list.add(input.nextLine());
		}
	}
	
	public static void traverseList(List<String> list) {
		long t1 = System.currentTimeMillis();
		for(int i = 0; i < list.size(); i++) {
			String word = list.get(i);
		}
		
		for(int i = list.size() - 1; i > 0; i--) {
			String word = list.get(i);
		}
		System.out.println("Time to traverse list: " + (System.currentTimeMillis() - t1));
	}
	
	public static void init() {
		arrayList = new ArrayList<String>();
		linkedList = new LinkedList<String>();
	}

}
