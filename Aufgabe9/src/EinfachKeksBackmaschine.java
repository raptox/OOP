/**
 * EinfachKeksBackmaschine stellt eine Backmaschine fuer das Backen von EinfachKeksen dar. (Factory Pattern)
 */
public class EinfachKeksBackmaschine extends Backmaschine {
	private Form form;
	private Teigart teig;
	
	/**
	 * Konstruktor der die Form und die Teigart des Kekses setzt.
	 * 
	 * form != null
	 * teig != null
	 * 
	 * @param form Form des Keks
	 * @param teig Teigart des Keks
	 */
	public EinfachKeksBackmaschine( Form form, Teigart teig ) {
		this.form = form;
		this.teig = teig;
	}
	
	/**
	 * Setzt die gewuenschte Teigart des EinfachKeks
	 * 
	 * teig != null
	 * 
	 * @param teig Teigart des EinfachKeks
	 */
	public void setTeig( Teigart teig ) {
		this.teig = teig;
	}
	
	/**
	 * Backt und liefert den gewuenschten Keks
	 * 
	 * @return EinfachKeks Objekt
	 */
	@Override
	public Keks backe() {
		return new EinfachKeks( this.form, this.teig );
	}
}
