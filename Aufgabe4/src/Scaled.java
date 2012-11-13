public class Scaled<P extends Pict> extends Repeated implements Pict {
	
	public Scaled( P[][] elements ) {
		super(elements);
	}
	
	@Override
	public void scale(double factor) {
		for (int i=0; i<elements.length; i++) {
			for (int y=0; y<elements[0].length; y++) {
				((P)elements[i][y]).scale(factor);
			}
		}
	}
	
}
