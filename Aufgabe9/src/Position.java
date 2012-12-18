
public class Position {
	private int anzahl;
	private Form form;
	private Teigart teig;
	private Fuellung fuellung;
	
	public Position(int anzahl, Form form, Teigart teig){
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = null;
	}
	public Position(int anzahl, Form form, Teigart teig, Fuellung fuellung){
		this.anzahl = anzahl;
		this.form = form;
		this.teig = teig;
		this.fuellung = fuellung;
	}
	
	public String toString(){
		String s = "Anzahl: "+anzahl+" Form: "+form+" Teigart: "+teig;
		if(fuellung != null){
			s+= " Fuellung: "+fuellung;
		}
		return s;
	}
	public int getAnzahl() {
		return anzahl;
	}
	public Form getForm() {
		return form;
	}
	public Teigart getTeigart() {
		return teig;
	}
	public Fuellung getFuellung() {
		return fuellung;
	}
}
