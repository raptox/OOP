import java.util.Iterator;

public class Drillmaschine implements Rolle {
	private int saeschare;
	
	/**
	 * Setzt die Anzahl der Saeschare der Drillmaschine
	 * 
	 * @param saeschare Anzahl der Saeschare
	 */
	public Drillmaschine( int saeschare ) {
		this.saeschare = saeschare;
	}
	
	/**
	 * Liefert die Anzahl der Saeschare
	 * 
	 * @return saeschare
	 */
	public double getValue() {
		return this.saeschare;
	}
	
	/**
	 * Liefert den Einsatzzweck des Traktors
	 * 
	 * @return Einsatzzweck des Traktors
	 */
	public Einsatzzweck getEinsatzzweck() {
		return Einsatzzweck.DRILLMASCHINE;
	}
	
	/*
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Jakob Kremsner")
	public String toString(){
		return "Drillmaschiene" + " Saeschare = "+this.getValue();
	}
}
