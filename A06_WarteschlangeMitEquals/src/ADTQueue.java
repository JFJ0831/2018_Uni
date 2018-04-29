/**
 *  Schnittstelle f&uuml;r Realisierungen des ADT Queue.
 */
public interface ADTQueue<T> {

    /**
     *  &Uuml;berpr&uuml;ft, ob die Warteschlange leer ist.
     */
    public boolean isEmpty();

    /**
     *  Ein Element wird hinten an die Warteschlange angef&uuml;gt.
     *  @param element Die anzuf&uuml;gende Objektreferenz.
     */
    public void enqueue(T element);

    /**
     *  Liefert das vorderste Element - so vorhanden - zur&uuml;ck.
     *  @return Vorderstes Element (Objektreferenz)
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public T front() throws IllegalStateException;

    /**
     *  Das erste Element der Warteschlange - so vorhanden - wird entfernt.
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public void dequeue() throws IllegalStateException;

}