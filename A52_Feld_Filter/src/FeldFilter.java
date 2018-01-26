/**
 * Klasse zur Realisierung verschiedener Filteroperationen
 * auf einem Feld.
 */
public class FeldFilter {
	// Attribute
	private int[] feld;
	
	// Konstruktor
	public FeldFilter(int [] intFeld) {
		this.feld = intFeld;
	}
	
	// Hilfsfunktionen
	/**
	 * Berechnet den minimalen Wert der im gegebenen Feld gespeichert ist.
	 * @return Minimaler im Feld gespeicherter Wert.
	 */
	private int getMin() {
		int currentMin = this.feld[0];
		for (int i = 0; i < this.feld.length; i++) {
			if (this.feld[i] < currentMin) {							// Falls der Wert des Feldes kleiner als der gespeicherte Wert ist, 
				currentMin = this.feld[i];								// so ueberschreibe ihn mit dem Wert des Feldes.
			}
		}
		return currentMin;
	}
	
	/**
	 * Berechnet den maximalen Wert der im gegebenen Feld gespeichert ist.
	 * @return Maximaler im Feld gespeicherter Wert.
	 */
	private int getMax() {
		int currentMax = this.feld[0];
		for (int i = 0; i < this.feld.length; i++) {
			if (this.feld[i] > currentMax) {							// Falls der Wert des Feldes groesser als der gespeicherte Wert ist,
				currentMax = this.feld[i];								// so ueberschreibe ihn mit dem Wert des Feldes.
			}
		}
		return currentMax;
	}

	// NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT
	/*
	 * Entfernt einen Eintrag aus einem Feld.
	 * @param inputFeld Feld aus dem ein Eintrag entfernt werden soll.
	 * @param feldIndex Eintrag der entfernt werden soll.
	 * @return Feld ohne den genannten Eintrag
	 */
/*
	private int[] entferneFeld(int[] inputFeld, int feldIndex) {
		int[] outputFeld = new int[inputFeld.length - 1];
		
		if (feldIndex < 0) {
			for (int i = 0; i < inputFeld.length; i++) {
				outputFeld[i] = inputFeld[i];
			}
		}
		for (int i = 0, j = 0; i < inputFeld.length; i++, j++) {
			outputFeld[j] = inputFeld[i];
			if (i == feldIndex) {
				j--;
			}
		}
		return outputFeld;
	}
//*/// NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT // NICHT BENOETIGT
	
	
	/**
	 * Fuegt einem Feld einen Eintrag an.
	 * @param inputFeld Feld dem der Eintrag hinzugefuegt werden soll.
	 * @param eintrag Eintrag der hinzugefuegt werden soll.
	 * @return Feld mit dem genannten Eintrag.
	 */
	private int[] haengeFeldAn(int[] inputFeld, int eintrag) {
		int[] outputFeld = new int[inputFeld.length + 1];
		
		for (int i = 0; i < outputFeld.length; i++) {
			if (i == outputFeld.length - 1) {							// Falls es sich um das letzte Feld handelt, 
				outputFeld[i] = eintrag;								// schreibe dort den neuen Eintrag hinein.
			}
			else {
				outputFeld[i] = inputFeld[i];							// Falls es sich nicht um das letzt eFeld handelt, kopiere die alten Werte herueber.
			}
		}
		return outputFeld;
	}

	// Hauptfunktionen
	/**
	 * Gib ein Feld zur&uuml;ck, das nur die Werte aus
	 * dem gespeicherten Feld enth&auml;lt, die echt gr&ouml;&szlig;er
	 * als der &uuml;bergebene Wert sind. Die Reihenfolge der Werte
	 * darf dabei nicht ver&auml;ndert werden.
	 * @param untereSchranke Wert, der als untere Schranke gelten soll.
	 * @return Berechnetes Feld.
	 */
	public int[] filterGroesserAls(int untereSchranke) {
		int[] ausgabe = {}; // Default-Rueckgabe: Leeres Feld.
		
		for (int i = 0; i < this.feld.length; i++) {
			if (this.feld[i] > untereSchranke) {						// Falls der Wert des aktuellen Feldes groesser als die untere Schranke ist,
				ausgabe = this.haengeFeldAn(ausgabe, this.feld[i]);		// so haenge ihn an die Ausgabe an.
			}
		}
		return ausgabe;
	}

	/**
	 * Gib ein Feld zur&uuml;ck, das nur die Werte aus
	 * dem gespeicherten Feld enth&auml;lt, die weder mit
	 * dem minimalen noch mit dem maximalen Element &uuml;bereinstimmen. 
	 * Die Reihenfolge der Werte darf dabei nicht ver&auml;ndert werden.
	 * @return Berechnetes Feld.
	 */
	public int[] eliminiereMinMax() {
		int[] ausgabe = {}; // Default-Rueckgabe: Leeres Feld.
		
		if (this.feld.length > 0) {
		
			int min = getMin();
			int max = getMax();
		
			for (int i = 0; i < this.feld.length; i++) {
				if (this.feld[i] != min && this.feld[i] != max) {			// Sofern der Wert des aktuellen Feldes weder ein Minimum, noch ein Maximum darstellt, 
					ausgabe = this.haengeFeldAn(ausgabe, this.feld[i]);		// haenge ihn an die Ausgabe an.
				}
			}
		}
		else (error "Feld hat Laenge 0");

		return ausgabe;
	}

}
