
public class Typumwandlung_3 {

	public static void main(String[] args) {						// Java arbeitet linksassoziativ, siehe §15.7 Java Language Specification: "The Java programming language guarantees that the operands of operators appear to be evaluated in a specific evaluation order, namely, from left to right."
		System.out.println("Das Ergebnis lautet: " + 17 + 25);		// Ausgabe beginnt mit einem String, weshalb das erste "+" nicht als mathematischer Operator interpretiert wird, sondern im Sinne von "append()". Also wird die 17 angehaengt, wodurch diese fuer  eine mathematische Interpretation des zweiten "+" wegfaellt und die 25 ebenfalls angehaengt wird.
		System.out.println(17 + 25 + " ist das Ergebnis.");			// Das erste "+" kann, aufgrund des davorstehenden int, in einem mathematischen Sinne interpretiert werden, weshalb 17 und 25 addiert werden. Da nach dem zweiten "+" ein String kommt, kann dies nicht im mathematischen Sinne interpretiert werden, sondern im Sinne von "append()".
	}
}
