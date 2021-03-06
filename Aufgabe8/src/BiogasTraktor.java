/**
 * BiogasTraktor erbt von AbstractTraktor und stellt einen konkreten Biogastraktor dar.
 */
@Programmierer(autoren="Bernd Artmueller")
public class BiogasTraktor extends AbstractTraktor {
	private double verbrauchtesGas;
	
	/**
	 * Konstruktor von BiogasTraktor setzt die eindeutige Nummer, anfaengliche Betriebsstunden, Einsatzzweck und die anfaengliche Anzahl
	 * verbrauchter Liter Diesel
	 * 
	 * @param nummer Eindeutige nummer
	 * @param betriebsstunden Anfaengliche Betriebsstunden des Traktors >= 0
	 * @param einsatzzweck Einsatzzweck des Traktors
	 * @param verbrauchtesGas Anfaengliche verbrauchte Kubikmeter Gas des Traktors >= 0
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public BiogasTraktor( int nummer, double betriebsstunden, Rolle einsatzzweck, double verbrauchtesGas ) {
		super( nummer, betriebsstunden, einsatzzweck );
		
		this.verbrauchtesGas = verbrauchtesGas;
	}
	
	/**
	 * Liefert die Menge der bis jetzt verbrauchten Kubikmeter an Gas seit Betriebsbeginn
	 * 
	 * @return verbrauchtesGas
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double getVerbrauchtesGas() {
		return this.verbrauchtesGas;
	}
	
	/**
	 * Vorbedingung: kubikmeterGas > 0
	 * 
	 * Erhoeht die Anzahl der verbrauchten Kubikmeter an Gas um die uebergebene Anzahl von Kubikmetern
	 * 
	 * @param kubikmeterGas - Anzahl der Kubikmeter an Gas die zu den bereits verbrauchen Kubikmetern Gas hinzugerechnet werden
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public void erhoeheVerbrauchtesGas( int kubikmeterGas ) {
		this.verbrauchtesGas += kubikmeterGas;
	}
	
	/**
	 * Liefert den Typ des Motor des Traktors
	 * 
	 * @return Motor Enum Wert
	 */
	@Programmierer(autoren="Bernd Artmueller")
	@Override
	public Motor getMotor() {
		return Motor.BIOGASTRAKTOR;
	}
	
	/**
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Jakob Kremsner")
	public String toString(){
		return super.toString() + ", Motor: Biogastraktor";
	}
}
