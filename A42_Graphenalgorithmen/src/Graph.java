import Jama.Matrix;

/**
 * Modellierung eines (gerichteten oder ungerichteten) Graphen.
 * @param <V> Referenzdatentyp f&uuml;r die Elemente, die in den 
 *            Knoten gespeichert werden k&ouml;nnen.
 * @param <E> Referenzdatentyp f&uuml;r die Elemente, die in den 
 *            Kanten gespeichert werden k&ouml;nnen.
 */
public interface Graph<V,E> {

	/**
	 * Liefert die Anzahl der gespeicherten Kanten zu&uuml;ck.
	 * @return Anzahl der gespeicherten Kanten.
	 */
	public int getAnzahlKanten();

	/**
	 * Liefert die Anzahl der gespeicherten Knoten zu&uuml;ck.
	 * @return Anzahl der gespeicherten Knoten.
	 */
	public int getAnzahlKnoten();
	
	/**
	 * Liefert einen durch seine Identifikationsnummer bestimmten
	 * Knoten zur&uuml;ck.
	 * @param index Identifikationsnummer des angefragten Knoten.
	 * @return Referenz auf den spezifizierten Knoten.
	 */
	public Knoten<V> getKnoten(int index);
	
	/**
	 * Liefert eine durch die Identifikationsnummern von
	 * Start- und Endknoten bestimmte Kante zur&uuml;ck.
	 * @param startKnoten Identifikationsnummer des Startknotens.
	 * @param endKnoten   Identifikationsnummer des Endknotens.
	 * @return Referenz auf die spezifizierte Kante.
	 */
	public Kante<E>  getKante(int startKnoten, int endKnoten);

	/**
	 * Liefert eine durch Start- und Endknoten bestimmte Kante zur&uuml;ck.
	 * @param startKnoten Referenz auf den Startknoten.
	 * @param endKnoten   Referenz auf den Endknoten.
	 * @return Referenz auf die spezifizierte Kante.
	 */
	public Kante<E>  getKante(Knoten<V> startKnoten, Knoten<V> endKnoten);
	
	/**
	 * Erzeugt innerhalb des Graphens einen neuen Knoten, der ein
	 * gegebenes Datenelement referenziert.
	 * @param index Identifikationsnummer des zu erzeugenden Knotens.
	 * @param info  Referenz auf das zu speichernde Datenelement.
	 */
	public void fuegeKnotenHinzu(int index, V info);

	/**
	 * Erzeugt innerhalb des Graphens eine neuen Kante, die zwei
	 * bereits existierende Knoten verbindet und ein gegebenes 
	 * Datenelement referenziert.
	 * @param startKnoten Identifikationsnummer des Startknotens.
	 * @param endKnoten   Identifikationsnummer des Endknotens.
	 * @param info        Referenz auf das zu speichernde Datenelement.
	 */
	public void fuegeKanteHinzu(int startKnoten, int endKnoten, E info);
	
	/**
	 * &Uuml;berpr&uuml;ft, ob ein Knoten mit einem gegebenen
	 * Index innerhalb des Graphens existiert.
	 * @param index Index des Knotens.
	 * @return <CODE>true</CODE>, falls der Knoten existiert,
	 *         ansonsten <CODE>false</CODE>.
	 */
	public boolean existiertKnoten(int index);
	
	/**
	 * &Uuml;berpr&uuml;ft, ob eine Kante mit gegebenen
	 * Start- und Endknoten innerhalb des Graphens existiert.
	 * @param startIndex Index des Startknotens.
	 * @param endIndex   Index des Endknotens.
	 * @return <CODE>true</CODE>, falls die Kante existiert,
	 *         ansonsten <CODE>false</CODE>.
	 */
	public boolean existiertKante(int startIndex, int endIndex);
	
	/**
	 * Liest den Knotengrad eines Knotens aus.
	 * @param index Identifikationsnummer des Knotens.
	 * @return Knotengrad des spezifizierten Knotens.
	 */
	public int getKnotengrad(int index);
	
	/**
	 * Liefert die Adjazenzmatrix des Graphens aus.
	 * @return Repr&auml;sentation der Adjazenzmatrix des Graphens.
	 */
	public Matrix getAdjazenzMatrix();
	
}
