import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


public class WarteschlangeTest {

	@Test
	public void test() {

		// Erzeuge Warteschlange zum Testen.
		Warteschlange<Integer> w = new Warteschlange<Integer>();
		
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
	public void testException() {
		
		// Erzeuge Warteschlange zum Testen.
		Warteschlange<Integer> w = new Warteschlange<Integer>();
		
		assertThrows(IllegalStateException.class, () -> { w.front(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der front()-Methode.");
		
		assertThrows(IllegalStateException.class, () -> { w.dequeue(); }, "Leere Warteschlange wirft keinen Fehler bei Anwendung der dequeue()-Methode.");
		
	}

}