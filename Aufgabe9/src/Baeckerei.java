import java.util.ArrayList;

/*
 * diese Klasse nimmt Bestellungen auf und erzeugt Kekse wenn die Bestellungen geliefert werden
 */
public class Baeckerei {
	private String name;
	private ArrayList bestellungen;
	
	/*
	 * Konstruktor
	 * VB: name != null
	 */
	public Baeckerei(String name) {
		this.name = name;
		bestellungen = new ArrayList();
	}
	
	/*
	 * Fuegt neue Bestellung hinzu
	 * VB: a != null
	 */
	public void neueBestellung(Bestellung a) {
		bestellungen.add(a);
	}
	
	/*
	 * Zeigt alle Bestellungen an
	 * NB: liefert String mit allen Bestellungen
	 */
	public String zeigeBestellungen() {
		String best = "";
		
		for (int i=0; i<bestellungen.size(); i++) {
			best = best + "Bestellung "+ i + ":\n" + bestellungen.get(i) + "\n";
		}
		
		return best;
	}
	
	public Kecksdose liefereBestellungen() {
		
	}
}
