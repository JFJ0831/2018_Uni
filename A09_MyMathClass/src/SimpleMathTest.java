import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.LinkedList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class SimpleMathTest {

	@Test
	public void testAddEveryKthArray() {

		int[] arr0 = new int[0];
		int[] arr1 = {12, -56, 33, 97, 1};
		int[] arr2 = {12, -56, 33, 97, 1, 84};
		int[] arr3 = null;

		// k=1
		assertThat("Leeres Array wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr0, 1), is(equalTo(0)));
		assertThat("Array der Länge 5 wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr1, 1), is(equalTo(87)));
		assertThat("Array der Länge 6 wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr2, 1), is(equalTo(171)));
		// k=2
		assertThat("Leeres Array wird nicht korrekt verarbeitet (k=2).", SimpleMath.addEveryKth(arr0, 2), is(equalTo(0)));
		assertThat("Array der Länge 5 wird nicht korrekt verarbeitet (k=2).", SimpleMath.addEveryKth(arr1, 2), is(equalTo(41)));
		assertThat("Array der Länge 6 wird nicht korrekt verarbeitet (k=2).", SimpleMath.addEveryKth(arr2, 2), is(equalTo(125)));
		// k=3
		assertThat("Leeres Array wird nicht korrekt verarbeitet (k=3).", SimpleMath.addEveryKth(arr0, 3), is(equalTo(0)));
		assertThat("Array der Länge 5 wird nicht korrekt verarbeitet (k=3).", SimpleMath.addEveryKth(arr1, 3), is(equalTo(33)));
		assertThat("Array der Länge 6 wird nicht korrekt verarbeitet (k=3).", SimpleMath.addEveryKth(arr2, 3), is(equalTo(117)));
		
		// null-Referenz als input
		assertThat("Leeres Array wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr3, 1), is(equalTo(0)));
		
		// Fehlertest
		assertThrows(IllegalArgumentException.class, () -> { SimpleMath.addEveryKth(arr0, 0); }, "Nicht echt positive Schrittweite wirt nicht korrekt verarbeitet.");
	}


	@Test
	public void testAddEveryKthList() {

		LinkedList<Integer> l0 = new LinkedList<Integer>();
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		LinkedList<Integer> l3 = null;

		// Fülle l1
		l1.addLast(12);
		l1.addLast(-56);
		l1.addLast(33);
		l1.addLast(97);
		l1.addLast(1);
		// Fülle l2
		l2.addLast(12);
		l2.addLast(-56);
		l2.addLast(33);
		l2.addLast(97);
		l2.addLast(1);
		l2.addLast(84);

		// k=1
		assertThat("Leere Liste wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(l0, 1), is(equalTo(0)));
		assertThat("Liste mit 5 Elementen wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(l1, 1), is(equalTo(87)));
		assertThat("Liste mit 6 Elementen wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(l2, 1), is(equalTo(171)));
		// k=2
		assertThat("Leere Liste wird nicht korrekt verarbeitet (k=2).", SimpleMath.addEveryKth(l0, 2), is(equalTo(0)));
		assertThat("Liste mit 5 Elementen wird nicht korrekt verarbeitet (k=2).", SimpleMath.addEveryKth(l1, 2), is(equalTo(41)));
		assertThat("Liste mit 6 Elementen wird nicht korrekt verarbeitet (k=2).", SimpleMath.addEveryKth(l2, 2), is(equalTo(125)));
		// k=3
		assertThat("Leere Liste wird nicht korrekt verarbeitet (k=3).", SimpleMath.addEveryKth(l0, 3), is(equalTo(0)));
		assertThat("Liste mit 5 Elementen wird nicht korrekt verarbeitet (k=3).", SimpleMath.addEveryKth(l1, 3), is(equalTo(33)));
		assertThat("Liste mit 6 Elementen wird nicht korrekt verarbeitet (k=3).", SimpleMath.addEveryKth(l2, 3), is(equalTo(117)));
		
		// null-Referenz als input
		assertThat("Leeres Array wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(l3, 1), is(equalTo(0)));
		
		// Fehlertest
		assertThrows(IllegalArgumentException.class, () -> { SimpleMath.addEveryKth(l0, 0); }, "Nicht echt positive Schrittweite wirt nicht korrekt verarbeitet.");
	}

}
