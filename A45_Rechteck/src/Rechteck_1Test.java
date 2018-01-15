import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rechteck_1Test {
	
	@Test
	void testGetLaenge() {
		Rechteck_1 re1 = new Rechteck_1(12, 14);
		assertEquals(12 , re1.getLaenge());	
	}
	
	@Test
	void testGetBreite() {
		Rechteck_1 re1 = new Rechteck_1(12, 14);
		assertEquals(14 , re1.getBreite());
	}
	
	@Test
	void testGetUmfang() {
		Rechteck_1 re1 = new Rechteck_1(12, 14);
		assertEquals(52 , re1.getUmfang());
	}
	
	@Test
	void testGetFlaeche() {
		Rechteck_1 re1 = new Rechteck_1(12, 14);
		assertEquals(168 , re1.getFlaeche());
	}

}
