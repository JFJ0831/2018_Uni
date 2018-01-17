/**
 * Repr&auml;sentation eines Tic-Tac-Toe-Spielbretts.
 */
public class TicTacToeBrett {

	/**
	 * Seitenl&auml;nge eines Tic-Tac-Toe-Spielbretts.
	 */
	public static final int seitenLaenge = 3;

	private TicTacToeMarke[][] markierungen;

	/**
	 * Erzeugt ein leeres Tic-Tac-Toe-Brett.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Erzeugt ein Tic-Tac-Toe-Brett aus einem gegebenen Feld.
	 * Das Feld muss die Gr&ouml;sse 3x3 haben, ansonsten wird
	 * eine Fehlermeldung ausgel&ouml;st.
	 * @param markierungen Das Spielfeld.
	 */
	// Hier Programmtext ergaenzen.
	
	/**
	 * Gibt die Seitenl&auml;nge des Spielbretts an.
	 * @return Seitenl&auml;nge des Spielbretts.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Getter f&uuml;r die Marke an einer anzugebenden Adresse.
	 * @param x Spalten-Koordinate.
	 * @param y Zeilen-Koordinate.
	 * @return Marke des Bretts an der gegebenen Adresse.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Setzt eine Markierung f&uuml;r das &uuml;ber die Koordinaten angegebene Feld.
	 * @param x Horizontale Koordinate v. l. n. r., beginnend bei 0.
	 * @param y Vertikale Koordinate v. o. n. u., beginnend bei 0.
	 * @param marke Die Markierung, die auf das Feld gesetzt werden soll.
	 */
	// Hier Programmtext ergaenzen.

	/**
	 * Testet, ob das Brett eine Gewinnposition enth&auml;lt
	 * und gibt das Symbol des Gewinners zur&uuml;ck. Falls beide Spieler
	 * Gewinnpositionen haben, soll das Symbol des ersten Spielers (X)
	 * zur&uuml;ckgegeben werden. 
	 * @return Wert des Gewinners. Wenn es keinen gibt, <CODE>null</CODE>.
	 */
	// Hier Programmtext ergaenzen.


	// Die nachfolgenden Methoden dienen dem Testen bzw. der Fehlersuche
	// und sind daher schon ausprogrammiert.
	
	/**
	 * Pr&uuml;ft, ob zwei Bretter "gleich" sind.
	 * Dies ist der Fall, wenn die Spielfelder gleich markiert sind.
	 * @param b Das andere Brett.
	 * @return Wahr genau dann, wenn die zwei Felder "gleich" sind.
	 */
	@Override
	public boolean equals(Object b) {

		// Gar kein Brett: dann nicht "gleich"
		if (! (b instanceof TicTacToeBrett)) {
			return false;
		}

		// Typumwandlung sicher
		TicTacToeBrett brett = (TicTacToeBrett) b;

		// Vergleiche einzeln
		for (int y = 0; y < brett.getSeitenLaenge(); y++) {
			for (int x = 0; x < brett.getSeitenLaenge(); x++) {
				if (brett.getFeld(x, y) != getFeld(x, y)) { // null-sicher!
					return false;
				}
			}
		}

		// Dann müssen sie gleich sein!
		return true;
	}

	/**
	 * Erzeugt eine String-Repr&auml;sentation des Feldes.
	 */
	@Override
	public String toString() {
		String output = "Spielfeld:\n";

		// Iteriere über alle Zeilen
		for (int y = 0; y < markierungen.length; y++) {

			// Iteriere über alle Spalten
			for (int x = 0; x < markierungen.length; x++) {
				TicTacToeMarke m = markierungen[y][x];
				if (m == null) {
					output += " ";
				}
				else {
					output += m;
				}
			}

			// Zeile fertig
			output += "\n";
		}

		// Fertig
		return output;
	}
}
