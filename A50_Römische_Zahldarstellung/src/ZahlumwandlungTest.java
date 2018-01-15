import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class ZahlumwandlungTest {

	@Test
	public void testWandeleZahlUm() {
		// Erzeuge ein Objekt der Klasse Zahlumwandlung.
		Zahlumwandlung eineZahlumwandlung = new Zahlumwandlung();

		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(1),
				is(equalTo("I")));
		
		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(3000),
				is(equalTo("MMM")));
		
		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(2018),
				is(equalTo("MMXVIII")));
		
		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(34),
				is(equalTo("XXXIV")));
		
		assertThat("Zahl 1 wurde nicht korrekt umgewandelt.",
				eineZahlumwandlung.wandeleZahlUm(99),
				is(equalTo("XCIX")));

		Throwable ex = assertThrows(IllegalArgumentException.class, () -> {eineZahlumwandlung.wandeleZahlUm(3500);});
		assertThat("I wurde nicht korrekt verarbeitet.",
				ex.getMessage(),
				is(equalTo("Zahl liegt nicht im Bereich 1 bis 3000.")));

	}
}
