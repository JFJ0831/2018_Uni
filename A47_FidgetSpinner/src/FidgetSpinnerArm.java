/**
 * L&ouml;sung zu Aufgabe 46 (WiSe 2017/2018).
 * (Erg#&auml;nze: Modellierung ...)
 * @author [hier erg&auml;nzen]
 */
public class FidgetSpinnerArm {
	// Vereinbare die folgenden Attribute:
	private static double d1; // Durchmesser des ersten Halbstifts
	private static double l1; // L&auml;nge des ersten Halbstifts.
	private static double d2; // Durchmesser des zweiten Halbstifts.
	private static double l2; // L&auml;nge des zweiten Halbstifts.

	// Die nachfolgende Deklarationen nutzen Konstrukte aus Kapitel 11 und 12
	// (static/final), um oeffentlich sichtbare (public) Konstanten zu vereinbaren.
	public static final double APX_PI              = 3.14;
	public static final double GOLD_DICHTE         = 19.32;
	public static final double APX_WURZEL_FUENF    = 2.24;
	
	// Die Logik hinter dem nachfolgenden Konstruktor wird erst am
	// Donnerstag in der Vorlesung (Folien 9.66f.) erklaert. Aus diesem
	// Grund wird die Implementierung hier bereits vorgegeben.
	/**
	 * Konstruktor f&uuml;r den Fidget-Spinner-Arm.
	 * Dieser Konstruktor erwartet vier nicht-negative Werte, die den
	 * Durchmesser und die L&auml;nge des ersten bzw. zweiten Zylinders 
	 * beschreiben. Diese Werte m&uuml;ssen beim Erzeugen eines Arms 
	 * &uuml;bergeben werden und sind danach weder ver&auml;nderbar noch auslesbar.
	 * Als Einheit aller Ma&szlig;e wird "cm" angenommen.
	 * @param d1 Durchmesser des ersten Zylinders.
	 * @param l1 L&auml;nge des ersten Zylinders.
	 * @param d2 Durchmesser des zweiten Zylinders.
	 * @param l2 L&auml;nge des zweiten Zylinders.
	 */
	public FidgetSpinnerArm(double d1, double l1, double d2, double l2) {
		if (d1 < 0) {
			//  Entspricht vom Prinzip her dem aus Racket bekannten
			//  (error ...), d.h. es wird eine Fehlermeldung ausgeloest.
			throw new IllegalArgumentException("Durchmesser d1 darf nicht negativ sein.");
		}
		if (l1 < 0) {
			throw new IllegalArgumentException("Laenge l1 darf nicht negativ sein.");
		}
		if (d2 < 0) {
			throw new IllegalArgumentException("Durchmesser d2 darf nicht negativ sein.");
		}
		if (l2 < 0) {
			throw new IllegalArgumentException("Laenge l2 darf nicht negativ sein.");
		}
		// Speichere den Wert des Parameters d1 im Objekt-Attribut d1.
		FidgetSpinnerArm.d1 = d1;
		// Speichere den Wert des Parameters l1 im Objekt-Attribut l1.
		FidgetSpinnerArm.l1 = l1;
		// Speichere den Wert des Parameters d2 im Objekt-Attribut d2.
		FidgetSpinnerArm.d2 = d2;
		// Speichere den Wert des Parameters l2 im Objekt-Attribut l2.
		FidgetSpinnerArm.l2 = l2;
	}

	/**
	 * Runden einer gegebenen Zahl auf eine gegebene Anzahl an Nachkommastellen.
	 * @param x Zu rundende Zahl.
	 * @param n Anzahl der erwuenschten Nachkommastellen.
	 * @return Auf <I>n</I> Nachkommastellen abgerundeter Wert von <I>x</I>.
	 */
	static double runde(double x, int n) {
		if (n < 0) {
			throw new IllegalArgumentException("Anzahl der Nachkommastellen darf nicht negativ sein.");
		}
		return Math.floor(x * Math.pow(10, n)) / Math.pow(10, n);
	}

	/**
	 * Approximative Berechung der Fl&auml;che eine Kreisscheibe f&uuml;r einen gegebenen Durchmesser. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser der Kreisscheibe.
	 * @return Approximierte Fl&auml;che der Kreisscheibe.
	 */
	static double berechneKreisflaeche(double d) {
		if (d < 0) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		return Math.pow((d / 2), 2) * APX_PI;
	}

	/**
	 * Approximative Berechung des Volumens eines Kegels f&uuml;r einen gegebenen 
	 * Durchmesser, der auch der H&ouml;he entspricht. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser des Kegels.
	 * @return Approximiertes Volumen des Kegels.
	 */
	static double berechneKegelvolumen(double d) {
		if (d < 0) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		return FidgetSpinnerArm.berechneKreisflaeche(d) * d * 1 / 3 ;
	}

	/**
	 * Approximative Berechung des Volumens eines Zylinders f&uuml;r einen gegebenen Durchmesser
	 * und eine gegebene L&auml;nge.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser der Zylinders.
	 * @param l L&auml;nge des Zylinders
	 * @return Approximiertes Volumen des Zylinders.
	 */
	static double berechneZylindervolumen(double d, double l) {
		if (d < 0) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		if (l < 0) {
			throw new IllegalArgumentException("Laenge darf nicht negativ sein.");
		}
		return FidgetSpinnerArm.berechneKreisflaeche(d) * l;
	}

	/**
	 * Approximative, ungerundete Berechung des Volumens des Arms.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximiertes Volumen des Arms.
	 */
	static double berechneUngerundetesVolumen() {
		return FidgetSpinnerArm.berechneKegelvolumen(d1) 
				+ FidgetSpinnerArm.berechneZylindervolumen(d1, l1) 
				+ FidgetSpinnerArm.berechneZylindervolumen(d2, l2);
	}

	/**
	 * Approximative Berechung der Oberfl&auml;che eines Kegels f&uuml;r einen gegebenen 
	 * Durchmesser, der auch der H&ouml;he entspricht.
	 * Es wird nur die Mantelfl�che berechnet, die Grundfl�che wird nicht ber�cksichtigt. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser des Kegels.
	 * @return Approximierte Oberfl&auml;che des Kegels.
	 */
	static double berechneKegeloberflaeche(double d) {
		if (d < 0) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}

		return Math.sqrt(Math.pow(d, 2) + Math.pow((d / 2 ), 2))  ;
	}

	/**
	 * Approximative Berechung der Oberfl&auml;che eines Zylinders f&uuml;r einen gegebenen 
	 * Durchmesser und eine gegebene L&auml;nge.
	 * Es wird nur die Mantelfl�che berechnet, die Grund- und Deckfl�che werden nicht ber�cksichtigt.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @param d Durchmesser der Zylinders.
	 * @param l L&auml;nge des Zylinders
	 * @return Approximierte Oberfl&auml;che des Zylinders.
	 */
	static double berechneZylinderoberflaeche(double d, double l) {
		if (d < 0) {
			throw new IllegalArgumentException("Durchmesser darf nicht negativ sein.");
		}
		if (l < 0) {
			throw new IllegalArgumentException("Laenge darf nicht negativ sein.");
		}

		return 2 * APX_PI * (d / 2) * l;
	}

	/**
	 * Approximative Berechung der Oberfl&auml;che des Armes.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximierte Oberfl&auml;che des Armes.
	 */
	static double berechneUngerundeteOberflaeche() {
		double x = 0;
		if (d1 > d2) { 
			x = FidgetSpinnerArm.berechneKreisflaeche(d1); 
		} else {
			x = 2 * FidgetSpinnerArm.berechneKreisflaeche(d2) - FidgetSpinnerArm.berechneKreisflaeche(d1);
		}
		
 		return FidgetSpinnerArm.berechneKegeloberflaeche(d1)
				+ FidgetSpinnerArm.berechneZylinderoberflaeche(d1, l1)
				+ FidgetSpinnerArm.berechneZylinderoberflaeche(d2, l2)
				+ x;
	}

	/**
	 * Approximative Berechnung der Masse des Armes.
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximierte Masse des Armes.
	 */
	 static double berechneUngerundeteMasse() {
	    return GOLD_DICHTE * (FidgetSpinnerArm.berechneKegelvolumen(d1)
	    		+ FidgetSpinnerArm.berechneZylindervolumen(d1, l1)
	    		+ FidgetSpinnerArm.berechneZylindervolumen(d2, l2));
	}

	/**
	 * Approximative, auf drei Nachkommastellen gerundete Berechnung des Volumens
	 * des Arms. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximatives, auf drei Nachkommastellen gerundetes Volumen. 
	 */
	public double berechneGerundetesVolumen() {
		return FidgetSpinnerArm.runde(FidgetSpinnerArm.berechneUngerundetesVolumen(), 3);
	}

	/**
	 * Approximative, auf zwei Nachkommastellen gerundete Berechnung der Oberfl&auml;che
	 * des Arms. 
	 * Bei der Berechnung wird als Approximation von &Pi; der Wert 3.14 verwendet.
	 * @return Approximatives, auf zwei Nachkommastellen gerundetes Volumen. 
	 */
	public double berechneGerundeteOberflaeche() {
		return FidgetSpinnerArm.runde(FidgetSpinnerArm.berechneUngerundeteOberflaeche(), 2);
	}

	/**
	 * Approximative, auf zwei Nachkommastellen gerundete Berechnung der Masse (in g)
	 * des Stifts bei einer Dichte von 19,32 g/cm<SUP>3</SUP>. 
	 * Bei der Berechnung wird als Approximation von PI der Wert 3,14 verwendet.
	 * @return Approximative, auf zwei Nachkommastellen gerundete Masse in Gramm. 
	 */
	public double berechneGerundeteMasse() {
		return FidgetSpinnerArm.runde(FidgetSpinnerArm.berechneUngerundeteMasse(), 2);
	}

}
