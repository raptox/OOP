import java.util.Iterator;

/**
 * AbstractTraktor stellt die Oberklasse eines Traktors da mit einer eindeutigen Nummer, start Betriebsstunden und einem Einsatzzweck/Rolle
 */
@Programmierer(autoren="Bernd Artmueller")
public abstract class AbstractTraktor implements CollectionItem {
	private int nummer;
	private double betriebsstunden;
	
	private Rolle rolle;
	
	/**
	 * Konstruktor von AbstractTraktor setzt die eindeutige Nummer, anfaengliche Betriebsstunden und den Einsatzzweck
	 * 
	 * @param nummer Eindeutige nummer
	 * @param betriebsstunden Anfaengliche Betriebsstunden des Traktors >= 0
	 * @param rolle Rolle des Traktors != null
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public AbstractTraktor( int nummer, double betriebsstunden, Rolle rolle ) {
		this.nummer = nummer;
		this.betriebsstunden = betriebsstunden;
		this.rolle = rolle;
	}
	
	/**
	 * Liefert die Nummer des Traktors
	 * 
	 * @return nummer
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public int getNummer() {
		return this.nummer;
	}
	
	/**
	 * Liefert die Anzahl der Betriebsstunden
	 * 
	 * @return betriebsstunden
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double getBetriebsstunden() {
		return this.betriebsstunden;
	}
	
	/**
	 * Vorbedingung: stunden > 0
	 * 
	 * Erhoeht die Anzahl der Betriebsstunden um die uebergebene Anzahl von Stunden
	 * 
	 * stunden > 0
	 * 
	 * @param stunden - Anzahl der Stunden die zu den Betriebsstunden hinzugerechnet werden sollen
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public void erhoeheBetriebsstunden( double stunden ) {
		this.betriebsstunden += stunden;
	}
	
	/**
	 * Liefert den Einsatzzweck/Rolle des Traktors
	 * 
	 * @return rolle
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public Rolle getRolle() {
		return this.rolle;
	}
	
	/**
	 * Aendert den Einsatzzweck des Traktors
	 * 
	 * rolle != null
	 * 
	 * @param rolle Neuer Einsatzzweck des Traktors
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public void setRolle( Rolle rolle ) {
		this.rolle = rolle;
	}
	
	/**
	 * Liefert den Typ des Motor des Traktors
	 * 
	 * @return Motor Enum Wert
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public abstract Motor getMotor();
	
	/**
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Jakob Kremsner")
	public String toString(){
		return "ID = "+this.nummer+", Betriebsstunden = "+this.betriebsstunden+", Rolle = "+this.rolle;
	}
}

