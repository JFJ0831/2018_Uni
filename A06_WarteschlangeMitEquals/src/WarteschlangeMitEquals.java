import java.util.Objects;

/**
 *  Beispielhafte Realisierung des ADT Queue, die um 'equals' erg&auml;nzt wird.
 *  Die Implementierung greift auf die Klasse
 *  <code>java.util.LinkedList<T></code> zur&uuml;ck.
 */
public class WarteschlangeMitEquals<T> implements ADTQueue<T> {

    //  Assoziierte Stapel-Objekte zur Speicherung der Daten.
    private java.util.LinkedList<T> data;

    /**
     *  Default-Konstruktor.
     *  Die Attribute werden als leere Stapel initialisiert.
     */
    public WarteschlangeMitEquals() {
	data = new java.util.LinkedList<T>();
    }

    @Override
    public boolean isEmpty() {
	// Die Warteschlange ist leer, die Liste keine Elemente enthaelt.
	return data.isEmpty();
    }

    @Override
    public void enqueue(T element) {
	// Fuege Element am Ende der Liste an.
	data.addLast(element);
    }

    @Override
    public T front() throws IllegalStateException {
	if (isEmpty()) {
	    throw new IllegalStateException("Warteschlange ist leer.");
	}
	// Liefere das erste Element der Liste zurueck.
	return data.getFirst();
    }

    @Override
    public void dequeue() throws IllegalStateException {
	if (isEmpty()) {
	    throw new IllegalStateException("Warteschlange ist leer.");
	}
	// Entferne das erste Element der Liste.
	data.removeFirst();
    }

    /**
     * 	Zwei Warteschlangen sind identisch, wenn sie entweder beide
     *  leer sind oder die gleichen Objekte in der gleichen Reihenfolge enthalten.
     *  @param w Zu vergleichende Warteschlange
     *  @return <code>true</code>, falls beide Warteschlangen leer sind 
     *  oder die durch <code>w</code> referenzierte Warteschlange die gleichen 
     *  Eintr&auml;ge wie dieser Warteschlange und zudem in der gleichen 
     *  Reihenfolge enth&auml;lt.
     */
    @SuppressWarnings("unchecked")  // Wird weiter unten erlauetert
    @Override
    public boolean equals(Object param) {
	
	// Sonderfall 1: Die null-Referenz wird uebergeben.
	if (param == null) {
	    return false;   // Keine Ausnahme ausloesen, vgl. java.lang.Object.equals.
	}

	// Stelle sicher, dass eine Referenz auf ein Objekt
	// der gleichen Klasse übergeben wird. 
	// An dieser Stelle werden keine(!) Template-Parameter
	// verglichen, so dass nur ueberprueft wird, ob
	// beide Objekte vom Type WarteschlangeMitEquals<?> 
	// sind (in Java-Notation steht hier das '?' fuer
	// einen nicht-bekannten Template-Parameter). Dies
	// ist unkritisch, da fuer den Fall, dass beide
	// Warteschlangen unterschiedliche Typen von
	// Referenzen verwalten, der Vergleich der einzelnen
	// referenzierten Elemente 'false' ergibt.
	if (! (param instanceof ADTQueue<?>)) {
	    return false;
	}
		
	// Auf Grund des obigen Vergleichs wissen wir(!) nun,
	// dass eine explizite Typumwandlung der uebergebenen
	// Referenz auf ADTQueue<Object> moeglich ist.
	// Da die JVM dies aber nicht weiss, sollten wir
	// ihr sagen, dass wir ihre Warnung an dieser Stelle
	// ignorieren moechten -> @SuppressWarning("unchecked")
	ADTQueue<Object> w = (ADTQueue<Object>)param;

	boolean resultat = false;
	
	// Hilfsvariablen zur späteren Rekonstruktion des Ursprungszustands.
	int i = 0;		// Zählt die identischen Elemente beider Warteschlangen.
	int k = 0;		// Zählt die Elemente die nur in der durch this referenzierten Warteschlange vorkommen.
	int m = 0;		// Zählt die Elemente die nur in der durch w referenzierten Warteschlange vorkommen.
	
	// Hilfswarteschlange zur Speicherung der identischen Elemente der zu vergleichenden Warteschlangen.
	WarteschlangeMitEquals<T> temp = new WarteschlangeMitEquals<T>();

	    /**
	     * Schleife die iterativ die vordersten Elemente zweier nicht leerer Warteschlangen vergleicht 
	     * und diese, falls sie identisch sind, von beiden Warteschlangen entfernt 
	     * und zur späteren Rekonstruktion der Warteschlangen an eine tempöräre Wartesschlange anhängt.
	     * Sollten die Elemente nicht identisch sein, so sind die Warteschlangen auch nicht identisch.
	     * Die Schleife wird dann abgebrochen.
	     */
		while (!this.isEmpty() && !w.isEmpty()) {
			if (Objects.equals(this.front(), w.front())) {
				temp.enqueue(this.front());
				this.dequeue();
				w.dequeue();
				i++;
			}
			else {
				resultat = false;
				break;
			}
		}
		
		// Falls die Warteschlangen unterschiedelicher Länge sind, so sind sie nicht identisch.
		if (this.isEmpty() && !w.isEmpty()) {
			resultat = false;
		}
		
		// Falls die Warteschlangen unterschiedelicher Länge sind, so sind sie nicht identisch.
		if (!this.isEmpty() && w.isEmpty()) {
			resultat = false;
		}
		
		//Falls die Warteschlangen beide leer sind, so sind sie identisch. Dieser Fall kann auch nach Durchlaufen der vorangegangenen Schleife eintreten.
		if (this.isEmpty() && w.isEmpty()) {
			resultat = true;
		}
		
		/**
		 * Ab hier wird der Ursprungzustand der beiden referenzierten Warteschlangen wieder hergestellt, sofern dieser überhaupt verändert wurde.
		 * Zu erkennen ist dies daran, ob die temp-Warteschlange leer ist, oder nicht. 
		 */
		if (!temp.isEmpty()) {
			
			/**
			 * Die folgenden Zeilen stellen den Ursprungszustand der durch this referenzierten Warteschlange her.
			 * Dazu wird mittels einer Schleife die gesamte durch this referenzierte (Rest-)Warteschlange an die temp-Warteschlange angehängt.
			 * Wenn this leer ist wird die gesamte in temp gespeicherte Warteschlange wieder an this gehängt, 
			 * wobei die Elemente, die mit der durch w referenzierten Warteschlange identisch waren, durch erneutes Anhängen an temp weiterhin gespeichert bleiben.
			 */
			while (!this.isEmpty()) {
				temp.enqueue(this.front());
				this.dequeue();
				k++;
			}
			if (this.isEmpty()) {
				for (int j=i; j>0; j--) {
					this.enqueue(temp.front());
					temp.enqueue(temp.front());
					temp.dequeue();
				}
				for (int l=k; l>0; l--) {
					this.enqueue(temp.front());
					temp.dequeue();
				}
			}
			
			/**
			 * Die folgenden Zeilen stellen den Ursprungszustand der durch w referenzierten Warteschlange her.
			 * Dazu wird mittels einer Schleife die gesamte durch w referenzierte (Rest-)Warteschlange an die temp-Warteschlange angehängt.
			 * Wenn this leer ist wird die gesamte in temp gespeicherte Warteschlange wieder an w gehängt.
			 */
			while (!w.isEmpty()) {
				temp.enqueue((T) w.front());
				w.dequeue();
				m++;
			}
			if (w.isEmpty()) {
				for (int j=i; j>0; j--) {
					w.enqueue(temp.front());
					temp.dequeue();
				}
				for (int n=m; n>0; n--) {
					w.enqueue(temp.front());
					temp.dequeue();
				}
			}
		}
	    
	    return resultat;
    }

} 