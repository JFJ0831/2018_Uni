import java.util.Iterator;
import java.util.List;

public class SimpleMath {
	
	/**
	 * Default-Konstruktior
	 */
	public SimpleMath() {
		
	}

	/**
	 * Methode die, beginnend mit dem ersten Element, jedes k-te Element eines Arrays aufaddiert. 
	 * @param input Array mit int-Werten
	 * @param k Schrittweite (jedes k-te Element wird aufaddiert)
	 * @return Summe der aufaddierten Elemente des input-Arrays
	 * @throws IllegalArgumentException falls die Schrittweite k nicht echt positiv ist.
	 */
	public static int addEveryKth(int[] input, int k) throws IllegalArgumentException {
		
		int sum = 0;			// Summe der k-ten Elemente.
		int i = 1;				// Zählt mit, damit klar ist, welches das k-te Element ist.
		
		if (k <= 0) {
			throw new IllegalArgumentException("Schrittweite k ist nicht echt positiv.");
		}
		
		if ((input == null) || (input.length == 0)) {
			return sum;
		}
		else {
			for (int j=0; j<input.length; j++) {
				if (i == k) {
					sum += input[j];
					i = 1;
				}
				else {
					i++;
				}
			}
			return sum;
		}
	}
	
	/**
	 * Methode die, beginnend mit dem ersten Element, jedes k-te Element einer Liste aufaddiert. 
	 * @param input Liste mit Integer-Werten
	 * @param k Schrittweite (jedes k-te Element wird aufaddiert)
	 * @return Summe der aufaddierten Elemente der input-Liste
	 * @throws IllegalArgumentException falls die Schrittweite k nicht echt positiv ist.
	 */
	public static Integer addEveryKth(List<Integer> input, int k) throws IllegalArgumentException {
		
		Integer sum = 0;		// Summe der k-ten Elemente.
		int l = 1;				// Zählt mit, damit klar ist, welches das k-te Element ist.
		
		if (input == null) {
			return sum;
		}
		
		Iterator<Integer> i = input.iterator();
		
		if (k <= 0) {
			throw new IllegalArgumentException("Schrittweite k ist nicht echt positiv.");
		}
		
		if (input.isEmpty()) {
			return sum;
		}
		else {
			while (i.hasNext()) {
				if (l == k) {
					sum += i.next();
					l = 1;
				}
				else {
					l++;
					i.next();
				}
			}
			return sum;
		}
	}
}
