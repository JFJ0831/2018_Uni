/**
 * Klasse zur Repr&auml;sentation eines gek&uuml;rzten Dezimalbruchs. 
 */
public class Bruch {

	/**
	 * Attribut welches den Zaehler des Bruchs angibt.
	 */
	private int zaehler;
	
	/**
	 * Attribut welches den Nenner des Bruchs angibt.
	 */
	private int nenner;

	/**
	 * Konstruktor ohne Argument. Bruch repraesentiert Wert 1.
	 */
	public Bruch() {
		zaehler = 1;
		nenner = 1;
	}
	/**
	 * Konstruktor mit einem ganzzahligen Argument zaehler.
	 * Der Bruch hat den selben Wert wie zaehler.
	 * @param zaehler Zaehler des Bruchs
	 */
	public Bruch(int zaehler) {
		this.zaehler = zaehler;
		this.nenner = 1;
	}
	
	/**
	 * Konstruktor mit zwei ganzzahligen Argumenten zaehler und nenner.
	 * Bruch repraesentiert den Wert zaehler/nenner.
	 * @param zaehler Zaehler des Bruchs
	 * @param nenner Nenner des Bruchs
	 */
	public Bruch(int zaehler, int nenner) {
		this.zaehler = zaehler;
		this.nenner = nenner;
		if (nenner == 0) {
			throw new IllegalArgumentException("Nenner muss von Null verschieden sein.");
		}
	}

	/**
	 * Gibt den Zaehler des Bruchs zurueck.
	 * @return Zaehler 
	 */
	public int getZaehler() {
		return zaehler;
	}
	
	/**
	 * Gibt den Nenner des Bruchs zurueck.
	 * @return Nenner
	 */
	public int getNenner() {
		return nenner;
	}
	
	/**
	 * Kuerzt den Bruch.
	 */
	public void kuerze() {
		int ggT = Math.abs(ggT(this.zaehler, this.nenner)); 	// Sorgt dafür, dass ggT immer positiv ist und somit nicht das Vorzeichen des Bruchs ändert.
		this.zaehler /= ggT;
		this.nenner /= ggT;
	}
	
	/**
	 * Berechnet den groessten gemeinsamen Teiler zweier Zahlen
	 * @param a Integer a
	 * @param b Integer b
	 * @return Groesster gemeinsamer Teiler
	 */
	public int ggT(int a, int b) {
		if (b == 0)
			return a;
		else
			return ggT(b, a%b);
	}
	
	/**
	 * Setzt den Zaehler des Bruchs und k&uuml;rzt dann ggfs.
	 * @param zaehler Der neue Zaehler des Bruchs.
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
		kuerze();
	}
	
	/**
	 * Setzt den Nenner des Bruchs und k&uuml;rzt dann ggfs.
	 * @param nenner Der neue Nenner des Bruchs.
	 */
	public void setNenner(int nenner) {
		if (nenner == 0) {
			throw new IllegalArgumentException("Nenner muss von Null verschieden sein.");
		}
		this.nenner = nenner;
		kuerze();
	}
	
	/**
	 * Addiert das aktuelle Bruchobjekt mit dem Uebergebenen. Gibt das Ergebnis als neuen Bruch zurueck.
	 * @param b2 Uebergebener Bruch
	 * @return b3 Ergebnis der Bruchaddition als neuer Bruch.
	 */
	public Bruch addiere(Bruch b2) {
		/*
		 * Z1   Z2   Z1*N2 + N1*Z2   Z3
		 * -- + -- = ------------- = --
		 * N1   N2       N1*N2       N3
		 */
		int newZaehler = this.zaehler * b2.nenner + this.nenner * b2.zaehler;
		int newNenner = this.nenner * b2.nenner;
		
		Bruch b3 = new Bruch(newZaehler, newNenner);
		b3.kuerze();
		return b3;
	}
	
	/**
	 * Multipliziert das aktuelle Bruchobjekt mit dem Uebergebenen. Gibt das Ergebnis als neuen Bruch zurueck.
	 * @param b2 Uebergebener Bruch
	 * @return b3 Ergebnis der Bruchmultiplikation als neuer Bruch.
	 */
	public Bruch multipliziere(Bruch b2) {
		/*
		 * Z1   Z2   Z1*Z2   Z3
		 * -- * -- = ----- = --
		 * N1   N2   N1*N2   N3
		 */
		Bruch b3 = new Bruch((this.zaehler * b2.zaehler), (this.nenner * b2.nenner));
		b3.kuerze();
		return b3;
	}
	
	/**
	 * Subtrahiert das uebergebene Bruchobjekt vom Aktuellen. Gibt das Ergebnis als neuen Bruch zurueck.
	 * @param b2 Uebergebener Bruch
	 * @return b3 Ergebnis der Bruchsubtraktion als neuer Bruch.
	 */
	public Bruch subtrahiere(Bruch b2) {
		/*
		 * Z1   Z2   Z1*N2 - N1*Z2   Z3
		 * -- - -- = ------------- = --
		 * N1   N2       N1*N2       N3
		 */
		int zaehler = this.zaehler * b2.nenner - this.nenner * b2.zaehler;
		int nenner = this.nenner * b2.nenner;
		
		Bruch b3 = new Bruch(zaehler, nenner);
		b3.kuerze();
		return b3;
	}
	
	/**
	 * Dividiert das aktuelle Bruchobjekt durch das Uebergebenen. Gibt das Ergebnis als neuen Bruch zurueck.
	 * Division mithilfe der Multiplikation mit dem Kehrwert des übergebenen Bruchobjekts.
	 * @param b2 Uebergebener Bruch
	 * @return b3 Ergebnis der Bruchdivision als neuer Bruch.
	 */
	public Bruch dividiere(Bruch b2) {
		Bruch b3 = new Bruch(b2.nenner, b2.zaehler); 		// Kehrwert des Bruchs
		return multipliziere(b3);
	}

	
	

}
