
import java.awt.Point;


public class SchlangenLinieStrategie extends AbstractStrategie {
	public SchlangenLinieStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}

	@Override
	public Point next( SchnellesAuto auto, Point derzeitigePosition ) {
		double randomVal = Math.random();
		int x = derzeitigePosition.x;
		int y = derzeitigePosition.y;

		// Fange mit rechts oben Kreis an
		if (randomVal<0.5) {
			// Kreis nach rechts
			if (x+1 < breite) {
				x++;
			}
			// Kreis nach links
			else {
				x--;
			}

			// Kreis nach oben
			if (y-1 > 0)
				y--;
			// Kreis nach unten
			else 
				y++;
		}
		// Fange mit links unten Kreis an
		else {
			// Kreis nach links
			if (x-1 > 0) {
				x--;
			}
			// Kreis nach rechts
			else {
				x++;
			}

			// Kreis nach unten
			if (y+1 < hoehe)
				y++;
			// Kreis nach oben
			else 
				y--;			

		}

		return new Point( x,y );
	}

	@Override
	public Point next(BeweglichesAuto auto, Point derzeitigePosition) {
		double randomVal = Math.random();
		int x = derzeitigePosition.x;
		int y = derzeitigePosition.y;

		// Fange mit rechts oben Kreis an
		if (randomVal<0.5) {
			// Kreis nach rechts
			if (x+1 < breite) {
				x++;
			}
			// Kreis nach links
			else {
				x--;
			}

			// Kreis nach oben
			if (y-1 > 0)
				y--;
			// Kreis nach unten
			else 
				y++;
		}
		// Fange mit links unten Kreis an
		else {
			// Kreis nach links
			if (x-1 > 0) {
				x--;
			}
			// Kreis nach rechts
			else {
				x++;
			}

			// Kreis nach unten
			if (y+1 < hoehe)
				y++;
			// Kreis nach oben
			else 
				y--;			

		}

		return new Point( x,y );
	}
}
