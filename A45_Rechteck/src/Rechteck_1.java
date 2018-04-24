/**
 * Rechteck_1
 * @author Julius Joha
 * @version 1.0
 * 
 */
public class Rechteck_1 {
	
	private double laenge;
	private double breite;
	
	/**
	 * Konstruktor Rechteck_1
	 * @param initLaenge Laenge die das Rechteck haben soll.
	 * @param initBreite Breite die das Rechteck haben soll.
	 */
	public Rechteck_1(double initLaenge, double initBreite) {
		laenge = initLaenge;
		breite = initBreite;
	}
	
	/**
	 * 
	 * @return Laenge des Rechtecks
	 */
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * 
	 * @return Breite des Rechtecks
	 */
	public double getBreite() {
		return breite;
	}
	
	/**
	 * Berechnet den Umfang des Rechtecks, indem die Parameter laenge und breite jeweils zweimal zusammenaddiert werden.
	 * @return Umfang des Rechtecks
	 */
	public double getUmfang() {
		return (laenge * 2 + breite * 2);
	}
	
	/**
	 * Berechnet die Flaeche des Rechtecks, indem die Parameter laenge und breite miteinander multipliziert werden.
	 * @return Flaeche des Rechtecks
	 */
	public double getFlaeche() {
		return (laenge * breite);
	}
}
