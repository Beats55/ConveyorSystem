package org.barclays.assignment.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.barclays.assignment.ConveyorGraph;
import org.junit.Test;

public class TestConveyorGraph {
	
	@Test
	public void testInitialize() {
		ConveyorGraph cg = new ConveyorGraph();
		ArrayList<String> input = new ArrayList<String>();
		
		input.add("A1 A2 2");
		input.add("A2 A3 1");
		input.add("A2 A4 3");
		
		assertTrue(cg.initialize(input));
	}

}
