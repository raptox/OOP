/**
 * DoppelKeks stellt einen Keks mit einer bestimmten Form, einer bestimmten Teigart und einer Fuellung dar. DoppelKeks besteht im Prinzip aus zwei einfachen Keksen, wo
 * dazwischen eine Fuellung ist.
 */
public class DoppelKeks extends Keks {
	private Fuellung fuellung;
	
	/**
	 * Konstruktor von DoppelKeks, initialisiert den Keks mit der uebergebenen Form, der Teigart und einer Fuellung
	 * 
	 * form != null
	 * teig != null
	 * fuellung != null
	 * 
	 * @param form Form des Keks
	 * @param teig Teigart des Keks
	 * @param fuellung Fuellung des Keks
	 */
	public DoppelKeks( Form form, Teigart teig, Fuellung fuellung ) {
		super( form, teig );
		
		this.fuellung = fuellung;
	}
	
	/**
	 * Liefet eine Leserlichen Darstellung des DoppelKeks
	 * 
	 * @return Keks als String
	 */
	public String toString() {
		return "Doppelkeks mit der Form '" + this.form + "', " + this.teig + " und der Fuellung '" + this.fuellung;
	}
}
