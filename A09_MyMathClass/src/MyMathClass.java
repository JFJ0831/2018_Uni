import java.util.Iterator;
import java.util.Vector;

/**
 * Klasse zur Berechnung der Standartabweichung.
 */
public class MyMathClass<T extends Number>{
	public MyMathClass() {
		
	}

	/**
	 * Berechnet die Standardabweichung. "null"-Elemente werden entfernt. Sollte der Vektor (dann) leer sein, so wird 0.0 zurück gegeben.
	 * @param v Vektor mit Werten deren Standartabweichung berechnet werden soll.
	 * @return Standartabweichung der im Vektor übergebenen Werte.
	 */
	public double standardDeviation(Vector<Number> v) {
		
		Vector<Number> removed = this.removeNullElements(v);
		
		if (removed.isEmpty()) {
			return 0;
		}
		else {
			return Math.sqrt(this.calculateVariance(removed));
		}
		
	}

	/**
	 * Berechnet den Mittelwert der in einem Vektor gespeicherten Werte.
	 * @param v Vektor mit Werten deren Mittelwert berechnet werden soll.
	 * @return Mittelwert aller im Vektor gespeicherten Werte.
	 */
	 double calculateMean(Vector<Number> v) {
		
		Iterator<Number> i = v.iterator();			// Objekt zum sequentiellen Durchlaufen eines Objekts (hier Vektor). Erlaubt durch die Methode "next()" den Aufruf des nächsten im Objekt gespeicherten Werts.
		Double all = 0.0;
		
		while (i.hasNext()) {
			all += i.next().doubleValue();
		}
		return all/v.size();
	}

	/**
	 * Berechnet die (empirische) Varianz, also die mittlere quadratische Abweichung vom Mittelwert.
	 * @param v Vektor mit Werten aus denen Varianz berechnet werden soll.
	 * @return Varianz der im Vektor übergebenen Werte.
	 */
	  double calculateVariance(Vector<Number> v) {
		
		Double mean = this.calculateMean(v);
		Double result = 0.0;
		Iterator<Number> i = v.iterator();
		
		while (i.hasNext()) {
			Double x = i.next().doubleValue() - mean;
			result += Math.pow(x, 2);
		}
		return (result/v.size());
	}

	/**
	 * Entfernt null-Referenzen aus einem Vektor.
	 * @param v Vektor von welchem null-Referenzen entfernt werden sollen.
	 * @return Vektor ohne null-Referenzen.
	 */
	 Vector<Number> removeNullElements(Vector<Number> v){
		
		Vector<Number> clear = new Vector<Number>();
		Iterator<Number> i = v.iterator();
		
		while (i.hasNext()) {
			Number next = i.next();
			if(next != null) {
				clear.add(next);
			}
		}
		return clear;
	}
}





