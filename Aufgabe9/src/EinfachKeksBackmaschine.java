public class EinfachKeksBackmaschine extends Backmaschine {
	private Form form;
	private Teigart teig;
	
	public EinfachKeksBackmaschine( Form form, Teigart teig ) {
		this.form = form;
		this.teig = teig;
	}
	
	public void setTeig( Teigart teig ) {
		this.teig = teig;
	}
	
	@Override
	public Keks backe() {
		return new EinfachKeks( this.form, this.teig );
	}
}
