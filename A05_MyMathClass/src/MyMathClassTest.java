import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Vector;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import org.junit.Test;

public class MyMathClassTest {
	
	@Test
	public void testStandardDeviation() {
		
		MyMathClass<Number> mmc = new MyMathClass<Number>();
		Vector<Number> vec = new Vector<Number>();
		
		vec.addElement(9);		
		vec.addElement(-45);
		vec.addElement(10.6);
		vec.addElement(null);
		vec.addElement(0);
		
		assertThat("Standartabweichung wird nicht korrekt berechnet.", mmc.standardDeviation(vec), is(equalTo(22.677466789745277896181082151853)));
		assertEquals("Standartabweichung wird nicht korrekt berechnet.", 22.677466, mmc.standardDeviation(vec), 0.000001);
	}

	/**
	 * Damit die folgenden Tests funktionieren müssen die zu Testenden Hilfsmethoden erst Paketsichtbarkeit erhalten.
	 */
	/*
	@Test
	public void testCalculateMean() {
		
		MyMathClass<Number> mmc = new MyMathClass<Number>();
		Vector<Number> vec = new Vector<Number>();
		
		vec.addElement(9);
		
		assertEquals("Arithmetisches Mittel wird nicht korekkt berechnet.", 9, mmc.calculateMean(vec), 0);
		
		vec.addElement(-45);
		vec.addElement(10.6);
		vec.addElement(0);
		// null-referenz kann nicht im Vektor enthalten sein, da es sich eigentlich um eine private Methode handelt.
		assertEquals("Arithmetisches Mittel wird nicht korekkt berechnet.", -6.35, mmc.calculateMean(vec), 0);
	}
	
	@Test
	public void testCalculateVariance() {
		
		MyMathClass<Number> mmc = new MyMathClass<Number>();
		Vector<Number> vec = new Vector<Number>();
		
		vec.addElement(9);
		
		assertEquals("Varianz wird nicht korekkt berechnet.", 0, mmc.calculateVariance(vec), 0);
		
		vec.addElement(-45);
		vec.addElement(10.6);
		vec.addElement(0);
		
		assertEquals("Varianz wird nicht korekkt berechnet.", 514.2675, mmc.calculateVariance(vec), 0);
	}
	
	@Test
	public void testRemoveNullElements() {
		
		MyMathClass<Number> mmc = new MyMathClass<Number>();
		Vector<Number> vec1 = new Vector<Number>();
		Vector<Number> vec2 = new Vector<Number>();
		
		vec1.addElement(9);		
		vec1.addElement(-45);
		vec1.addElement(10.6);
		vec1.addElement(null);
		vec1.addElement(0);
		
		vec2.addElement(9);		
		vec2.addElement(-45);
		vec2.addElement(10.6);
		vec2.addElement(0);
		
		assertThat("null-Referenzen werden nicht korrekt entfernt.", mmc.removeNullElements(vec1), is(equalTo(vec2)));
	}
	*/
}