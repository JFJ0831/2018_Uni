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
		
		int sum = 0;
		int i = 0;
		
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
					i = 0;
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
		
		Integer sum = 0;
		int j = k;
		Iterator<Integer> i = input.iterator();
		
		if (k <= 0) {
			throw new IllegalArgumentException("Schrittweite k ist nicht echt positiv.");
		}
		
		if ((input == null) || (input.isEmpty())) {
			return sum;
		}
		else {
			while (i.hasNext()) {
				if (j == k) {
					sum += i.next();
					j = 0;
				}
				j++;
			}
			return sum;
		}
	}
}
