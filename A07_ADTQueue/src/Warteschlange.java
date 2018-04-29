/**
 *  Beispielhafte Realisierung des ADT Queue.
 *  Die Implementierung nutzt zwei Stapel.
 */
public class Warteschlange<T> implements ADTQueue<T> {
	
	// Erzeugt jeweils einen Stapel dessen oberstes Element später das erste bzw. das letzte Element der Warteschlange ist.
	private Stapel<T> upperfirstofqueue = new Stapel<T>();
	private Stapel<T> upperlastofqueue = new Stapel<T>();

	public Warteschlange() {
		
	}
	
	/**
	 * Legt die Elemente des from-Stapels in umgekehrter Reihenfolge auf den to-Stapel.
	 * @param from Der Stapel der umgeschichtet werden soll.
	 * @param to Der Zielstapel des Umschichtens.
	 * @throws IllegalStateException falls der Zielstapel (to) nicht leer ist.
	 */
	private void restack(Stapel<T> from, Stapel<T> to) throws IllegalStateException {
		if (!to.isEmpty() && !from.isEmpty()) {
			throw new IllegalStateException("Umschichten fehlgeschlagen, da Zielstapel nicht leer.");
		}
		else {
			while (!from.isEmpty()) {
				to.push(from.top());
				from.pop();
			}
		}
	}
	
    /**
     *  &Uuml;berpr&uuml;ft, ob die Warteschlange leer ist.
     */
    public boolean isEmpty() {
    	if (upperfirstofqueue.isEmpty() && upperlastofqueue.isEmpty()) {
    		return true;
    	}
    	else return false;
    }

    /**
     *  Ein Element wird hinten an die Warteschlange angef&uuml;gt.
     *  @param element Die anzuf&uuml;gende Objektreferenz.
     */
    public void enqueue(T element) {
    	this.restack(upperfirstofqueue, upperlastofqueue);
    	upperlastofqueue.push(element);
    }

    /**
     *  Liefert das vorderste Element - so vorhanden - zur&uuml;ck.
     *  @return Vorderstes Element (Objektreferenz)
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public T front() throws IllegalStateException {
    	if (this.isEmpty()) {
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else {
    		this.restack(upperlastofqueue, upperfirstofqueue);
    		return upperfirstofqueue.top();
    	}
    }

    /**
     *  Das erste Element der Warteschlange - so vorhanden - wird entfernt.
     *  @throws IllegalStateException falls die Warteschlange leer ist.
     */
    public void dequeue() throws IllegalStateException {
    	if (this.isEmpty()) {
    		throw new IllegalStateException("Warteschlange ist leer.");
    	}
    	else {
    		this.restack(upperlastofqueue, upperfirstofqueue);
    		upperfirstofqueue.pop();
    	}
    }
} 