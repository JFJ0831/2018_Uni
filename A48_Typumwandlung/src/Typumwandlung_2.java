
public class Typumwandlung_2 {

	double m = 8.7, n = 22.6;
	int i = 4, j = 5;
	char a = 'F';
	float p = 15.4f, q = 7.2f;
	
	public void run() {
		a = (char) m;				// Explizite Typumwandlung notwendig, da char ein niederwertiger Datentyp als double ist, und somit keine implizite Typumwandlung automatisch stattfinden kann.
		q = (float) (n + i);		// Explizite Typumwandlung notwendig, da n vom Typ double ist, waehrend q nur vom Typ float ist. Eine implizite Typumwandlung findet nur beim int i statt.
		m = (p * j);				// Explizite Typumwandlung nicht notwendig, da p und j aufgrund ihrer niederwertigkeit gegenueber m schon automatisch umgewandelt werden.
		p = j + (float) n;			// Explizite Typumwandlung notwendig, da n vom Typ double ist, waehrend p nur vom Typ float ist. Eine implizite Typumwandlung findet nur beim int j statt.
		
		System.out.println(a);
		System.out.println(q);
		System.out.println(m);
		System.out.println(p);
	}
	
	public static void main(String[] args) {
		Typumwandlung_2 tur =  new Typumwandlung_2();
		tur.run();
	}
}