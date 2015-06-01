package org.barclays.assignment;

/**
 * This class represents a Baggage with its Source and Destination
 * 
 * @author Administrator
 *
 */
public class Bag {
	private String BagNumber;
	private String BagSource;
	private String BagDestination;
	
	/**
	 * @param bagNumber
	 * @param bagSource
	 * @param bagDestination
	 */
	public Bag(String bagNumber, String bagSource, String bagDestination) {
		BagNumber = bagNumber;
		BagSource = bagSource;
		BagDestination = bagDestination;
	}
	
	/**
	 * @return the bagNumber
	 */
	public String getBagNumber() {
		return BagNumber;
	}
	
	/**
	 * @param bagNumber the bagNumber to set
	 */
	public void setBagNumber(String bagNumber) {
		BagNumber = bagNumber;
	}
	
	/**
	 * @return the bagSource
	 */
	public String getBagSource() {
		return BagSource;
	}
	
	/**
	 * @param bagSource the bagSource to set
	 */
	public void setBagSource(String bagSource) {
		BagSource = bagSource;
	}
	
	/**
	 * @return the bagDestination
	 */
	public String getBagDestination() {
		return BagDestination;
	}
	
	/**
	 * @param bagDestination the bagDestination to set
	 */
	public void setBagDestination(String bagDestination) {
		BagDestination = bagDestination;
	}
	
}
