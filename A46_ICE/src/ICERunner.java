/**
 * Aufgabe 46 (WiSe 2017/18).
 */
public class ICERunner {

    public void run() {
        // Erzeuge ein neues Objekt.
        ICE ICE1 = new ICE((short) 24061, "Muenster");

        // Beschleunige sechsmal (hier ohne Schleifenkonstrukt).
        ICE1.beschleunige();
        ICE1.beschleunige();
        ICE1.beschleunige();
        ICE1.beschleunige();
        ICE1.beschleunige();
        ICE1.beschleunige();

        // Wiederhole viermal:
        // - Bremse ab.
        // - Gib aktuelle Geschwindigkeit aus.
        ICE1.bremseAb();
        ICE1.getGeschwindigkeit();
        ICE1.bremseAb();
        ICE1.getGeschwindigkeit();
        ICE1.bremseAb();
        ICE1.getGeschwindigkeit();
        ICE1.bremseAb();
        ICE1.getGeschwindigkeit();
    }

    public static void main(String[] args) {
        ICERunner einICERunner = new ICERunner();
        einICERunner.run();
    }

}
