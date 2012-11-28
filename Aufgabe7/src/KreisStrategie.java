import java.awt.Point;


public class KreisStrategie extends AbstractStrategie {
	public KreisStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}
	
	@Override
	public Point next( Point derzeitigePosition ) {
		// gehe nach rechts
		if ( derzeitigePosition.x + 1 < this.breite ) {
			return new Point( derzeitigePosition.x + 1, derzeitigePosition.y );
		}
		
		
		return null;
	}

}
