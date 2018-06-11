import java.util.Arrays;

public class InversionenZaehlen {

	/**
	 * Bestimme die Anzahl der Inversionen in der &uuml;bergebenen
	 * Permutation der Zahlen [0,...,a.length-1]. 
	 * @param a  Referenz auf Feld mit Permutation
	 * @return Anzahl der Permutationen.
	 */
	public static int anzahlInversionen(int[] a) {
		// In einem leeren Feld gibt es keine Inversionen.
		int inversionen = 0;

		// Test die Eingabe auf Gueltigkeit.
		if (a == null) {
			throw new IllegalArgumentException("Null-Referenz uebergeben.");
		}

		int[] sortedA = a.clone();
		Arrays.sort(sortedA);

		// Test der Eingabe auf Permutation
		for (int i = 0; i < sortedA.length; i++) {
			if (a.length == 0) {
				return inversionen;
			}
			if (i != sortedA[i]) {
				throw new IllegalArgumentException("Uebergebenes Feld a enthaelt keine Permutation der Zahlen 0 bis |a|-1.");
			}
		}

		// Zaehlen der Inversionen
		for (int j = 0; j < a.length - 1; j++) {
			for (int k = j + 1; k < a.length; k++) {
				if (a[j] > a[k]) {
					inversionen++;
				}
			}
		}

		return inversionen;
	}

}