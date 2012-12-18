import java.util.ArrayList;

/*
 * In dieser Klasse werden verschiedene Kekse gespeichert
 */
public class Kecksdose {
	private ArrayList<Keks> kekse;
	private String beschriftung;
	
	/*
	 * Konstruktor
	 * VB: beschriftung != null
	 */
	public Kecksdose(String beschriftung) {
		this.beschriftung = beschriftung;
	}
	
	/*
	 * gibt den Inhalt der Dose zurueck
	 * NB: liefert String mit allen Keksen
	 */
	public String listeInhalt() {
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
