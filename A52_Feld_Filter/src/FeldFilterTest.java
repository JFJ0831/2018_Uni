import static org.junit.Assert.*;

import org.junit.Test;


public class FeldFilterTest {

/*	
	@Test
	public void testGetMin() {
		// Testdaten
		int[] beispielfeld = {2, 17, 10, 9, 16, 
				3, 9, 16, 5, 1, 17, 14};
		// Erzeuge ein Testobjekt.
		FeldFilter einFeldFilter = new FeldFilter(beispielfeld);

		assertEquals(1,
				einFeldFilter.getMin());
	}	
//*

	@Test
	public void testGetMax() {
		// Testdaten
		int[] beispielfeld = {2, 17, 10, 9, 16, 
				3, 9, 16, 5, 1, 17, 14};
		// Erzeuge ein Testobjekt.
		FeldFilter einFeldFilter = new FeldFilter(beispielfeld);

		assertEquals(17,
				einFeldFilter.getMax());
	}	
/*
	// NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT
	@Test
	public void testEntferneFeld() {
		// Testdaten
		int[] beispielfeld = {2, 17, 10, 9, 16, 
				3, 9, 16, 5, 1, 17, 14};
		// Erzeuge ein Testobjekt.
		FeldFilter einFeldFilter = new FeldFilter(beispielfeld);

		int[] erwartet = {2, 17, 9, 16, 3, 9, 16, 5, 1, 17, 14};
		assertArrayEquals(erwartet,
				einFeldFilter.entferneFeld(beispielfeld, 2));
	}	
//* // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT// NICHT BENOETIGT // NICHT BENOETIGT

	@Test
	public void testHaengeFeldAn() {
		// Testdaten
		int[] beispielfeld = {2, 17, 10, 9, 16, 
				3, 9, 16, 5, 1, 17, 14};
		// Erzeuge ein Testobjekt.
		FeldFilter einFeldFilter = new FeldFilter(beispielfeld);

		int[] erwartet = {2, 17, 10, 9, 16, 3, 9, 16, 5, 1, 17, 14, 99};
		assertArrayEquals(erwartet,
				einFeldFilter.haengeFeldAn(beispielfeld, 99));
	}	
//*/

	@Test
	public void testFilterGroesserAls() {
		// Testdaten
		int[] beispielfeld = {2, 17, 10, 9, 16, 
				3, 9, 16, 5, 1, 17, 14};
		// Erzeuge ein Testobjekt
		FeldFilter einFeldFilter = new FeldFilter(beispielfeld);

		int[] erwartet1 = {17, 16, 16, 17, 14};
		assertArrayEquals(erwartet1,
				einFeldFilter.filterGroesserAls(10));

		int[] erwartet2 = beispielfeld.clone();
		assertArrayEquals(erwartet2,
				einFeldFilter.filterGroesserAls(0));

		int[] erwartet3 = {};
		assertArrayEquals(erwartet3,
				einFeldFilter.filterGroesserAls(17));
	}
//*/

	@Test
	public void testEliminiereMinMax() {
		// Testdaten
		int[] beispielfeld1 = {2, 17, 10, 9, 16, 
				3, 9, 16, 5, 1, 17, 14};
		// Erzeuge ein Testobjekt
		FeldFilter einFeldFilter = new FeldFilter(beispielfeld1);

		int[] erwartet1 = {2, 10, 9, 16, 
				3, 9, 16, 5, 14};
		assertArrayEquals(erwartet1,
				einFeldFilter.eliminiereMinMax());

		// Testdaten
		int[] beispielfeld2 = {1, 1, 1, 1};
		// Erzeuge ein Testobjekt
		einFeldFilter = new FeldFilter(beispielfeld2);

		int[] erwartet2 = {};
		assertArrayEquals(erwartet2,
				einFeldFilter.eliminiereMinMax());

		// Testdaten
		int[] beispielfeld3 = {-1, -12, -4, -5};
		// Erzeuge ein Testobjekt
		einFeldFilter = new FeldFilter(beispielfeld3);

		int[] erwartet3 = {-4, -5};
		assertArrayEquals(erwartet3,
				einFeldFilter.eliminiereMinMax());
	}
//*/
}
