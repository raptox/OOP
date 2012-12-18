/**
 * EinfachKeks stellt einen Keks mit einer bestimmen Form und einer bestimmten Teigart dar. EinfachKeks besteht aus nur einem Keks.
 */
public class EinfachKeks extends Keks {
	/**
	 * Konstruktor von EinfachKeks, initialisiert den Keks mit der uebergebenen Form und der Teigart
	 * 
	 * form != null
	 * teig != null
	 * 
	 * @param form Form des Keks
	 * @param teig Teigart des Keks
	 */
	public EinfachKeks( Form form, Teigart teig ) {
		super( form, teig) ;
	}
	
	/**
	 * Liefet eine Leserlichen Darstellung des EinfachKeks
	 * 
	 * @return Keks als String
	 */
	public String toString() {
		return "Einfachkeks mit der Form '" + this.form + "' und aus " + this.teig;
	}
}
