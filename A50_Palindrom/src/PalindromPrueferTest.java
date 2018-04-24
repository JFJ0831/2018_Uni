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

		// Teste Palindrom.
		assertThat("Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("Radar"),
				is(equalTo(true)));
		
		assertThat("Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("0110"),
				is(equalTo(true)));
		
		assertThat("Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("\u265e\u262f\u262f\u265e"),
				is(equalTo(true)));

		// Teste Nicht-Palindrom.
		assertThat("Nicht-Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("Rakete"),
				is(equalTo(false)));

		assertThat("Nicht-Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("456789"),
				is(equalTo(false)));
		
		assertThat("Nicht-Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istPalindrom("\u265e\u262f\u262f"),
				is(equalTo(false)));
		
	}

	@Test
	public void testIstSatzPalindrom() {
		// Erzeuge ein Objekt zum Testen.
		PalindromPruefer einPalindromPruefer = new PalindromPruefer();

		// Teste die null-Referenz.
		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {einPalindromPruefer.istSatzPalindrom(null);});
		assertThat("Null-Referenz wurde nicht korrekt verarbeitet.",
		        ex.getMessage(),
		        is(equalTo("Argument darf nicht null sein.")));

		// Teste Zeichenkette der Laenge 0.
		assertThat("String der Laenge 0 wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istSatzPalindrom(""),
				is(equalTo(true)));

		// Teste Satz-Palindrom.
		assertThat("Satz-Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istSatzPalindrom("Vitaler Nebel mit Sinn ist im Leben relativ."),
				is(equalTo(true)));

		// Teste Nicht-Satz-Palindrom.
		assertThat("Nicht-Satz-Palindrom wurde nicht korrekt verarbeitet.",
				einPalindromPruefer.istSatzPalindrom("Vitaler Nebel mit Sinn ist im Leben nicht relativ."),
				is(equalTo(false)));

	}

}
