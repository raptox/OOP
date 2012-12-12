/**
 * Drillmaschine stellt einen konkreten Einsatzzweck eines Traktors dar mit einer uebergebenen Anzahl an Saescharen. Also eine Rolle. 
 */
@Programmierer(autoren="Bernd Artmueller")
public class Drillmaschine implements Rolle {
	private int saeschare;
	
	/**
	 * Setzt die Anzahl der Saeschare der Drillmaschine
	 * 
	 * saeschare > 0
	 * 
	 * @param saeschare Anzahl der Saeschare
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public Drillmaschine( int saeschare ) {
		this.saeschare = saeschare;
	}
	
	/**
	 * Liefert die Anzahl der Saeschare
	 * 
	 * @return saeschare
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double getValue() {
		return this.saeschare;
	}
	
	/**
	 * Liefert den Einsatzzweck des Traktors
	 * 
	 * @return Einsatzzweck des Traktors
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public Einsatzzweck getEinsatzzweck() {
		return Einsatzzweck.DRILLMASCHINE;
	}
	
	/**
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Jakob Kremsner")
	public String toString(){
		return "Drillmaschiene" + " Saeschare = "+this.getValue();
	}
}
