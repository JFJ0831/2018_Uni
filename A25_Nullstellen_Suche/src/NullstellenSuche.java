import java.util.function.Function;

/**
 * Nullstellen-Suche mit dem Verfahren der Bisektion.
 */
public class NullstellenSuche {

	/**
	 * Finde eine Nullstelle der &uuml;bergebenen stetigen Funktion im angegebenen 
	 * Intervall. Die Suche endet, wenn das Intervall die angegebene Mindestgr&ouml;&szlig;e
	 * erreicht oder unterschreitet und gibt den Mittelpunkt dieses Intervalls zur&uuml;ck. 
	 * Ist im angegebenen Intervall nicht eine ungerade Anzahl an Nullstellen enthalten,
	 * oder ist das Intervall degeneriert, wird eine Fehlermeldung erzeugt. 
	 * @param function      Auszuwertende reellwertige Funktion.
	 * @param untereGrenze  Untere Grenze des zu betrachtenden Intervalls.
	 * @param obereGrenze   Obere Grenze des zu betrachtenden Intervalls.
	 * @param epsilon       Breite des Toleranz-Intervalls.
	 * @return Mitte eines Intervalls mit maximal der vorgegebenen Breite, 
	 * das eine Nullstelle enth&auml;lt.
	 */
	public static double findeNullstelle(Function<Double, Double> function, 
			double untereGrenze, double obereGrenze, double epsilon) {

		double mitte = findeIntervallmitte(untereGrenze, obereGrenze); // Approximierte Nullstelle
		double halfepsilon = epsilon / 2;
		double lowerBound = untereGrenze;
		double upperBound = obereGrenze;

		if (untereGrenze >= obereGrenze) {
			throw new IllegalArgumentException("Untere Inervallgrenze ist nicht echt kleiner als obere Intervallgrenze.");
		}
		if ((function.apply(lowerBound) > 0 && function.apply(upperBound) > 0) || (function.apply(lowerBound) < 0 && function.apply(upperBound) < 0)) {
			throw new IllegalArgumentException("Im Intervall ist keine oder eine gerade Anzahl an Nullstellen enthalten.");
		}

		for (; !((lowerBound >= (mitte - halfepsilon)) && (upperBound <= (mitte + halfepsilon))); mitte = findeIntervallmitte(lowerBound, upperBound)) {
			if (function.apply(lowerBound) == 0.0) {
				return lowerBound;
			}
			else if (function.apply(mitte) == 0.0) {
				return mitte;
			}
			else if (function.apply(upperBound) == 0.0) {
				return upperBound;
			}
			else if ((function.apply(lowerBound) > 0.0 && function.apply(mitte) < 0.0) || (function.apply(lowerBound) < 0.0 && function.apply(mitte) > 0.0)) {
				upperBound = mitte;
			}
			else if ((function.apply(upperBound) > 0.0 && function.apply(mitte) < 0.0) || (function.apply(upperBound) < 0.0 && function.apply(mitte) > 0.0)) {
				lowerBound = mitte;
			}
		}
		return mitte;
	}

	/**
	 * Berechnet die Mitte eines Inetervalls aus der oberen und unteren Intervallgrenze.
	 * @param UG Untere Intervallgrenze
	 * @param OG Obere Intervallgrenze
	 * @return Mitte des Intervalls
	 */
	private static double findeIntervallmitte(double UG, double OG) {
		return ((OG - UG) / 2) + UG;	
	}
}