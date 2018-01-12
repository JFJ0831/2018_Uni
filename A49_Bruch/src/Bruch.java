/**
 * Klasse zur Repr&auml;sentation eines gek&uuml;rzten Dezimalbruchs. 
 */
public class Bruch {

	/*
	 * Hier Attributvereinbarungen ergaenzen.
	 */
	private int zaehler;
	private int nenner;

	/*
	 * Hier Konstruktoren ergaenzen.
	 */
	public Bruch() {
		zaehler = 1;
		nenner = 1;
	}
	
	public Bruch(int zaehler) {
		this.zaehler = zaehler;
		nenner = 1;
	}
	
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
	public int getZaehler(Bruch b) {
		return zaehler;
	}
	
	/**
	 * Gibt den Nenner des Bruchs zurueck.
	 * @return Nenner
	 */
	public int getNenner(Bruch b) {
		return nenner;
	}
	
	public Bruch kuerze(Bruch Buk) {
		Bruch Bk = new Bruch();
		return Bk; 
	}
	
	public Bruch erweitere(Bruch Bne) {
		Bruch Be = new Bruch();
		return Be;
	}
	
	/**
	 * Setzt den Zaehler des Bruchs und k&uuml;rzt dann ggfs.
	 * @param Zaehler Der neue Zaehler des Bruchs.
	 */
	public void setZaehler(int zaehler) {
		this.zaehler = zaehler;
	}
	
	/**
	 * Setzt den Nenner des Bruchs und k&uuml;rzt dann ggfs.
	 * @param Nenner Der neue Nenner des Bruchs.
	 */
	public void setNenner(int nenner) {
		if (nenner == 0) {
			throw new IllegalArgumentException("Nenner muss von Null verschieden sein.");
		}
		this.nenner = nenner;
		if (this.nenner > this.zaehler) {
			kuerze(this.zaehler, this.nenner);
		}
	}
	
	public Bruch addiere(Bruch b1, Bruch b2) {
		
		Bruch b3 = new Bruch();
		return b3;
	}
	
	public Bruch multipliziere() {
		
	}
	
	public Bruch subtrahiere() {
		
	}
	
	public Bruch dividiere() {
		
	}

	
	

}
