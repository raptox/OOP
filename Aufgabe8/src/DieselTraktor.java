/**
 * DieselTraktor erbt von AbstractTraktor und stellt einen konkreten Dieseltraktor dar.
 */
@Programmierer(autoren="Bernd Artmueller")
public class DieselTraktor extends AbstractTraktor {
	private int verbrauchteLiterDiesel;
	
	/**
	 * Konstruktor von DieselTraktor setzt die eindeutige Nummer, anfaengliche Betriebsstunden, Einsatzzweck und die anfaengliche Anzahl
	 * verbrauchter Liter Diesel
	 * 
	 * @param nummer Eindeutige nummer
	 * @param betriebsstunden Anfaengliche Betriebsstunden des Traktors >= 0
	 * @param einsatzzweck Einsatzzweck/Rolle des Traktors
	 * @param verbrauchteLiterDiesel Anfaengliche verbrauchte Liter Diesel des Traktors >= 0
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public DieselTraktor( int nummer, double betriebsstunden, Rolle einsatzzweck, int verbrauchteLiterDiesel ) {
		super( nummer, betriebsstunden, einsatzzweck );
		
		this.verbrauchteLiterDiesel = verbrauchteLiterDiesel;
	}
	
	/**
	 * Liefert die Menge der bis jetzt verbrauchten Liter Diesel
	 * 
	 * @return verbrauchteLiter
	 */
	@Programmierer(autoren="Bernd Artmueller")
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
	@Programmierer(autoren="Bernd Artmueller")
	public void erhoeheverbrauchteLiterDiesel( int liter ) {
		this.verbrauchteLiterDiesel += liter;
	}
	
	/**
	 * Liefert den Typ des Motor des Traktors
	 * 
	 * @return Motor Enum Wert
	 */
	@Programmierer(autoren="Bernd Artmueller")
	@Override
	public Motor getMotor() {
		return Motor.DIESELTRAKTOR;
	}
	
	/**
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Jakob Kremsner")
	public String toString(){
		return super.toString() + ", Motor: Dieseltraktor";
	}
}
