import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class PalindromPrueferTest {

	@Test
	public void testIstPalindrom() {
		// Erzeuge ein Objekt zum Testen.
		PalindromPruefer einPalindromPruefer = new PalindromPruefer();

		// Teste die null-Referenz.
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {einPalindromPruefer.istPalindrom(null);});
		assertThat("Null-Referenz wurde nicht korrekt verarbeitet.",
		        ex.getMessage(),
		        is(equalTo("Argument darf nicht null sein.")));

		// Teste Zeichenkette der Laenge 0.
		assertThat("String der Laenge 0 wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom(""),
				is(equalTo(true)));

		/*
		 * Tests hier ergaenzen.
		 */

	}

	/*
	 * Tests hier ergaenzen.
	 */

}
