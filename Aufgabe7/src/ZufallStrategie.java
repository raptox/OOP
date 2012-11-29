import java.awt.Point;


public class ZufallStrategie extends AbstractStrategie {
	public ZufallStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}
	
	@Override
	public Point next( Point derzeitigePosition ) {
		return new Point( derzeitigePosition.x - 1, derzeitigePosition.y );
	}

}
