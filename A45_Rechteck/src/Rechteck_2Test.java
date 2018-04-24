import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Rechteck_2Test {

	@Test
	void testGetLaenge() {
		Rechteck_2 re2 = new Rechteck_2(12, 52);
		assertEquals(12 , re2.getLaenge());
	}
	
	@Test
	void testGetBreite() {
		Rechteck_2 re2 = new Rechteck_2(12, 52);
		assertEquals(14 , re2.getBreite());
	}
	
	@Test
	void testGetUmfang() {
		Rechteck_2 re2 = new Rechteck_2(12, 52);
		assertEquals(52 , re2.getUmfang());
	}
	
	@Test
	void testGetFlaeche() {
		Rechteck_2 re2 = new Rechteck_2(12, 52);
		assertEquals(168 , re2.getFlaeche());
	}

}
