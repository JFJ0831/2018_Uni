/**
 * &Uuml;berpr&uuml;fung der Eigenschaft, ein Palindrom zu sein.
 */
public class PalindromPruefer {
	
	private String eingabe;

    /**
     * &Uuml;berpr&uuml;fe, ob die &uuml;bergebene Zeichenkette
     * ein Palindrom ist. Hierbei soll nicht zwischen Gross- und
     * Kleinbuchstaben unterschieden werden.
     * @param eingabe Zu testende Zeichenkette.
     * @return <CODE>true</CODE>, wenn die Zeichenkette ein Palindrom
     *         ist, <CODE>false</CODE> sonst.
     */
    public boolean istPalindrom(String eingabe) {
    	
    	if (eingabe == null)														// Fehler falls die Eingabe null ist.
    		throw new IllegalArgumentException("Argument darf nicht null sein.");
    	
    	this.eingabe = eingabe.toLowerCase();										// Wandelt alle grossen Zeichen in kleine um.
    	String reverse = "";
    	
    	for (int i = this.eingabe.length() - 1; i >= 0; i--)						// Schleife ueber die Laenge des eingabe-Strings.
    		if (!Character.isAlphabetic(this.eingabe.charAt(i)))					// Ersetzt alle Zeichen die nicht ""isAlphabetic" sind durch den niedrigsten Wert der Unicode-Tabelle
    			eingabe.replace(this.eingabe.charAt(i), Character.MIN_VALUE);
    	
    	for (int i = this.eingabe.length() - 1; i >= 0; i--)						// Schleife ueber die Laenge des eingabe-Strings.
    		reverse += this.eingabe.charAt(i);										// Haengt die Zeichen des Eingabestrings in umgekehrter Reihenfolge in einem neuen String aneinander.
    	
    	if (this.eingabe.matches(reverse))											// vergleicht eingabe-Sring und reverse-String.
    		return true;
    	else 
    		return false;

    }

    /**
     * &Uuml;berpr&uuml;fe, ob die &uuml;bergebene Zeichenkette
     * ein Satzpalindrom ist. Hierbei soll nicht zwischen Gross- und
     * Kleinbuchstaben unterschieden werden.
     * @param eingabe Zu testende Zeichenkette.
     * @return <CODE>true</CODE>, wenn die Zeichenkette ein Palindrom
     *         ist, <CODE>false</CODE> sonst.
     */
    public boolean istSatzPalindrom(String eingabe) {
    	
    	if (eingabe == null)														// Fehler falls die Eingabe null ist.
    		throw new IllegalArgumentException("Argument darf nicht null sein.");
    	
    	this.eingabe = eingabe.replace(" ", "");									// Im folgenden werden alle gaengigen Satzzeichen entfernt.
    	this.eingabe = this.eingabe.replace(".", "");
    	this.eingabe = this.eingabe.replace(",", "");
    	this.eingabe = this.eingabe.replace(";", "");
    	this.eingabe = this.eingabe.replace(":", "");
    	this.eingabe = this.eingabe.replace("!", "");
    	this.eingabe = this.eingabe.replace("?", "");
    	this.eingabe = this.eingabe.replace("-", "");
    	this.eingabe = this.eingabe.replace("'", "");
    	this.eingabe = this.eingabe.replace("´", "");
    	this.eingabe = this.eingabe.replace("`", "");
    	
    	for (int i = this.eingabe.length() - 1; i >= 0; i--)						// Schleife ueber die Laenge des eingabe-Strings.
    		if (!Character.isAlphabetic(this.eingabe.charAt(i)))					// Ersetzt alle Zeichen die nicht ""isAlphabetic" sind durch den niedrigsten Wert der Unicode-Tabelle.
    			eingabe.replace(this.eingabe.charAt(i), Character.MIN_VALUE);
    	
        return istPalindrom(this.eingabe);

    }

}
