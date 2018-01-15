import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;

public class ZahlumwandlungTest {

	@Test
	public void testWandeleZahlUm() {
		// Erzeuge ein Objekt der Klasse Zahlumwandlung.
		Zahlumwandlung eineZahlumwandlung = new Zahlumwandlung();

		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(1),
				is(equalTo("I")));

		/*
		 * Tests hier ergaenzen.
		 */

	}
}
