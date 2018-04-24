import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class BruchTest {

    @Test
    public void testKonstruktor() {

        // Teste das Ausloesen einer Ausnahme bei Null als Nenner
        Throwable ex = assertThrows(IllegalArgumentException.class, () -> {new Bruch(42, 0);});
        assertThat("Inkorrekte Ausnahme geworfen.",
                ex.getMessage(),
                is(equalTo("Nenner muss von Null verschieden sein.")));
    }

    @Test
    public void testGetZaehler() {
        // Erzeuge einen Bruch zum Testen.
        Bruch einBruch = new Bruch();

        // Teste den Zaehler des Bruchs.
        assertThat("getZaehler arbeitet nicht korrekt.",
                einBruch.getZaehler(),
                is(equalTo(1)));
    }
    
    @Test
    public void testGetNenner() {
        // Erzeuge einen Bruch zum Testen.
        Bruch einBruch = new Bruch();

        // Teste den Nenner des Bruchs.
        assertThat("getNenner arbeitet nicht korrekt.",
                einBruch.getNenner(),
                is(equalTo(1)));
    }
    
    @Test
    public void testKuerze() {
    	 // Erzeuge Brueche zum Testen.
        Bruch b1 = new Bruch(50, 150);
        Bruch b2 = new Bruch(1, 3);
        b1.kuerze();
        
     // Teste kuerze.
        assertThat("kuerze zaehler arbeitet nicht korrekt.",
                b1.getZaehler(),
                is(equalTo(b2.getZaehler())));

        assertThat("kuerze nenner arbeitet nicht korrekt.",
                b1.getNenner(),
                is(equalTo(b2.getNenner())));
    }
    
    @Test
    public void testGgT() {
        // Erzeuge einen Bruch zum Testen.
    	Bruch einBruch = new Bruch();
    	
    	// Erzeuge Integer zum Testen.
        int a = 40;
        int b = 75;

        // Teste ggT.
        assertThat("ggT arbeitet nicht korrekt.",
                einBruch.ggT(a, b),
                is(equalTo(5)));
    }
    
    @Test
    public void testSetZaehler() {
        // Erzeuge einen Bruch zum Testen.
        Bruch einBruch = new Bruch();
        einBruch.setZaehler(42);
        
        // Teste setZaehler.
        assertThat("setZaehler arbeitet nicht korrekt.",
                einBruch.getZaehler(),
                is(equalTo(42)));
    }
    
    @Test
    public void testSetNenner() {
        // Erzeuge einen Bruch zum Testen.
        Bruch einBruch = new Bruch();
        einBruch.setNenner(42);

        // Teste setNenner.
        assertThat("setNenner arbeitet nicht korrekt.",
                einBruch.getNenner(),
                is(equalTo(42)));
        
        Throwable ex = assertThrows(IllegalArgumentException.class, () -> {einBruch.setNenner(0);});
        assertThat("Inkorrekte Ausnahme geworfen.",
                ex.getMessage(),
                is(equalTo("Nenner muss von Null verschieden sein.")));
    }
    
    @Test
    public void testAddiere() {
        // Erzeuge einen Bruch zum Testen.
        Bruch b1 = new Bruch(3, 10);
        Bruch b2 = new Bruch(1, 5);
        Bruch b3 = new Bruch(1, 2);

        // Teste addiere.
        assertThat("addiere zaehler arbeitet nicht korrekt.",
        		b1.addiere(b2).getZaehler(),
                is(equalTo(b3.getZaehler())));
        
        assertThat("addiere nenner arbeitet nicht korrekt.",
        		b1.addiere(b2).getNenner(),
                is(equalTo(b3.getNenner())));
    }
    
    @Test
    public void testMultipliziere() {
        // Erzeuge einen Bruch zum Testen.
    	Bruch b1 = new Bruch(3, 10);
        Bruch b2 = new Bruch(1, 5);
        Bruch b3 = new Bruch(3, 50);
        
        // Teste multipliziere.
        assertThat("multipliziere zaehler arbeitet nicht korrekt.",
        		b1.multipliziere(b2).getZaehler(),
                is(equalTo(b3.getZaehler())));
        
        assertThat("multipliziere nenner arbeitet nicht korrekt.",
        		b1.multipliziere(b2).getNenner(),
                is(equalTo(b3.getNenner())));
    }
    
    @Test
    public void testSubtrahiere() {
        // Erzeuge einen Bruch zum Testen.
    	Bruch b1 = new Bruch(3, 10);
        Bruch b2 = new Bruch(1, 5);
        Bruch b3 = new Bruch(1, 10);

        // Teste subtrahiere.
        assertThat("subtrahiere zaehler arbeitet nicht korrekt.",
        		b1.subtrahiere(b2).getZaehler(),
                is(equalTo(b3.getZaehler())));
        
        assertThat("subtrahiere nenner arbeitet nicht korrekt.",
        		b1.subtrahiere(b2).getNenner(),
                is(equalTo(b3.getNenner())));
    }
    
    @Test
    public void testDividiere() { 
        // Erzeuge einen Bruch zum Testen.
    	Bruch b1 = new Bruch(3, 10);
        Bruch b2 = new Bruch(1, 5);
        Bruch b3 = new Bruch(3, 2);

        // Teste dividiere.
        assertThat("dividiere zaehler arbeitet nicht korrekt.",
        		b1.dividiere(b2).getZaehler(),
                is(equalTo(b3.getZaehler())));
        
        assertThat("dividiere nenner arbeitet nicht korrekt.",
        		b1.dividiere(b2).getNenner(),
                is(equalTo(b3.getNenner())));
    }

}
