public class Duengerstreuer implements Rolle {
	private double kapazitaet;
	
	/**
	 * Setzt die Fassungskapazitaet des Behaelters in Liter
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
	public double getValue() {
		return this.kapazitaet;
	}
	
	/**
	 * Liefert den Einsatzzweck des Traktors
	 * 
	 * @return Einsatzzweck des Traktors
	 */
	public Einsatzzweck getEinsatzzweck() {
		return Einsatzzweck.DUENGERSTREUER;
	}
}
