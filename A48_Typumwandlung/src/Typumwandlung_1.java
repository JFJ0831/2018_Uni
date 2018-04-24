
public class Typumwandlung_1 {

	float x = 6.0f , y = 7.1f;
	int a = (int)( x * y );										// Multipliziert 6.0f und 7.1f zu 42.6f und wandelt dann in int 42 um. Daher hat a den Wert 42.
	char eins = 'A', zwei = (char)(eins + (int) y * 3);			// Variable eins ist Buchstabe A. Float 7.11f wird mit 3 zu 21.3f multipliziert und dann in int zu 21 umgewandelt. "Addiert" man zu A 21, also geht man 21 Buchstaben im Alphabet weiter, so landet man bei V.
	
	public void run() {
		System.out.println("Das Ergebnis lautet : " + eins + zwei + " " + a );		// Ausgabe: "Das Ergebnis lautet: AV 42
	}
	
	public static void main(String[] args) {
		Typumwandlung_1 tur =  new Typumwandlung_1();
		tur.run();
	}
}
