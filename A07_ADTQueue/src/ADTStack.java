/**
 *  Schnittstelle f&uuml;r Realisierungen des ADT Stack.
 */
public interface ADTStack<T> {

    /**
     *  &Uuml;berpr&uuml;ft, ob der Stapel leer ist.
     */
    public boolean isEmpty();

    /**
     *  Ein Element wird auf den Stapel gelegt.
     *  @param element Die auf den Stapel zu legende Objektreferenz.
     */
    public void push(T element);

    /**
     *  Liefert das oberste Element - so vorhanden - zur&uuml;ck.
     *  @return Oberstes Element (Objektreferenz)
     *  @throws IllegalStateException falls der Stapel leer ist.
     */
    public T top() throws IllegalStateException;

    /**
     *  Das oberste Element des Stapels - so vorhanden - wird entfernt.
     *  @throws IllegalStateException falls der Stapel leer ist.
     */
    public void pop() throws IllegalStateException;

}