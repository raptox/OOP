public abstract class Keks {
	protected Form form;
	protected Teigart teig;
	
	public Keks( Form form, Teigart teig ) {
		this.form = form;
		this.teig = teig;
	}

	public Form getForm() {
		return form;
	}

	public void setForm(Form form) {
		this.form = form;
	}

	public Teigart getTeig() {
		return teig;
	}

	public void setTeig(Teigart teig) {
		this.teig = teig;
	}
}
