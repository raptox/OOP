
import java.awt.Point;


public class KreisStrategie extends AbstractStrategie {
	public KreisStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}
	
	@Override
	public Point next( Point derzeitigePosition ) {
		return new Point( derzeitigePosition.x + 1, derzeitigePosition.y );
	}

}
