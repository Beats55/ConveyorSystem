package org.barclays.assignment;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * This Class initializes & runs Conveyor System
 * 
 * @author Administrator
 *
 */
public class ConveyorSystem {
	private static File file;
	private static ArrayList<String> inGraph;
	private static ArrayList<String> departures;
	private static ArrayList<String> bags;
	private static HashMap<String, LinkedList<Node>> graph;
	private static HashMap<String, Departure> departureList;
	private static ArrayList<Bag> bagList;

	/**
	 * 
	 */
	public static void initialize() {
		inGraph = new ArrayList<String>();
		departures = new ArrayList<String>();
		bags = new ArrayList<String>();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Starting Reading Input");
		if(args.length != 1) {
			System.out.println("USAGE: java -jar \"path-to-inputFile\"");
			System.exit(0);
		}
		
		file = new File(args[0]);
		
		if(!file.exists()) {
			System.out.println("Input File DO NOT exists. Please provide a correct input File");
			System.exit(0);
		}
		
		initialize();
		readInput(file);

		ConveyorGraph cg = new ConveyorGraph();
		cg.initialize(inGraph);
		
		departureList = getDepartureList();
		bagList = getBagList();
		
		Iterator<Bag> it = bagList.iterator();
		while(it.hasNext()) {
			Bag b = it.next();
			String bNumber = b.getBagNumber();
			String source = b.getBagSource();
			String fId = b.getBagDestination();
			String destination; 
			
			if(fId.equalsIgnoreCase("ARRIVAL"))
				destination = "BaggageClaim";
			else
				destination = departureList.get(fId).getFlightGate();
			
			//Integer sd = cg.getShortestDistance(source, destination);
			ArrayList<ArrayList<String>> sd = cg.getShortestDistance(source, destination);
			Integer i = cg.getShortestDistance();
			
			System.out.print(bNumber + " " + source + " ");
			Iterator<ArrayList<String>> ito = sd.iterator();
			while(ito.hasNext()) {
				ArrayList<String> temp = ito.next();
				
				if(temp.contains(destination)) {
					for(String s: temp)
						System.out.print(s + " ");
					System.out.println(": " + i);
				}
			}
			
			//System.out.println(bNumber + " " + source + " " + destination + " " + sd);
		}
	}

	public static HashMap<String, Departure> getDepartureList() {
		HashMap<String, Departure> dList = new HashMap<String, Departure>();
		Flight f;
		Departure d;
		String [] strArr;
		
		for(String str : departures) {
			strArr = str.split(" ");
			String fId = strArr[0];
			String fGate = strArr[1];
			String fDest = strArr[2];
			String fTime = strArr[3];
			
			f = new Flight(fId, fDest);
			d = new Departure(f, fGate, fTime);
			dList.put(fId, d);
		}
		
		return dList;
	}
	
	public static ArrayList<Bag> getBagList() {
		ArrayList<Bag> bList = new ArrayList<Bag>();
		String[] strArr;
		Bag b;
		
		Iterator<String> it = bags.iterator();
		while(it.hasNext()) {
			String str = it.next();
			strArr = str.split(" ");
			
			b = new Bag(strArr[0], strArr[1], strArr[2]);
			
			bList.add(b);
		}
		
		return bList;
	}
	
	public static boolean readInput(File file) {
		boolean pass = false;
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String inputLine = reader.readLine();
			
			while(inputLine != null) {
				if(inputLine.startsWith("#")) {
					if(inputLine.contains("Conveyor System")) {
						inputLine = reader.readLine();
						
						while(!inputLine.startsWith("#")) {
							inGraph.add(inputLine);
							inputLine = reader.readLine();
						}
					} else if(inputLine.contains("Departures")) {
						inputLine = reader.readLine();
						
						while(!inputLine.startsWith("#")) {
							departures.add(inputLine);
							inputLine = reader.readLine();
						}
					} else if(inputLine.contains("Bags")) {
						inputLine = reader.readLine();
						
						while(inputLine != null) {
							bags.add(inputLine);
							inputLine = reader.readLine();
						}
					}
				}
			}
			reader.close();
			pass = true;
			
		} catch(Exception ex) {
			System.out.println(ex.getLocalizedMessage());
		}
		
		return pass;
	}

	
}
