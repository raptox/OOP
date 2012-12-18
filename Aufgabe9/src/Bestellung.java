import java.util.ArrayList;


public class Bestellung {
	private ArrayList<Position> positionen;
	
	/*
	 * Konstruktor
	 * VB: positionen != null
	 */
	public Bestellung(ArrayList<Position> positionen){
		this.positionen = positionen;
	}
	/*
	 * Die Methode drucke gibt einen String aller toString Methoden
	 * der gespeicherten Positionen zurueck
	 */
	public String drucke(){
		String s = "";
		for(int i = 0;i<positionen.size();i++){
			s += positionen.get(i) + "\n";
		}
		return s;
	}
	/*
	 * liefert eine ArrayList von Positionen zurueck
	 */
	public ArrayList<Position> getPositionen() {
		return positionen;
	}
}
