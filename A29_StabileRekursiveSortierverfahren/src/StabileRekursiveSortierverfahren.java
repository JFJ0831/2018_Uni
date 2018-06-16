/**
 * Realisierung einfacher Sortierverfahrens.
 */
public class StabileRekursiveSortierverfahren {

    /**
     * Sortiere ein gegebenes Feld stabil mit Hilfe des Insertion Sort-Verfahrens.
     * Diese Implementierung ersetzt die &auml;u&szlig;e Schleife durch Rekursion.
     * @param a Zu sortierendes Feld.
     */
    static public <T extends Comparable<T>> void insertionsort(T[] a) {
    	if ((a == null) || (a.length == 0)) {
    		throw new IllegalArgumentException("Leeres Feld kann nich sortiert werden.");
    	}
    	insertionsort(a, a.length-1);
    }    
    
    /**
     * Methode, welche die bestehende insertionsort-Methode um einen weiteren Parameter erweitert 
     * und somit eine rekursive insertionsort-Methode ermoeglicht. 
     * @param a Zu sortierendes Feld.
     * @param end Index bis zu welchem in diesem Methodenaufruf das Feld sortiert werden soll.  
     */
    static private <T extends Comparable<T>> void insertionsort(T[] a, int end) {
    	// Falls das Feld nur eine Laenge von 1 hat, so ist es bereits sortiert.
    	if (end <= 0) { return; }
    	// Methode rekursiv aufrufen, wobei der betrachtete Feldteil um eins verkleinert wird.
    	insertionsort(a, end - 1);
    	// For-Schleife, welche das Element an der Stelle i solange weiter vorne in das Feld verschiebt, bis es nicht mehr kleiner als das Element an der Stelle i-1 ist.
    	for (int i = end; ((i >= 1) && (a[i].compareTo(a[i-1]) < 0)); i--) {
    		swapStable(a, i-1, i);
    	}
      }    
	
    /**
     * Sortiere ein gegebenes Feld stabil mit Hilfe des Selection Sort-Verfahrens.
     * Diese Implementierung ersetzt die &auml;u&szlig;e Schleife durch Rekursion.
     * @param a Zu sortierendes Feld.
     */
    static public <T extends Comparable<T>> void selectionsort(T[] a) {
    	if ((a == null) || (a.length == 0)) {
    		throw new IllegalArgumentException("Leeres Feld kann nich sortiert werden.");
    	}
    	selectionsort(a, 0);
    }
    
    /**
     * Methode, welche die bestehende selectionsort-Methode um einen weiteren Parameter erweitert 
     * und somit eine rekursive selectionsort-Methode ermoeglicht.
     * @param a Zu sortierendes Feld.
     * @param start Index des Beginns des Feldteils, welcher nach dem niedrigsten Element durchsucht werden muss und noch nicht sortiert ist.
     */
    static private <T extends Comparable<T>> void selectionsort(T[] a, int start) {
    	// Es wird angenommen, dass das kleinste Element im Teilfeld an der vordersten Stelle des Teilfeldes steht.
    	int minIndex = start;
    	// Falls das Feld nur eine Laenge von 1 hat, so ist es bereits sortiert. 
    	if (start == a.length - 1) { return; }
    	// For-Schleife, welche den Index des kleinsten Elements im Teilfeld ab start bestimmt.
    	for (int i = start; i <= a.length-1; i++) {
    		if ((a[i].compareTo(a[minIndex])) < 0) {
    			minIndex = i;
    		}
    	}
    	// Tausch des kleinsten Elements im betrachteten Teilfeld mit dem Element an der Stelle start.
    	swapStable(a, start, minIndex);
    	// Methode rekursiv aufrufen, wobei der Beginn des betrachteten Teilfeldes um eins nach rechts verschoben wird.
    	selectionsort(a, start + 1);
    }
	
	/**
	 *  Vertausche in einem gegebenen Feld die Eintraege an
	 *  den beiden gegebenen Stellen a[indexA] und a[indexB],
	 *  wobei indexA <= indexB ist.
	 *  @param a Eingabefeld
	 *  @param indexA Index des ersten zu tauschenden Elements.
	 *  @param indexB Index des zweiten zu tauschenden Elements.
	 */
	static public <T> void swapStable(T[] a, int indexA, int indexB) {
		if (indexA > indexB) {
			throw new IllegalArgumentException("indexA darf nicht groesser als indexB sein.");
		}

		T temp  = a[indexB];
		for(int current = indexB-1; current >= indexA; current--) {
			a[current+1] = a[current];
		}
		a[indexA] = temp;


	}

}