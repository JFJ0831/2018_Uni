import java.util.*;

/**
 * Umrechnung einer Zahl im Bereich [1..3000] in das r&ouml;mische Zahlsystem.
 */
public class Zahlumwandlung {

	/**
	 * Wandelt eine echt positive ganze Zahl in ein roemisches Numeral um.
	 * @param n Echt positive ganze Zahl
	 * @return Roemisches Numeral
	 */
	public String wandeleZahlUm(int n) {
		
		if ((n<1)||(n>3000)) {
			throw new IllegalArgumentException("Zahl liegt nicht im Bereich 1 bis 3000.");
		}
		
		return String.join("", Collections.nCopies(n, "I"))		// Reiht "I" n-mal in einem String aneinander.
	            .replace("IIIII", "V")							// Ersetzt niedrige Zahlzeichen durch größere Zahlzeichen.
	            .replace("IIII", "IV")
	            .replace("VV", "X")
	            .replace("VIV", "IX")
	            .replace("XXXXX", "L")
	            .replace("XXXX", "XL")
	            .replace("LL", "C")
	            .replace("LXL", "XC")
	            .replace("CCCCC", "D")
	            .replace("CCCC", "CD")
	            .replace("DD", "M")
	            .replace("DCD", "CM");
		
	}
}
