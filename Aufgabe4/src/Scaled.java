public class Scaled<P extends Pict> extends Repeated implements Pict {
	
	// elements != null
	public Scaled( P[][] elements ) {
		super(elements);
	}
	
	@Override
	// 0.1 <= factor <= 10.0; resize the picture
	public void scale(double factor) {
		for (int i=0; i<elements.length; i++) {
			for (int y=0; y<elements[0].length; y++) {
				((P)elements[i][y]).scale(factor);
			}
		}
	}
	
}
