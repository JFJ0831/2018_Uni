import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


public class DoppelwarteschlangeTest {

	@Test
	public void testFront() {

		// Erzeuge Warteschlange zum Testen.
		Doppelwarteschlange<Integer> w = new Doppelwarteschlange<Integer>();
		
		assertEquals("Warteschlange wird nicht als leer erkannt.", true, w.isEmpty());
		
		w.frontEnqueue(0);
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.front());
		assertEquals("Das hinterste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.back());
		
		w.frontEnqueue(1000);
		w.frontEnqueue(2147483647);
		w.frontEnqueue(1);
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 1, w.front());
		assertEquals("Das hinterste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.back());
		
		w.frontDequeue();
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 2147483647, w.front());
		assertEquals("Das hinterste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.back());
		
		w.frontDequeue();
		w.frontDequeue();
		w.frontDequeue();
		
		assertEquals("Warteschlange wird nicht als leer erkannt.", true, w.isEmpty());

	}
	
	@Test
	public void testBack() {

		// Erzeuge Warteschlange zum Testen.
		Doppelwarteschlange<Integer> w = new Doppelwarteschlange<Integer>();
		
		assertEquals("Warteschlange wird nicht als leer erkannt.", true, w.isEmpty());
		
		w.backEnqueue(0);
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das hinterste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.back());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.front());
		
		w.backEnqueue(1000);
		w.backEnqueue(2147483647);
		w.backEnqueue(1);
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das hinterste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 1, w.back());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.front());
		
		w.backDequeue();
		
		assertEquals("Warteschlange wird als leer erkannt.", false, w.isEmpty());
		assertEquals("Das hinterste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 2147483647, w.back());
		assertEquals("Das vorderste Element der Warteschlange wird nicht korekkt erkannt.", (Integer) 0, w.front());
		
		w.backDequeue();
		w.backDequeue();
		w.backDequeue();
		
		assertEquals("Warteschlange wird nicht als leer erkannt.", true, w.isEmpty());

	}

	@Test
	public void testException() {
		
		// Erzeuge Warteschlange zum Testen.
		Doppelwarteschlange<Integer> w = new Doppelwarteschlange<Integer>();
		
		assertThrows(IllegalStateException.class, () -> { w.front(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der front()-Methode.");
		
		assertThrows(IllegalStateException.class, () -> { w.frontDequeue(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der frontDequeue()-Methode.");
		
		assertThrows(IllegalStateException.class, () -> { w.back(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der back()-Methode.");
		
		assertThrows(IllegalStateException.class, () -> { w.backDequeue(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der backDequeue()-Methode.");
		
	}

}