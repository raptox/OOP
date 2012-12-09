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
	public BiogasTraktor( int nummer, double betriebsstunden, Rolle einsatzzweck, double verbrauchtesGas ) {
		super( nummer, betriebsstunden, einsatzzweck );
		
		this.verbrauchtesGas = verbrauchtesGas;
	}
	
	/**
	 * Liefert die Menge der bis jetzt verbrauchten Kubikmeter an Gas seit Betriebsbeginn
	 * 
	 * @return verbrauchtesGas
	 */
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
	public void erhoeheVerbrauchtesGas( int kubikmeterGas ) {
		this.verbrauchtesGas += kubikmeterGas;
	}
	
	/**
	 * Liefert den Typ des Motor des Traktors
	 * 
	 * @return Motor Enum Wert
	 */
	@Override
	public Motor getMotor() {
		return Motor.BIOGASTRAKTOR;
	}
}
