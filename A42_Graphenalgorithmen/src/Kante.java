/**
 * Repr&auml;sentiert eine Kante in einem Graphen.
 * Jede Kante speichert die Indizes ihrer beiden Endknoten
 * und ein Datenelement. 
 * @param <T> Referenzdatentyp der Elemente, die zu den
 *            Kanten gespeichert werden sollen.
 */
public class Kante<T> {

	private int startIndex;
	private int endIndex;
	private Graph<?,T> graph;
	private T info;
	
	/**
	 * Konstruktor f&uuml;r eine Kante. Mit Ausnahme der Referenz auf
	 * das Datenelement sind alle Attribute konstant.
	 * 
	 * @param graph      Referenz auf den Graphen, zu dem diese
	 *                   Kante geh&ouml;rt.
	 * @param startIndex Identifikationsnummer des Startknotens 
	 *                   dieser Kante innerhalb des Graphens.
	 * @param endIndex   Identifikationsnummer des Endknotens 
	 *                   dieser Kante innerhalb des Graphens.
	 * @param info       Referenz auf das zu speichernde Datenelement.
	 */
	public Kante(Graph<?, T> graph, int startIndex, int endIndex, T info) {
		if (graph == null) {
			throw new IllegalArgumentException("Die Kante muss zu einem Graphen gehoeren.");
		}
		this.graph      = graph;
		
		if (!graph.existiertKnoten(startIndex)) {
			throw new IllegalArgumentException("Startknoten muss existieren.");
		}
		this.startIndex = startIndex;

		if (!graph.existiertKnoten(endIndex)) {
			throw new IllegalArgumentException("Startknoten muss existieren.");
		}
		this.endIndex   = endIndex;
	
		this.info       = info;
	}

	/**
	 * Liest den Index des Startknotens aus.
	 * @return Index des Startknotens.
	 */
	public int getStartIndex() {
		return startIndex;
	}

	/**
	 * Liest den Index des Endknotens aus.
	 * @return Index des Endknotens.
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * Liest den enthaltenden Graphen aus.
	 * @return Referenz auf den enthaltenden Graphen.
	 */
	public Graph<?, T> getGraph() {
		return graph;
	}

	/**
	 * Liest das gespeicherte Datenelement aus.
	 * @return Referenz auf das gespeicherte Datenelement.
	 */
	public T getInfo() {
		return info;
	}

	/**
	 * Setzt das gespeicherte Datenelement
	 * @param info Referenz auf zu speichernde Datenelement.
	 */
	public void setInfo(T info) {
		this.info = info;
	}
	
}
