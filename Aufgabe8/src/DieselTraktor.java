public class DieselTraktor extends AbstractTraktor {
	private int verbrauchteLiterDiesel;
	
	/**
	 * Konstruktor von DieselTraktor setzt die eindeutige Nummer, anfaengliche Betriebsstunden, Einsatzzweck und die anfaengliche Anzahl
	 * verbrauchter Liter Diesel
	 * 
	 * @param nummer Eindeutige nummer
	 * @param betriebsstunden Anfaengliche Betriebsstunden des Traktors >= 0
	 * @param einsatzzweck Einsatzzweck des Traktors
	 * @param verbrauchteLiterDiesel Anfaengliche verbrauchte Liter Diesel des Traktors >= 0
	 */
	public DieselTraktor( int nummer, double betriebsstunden, Rolle einsatzzweck, int verbrauchteLiterDiesel ) {
		super( nummer, betriebsstunden, einsatzzweck );
		
		this.verbrauchteLiterDiesel = verbrauchteLiterDiesel;
	}
	
	/**
	 * Liefert die Menge der bis jetzt verbrauchten Liter Diesel
	 * 
	 * @return verbrauchteLiter
	 */
	public double getVerbrauchteLiterDiesel() {
		return this.verbrauchteLiterDiesel;
	}
	
	/**
	 * Vorbedingung: liter > 0
	 * 
	 * Erhoeht die Anzahl der verbrauchten Liter Diesel um die uebergebene Anzahl von Liter Diesel
	 * 
	 * @param liter - Anzahl der Liter Diesel die zu den verbrauchten Litern Diesel hinzugerechnet werden sollen
	 */
	public void erhoeheverbrauchteLiterDiesel( int liter ) {
		this.verbrauchteLiterDiesel += liter;
	}
	
	/**
	 * Liefert den Typ des Motor des Traktors
	 * 
	 * @return Motor Enum Wert
	 */
	public Motor getMotor() {
		return Motor.DIESELTRAKTOR;
	}
}
