/**
 * Schnittstelle für Realisierung des ADT Deque.
 * @author Julius Joha
 *
 * @param <T>
 */
public interface ADTDeque<T> {
	
	/**
	 * Überprüft ob die Doppelwarteschlange leer ist.
	 * @return true, falls Doppelwarteschlange leer ist, sonst false.
	 */
	public boolean isEmpty();
	
	/**
	 * Ein Element wird vorne an die Doppelwarteschlange angefügt.
	 */
	public void frontEnqueue();
	
	/**
	 * Ein Element wird hinten an die Doppelwarteschlange angefügt.
	 */
	public void backEnqueue();
	
	/**
	 * Liefert das vorderste Element - so vorhanden - zurück.
	 * @return Vorderstes Element
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public T front() throws IllegalStateException;
	
	/**
	 * Liefert das hinterste Element - so vorhanden - zurück.
	 * @return Hinterstes Element
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public T back() throws IllegalStateException;
	
	/**
	 * Das erste Element der Doppelwarteschlange - so vorhanden - wird entfernt.
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public void frontDequeue() throws IllegalStateException;
	
	/**
	 * Das letzte Element der Doppelwarteschlange - so vorhanden - wird entfernt.
	 * @throws IllegalStateException falls die Warteschlange leer ist.
	 */
	public void backDequeue() throws IllegalStateException;
}
