/**
 * Realisierung einfacher Sortierverfahrens.
 */
public class StabileRekursiveSortierverfahren {

    /**
     *  Sortiere ein gegebenes Feld stabil mit Hilfe des Insertion Sort-Verfahrens.
     *  Diese Implementierung ersetzt die &auml;u&szlig;e Schleife durch Rekursion.
    *  @param a Zu sortierendes Feld.
     */
    static public <T extends Comparable<T>> void insertionsort(T[] a) {
    	if ((a == null) || (a.length == 0)) {
    		throw new IllegalArgumentException("Leeres Feld kann nich sortiert werden.");
    	}
    	insertionsort(a, a.length);
    }    
    
    static private <T extends Comparable<T>> void insertionsort(T[] a, int end) {
    	
    	if (end <= 1) { return; }
    	
    	insertionsort(a, end - 1);

    	for (int i = end-1; ((i >= 1) && (a[i].compareTo(a[i-1]) < 0)); i--) {
    		swapStable(a, i-1, i);
    	}
      }    
	
    /**
     *  Sortiere ein gegebenes Feld stabil mit Hilfe des Selection Sort-Verfahrens.
     *  Diese Implementierung ersetzt die &auml;u&szlig;e Schleife durch Rekursion.
     *  @param a Zu sortierendes Feld.
     */
    static public <T extends Comparable<T>> void selectionsort(T[] a) {
    	if ((a == null) || (a.length == 0)) {
    		throw new IllegalArgumentException("Leeres Feld kann nich sortiert werden.");
    	}
    	selectionsort(a, 0);
    }
    
    static private <T extends Comparable<T>> void selectionsort(T[] a, int start) {
    	
    	if (start == a.length - 1) { return; }
    	
    	int minIndex = start;
    	
    	for (int i = start; i <= a.length-1; i++) {
    		if ((a[i].compareTo(a[minIndex])) < 0) {
    			minIndex = i;
    		}
    	}
    	
    	swapStable(a, start, minIndex);
    	
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