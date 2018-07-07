/**
 * Repr&auml;sentiert einen Knoten in einem Graphen.
 * Jeder Knoten speichert eine Identifikationsnummer
 * und ein Datenelement, diese Nummer ist der Index 
 * des Knotens in der Menge der Knoten des Graphen. 
 * Die topologischen Informationen 
 * werden nicht im Knoten gespeichert.
 * @param <T> Referenzdatentyp der Elemente, die in den
 *            Knoten gespeichert werden sollen.
 */
public class Knoten<T> {

	private T info;
	private int index;
	private Graph<T,?> graph;

	/**
	 * Konstruktor f&uuml;r einen Knoten.
	 * @param graph Referenz auf den Graphen, zu dem dieser
	 *              Knoten geh&ouml;rt.
	 * @param index Identifikationsnummer des Knotens innerhalb
	 *              des Graphens.
	 * @param info  Referenz auf das zu speichernde Datenelement.
	 */
	public Knoten(Graph<T,?> graph, int index, T info) {
		this.graph = graph;
		this.index = index;
		this.info  = info;
	}

	/**
	 * Liest den enthaltenden Graphen aus.
	 * @return Referenz auf den enthaltenden Graphen.
	 */
	public Graph<T, ?> getGraph() {
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
	
	/**
	 * Liest die Identifikationsnummer aus.
	 * @return Identifikationsnummer des Knotens.
	 */
	public int getIndex() {
		return index;
	}
	
	@Override
	public String toString() {
		return "Knoten " + getIndex() + " (" + getInfo() + ")";
	}
	
}
