package org.barclays.assignment.test;

import static org.junit.Assert.*;

import org.barclays.assignment.ConveyorSystem;
import org.junit.Test;


public class TestConveyorSystem {
	
	@Test
	public void fileInput() {
		ConveyorSystem cs = new ConveyorSystem();
		assertNotNull("Input File missing", getClass().getResource("/Input.txt"));
	}

}
