package org.barclays.assignment;
/**
 * This Class represents a Departure
 * 
 * @author Administrator
 *
 */
public class Departure {
	private Flight flight;
	private String FlightGate;
	private String FlightTime;
	
	/**
	 * @param flight
	 * @param flightGate
	 * @param flightTime
	 */
	public Departure(Flight flight, String flightGate, String flightTime) {
		this.flight = flight;
		FlightGate = flightGate;
		FlightTime = flightTime;
	}

	/**
	 * @return the flight
	 */
	public Flight getFlight() {
		return flight;
	}

	/**
	 * @param flight the flight to set
	 */
	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	/**
	 * @return the flightGate
	 */
	public String getFlightGate() {
		return FlightGate;
	}

	/**
	 * @param flightGate the flightGate to set
	 */
	public void setFlightGate(String flightGate) {
		FlightGate = flightGate;
	}

	/**
	 * @return the flightTime
	 */
	public String getFlightTime() {
		return FlightTime;
	}

	/**
	 * @param flightTime the flightTime to set
	 */
	public void setFlightTime(String flightTime) {
		FlightTime = flightTime;
	}
	
}
