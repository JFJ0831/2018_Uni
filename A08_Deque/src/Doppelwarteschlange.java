/**
 * Beispielhafte Realisierung des ADT Deque.
 *
 * @param <T>
 */
public class Doppelwarteschlange<T> implements ADTDeque<T> {
	
	 //  Liste zur Speicherung der Daten.
	private java.util.LinkedList<T> data;
	
	/**
     *  Default-Konstruktor.
     *  Erzeuge leere Liste zur Speicherung der Elemente.
     */
	public Doppelwarteschlange() {
		data = new java.util.LinkedList<T>();
	}

	/**
	 * Überprüft ob die Doppelwarteschlange leer ist.
	 * @return true, falls Doppelwarteschlange leer ist, sonst false.
	 */
	public boolean isEmpty() {
		return data.isEmpty();
	}

	/**
	 * Ein Element wird vorne an die Doppelwarteschlange angefügt.
	 * @param element Die anzufügende Objektreferenz.
	 */
	public void frontEnqueue(T element) {
		data.addFirst(element);
	}

	/**
	 * Ein Element wird hinten an die Doppelwarteschlange angefügt.
	 * @param element Die anzufügende Objektreferenz.
	 */
	public void backEnqueue(T element) {
		data.addLast(element);
	}

	/**
	 * Liefert das vorderste Element - so vorhanden - zurück.
	 * @return Vorderstes Element
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public T front() throws IllegalStateException {
		if (this.isEmpty()) {
			throw new IllegalStateException("Doppelwarteschlange ist leer.");
		}
		else {
			return data.getFirst();
		}
	}

	/**
	 * Liefert das hinterste Element - so vorhanden - zurück.
	 * @return Hinterstes Element
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public T back() throws IllegalStateException {
		if (this.isEmpty()) {
			throw new IllegalStateException("Doppelwarteschlange ist leer.");
		}
		else {
			return data.getLast();
		}
	}

	/**
	 * Das erste Element der Doppelwarteschlange - so vorhanden - wird entfernt.
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public void frontDequeue() throws IllegalStateException {
		if (this.isEmpty()) {
			throw new IllegalStateException("Doppelwarteschlange ist leer.");
		}
		else {
			data.removeFirst();
		}
	}
	
	/**
	 * Das letzte Element der Doppelwarteschlange - so vorhanden - wird entfernt.
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public void backDequeue() throws IllegalStateException {
		if (this.isEmpty()) {
			throw new IllegalStateException("Doppelwarteschlange ist leer.");
		}
		else {
			data.removeLast();
		}
	}

}
