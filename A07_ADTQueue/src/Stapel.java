/**
 *  Beispielhafte Realisierung des ADT Stack.
 *  Die Implementierung greift auf die Klasse
 *  <code>java.util.LinkedList<T></code> zur&uuml;ck.
 */
public class Stapel<T> implements ADTStack<T> {

    //  Assoziiertes Listen-Objekt zur Speicherung der Daten.
    private java.util.LinkedList<T> daten;  //  An Stelle der Klasse Liste<T>

    /**
     *  Default-Konstruktor.
     *  Das <code>data</code>-Attribut wird als
     *  leere Liste initialisiert.
     */
	 public Stapel() {
	 //  Erzeuge eine leere Liste zur Speicherung der Elemente.
	 daten = new java.util.LinkedList<T>();
     }

    @Override
    public boolean isEmpty() {
	// Leite die Anfrage direkt an die Liste weiter.
	return daten.isEmpty();
    }

    @Override
    public void push(T element) {
	//  Fuege das Element vorne an die Liste an.
	daten.add(0, element);
    }

    @Override
    public T top() throws IllegalStateException {
	if (isEmpty()) {
	    throw new IllegalStateException("Stapel ist leer.");
	}

	//  Greife auf das erste Listenelement zu.
	return daten.getFirst();
    }

    @Override
    public void pop() throws IllegalStateException {
	if (isEmpty()) {
	    throw new IllegalStateException("Stapel ist leer.");
	}

	//  Entferne das erste Listenelement.
	daten.remove(0);
    }
	

} 