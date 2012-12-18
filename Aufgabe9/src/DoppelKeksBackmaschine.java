/**
 * DoppelKeksBackmaschine stellt eine Backmaschine fuer das Backen von DoppelKeksen dar. Diese bestehen aus zwei EinfachKeksen (Deckel und Boden) und einer Fuellung. (Factory Pattern)
 */
public class DoppelKeksBackmaschine extends Backmaschine {
	private Keks deckel;
	private Fuellung fuellung;
	
	/**
	 * Konstruktor der den Deckel (EinfachKeks) und die Fuellung des DoppelKeks setzt.
	 * 
	 * deckel != null
	 * fuellung != null
	 * 
	 * @param deckel Deckel des DoppelKeks der als Vorlage fuer den Boden dient
	 * @param fuellung Fuellung des Keks
	 */
	public DoppelKeksBackmaschine( EinfachKeks deckel, Fuellung fuellung ) {
		this.deckel = deckel;
		this.fuellung = fuellung;
	}
	
	/**
	 * Backt und liefert den gewuenschten Keks
	 * 
	 * @return DoppelKeks Objekt
	 */
	@Override
	public Keks backe() {
		return new DoppelKeks( this.deckel.getForm(), this.deckel.getTeig(), this.fuellung );
	}
}
