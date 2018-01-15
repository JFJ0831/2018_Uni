import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ICETest {

	@Test
	void testGetZugnummer() {
		ICE ICE1 = new ICE((short) 24061, "Muenster");
		assertEquals((short) 24061, ICE1.getZugnummer());
	}
	
	@Test
	void testGetZielbahnhof() {
		ICE ICE1 = new ICE((short) 24061, "Muenster");
		assertEquals("Muenster", ICE1.getZielbahnhof());
	}
	
	@Test
	void testGetGeschwindigkeit() {
		ICE ICE1 = new ICE((short) 24061, "Muenster");
		assertEquals(0, ICE1.getGeschwindigkeit());
	}
	
	@Test
	void testBeschleunige() {
		ICE ICE1 = new ICE((short) 24061, "Muenster");
		ICE1.beschleunige();
		assertEquals(15, ICE1.getGeschwindigkeit());
	}
	
	@Test
	void testBremseAb() {
		ICE ICE1 = new ICE((short) 24061, "Muenster");
		ICE1.bremseAb();
		assertEquals(-20, ICE1.getGeschwindigkeit());
	}

}
