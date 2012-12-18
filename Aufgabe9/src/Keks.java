/**
 * Abstrakte Oberklasse fuer alle Kekse. Kekse bestehen aus einer bestimmten Form und aus einer bestimmten Teigart.
 */
public abstract class Keks {
	protected Form form;
	protected Teigart teig;
	
	/**
	 * Konstruktor von Keks, initialisiert den Keks mit der uebergebenen Form und der Teigart
	 * 
	 * form != null
	 * teig != null
	 * 
	 * @param form Form des Keks
	 * @param teig Teigart des Keks
	 */
	public Keks( Form form, Teigart teig ) {
		this.form = form;
		this.teig = teig;
	}
	
	/**
	 * Liefert die Form des Keks
	 * 
	 * @return form Form des Keks
	 */
	public Form getForm() {
		return form;
	}
	
	/**
	 * Setzt die Form des Keks
	 * 
	 * form != null
	 * 
	 * @param form Form des Keks
	 */
	public void setForm(Form form) {
		this.form = form;
	}
	
	/**
	 * Liefert die Teigart 
	 * 
	 * @return teig Teigart des Keks
	 */
	public Teigart getTeig() {
		return teig;
	}
	
	/**
	 * Setzt die Teigart des Keks
	 * 
	 * teig != null
	 * 
	 * @param teig Teigart des Keks
	 */
	public void setTeig(Teigart teig) {
		this.teig = teig;
	}
}
