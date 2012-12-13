public class DoppelKeksBackmaschine extends Backmaschine {
	private Keks deckel;
	private Fuellung fuellung;
	
	public DoppelKeksBackmaschine( Keks deckel, Fuellung fuellung ) {
		this.deckel = deckel;
		this.fuellung = fuellung;
	}
	
	@Override
	public Keks backe() {
		return new DoppelKeks( this.deckel.getForm(), this.deckel.getTeig(), this.fuellung );
	}
}
