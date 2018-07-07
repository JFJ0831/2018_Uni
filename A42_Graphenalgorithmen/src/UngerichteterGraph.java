/**
 * Implementierung eines ungerichteten Graphen.
 * Die topologischen Informationen werden in einer Adjazenzmatrix
 * gespeichert.
 * @param <V> Referenzdatentyp f&uuml;r die Elemente, die in den 
 *            Knoten gespeichert werden k&ouml;nnen.
 * @param <E> Referenzdatentyp f&uuml;r die Elemente, die in den 
 *            Kanten gespeichert werden k&ouml;nnen.
 *            
 */
public class UngerichteterGraph<V, E> extends GraphAdjazenzMatrix<V, E> {

	/**
	 * Konstruktor zur Erzeugung eines ungerichteten Graphen mit
	 * einer maximalen Anzahl an Knoten.
	 * @param anzahlKnoten Maximale Anzahl an Knoten.
	 */
	public UngerichteterGraph(int anzahlKnoten){
		super(anzahlKnoten);
	}

	/* (non-Javadoc)
	 * @see graph.Graph#fuegeKanteHinzu(int, int, java.lang.Object)
	 */
	@Override
	public void fuegeKanteHinzu(int startIndex, int endIndex, E info) {
		if (!existiertKnoten(startIndex) || !existiertKnoten(endIndex)) {
			throw new IllegalArgumentException("Zuriff darf nur auf Start-/Endknoten " +
					"mit Index in [0,"+getAnzahlKnoten()+"] erfolgen.");
		}
		if (kanten.get(startIndex).get(endIndex) == null) {
			anzahlKanten++;
		}
		
		// Erzeuge neue Kante.
		Kante<E> neueKante = new Kante<E>(this,Math.min(startIndex,endIndex),Math.max(startIndex, endIndex),info);

		// Fuege Kante "in beide Richtungen" hinzu.
		kanten.get(startIndex).set(endIndex, neueKante);
		kanten.get(endIndex).set(startIndex, neueKante);
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getKnotengrad(int)
	 */
	@Override
	public int getKnotengrad(int index) {
		if (!existiertKnoten(index)) {
			throw new IllegalArgumentException("Zuriff darf nur auf Knoten " +
					"mit Index in [0,"+getAnzahlKnoten()+"] erfolgen.");
		}

		int grad = 0;

		for (int i = 0; i < getAnzahlKnoten(); i++) {
			if (kanten.get(index).get(i) != null) {
				grad++;
			}
		}
		return grad;
	}
}
