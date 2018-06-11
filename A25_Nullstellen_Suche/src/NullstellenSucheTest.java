import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.closeTo;  // Hinweise zur Nutzung von "closeTo" auf frueherem Zettel beachten.
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.function.Function;

import org.junit.jupiter.api.Test;

class NullstellenSucheTest {

	static final double EPSILON = 0.00001;
	
	@Test
	void testFindeNullstelleLinear() {
		
		Function <Double,Double> linearFunction1 = (x) -> { return x; };
		Function <Double,Double> linearFunction2 = (x) -> { return 3*x; };
		Function <Double,Double> linearFunction3 = (x) -> { return -(x - 3); };
		
		assertThat("Nullstelle einer linearen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(linearFunction1, -5, 5, EPSILON),
				is(closeTo(0.0, EPSILON)));

		assertThat("Nullstelle einer linearen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(linearFunction1, 0, 5, EPSILON),
				is(closeTo(0.0, EPSILON)));

		assertThat("Nullstelle einer linearen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(linearFunction1, -5, 0, EPSILON),
				is(closeTo(0.0, EPSILON)));

		assertThat("Nullstelle einer linearen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(linearFunction2, -15, 2, EPSILON),
				is(closeTo(0.0, EPSILON)));

		assertThat("Nullstelle einer linearen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(linearFunction3, -15, 122, EPSILON),
				is(closeTo(3.0, EPSILON)));

	}

	@Test
	void testFindeNullstelleNichtLinear() {
		
		Function <Double,Double> nonLinearFunction1 = (x) -> { return x * x * x; };
		Function <Double,Double> nonLinearFunction2 = (x) -> { return 3*x * x * x * x * x; };
		Function <Double,Double> nonLinearFunction3 = (x) -> { return x * x - 2; };
		Function <Double,Double> nonLinearFunction4 = (x) -> { return Math.sin(x-1); };
		
		assertThat("Nullstelle einer kubischen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(nonLinearFunction1, -5, 5, EPSILON),
				is(closeTo(0.0, EPSILON)));

		assertThat("Nullstelle einer kubischen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(nonLinearFunction2, -15, 2, EPSILON),
				is(closeTo(0.0, EPSILON)));

		assertThat("Nullstelle einer quadratischen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(nonLinearFunction3, 1, 1.5, EPSILON),
				is(closeTo(1.4142135624, EPSILON)));

		assertThat("Nullstelle einer trigonometrischen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(nonLinearFunction4, 0.0, 2.0, EPSILON),
				is(closeTo(1.0, EPSILON)));

	}

	@Test
	void testFindeNullstelleLargeEpsilon() {
		
		Function <Double,Double> linearFunction1 = (x) -> { return x; };
		
		assertThat("Nullstelle einer linearen Funktion nicht korrekt berechnet.",
				NullstellenSuche.findeNullstelle(linearFunction1, -500, 0.0005, 5000),
				is(closeTo(0.0, 5000)));

	}

	@Test
	void testFindeNullstelleExceptions() {
		
		Function <Double,Double> nonLinearFunction1 = (x) -> { return 5.0d; };
		Function <Double,Double> nonLinearFunction2 = (x) -> { return x * x + 5; };
		Function <Double,Double> nonLinearFunction3 = (x) -> { return x; };
		
		assertThrows(IllegalArgumentException.class, 
				() -> { 
					NullstellenSuche.findeNullstelle(nonLinearFunction1, 0, 500, EPSILON);
					}, 
				"Fehlerhafte Suche nach nicht-vorhandener Nullstelle.");
		
		assertThrows(IllegalArgumentException.class, 
				() -> { 
					NullstellenSuche.findeNullstelle(nonLinearFunction2, -5, 5, EPSILON);
					}, 
				"Fehlerhafte Suche nach nicht-vorhandener Nullstelle.");

		assertThrows(IllegalArgumentException.class, 
				() -> { 
					NullstellenSuche.findeNullstelle(nonLinearFunction3, 0, 0, EPSILON);
					}, 
				"Fehlerhafte Suche nach nicht-vorhandener Nullstelle.");

	}

}