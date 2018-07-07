import java.util.Vector;

import Jama.Matrix;

/**
 * Modellierung eines (gerichteten oder ungerichteten) Graphen.
 * Die topologischen Informationen werden in einer Adjazenzmatrix
 * gespeichert.
 * @param <V> Referenzdatentyp f&uuml;r die Elemente, die in den 
 *            Knoten gespeichert werden k&ouml;nnen.
 * @param <E> Referenzdatentyp f&uuml;r die Elemente, die in den 
 *            Kanten gespeichert werden k&ouml;nnen.
 */
public abstract class GraphAdjazenzMatrix<V, E> implements Graph<V, E> {

	protected Vector<Knoten<V> > knoten;
	protected Vector< Vector<Kante<E> > > kanten;
	protected int anzahlKanten;
	
	public GraphAdjazenzMatrix(int anzahlKnoten){
		knoten = new Vector<Knoten<V> >(anzahlKnoten);
		knoten.setSize(anzahlKnoten);
		kanten = new Vector<Vector<Kante<E>>> (anzahlKnoten);
		for (int i = 0; i < anzahlKnoten; i++) {
			Vector<Kante<E>> zeile = new Vector<Kante<E>>(anzahlKnoten);
			zeile.setSize(anzahlKnoten);
			kanten.add(zeile);
		}
		anzahlKanten = 0;
	}
	
	/* (non-Javadoc)
	 * @see graph.Graph#getAnzahlKanten()
	 */
	@Override
	public int getAnzahlKanten() {
		return anzahlKanten;
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getAnzahlKnoten()
	 */
	@Override
	public int getAnzahlKnoten() {
		return knoten.size();
	}
	
	/* (non-Javadoc)
	 * @see graph.Graph#getKnoten(int)
	 */
	@Override
	public Knoten<V> getKnoten(int index) {
		if (!existiertKnoten(index)) {
			throw new IllegalArgumentException("Zuriff darf nur auf Knoten " +
					"mit Index in [0,"+getAnzahlKnoten()+"] erfolgen.");
		}
		return knoten.get(index);
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getKante(int, int)
	 */
	@Override
	public Kante<E> getKante(int startIndex, int endIndex) {
		if (!existiertKnoten(startIndex) || !existiertKnoten(endIndex)) {
			throw new IllegalArgumentException("Zuriff darf nur auf Start-/Endknoten " +
					"mit Index in [0,"+getAnzahlKnoten()+"] erfolgen.");
		}
		return kanten.get(startIndex).get(endIndex);
	}

	/* (non-Javadoc)
	 * @see graph.Graph#getKante(graph.Knoten, graph.Knoten)
	 */
	@Override
	public Kante<E> getKante(Knoten<V> startKnoten, Knoten<V> endKnoten) {
		if (this != startKnoten.getGraph() || this != endKnoten.getGraph()) {
			throw new IllegalArgumentException("Beide Knoten muessen in diesem Graphen sein.");
		}
		return this.getKante(startKnoten.getIndex(),endKnoten.getIndex());
	}

	/* (non-Javadoc)
	 * @see graph.Graph#fuegeKnotenHinzu(int, java.lang.Object)
	 */
	@Override
	public void fuegeKnotenHinzu(int index, V info) {
		if (index < 0 || index >= getAnzahlKnoten()) {
			throw new IllegalArgumentException("Zuriff darf nur auf Knoten " +
					"mit Index in [0,"+getAnzahlKnoten()+"] erfolgen.");
		}
		knoten.set(index, new Knoten<V>(this, index, info));
	}

	/* (non-Javadoc)
	 * @see graph.Graph#existiertKnoten(int)
	 */
	@Override
	public boolean existiertKnoten(int index) {
		return (index >= 0                  &&
				index <  getAnzahlKnoten()  &&
				knoten.get(index) != null);
				
	}

	/* (non-Javadoc)
	 * @see graph.Graph#existiertKante(int, int)
	 */
	@Override
	public boolean existiertKante(int startIndex, int endIndex) {
		if (!existiertKnoten(startIndex) || !existiertKnoten(endIndex)) {
			throw new IllegalArgumentException("Zuriff darf nur auf Start-/Endknoten " +
					"mit Index in [0,"+getAnzahlKnoten()+"] erfolgen.");
		}
		return (kanten.get(startIndex).get(endIndex) != null);
	}
	
	/* (non-Javadoc)
	 * @see graph.Graph#getAdjazenzMatrix()
	 */
	@Override
	public Matrix getAdjazenzMatrix() {

		// Erstelle neue Matrix, die mit Nullen initialisiert ist.
		Matrix m = new Matrix(getAnzahlKnoten(), getAnzahlKnoten());
		
		// Kopiere die Adjazenzmatrix in diese Matrix.
		for(int i = 0; i < getAnzahlKnoten(); i++) {
			for (int j = 0; j < getAnzahlKnoten(); j++) {
				if (existiertKante(i, j)) {
					m.set(i, j, 1.0);
				}
			}
		}
		
		return m;
	}
	
	public void toLATEX(Matrix em) {
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("%%% Darstellung der Matrix: ");
		System.out.println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%");
		System.out.println("\\begin{center}");
		System.out.print("  \\begin{tabular}{c|");
		for(int i = 0; i < this.getAnzahlKnoten(); i++) {
			System.out.print("c|");
		}
		System.out.println("}");
		System.out.print("    \\multicolumn{1}{c}{\\hspace*{1ex}} ");
		for(int i = 0; i < this.getAnzahlKnoten(); i++) {
			System.out.print("& \\multicolumn{1}{c}{");
			System.out.print("" + i + "} ");
		}
		System.out.println(" \\\\");
		for(int zeile = 0; zeile < this.getAnzahlKnoten(); zeile++) {
			System.out.println("    \\cline{2-" + (this.getAnzahlKnoten() + 1) + "}");
			System.out.print("    " + zeile );
			for(int spalte = 0; spalte < this.getAnzahlKnoten(); spalte++) {
				System.out.print(" &");
				System.out.print(em.get(zeile, spalte) == 1 ? " \\Wtrue " : " \\Wfalse");
			}
			System.out.println(" \\\\");
		}
		System.out.println("    \\cline{2-" + (this.getAnzahlKnoten() + 1) + "}");
		System.out.println("  \\end{tabular}");
		System.out.println("\\end{center}");
		System.out.println();
	}
}
