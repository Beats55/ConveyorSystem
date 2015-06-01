package org.barclays.assignment;
/**
 * 
 * This Class represents a Flight
 * 
 * @author Administrator
 *
 */
public class Flight {
	private String FlightId;
	private String FlightDestination;
	
	/**
	 * @param flightId
	 * @param flightDestination
	 */
	public Flight(String flightId, String flightDestination) {
		FlightId = flightId;
		FlightDestination = flightDestination;
	}

	/**
	 * @return the flightId
	 */
	public String getFlightId() {
		return FlightId;
	}

	/**
	 * @param flightId the flightId to set
	 */
	public void setFlightId(String flightId) {
		FlightId = flightId;
	}

	/**
	 * @return the flightDestination
	 */
	public String getFlightDestination() {
		return FlightDestination;
	}

	/**
	 * @param flightDestination the flightDestination to set
	 */
	public void setFlightDestination(String flightDestination) {
		FlightDestination = flightDestination;
	}
	
}
