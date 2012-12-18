
public class Position {
	private int anzahl;
	private Form form;
	private Teigart teig;
	private Fuellung fuellung;
	
	/*
	 * Kostruktor
	 * VB: anzahl, form, teig != null
	 */
	public Position(int anzahl, Form form, Teigart teig){
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = null;
	}
	/*
	 * Kostruktor
	 * VB: anzahl, form, teig, fuellung != null
	 */
	public Position(int anzahl, Form form, Teigart teig, Fuellung fuellung){
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = fuellung;
	}
	/*
	 * liefert einen String der Position zurueck, in dem die Anzahl, Form, Teigart
	 * und wenn fuellung!=null ist auch dessen fuellung gespeichert ist
	 */
	public String toString(){
		String s = "Anzahl: "+anzahl+" Form: "+form+" Teigart: "+teig;
		if(fuellung != null){
			s+= " Fuellung: "+fuellung;
		}
		return s;
	}
	/*
	 * liefert die Anzahl der Kekse der Position zurueck
	 */
	public int getAnzahl() {
		return anzahl;
	}
	/*
	 * liefert die Form der Kekse der Position zurueck
	 */
	public Form getForm() {
		return form;
	}
	/*
	 * liefert die Teigart der Kekse der Position zurueck
	 */
	public Teigart getTeigart() {
		return teig;
	}
	/*
	 * liefert die Fuellung der Kekse der Position zurueck
	 */
	public Fuellung getFuellung() {
		return fuellung;
	}
}
