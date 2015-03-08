package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Component;

public class ComponentTest {

	@Test
	public void testInitialitation() {
		Component c = new Component();
		assertFalse(c.getIsPlaced());
	}

	@Test
	public void testSetIsPlace() {
		Component c = new Component();
		c.setIsPlaced(true);
		assertTrue(c.getIsPlaced());
	}
}
