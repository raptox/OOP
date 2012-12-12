/**
 * Duengerstreuer stellt einen konkreten Einsatzzweck eines Traktors dar mit einer uebergebenen Fassungskapazitaet an Duengemittel. Also eine Rolle. 
 */
@Programmierer(autoren="Bernd Artmueller")
public class Duengerstreuer implements Rolle {
	private double kapazitaet;
	
	/**
	 * Setzt die Fassungskapazitaet des Behaelters in Liter
	 * 
	 * kapazitaet > 0
	 * 
	 * @param kapazitaet Fassungskapazitaet des Behaelters in Liter
	 */
	public Duengerstreuer( double kapazitaet ) {
		this.kapazitaet = kapazitaet;
	}
	
	/**
	 * Liefert die Fassungskapazitaet des Behaelters in Liter
	 * 
	 * @return saeschare
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double getValue() {
		return this.kapazitaet;
	}
	
	/**
	 * Liefert den Einsatzzweck des Traktors
	 * 
	 * @return Einsatzzweck des Traktors
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public Einsatzzweck getEinsatzzweck() {
		return Einsatzzweck.DUENGERSTREUER;
	}
	
	/**
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Jakob Kremsner")
	public String toString(){
		return "Duengerstreuer" + " Kapazitaet = "+this.getValue() ;
	}
}
