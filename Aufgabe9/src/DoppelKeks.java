public class DoppelKeks extends Keks {
	private Fuellung fuellung;
	
	public DoppelKeks( Form form, Teigart teig, Fuellung fuellung ) {
		super( form, teig );
		
		this.fuellung = fuellung;
	}
	
	public String toString() {
		return "Doppelkeks mit der Form '" + this.form + "', " + this.teig + " und der Fuellung '" + this.fuellung;
	}
}
