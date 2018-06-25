/**
 *  L&ouml;sung zu Aufgabe 33 (Sommersemester 2018)
 */
public class ZahlenAnalyse {

	/**
	 * Untersuche, ob im &uuml;bergebenen Feld mehr 
	 * echt positive oder echt negative Werte enthalten sind.
	 * @param a Feld mit zu untersuchenden Werten.
	 * @return -1, falls mehr echt negative Werte enthalten sind,
	 *          1, falls mehr echt positive Werte enthalten sind,
	 *          0, falls gleich viele echt positive und echt
	 *             negative Werte enthalten sind.
	 */
	public static int balance(int[] a) {

		if (a == null) {
			throw new IllegalArgumentException("Uebergebene Referenz ist null.");
		}

		if (a.length == 0) {
			return 0;
		}

		// Sollte das Feld nur eine Laenge von 1 haben, so ist das einzige Element ausschlaggebend fuer die Rueckgabe.
		if (a.length == 1) {
			if (a[0] == 0) {
				return 0;
			}
			else if (a[0] < 0) {
				return -1;
			}
			else if (a[0] > 0) {
				return 1;
			}
		}

		// Initialisierung der Rueckgabevariabel.
		int negorpos = 0;
		
		/* Initialisierung der balance-Variable.
		 * Je positiver (negativer) die Variabel, desto mehr positive (negative) Elemente enthaelt das Feld a.
		 * Bei der Initialisierung wird die balance-Hilfsmethode zweimal aufgerufen und die Rueckgabewerte addiert.
		 * Der vordere methodenaufruf betrachtet nur die vordere Haelfte des Feldes, der hintere nur dei hintere Haelfte des Feldes.
		 * Demnach muessen diese Intervallgrenzen auch uebergeben werden.
		 */
		int balance = balance(a, 0, Math.floorDiv(a.length, 2) - 1) + balance(a, Math.floorDiv(a.length, 2), a.length - 1);
		
		if (balance < 0) {
			negorpos = -1;
		}
		else if (balance > 0) {
			negorpos = 1;
		}

		return negorpos;
	}

	/**
	 * Hilfsmethode, welche in einem Abschnitt eines Feldes ueberprueft, ob mehr negative oder positive Elemente vorkommen.
	 * @param a	Feld mit zu untersuchenden Elementen.
	 * @param b	Beginn des zu untersuchenden Intervalls.
	 * @param e	Ende des zu untersuchenden Intervalls.
	 * @return 	negativen Wert, falls mehr negative Elemente aufgetreten sind,
	 * 			0,				falls negative und positive Elemente in gleicher Haufigkeit aufgetreten sind,
	 * 			positiven Wert,	falls mehr positive Elemente aufgetreten sind.
	 */
	private static int balance(int[] a, int b, int e) {

		// Sollte b gleich e sein, also das betrachtete Intervall des Feldes nur eine Laenge von eins haben, so muss nur dieses Element b betrachtet fuer einen Rueckgabewert.
		if (b == e) {
			if (a[b] == 0) {
				return 0;
			}
			else if (a[b] < 0) {
				return -1;
			}
			else if (a[b] > 0) {
				return 1;
			}
		}

		// Berechnen der neuen Intervallgrenzen.
		int newE = (b + Math.floorDiv((e - b), 2));
		int newB = (b + Math.floorDiv((e - b), 2) + 1);

		// Rekursive Methodenaufrufe mit neuen Grenzen fuer die betrachteten Intervalle.
		return balance(a, b, newE) + balance(a, newB, e);

	}

}