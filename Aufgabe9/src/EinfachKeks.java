public class EinfachKeks extends Keks {

	public EinfachKeks( Form form, Teigart teig ) {
		super( form, teig) ;
	}
	
	public String toString() {
		return "Einfachkeks mit der Form '" + this.form + "' und aus " + this.teig;
	}
}
