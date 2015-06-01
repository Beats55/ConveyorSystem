package org.barclays.assignment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 * 
 * @author Administrator
 *
 */
public interface IConveyorGraph {
	boolean initialize(ArrayList<String> in);
	void printGraph();
}

class Node {
	private String value;
	private String weight;
	
	public Node(String v, String w) {
		value = v;
		weight = w;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return the weight
	 */
	public String getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(String weight) {
		this.weight = weight;
	}	
}

class ShortestDistance {
	String Node;
	Integer distance;
	/**
	 * @param node
	 * @param distance
	 */
	public ShortestDistance(String node, Integer distance) {
		Node = node;
		this.distance = distance;
	}
	/**
	 * @return the node
	 */
	public String getNode() {
		return Node;
	}
	/**
	 * @param node the node to set
	 */
	public void setNode(String node) {
		Node = node;
	}
	/**
	 * @return the distance
	 */
	public Integer getDistance() {
		return distance;
	}
	/**
	 * @param distance the distance to set
	 */
	public void setDistance(Integer distance) {
		this.distance = distance;
	}
	
	
}