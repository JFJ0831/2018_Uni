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
    	
    	if (eingabe == null)
    		throw new IllegalArgumentException("Argument darf nicht null sein.");
    	
    	this.eingabe = eingabe.toLowerCase();
    	String reverse = "";
    	
    	for (int i = this.eingabe.length() - 1; i >= 0; i--)
    		if (!Character.isAlphabetic(this.eingabe.charAt(i)))
    			eingabe.replace(this.eingabe.charAt(i), Character.MIN_VALUE);
    	
    	for (int i = this.eingabe.length() - 1; i >= 0; i--)
    		reverse += this.eingabe.charAt(i);
    	
    	if (this.eingabe.matches(reverse))
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
    	
    	if (eingabe == null)
    		throw new IllegalArgumentException("Argument darf nicht null sein.");
    	
    	this.eingabe = eingabe.replace(" ", "");
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
    	
    	for (int i = this.eingabe.length() - 1; i >= 0; i--)
    		if (!Character.isAlphabetic(this.eingabe.charAt(i)))
    			eingabe.replace(this.eingabe.charAt(i), Character.MIN_VALUE);
    	
        return istPalindrom(this.eingabe);

    }

}
