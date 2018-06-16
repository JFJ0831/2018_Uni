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
    	insertionsort(a, a.length);
    }    
    
    static private <T extends Comparable<T>> void insertionsort(T[] a, int l) {
    	
    	if (l <= 1) {
    		return;
    	}
    	
    	insertionsort(a, l - 1);
    	/*
    	int i = l;
    	while (a[i].compareTo(a[i-1]) <= 0) {
    		swapStable(a, i, i-1);
    		i--;
    	}
    	*/
    	for (int i = l; (a[i].compareTo(a[i-1]) > 0); i--) {
    		swapStable(a, i, i-1);
    	}
    	// Programmtext hier ergaenzen.
      }    
	
    /**
     *  Sortiere ein gegebenes Feld stabil mit Hilfe des Selection Sort-Verfahrens.
     *  Diese Implementierung ersetzt die &auml;u&szlig;e Schleife durch Rekursion.
     *  @param a Zu sortierendes Feld.
     */
    static public <T extends Comparable<T>> void selectionsort(T[] a) {
	  // Programmtext hier ergaenzen.
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