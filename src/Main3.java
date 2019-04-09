import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
