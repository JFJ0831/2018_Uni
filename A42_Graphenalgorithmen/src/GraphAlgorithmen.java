import java.util.Vector;

import Jama.EigenvalueDecomposition;
import Jama.Matrix;

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
		
		// Schleife über die Anzahl der Knoten im Graphen.
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
			// Normalisierung des Knotengrades bzgl. des maximal möglichen Knotengrads.
			double normMaxMoeglich = graph.getKnotengrad(i) / (graph.getAnzahlKnoten() - 1);
			// Hinzufuegen des normalisierten Knotengrads an der Stelle i zu dem Vektor.
			zentralitaeten.add(i, normMaxMoeglich);
		}
		
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
		
		// Initialisierung des maximal auftretenden Knotengrads mit dem Wert 0.
		int maxAuftretend = 0;
		
		// Schleife über die Anzahl der Knoten im Graphen.
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
			// Speichern des aktuellen Knotengrads, falls dieser groesser als alle vorherigen ist.
			if (graph.getKnotengrad(i) > maxAuftretend) {
				maxAuftretend = graph.getKnotengrad(i);
			}
		}
		
		// Schleife über die Anzahl der Knoten im Graphen.
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
			// Normalisierung des Knotengrades bzgl. des maximal auftretenden Knotengrads.
			double normMaxAuftretend = graph.getKnotengrad(i) / maxAuftretend;
			// Hinzufuegen des normalisierten Knotengrads an der Stelle i zu dem Vektor.
			zentralitaeten.add(i, normMaxAuftretend);
		}
		
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

		// Initialisierung der Summe der Knotengrade mit 0.
		int summe = 0;
		
		// Schleife über die Anzahl der Knoten im Graphen.
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
			// Hinzufuegern des aktuellen Knotengrads zur Summe der Knotengrade.
			summe += graph.getKnotengrad(i);
		}
		
		// Schleife über die Anzahl der Knoten im Graphen.
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
			// Normalisierung des Knotengrades bzgl. der Summe der Knotengrade.
			double normSumme = graph.getKnotengrad(i) / summe;
			// Hinzufuegen des normalisierten Knotengerads an der Stelle i zu dem Vektor.
			zentralitaeten.add(i, normSumme);
		}

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
		Matrix transponierteAdjazenzMatrix = graph.getAdjazenzMatrix().transpose();
		EigenvalueDecomposition eigenwertZerlegung = transponierteAdjazenzMatrix.eig();
		
		// Finde den groessten Eigenwert, indem die reellen Teile der
		// zuvor berechneten Zerlegung betrachtet werden.
		double[] reelleEigenwerte = eigenwertZerlegung.getRealEigenvalues();
		int indexGroessterEigenwert = 0;
		for (int i = 1; i < reelleEigenwerte.length; i++) {
			if (reelleEigenwerte[i] > reelleEigenwerte[indexGroessterEigenwert]) {
				indexGroessterEigenwert = i;
			}
		}
		double groessterEigenwert = reelleEigenwerte[indexGroessterEigenwert];
		
		// Lies die Eigenvektoren zu den Eigenwerten aus.
		Matrix eigenvektoren = eigenwertZerlegung.getV();
		
		
		// Kopiere den Eigenvektor zum groessten Eigenwert.
		for (int i = 0; i < graph.getAnzahlKnoten(); i++) {
		eigenvektor.add(i, eigenvektoren.get(i, indexGroessterEigenwert));
		}

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
