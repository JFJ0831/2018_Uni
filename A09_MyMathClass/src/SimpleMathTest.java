import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

class SimpleMathTest {

	@Test
	void testAddEveryKthArray() {
		
		int[] arr0 = new int[0];
		int[] arr1 = {12, -56, 33, 97, 1};
		int[] arr2 = {12, -56, 33, 97, 1, 84};
		
		assertThat("Leeres Array wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr0, 1), is(equalTo(0)));
		assertThat("Array der Länge 5 wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr1, 1), is(equalTo(87)));
		assertThat("Array der Länge 6 wird nicht korrekt verarbeitet (k=1).", SimpleMath.addEveryKth(arr2, 1), is(equalTo(171)));
	}
	
	/*
	@Test
	void testAddEveryKthList() {
		
		SimpleMath sm = new SimpleMath();
	}
*/
}
