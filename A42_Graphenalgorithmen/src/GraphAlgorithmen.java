import java.util.Vector;

/**
 *  Sammlung verschiedener Graphalgorithmen.
 */
public class GraphAlgorithmen {

	/**
	 * Bestimme f&uuml;r jeden Knoten eines gegebenen Graphen seine
	 * Knotengrad-Zentralit&auml;t. Normiere diese bez&uuml;glich des
	 * maximal m&ouml;glichen Knotengrads
	 * @param graph Zu verarbeitender Graph
	 * @return Feld der Knotengrad-Zentralit&auml;ten
	 */
	public static Vector<Double> berechneKgZMaxMoeglich(Graph<?,?> graph) {
		
		// Erzeuge einen Vektor zum Speichern der berechneten Zentralitaeten
		Vector<Double> zentralitaeten = new Vector<Double>(graph.getAnzahlKnoten());
		
		/*
		 * Programmtext hier ergaenzen.
		 */
		
		// Gib den Vektor der berechneten Werte zurueck
		return zentralitaeten;
	}
	
	/**
	 * Bestimme f&uuml;r jeden Knoten eines gegebenen Graphen seine
	 * Knotengrad-Zentralit&auml;t. Normiere diese bez&uuml;glich des
	 * maximal auftretenden Knotengrads
	 * @param graph Zu verarbeitender Graph
	 * @return Feld der Knotengrad-Zentralit&auml;ten
	 */
	public static Vector<Double> berechneKgZMaxAuftretend(Graph<?,?> graph) {
		
		// Erzeuge einen Vektor zum Speichern der berechneten Zentralitaeten
		Vector<Double> zentralitaeten = new Vector<Double>(graph.getAnzahlKnoten());
		
		/*
		 * Programmtext hier ergaenzen.
		 */
		
		// Gib den Vektor der berechneten Werte zurueck
		return zentralitaeten;	
	}
	
	/**
	 * Bestimme f&uuml;r jeden Knoten eines gegebenen Graphen seine
	 * Knotengrad-Zentralit&auml;t. Normiere diese bez&uuml;glich der 
	 * Summe der Knotengrade.
	 * @param graph Zu verarbeitender Graph
	 * @return Feld der Knotengrad-Zentralit&auml;ten
	 */
	public static Vector<Double> berechneKgZSumme(Graph<?,?> graph) {

		// Erzeuge einen Vektor zum Speichern der berechneten Zentralitaeten
		Vector<Double> zentralitaeten = new Vector<Double>(graph.getAnzahlKnoten());

		/*
		 * Programmtext hier ergaenzen.
		 */

		// Gib den Vektor der berechneten Werte zurueck
		return zentralitaeten;	
	}
	
	/**
	 * Bestimme f&uuml;r jeden Knoten eines gegebenen Graphen seine
	 * Eigenwert-Zentralit&auml;t.
	 * @param graph  Zu verarbeitender Graph.
	 * @return Feld der Eigenwert-Zentralit&auml;ten.
	 */
	public static Vector<Double> berechneEigenwertZentralitaet(Graph<?,?> graph) {
		
		// Erzeuge den spaeter zurueckzugebenden Eigenvektor
		Vector<Double> eigenvektor = new Vector<Double>(graph.getAnzahlKnoten());

		// Berechne die Eigenwertzerlegung der transponierten Adjazenzmatrix

		
		
		// Finde den groessten Eigenwert, indem die reellen Teile der
		// zuvor berechneten Zerlegung betrachtet werden.

		
		
		// Lies die Eigenvektoren zu den Eigenwerten aus.

		
		
		// Kopiere den Eigenvektor zum groessten Eigenwert.


		// Gebe den berechneten Eigenvektor zurueck.
		return eigenvektor;
	}	
	
	/**
	 * Hilfsfunktion zur Ausgabe des Graphen auf der Konsole.
	 * @param graph  Zu verarbeitender Graph.
	 */
	public static void print(Graph<?, Double> graph) {
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
			for (int j = 0; j < graph.getAnzahlKnoten(); j++) {
				if (graph.existiertKante(i,j)) {
					System.out.print(graph.getKante(i,j).getInfo()+"  ");					
				}
				else {
					System.out.print(" .   ");					
				}
			}
			System.out.println();
		}
		System.out.println();
	}

}
