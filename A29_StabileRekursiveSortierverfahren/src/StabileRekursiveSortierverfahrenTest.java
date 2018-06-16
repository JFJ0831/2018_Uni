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
	Integer[] testfeld7 = {0, -1, 2, -3, -2};
	
	//Integer[] checkfeld0 = null;
	//Integer[] checkfeld1 = {};
	Integer[] checkfeld2 = {0};
	Integer[] checkfeld3 = {0, 1, 2, 3, 4};
	Integer[] checkfeld4 = {0, 1, 2, 3, 4};
	Integer[] checkfeld5 = {1, 2, 3, 5, 6, 7, 8, 9};
	Integer[] checkfeld6 = {0, 1, 2, 5, 5, 6, 6};
	Integer[] checkfeld7 = {-3, -2, -1, 0, 2};

	@Test
	void testRecursiveInsertionSort() {
		
		StabileRekursiveSortierverfahren.insertionsort(testfeld2);
		StabileRekursiveSortierverfahren.insertionsort(testfeld3);
		StabileRekursiveSortierverfahren.insertionsort(testfeld4);
		StabileRekursiveSortierverfahren.insertionsort(testfeld5);
		StabileRekursiveSortierverfahren.insertionsort(testfeld6);
		StabileRekursiveSortierverfahren.insertionsort(testfeld7);
		
		assertThrows(IllegalArgumentException.class, () -> {StabileRekursiveSortierverfahren.insertionsort(testfeld0);}, "null-Referenz wird nicht korrekt verarbeitet.");
		assertThrows(IllegalArgumentException.class, () -> {StabileRekursiveSortierverfahren.insertionsort(testfeld1);}, "Leeres Feld wird nicht korrekt verarbeitet.");
		assertThat("Testfeld mit einem Element wird nicht korrekt verarbeitet.", testfeld2, is(equalTo(checkfeld2)));
		assertThat("Sortiertes Testfeld wird nicht korrekt verarbeitet.", testfeld3, is(equalTo(checkfeld3)));
		assertThat("Invers sortiertes Testfeld wird nicht korrekt verarbeitet.", testfeld4, is(equalTo(checkfeld4)));
		assertThat("Testfeld mit fehlenden Elementen wird nicht korrekt verarbeitet.", testfeld5, is(equalTo(checkfeld5)));
		assertThat("Testfeld mit doppelten Elementen wird nicht korrekt verarbeitet.", testfeld6, is(equalTo(checkfeld6)));
		assertThat("Testfeld mit negativen Elementen wird nicht korrekt verarbeitet.", testfeld7, is(equalTo(checkfeld7)));
	}
	
	@Test
	void testRecursiveSelectionSort() {
		
		StabileRekursiveSortierverfahren.selectionsort(testfeld2);
		StabileRekursiveSortierverfahren.selectionsort(testfeld3);
		StabileRekursiveSortierverfahren.selectionsort(testfeld4);
		StabileRekursiveSortierverfahren.selectionsort(testfeld5);
		StabileRekursiveSortierverfahren.selectionsort(testfeld6);
		StabileRekursiveSortierverfahren.selectionsort(testfeld7);
		
		assertThrows(IllegalArgumentException.class, () -> {StabileRekursiveSortierverfahren.selectionsort(testfeld0);}, "null-Referenz wird nicht korrekt verarbeitet.");
		assertThrows(IllegalArgumentException.class, () -> {StabileRekursiveSortierverfahren.selectionsort(testfeld1);}, "Leeres Feld wird nicht korrekt verarbeitet.");
		assertThat("Testfeld mit einem Element wird nicht korrekt verarbeitet.", testfeld2, is(equalTo(checkfeld2)));
		assertThat("Sortiertes Testfeld wird nicht korrekt verarbeitet.", testfeld3, is(equalTo(checkfeld3)));
		assertThat("Invers sortiertes Testfeld wird nicht korrekt verarbeitet.", testfeld4, is(equalTo(checkfeld4)));
		assertThat("Testfeld mit fehlenden Elementen wird nicht korrekt verarbeitet.", testfeld5, is(equalTo(checkfeld5)));
		assertThat("Testfeld mit doppelten Elementen wird nicht korrekt verarbeitet.", testfeld6, is(equalTo(checkfeld6)));
		assertThat("Testfeld mit negativen Elementen wird nicht korrekt verarbeitet.", testfeld7, is(equalTo(checkfeld7)));
	}

}
