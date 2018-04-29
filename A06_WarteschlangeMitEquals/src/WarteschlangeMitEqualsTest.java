import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Test;

/** Beispiele zu Assertions in JUnit 5
 * @see https://junit.org/junit5/docs/5.0.1/api/org/junit/jupiter/api/Assertions.html
 */
public class WarteschlangeMitEqualsTest {

	@Test
	public void testStandartMethods() {

		// Erzeuge Warteschlange zum Testen.
		WarteschlangeMitEquals<Integer> w = new WarteschlangeMitEquals<Integer>();
		
		
		assertEquals("Warteschlange wird nicht als leer erkannt.", true, w.isEmpty());
		
		w.enqueue(0);
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.front());
		
		w.enqueue(2147483647);
		w.enqueue(1000);
		w.enqueue(1);
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.front());
		
		w.dequeue();
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 2147483647, w.front());
		
		w.dequeue();
		w.dequeue();
		w.dequeue();
		
		assertEquals("Warteschlange wird nicht als leer erkannt.", true, w.isEmpty());

	}
	
	@Test
	public void testEquals() {

		// Erzeuge Warteschlangen zum Testen.
		WarteschlangeMitEquals<Integer> wme1 = new WarteschlangeMitEquals<Integer>();
		WarteschlangeMitEquals<Integer> wme2 = new WarteschlangeMitEquals<Integer>();
		WarteschlangeMitEquals<Integer> wme3 = new WarteschlangeMitEquals<Integer>();
		WarteschlangeMitEquals<Integer> wme4 = new WarteschlangeMitEquals<Integer>();
		WarteschlangeMitEquals<Integer> wme5 = new WarteschlangeMitEquals<Integer>();
		WarteschlangeMitEquals<Integer> wme6 = new WarteschlangeMitEquals<Integer>();
		
		// Modifiziere Warteschlangen zum Testen.
		// WME1
		wme1.enqueue(0);
		wme1.enqueue(99);
		wme1.enqueue(600);
		wme1.enqueue(30);
		wme1.enqueue(4567);
		wme1.enqueue(97421);
		// WME2
		wme2.enqueue(0);
		wme2.enqueue(99);
		wme2.enqueue(600);
		wme2.enqueue(30);
		wme2.enqueue(4567);
		wme2.enqueue(97421);
		// WME3
		wme3.enqueue(0);
		wme3.enqueue(99);
		wme3.enqueue(600);
		wme3.enqueue(30);
		wme3.enqueue(4567);
		// WME4
		wme4.enqueue(0);
		wme4.enqueue(99);
		wme4.enqueue(4567);
		wme4.enqueue(568932);
		wme4.enqueue(345);
		wme4.enqueue(9876);
		// WME5
		wme5.enqueue(3);
		wme5.dequeue();
		
		// Testen
		assertEquals("Warteschlangen werden nicht als identisch erkannt", true, wme1.equals(wme2));
		
		assertEquals("Warteschlangen werden als identisch erkannt", false, wme1.equals(wme3));
		
		assertEquals("Warteschlangen werden als identisch erkannt", false, wme4.equals(wme3));
		
		assertEquals("Leere Warteschlangen werden nicht als identisch erkannt", true, wme5.equals(wme6));
		
		assertEquals("Warteschlange wird als identisch mit null erkannt", false, wme1.equals(null));
		
		assertEquals("Warteschlange wird als identisch mit leerer Warteschlange erkannt", false, wme1.equals(wme6));
		
	}


	@Test
	public void testException() {
		
		// Erzeuge Warteschlange zum Testen.
		WarteschlangeMitEquals<Integer> w = new WarteschlangeMitEquals<Integer>();
		
		assertThrows(IllegalStateException.class, () -> { w.front(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der front()-Methode.");
		
		assertThrows(IllegalStateException.class, () -> { w.dequeue(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der dequeue()-Methode.");
		
	}
				
	

}