import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

/** Beispiele zu Assertions in JUnit 5
 * @see https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
 */
public class ExampleTest {

	@Test
	public void testNotNull() {

		// Erzeuge Objekt zum Testen.
		String s = "Ein Test";
		
		// Dieser Test ist inhaltlich wenig zielfuehrend,
		// sondern zeigt nur die Syntax von 'assertThat'
		assertThat("Strings werden nicht korrekt verglichen.",
				s,
				is(not(equalTo("Ein anderer Test"))));
				
	}

	@Test
	public void testException() {
				
		// Bereite Feld zum Testen vor.
		int[] i = { 1, 2 };
		
		// Informell beschriebene Syntax von assertThrows:
		// 1. Parameter: Name der erwarteten Ausnahme erweitert um ".class". 
		//               In diesem Fall: ArrayIndexOutOfBoundsException.class
		// 2. Parameter: Lambda-Ausdruck [ja, so etwas gibt es in Java, https://docs.oracle.com/javase/8/docs/api/java/lang/FunctionalInterface.html]
		//               der Form "Parameterliste -> Funktionsrumpf". In diesem
		//               Fall: () [= keine Parameter] -> { i[3] = 5; }
		// 3. Parameter: Text der Fehlermeldung, falls Ausnahme erzeugt wird.
		//
		// Achtung: Die im Funktionsrumpf getesteten Variablen duerfen nach
		//          dem Rumpf (also z.B. in Vorbereitung eines weiteren Tests)
		//          nicht mehr veraendert werden, sind also aus Sicht des Tests
		//          konstant. Andernfalls wird ein Fehler bei der Kompilation erzeugt.
		// Allgemeine Dokumentation:
		// https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html#assertThrows-java.lang.Class-org.junit.jupiter.api.function.Executable-java.lang.String-
		assertThrows(ArrayIndexOutOfBoundsException.class, 
				() -> { 
					i[3] = 5;
					}, 
				"Zugriff ausserhalb der Feldgrenzen wird nicht gemeldet.");
		
	}

}