public class Scaled<P extends Pict> implements Pict {
	private P[][] elements;
	
	public Scaled( P[][] elements ) {
		this.elements = elements;
	}
	
	@Override
	public void scale(double factor) {
		
	}

}
