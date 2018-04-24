/**
 * Rechteck_2
 * @author Julius Joha
 * @version 1.0
 * 
 */
public class Rechteck_2 {
	
	private double laenge;
	private double umfang;
	
	/**
	 * Konstruktor Rechteck_2
	 * @param initLaenge Laenge die das Rechteck haben soll.
	 * @param initUmfang Umfang den das Rechteck haben soll.
	 */
	public Rechteck_2(double initLaenge, double initUmfang) {
		laenge = initLaenge;
		umfang = initUmfang;
	}
	
	/**
	 * 
	 * @return Laenge des Rechtecks
	 */
	public double getLaenge() {
		return laenge;
	}
	
	/**
	 * berechnet die Breite des Rechtecks, indem vom Parameter umfang zweimal der Parameter laenge subtrahiert wird. 
	 * @return Breite des Rechtecks
	 */
	public double getBreite() {
		return ((umfang - 2 * laenge) / 2);
	}
	
	/**
	 * 
	 * @return Umfang des Rechtecks
	 */
	public double getUmfang() {
		return umfang;
	}
	
	/**
	 * Berechnet die Flaeche des Rechtecks, indem einer lokalen Variabel der Rückgabewert der Methode getBreite zugeordnet wird.
	 * Danach wird die lokale Variabel breite mit dem Parameter laenge multipliziert.
	 * @return Flaeche des Rechtecks
	 */
	public double getFlaeche() {
		double breite = getBreite();
		return (laenge * breite);
	}
}
