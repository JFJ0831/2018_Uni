import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.Test;

class ZahlenAnalyseTest {
	
	int[] testfeld0 	= null;
	int[] testfeld1 	= {};
	int[] testfeld2 	= {-1};
	int[] testfeld3 	= {0};
	int[] testfeld4 	= {1};
	int[] testfeld5 	= {-1, 1};
	int[] testfeld6 	= {5, 0, -5};
	int[] testfeld7 	= {0, 1, -2, 3, 2};
	int[] testfeld8 	= {-9, 100, 3, -3, -8, -7, 4};
	int[] testfeld9 	= {0, 0, 0, 0, 0};
	int[] testfeld10 	= {-4, -1, -2, -3, -7};
	int[] testfeld11 	= {4, 1, 2, 3, 7};

	@Test
	void testBalance() {

		assertThrows(IllegalArgumentException.class, () -> {ZahlenAnalyse.balance(testfeld0);}, "null-Referenz wird nicht korrekt verarbeitet.");
		assertThat("Leeres Testfeld wird nicht korrekt verarbeitet.", 								ZahlenAnalyse.balance(testfeld1), is(equalTo(0)));
		assertThat("Testfeld mit einem Element (-1) wird nicht korrekt verarbeitet.", 				ZahlenAnalyse.balance(testfeld2), is(equalTo(-1)));
		assertThat("Testfeld mit einem Element (0) wird nicht korrekt verarbeitet.", 				ZahlenAnalyse.balance(testfeld3), is(equalTo(0)));
		assertThat("Testfeld mit einem Element (1) wird nicht korrekt verarbeitet.", 				ZahlenAnalyse.balance(testfeld4), is(equalTo(1)));
		assertThat("Testfeld mit zwei Elementen wird nicht korrekt verarbeitet.", 					ZahlenAnalyse.balance(testfeld5), is(equalTo(0)));
		assertThat("Testfeld mit drei Elementen wird nicht korrekt verarbeitet.", 					ZahlenAnalyse.balance(testfeld6), is(equalTo(0)));
		assertThat("Testfeld mit ueberwiegend positiven Elementen wird nicht korrekt verarbeitet.", ZahlenAnalyse.balance(testfeld7), is(equalTo(1)));
		assertThat("Testfeld mit ueberwiegend negativen Elementen wird nicht korrekt verarbeitet.", ZahlenAnalyse.balance(testfeld8), is(equalTo(-1)));
		assertThat("Testfeld bestehend aus fuenfmal 0 wird nicht korrekt verarbeitet.", 			ZahlenAnalyse.balance(testfeld9), is(equalTo(0)));
		assertThat("Testfeld mit ueberwiegend negativen Elementen wird nicht korrekt verarbeitet.", ZahlenAnalyse.balance(testfeld10), is(equalTo(-1)));
		assertThat("Testfeld mit ueberwiegend positiven Elementen wird nicht korrekt verarbeitet.", ZahlenAnalyse.balance(testfeld11), is(equalTo(1)));
	}

}
