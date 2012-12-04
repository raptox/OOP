
import java.awt.Point;


public class KreisStrategie extends AbstractStrategie {
	public KreisStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}

	@Override
	public Point next( SchnellesAuto auto, Point derzeitigePosition ) {
		System.out.println( "Kreis fuer Schnelles Auto" );
		return new Point( derzeitigePosition.x + 1, derzeitigePosition.y );
	}

	@Override
	public Point next(BeweglichesAuto auto, Point derzeitigePosition) {
		System.out.println( "Kreis fuer Bewegliches Auto" );
		// TODO Auto-generated method stub
		return new Point( derzeitigePosition.x + 1, derzeitigePosition.y );
	}
}
