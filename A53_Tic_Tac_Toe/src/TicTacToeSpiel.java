/**
 * Ein Tic-Tac-Toe-Spiel
 */
public class TicTacToeSpiel {

    private TicTacToeBrett      brett;
    private TicTacToeSpieler    spieler1;
    private TicTacToeSpieler    spieler2;

    /**
     * Erzeugung eines Standard-Tic-Tac-Toe-Spiels mit zwei Spielern.
     * @param spielerName1 Der Name des ersten Spielers
     * @param spielerName2 Der Name des zweiten Spielers
     */
    public TicTacToeSpiel(String spielerName1, String spielerName2) {

        // Initialisierung der Spieler mit fester Vorgabe ihrer Markierungen
    		spieler1 = new TicTacToeSpieler(spielerName1, TicTacToeMarke.X);
    		spieler2 = new TicTacToeSpieler(spielerName2, TicTacToeMarke.O);
    		
    		brett = new TicTacToeBrett();
    }
    
    /**
     * Bestimmt f&uuml;r eine gegebene Folge von Spielz&uuml;gen den Namen des Spielers,
     * der als erstes eine Gewinnposition erzielt oder "niemand", wenn dies niemandem gelingt.
     * Bei einer ung&uuml;ltigen Folge von Spielz&uuml;gen (null-Referenz, mehrfaches 
     * Setzen eines Felds) wird eine entsprechende Fehlermeldung ausgegeben.
     * @param spielzuege Folge der Spielz&uuml;ge, beginnend mit dem ersten Zug von Spieler 1.
     * @return Name des Siegers bzw. "niemand".
     */
    public String bestimmeSieger(TicTacToeZug[] spielzuege) {
     		
    		String sieger = "niemand";
    		
    		//  Hier Programmtext ergaenzen.
    		
    		return sieger;
    }
        
    /**
     * String-Repr&auml;sentation des Spiels inkl. Brett und Spieler.
     * @return String-Repr&auml;sentation des Spiels
     */
    @Override
    public String toString() {
        return "Spiel zwischen " + spieler1 + " und " + spieler2 + ":\n" + brett;
    }
}
