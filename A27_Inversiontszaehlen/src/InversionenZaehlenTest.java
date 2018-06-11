import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;

class InversionenZaehlenTest {

	@Test
	void testExceptions() {

		int[] testfeld0 = null;
		int[] testfeld1 = {2, 5, 0, 1, 6, 8, 7};
		int[] testfeld2 = {3, 2, 2, 1};
		int[] testfeld3 = {0, -1, -2, -3};
		
		assertThrows(IllegalArgumentException.class, () -> { InversionenZaehlen.anzahlInversionen(testfeld0); }, "null-Referenz wird nicht korrekt verarbeitet.");
		assertThrows(IllegalArgumentException.class, () -> { InversionenZaehlen.anzahlInversionen(testfeld1); }, "Nicht vorhandene Permutation wird nicht korrekt verarbeitet.");
		assertThrows(IllegalArgumentException.class, () -> { InversionenZaehlen.anzahlInversionen(testfeld2); }, "Nicht vorhandene Permutation wird nicht korrekt verarbeitet.");
		assertThrows(IllegalArgumentException.class, () -> { InversionenZaehlen.anzahlInversionen(testfeld3); }, "Nicht vorhandene Permutation wird nicht korrekt verarbeitet.");
	}
	
	@Test
	void testAnzahlInversionen() {
		
		int[] testfeld0 = {};
		int[] testfeld1 = {0, 1, 2, 3, 4, 5};
		int[] testfeld2 = {0, 2, 3, 6, 8, 1, 4, 7, 5};
		int[] testfeld3 = {0, 4, 2, 3, 1};
		
		assertThat("Inversionen in leerem Feld werden nicht korrekt berechnet.", InversionenZaehlen.anzahlInversionen(testfeld0), is(equalTo(0)));
		assertThat("Inversionen in sortiertem Feld werden nicht korrekt berechnet.", InversionenZaehlen.anzahlInversionen(testfeld1), is(equalTo(0)));
		assertThat("Inversionen werden nicht korrekt berechnet.", InversionenZaehlen.anzahlInversionen(testfeld2), is(equalTo(10)));
		assertThat("Inversionen werden nicht korrekt berechnet.", InversionenZaehlen.anzahlInversionen(testfeld3), is(equalTo(5)));
	}

}
