package org.barclays.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

/**
 * 
 * @author Administrator
 *
 */
public class ConveyorGraph implements IConveyorGraph{
	private HashMap<String, LinkedList<Node>> graph = null;
	private Integer shortestDistance = null;

	public ConveyorGraph() {
		graph = new HashMap<String, LinkedList<Node>>();
	}
	
	/* 
	 * Initializes the Conveyor System
	 */
	public boolean initialize(ArrayList<String> input) {
		boolean status = false;
		LinkedList<Node> temp1;
		LinkedList<Node> temp2;
		
		String [] strArr;
		for(String str : input) {
			strArr = str.split(" ");
			String s1 = strArr[0];
			String s2 = strArr[1];
			
			Node n1 = new Node(s1, strArr[2]);
			Node n2 = new Node(s2, strArr[2]);
			
			temp1 = graph.get(s1);
			if(temp1 == null)
				temp1 = new LinkedList<Node>();
			temp1.add(n2);
			
			temp2 = graph.get(s2);
			if(temp2 == null)
				temp2 = new LinkedList<Node>();
			temp2.add(n1);
			
			graph.put(s1, temp1);
			graph.put(s2, temp2);
		}
		status = true;
		return status;
	}
	
	public void printGraph() {
		Set<String> str = graph.keySet();
		
		for(String s : str) {
			LinkedList<Node> l;
			
			l = graph.get(s);
			System.out.print(s + "->");
			Iterator<Node> i = l.iterator();
			while(i.hasNext()) {
				Node node = (Node) i.next();
				System.out.print(node.getValue() + " ");
				System.out.print(node.getWeight() + " ->");
			}
			System.out.println("null");
		}
	}
	
	public ArrayList<ArrayList<String>> getShortestDistance(String node1, String node2) {
		Set<String> keys = graph.keySet();
		ArrayList<ArrayList<String>> paths = new ArrayList<ArrayList<String>>();
		ArrayList<String> temp;
		ArrayList<String> covered = new ArrayList<String>();
		int noOfKeys = keys.size();
		ArrayList<ShortestDistance> list = new ArrayList<ShortestDistance>();
		ShortestDistance sd;
		LinkedList<Node> ll;
		Integer min;
		Iterator<ShortestDistance> its;
		String cur = null;
		
		sd = new ShortestDistance(node1, 0);
		list.add(sd);
		
		
		for(int i = 1; i < noOfKeys; i++) {
			String sourceNode = null;
			Integer sourceWeight = null;
			String destNode = null;
			Integer destWeight = null;
			min = Integer.MAX_VALUE;
			
			its = list.iterator();
			while(its.hasNext()) {
				sd = its.next();
				ll = graph.get(sd.getNode());
				
				Iterator<Node> itl = ll.iterator();
				while(itl.hasNext()) {
					Node n = itl.next();
					
					String s = sd.getNode() + " " + n.getValue();
					
					if(!covered.contains(s)) {
					
						if(Integer.parseInt(n.getWeight()) <= min) {
							min = Integer.parseInt(n.getWeight());
							sourceNode = sd.getNode();
							sourceWeight = sd.getDistance();
							destNode = n.getValue();
							destWeight = Integer.parseInt(n.getWeight());
										 
						}
					}
						
				}
				
			}

			covered.add(sourceNode + " " + destNode);
			covered.add(destNode + " " + sourceNode);
			destWeight += sourceWeight;
			 
			boolean f = false;
			Iterator<ArrayList<String>> it = paths.iterator();
			if(it.hasNext()) {
				while(it.hasNext()) {
					ArrayList<String> t = it.next();
					
					if(t.contains(sourceNode) && cur.equalsIgnoreCase(sourceNode)) {
						t.add(destNode);
						cur = destNode;
						f = true;
					} 
									
				}
				
				if(!f) {
					ArrayList<String> n = new ArrayList<String>();
					
					if(!sourceNode.equalsIgnoreCase(node1))
						n.add(sourceNode);
					n.add(destNode);
					cur = destNode;
					paths.add(n);
				}
			} else {
				ArrayList<String> n = new ArrayList<String>();
				//n.add(sourceNode);
				n.add(destNode);
				paths.add(n);
				cur = destNode;
			}
				
			
			
			if(destNode.equalsIgnoreCase(node2)) {
				shortestDistance = destWeight;
				return paths;
			}
			sd = new ShortestDistance(destNode, destWeight);
			list.add(sd);
		}
		
		
		return null;
	}

	/**
	 * @return the graph
	 */
	public HashMap<String, LinkedList<Node>> getGraph() {
		return graph;
	}

	/**
	 * @param graph the graph to set
	 */
	public void setGraph(HashMap<String, LinkedList<Node>> graph) {
		this.graph = graph;
	}

	/**
	 * @return the shortestDistance
	 */
	public Integer getShortestDistance() {
		return shortestDistance;
	}

	/**
	 * @param shortestDistance the shortestDistance to set
	 */
	public void setShortestDistance(Integer shortestDistance) {
		this.shortestDistance = shortestDistance;
	}
	
	
}

