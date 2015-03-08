package tests;

import static org.junit.Assert.*;
import org.junit.Test;

import domain.Upholstery;

public class UpholsteryTests {

	@Test
	public void testInitialization() {
		Upholstery u = new Upholstery();
		assertFalse(u.getIsPlaced());
	}

	@Test
	public void testSetup() {
		fail("Not yet implemented");
	}

}
