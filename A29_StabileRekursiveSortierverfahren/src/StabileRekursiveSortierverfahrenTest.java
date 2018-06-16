import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;

class StabileRekursiveSortierverfahrenTest {
	
	Integer[] testfeld0 = null;
	Integer[] testfeld1 = {};
	Integer[] testfeld2 = {0};
	Integer[] testfeld3 = {0, 1, 2, 3, 4};
	Integer[] testfeld4 = {4, 3, 2, 1, 0};
	Integer[] testfeld5 = {9, 3, 6, 7, 1, 8, 2, 5};
	Integer[] testfeld6 = {2, 6, 0, 5, 5, 6, 1};
	
	Integer[] checkfeld0 = null;
	Integer[] checkfeld1 = {};
	Integer[] checkfeld2 = {0};
	Integer[] checkfeld3 = {0, 1, 2, 3, 4};
	Integer[] checkfeld4 = {0, 1, 2, 3, 4};
	Integer[] checkfeld5 = {1, 2, 3, 5, 6, 7, 8, 9};
	Integer[] checkfeld6 = {0, 1, 2, 5, 5, 6, 6};

	@Test
	void testSRS() {
		
		//StabileRekursiveSortierverfahren.insertionsort(testfeld0);
		//StabileRekursiveSortierverfahren.insertionsort(testfeld1);
		StabileRekursiveSortierverfahren.insertionsort(testfeld2);
		//StabileRekursiveSortierverfahren.insertionsort(testfeld3);
		StabileRekursiveSortierverfahren.insertionsort(testfeld4);
		StabileRekursiveSortierverfahren.insertionsort(testfeld5);
		StabileRekursiveSortierverfahren.insertionsort(testfeld6);
		
		//assertThat("", testfeld0, is(equalTo(checkfeld0)));
		//assertThat("", testfeld1, is(equalTo(checkfeld1)));
		assertThat("", testfeld2, is(equalTo(checkfeld2)));
		//assertThat("", testfeld3, is(equalTo(checkfeld3)));
		assertThat("", testfeld4, is(equalTo(checkfeld4)));
		assertThat("", testfeld5, is(equalTo(checkfeld5)));
		assertThat("", testfeld6, is(equalTo(checkfeld6)));
	}

}
