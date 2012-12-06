public abstract class AbstractTraktor {
	private int nummer;
	private double betriebsstunden;
	
	private Rolle einsatzzweck;
	
	/**
	 * Konstruktor von AbstractTraktor setzt die eindeutige Nummer, anfaengliche Betriebsstunden und den Einsatzzweck
	 * 
	 * @param nummer Eindeutige nummer
	 * @param betriebsstunden Anfaengliche Betriebsstunden des Traktors >= 0
	 * @param einsatzzweck Einsatzzweck des Traktors
	 */
	public AbstractTraktor( int nummer, double betriebsstunden, Rolle einsatzzweck ) {
		this.nummer = nummer;
		this.betriebsstunden = betriebsstunden;
		this.einsatzzweck = einsatzzweck;
	}
	
	/**
	 * Liefert die Nummer des Traktors
	 * 
	 * @return nummer
	 */
	public int getNummer() {
		return this.nummer;
	}
	
	/**
	 * Liefert die Anzahl der Betriebsstunden
	 * 
	 * @return betriebsstunden
	 */
	public double getBetriebsstunden() {
		return this.betriebsstunden;
	}
	
	/**
	 * Vorbedingung: stunden > 0
	 * 
	 * Erhoeht die Anzahl der Betriebsstunden um die uebergebene Anzahl von Stunden
	 * 
	 * @param stunden - Anzahl der Stunden die zu den Betriebsstunden hinzugerechnet werden sollen
	 */
	public void erhoeheBetriebsstunden( double stunden ) {
		this.betriebsstunden += stunden;
	}
	
	/**
	 * Liefert den Einsatzzweck des Traktors
	 * 
	 * @return einsatzzweck
	 */
	public Rolle getEinsatzzweck() {
		return this.einsatzzweck;
	}
	
	/**
	 * Aendert den Einsatzzweck des Traktors
	 * 
	 * @param einsatzzweck Neuer Einsatzzweck des Traktors
	 */
	public void setEinsatzzweck( Rolle einsatzzweck ) {
		this.einsatzzweck = einsatzzweck;
	}
	
	/**
	 * Liefert den Typ des Motor des Traktors
	 * 
	 * @return Motor Enum Wert
	 */
	public abstract Motor getMotor();
}

