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
	public TicTacToeBrett() {
		this.markierungen = new TicTacToeMarke[3][3];
		for (int i = 0; i < seitenLaenge; i++) {
			for (int j = 0; j < seitenLaenge; j++) {
				this.setFeld(i, j, null);
			}
		}
	}

	/**
	 * Erzeugt ein Tic-Tac-Toe-Brett aus einem gegebenen Feld.
	 * Das Feld muss die Gr&ouml;sse 3x3 haben, ansonsten wird
	 * eine Fehlermeldung ausgel&ouml;st.
	 * @param markierungen Das Spielfeld.
	 */
	public TicTacToeBrett(TicTacToeMarke[][] markierungen) {
		if (seitenLaenge != getSeitenLaenge())
			throw new IllegalArgumentException("Feld hat nicht die Groesse 3x3");
		this.markierungen = new TicTacToeMarke[3][3];
		for (int i = 0; i < this.getSeitenLaenge(); i++) {
			for (int j = 0; j < this.getSeitenLaenge(); j++) {
				this.setFeld(i, j, markierungen[i][j]);
			}
		}
			
	}

	/**
	 * Gibt die Seitenl&auml;nge des Spielbretts an.
	 * @return Seitenl&auml;nge des Spielbretts.
	 */
	int getSeitenLaenge() {
		return seitenLaenge;		// markierungen.length
	}

	/**
	 * Getter f&uuml;r die Marke an einer anzugebenden Adresse.
	 * @param x Spalten-Koordinate.
	 * @param y Zeilen-Koordinate.
	 * @return Marke des Bretts an der gegebenen Adresse.
	 */
	TicTacToeMarke getFeld(int x, int y) {
		return this.markierungen[x][y];
	}

	/**
	 * Setzt eine Markierung f&uuml;r das &uuml;ber die Koordinaten angegebene Feld.
	 * @param x Horizontale Koordinate v. l. n. r., beginnend bei 0.
	 * @param y Vertikale Koordinate v. o. n. u., beginnend bei 0.
	 * @param marke Die Markierung, die auf das Feld gesetzt werden soll.
	 */
	void setFeld(int x, int y, TicTacToeMarke marke) {
		if (marke != null) {
		this.markierungen[x][y] = marke;
		}
	}

	/**
	 * Testet, ob das Brett eine Gewinnposition enth&auml;lt
	 * und gibt das Symbol des Gewinners zur&uuml;ck. Falls beide Spieler
	 * Gewinnpositionen haben, soll das Symbol des ersten Spielers (X)
	 * zur&uuml;ckgegeben werden. 
	 * @return Wert des Gewinners. Wenn es keinen gibt, <CODE>null</CODE>.
	 */
	TicTacToeMarke enthaeltGewinnposition() {
		// Initialisierung Rueckgabe
		TicTacToeMarke marke = null;
		// Vertikal
		for (int i = 0; i < seitenLaenge; i++) {
			if (this.getFeld(i, 0) == this.getFeld(i, 1) && this.getFeld(i, 0) == this.getFeld(i, 2))
				marke = this.getFeld(i, 0);
		}
		// Horizontal
		for (int i = 0; i < seitenLaenge; i++) {
			if (this.getFeld(0, i) == this.getFeld(1, i) && this.getFeld(0, i) == this.getFeld(2, i))
				marke = this.getFeld(0, i);
		}
		// Diagonal 1
		if (this.getFeld(0, 0) == this.getFeld(1, 1) && this.getFeld(0, 0) == this.getFeld(2, 2)) {
			marke = this.getFeld(0, 0);
		}
		// Diagonal 2
		if (this.getFeld(0, 2) == this.getFeld(1, 1) && this.getFeld(0, 2) == this.getFeld(2, 0)) {
			marke = this.getFeld(0, 2);
		}
		
		return marke;
	}



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
		for (int x = 0; x < markierungen.length; x++) {

			// Iteriere über alle Spalten
			for (int y = 0; y < markierungen.length; y++) {
				TicTacToeMarke m = markierungen[x][y];
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
