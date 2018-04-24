/**
 * Aufgabe 46
 * @author Julius Joha
 * @version 1.0
 */
public class ICE {
	
	private short zugnummer;
	private String zielbahnhof;
	private int geschwindigkeit;
	
	/**
	 * Konstruktor eines ICE
	 * @param initZugnummer Zugnummer die der Zug haben soll.
	 * @param initZielbahnhof Zielbahnhof die der Zug haben soll.
	 */
	public ICE(short initZugnummer, String initZielbahnhof) {
		
		zugnummer = initZugnummer;
		zielbahnhof = initZielbahnhof;
		geschwindigkeit = 0;
	}
	
	/**
	 * Gibt die Zugnummer des Zuges zurueck.
	 * @return zugnummer
	 */
	public short getZugnummer() {
		return zugnummer;
	}
	
	/**
	 * Gibt den Zielbahnhof des Zuges zurueck.
	 * @return zielbahnhof
	 */
	public String getZielbahnhof() {
		return zielbahnhof;
	}
	
	/**
	 * Gibt die Geschwindigkeit des Zuges zurueck.
	 * @return geschwindigkeit 
	 */
	public int getGeschwindigkeit() {
		return geschwindigkeit;
	}
	
	/**
	 * Erhoeht die Geschwindigkeit des Zuges um 15.
	 */
	public void beschleunige() {
		geschwindigkeit = geschwindigkeit + 15;
	}
	
	/**
	 * Reduziert die Geschwindikeit des Zuges um 20.
	 */
	public void bremseAb() {
		geschwindigkeit = geschwindigkeit - 20;
	}
}
