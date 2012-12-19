import java.util.ArrayList;

/*
 * In dieser Klasse werden verschiedene Kekse gespeichert
 * Klasse kann auch oeffentlich verwendet werden, addKeks ist oeffentlich, weil jeder
 * einen Keks hinzufuegen kann, nicht nur die Baekerei
 */
public class Keksdose {
	private ArrayList<Keks> kekse;
	private String beschriftung;
	
	/*
	 * Konstruktor
	 * VB: beschriftung != null
	 */
	public Keksdose(String beschriftung) {
		this.beschriftung = beschriftung;
		this.kekse = new ArrayList<Keks>();
	}
	
	/*
	 * gibt den Inhalt der Dose zurueck
	 * NB: liefert String mit allen Keksen
	 */
	public String inhalt() {
		String inh = beschriftung + "\n";
		
		for (int i=0; i<kekse.size(); i++) {
			inh += kekse.get(i).toString() + "\n";
		}
		
		return inh;
	}
	
	/*
	 * Fuegt neuen Keks hinzu
	 * VB: keks != null
	 */
	public void addKeks(Keks keks) {
		kekse.add(keks);
	}
}
