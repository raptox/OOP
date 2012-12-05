
import java.awt.Point;

// SchlangenLinieStrategie berechnet die naechste Position von einem Auto innerhalb des Spielfelds. Diese Strategie
// laesst das Auto in Schlangenlinien fahren.
public class SchlangenLinieStrategie extends AbstractStrategie {
	public SchlangenLinieStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}
	
	/*
	 * Vorb.: auto darf nicht null sein und derzeitigePosition muss einer gueltigen Position innerhalb des Spielfelds darstellen
	 * Nachb.: Liefert die naechste Position auf dem Spielfeld fuer das uebergebene Auto
	 */
	@Override
	public Point next( SchnellesAuto auto, Point derzeitigePosition ) {
		double randomVal = Math.random();
		int x = derzeitigePosition.x;
		int y = derzeitigePosition.y;
		Richtung nextRichtung = auto.getRichtung();
		boolean rechts = false , oben = false;
		
		// Fange mit rechts oben Kreis an
		if (randomVal<0.5) {
			// Kreis nach rechts
			if (x+1 < breite) {
				rechts=true;
				x++;
			}
			// Kreis nach links
			else {
				x--;
			}

			// Kreis nach oben
			if (y-1 > 0) {
				oben = true;
				y--;
			}
			// Kreis nach unten
			else { 
				y++;
			}
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
				rechts = true;
			}

			// Kreis nach unten
			if (y+1 < hoehe) {
				y++;
			}
			// Kreis nach oben
			else {
				oben = true;
				y--;			
			}
		}

		if (nextRichtung == Richtung.NORDEN) {
			if (oben == false)
				auto.setRichtung(Richtung.SUEDEN);
		} else if (nextRichtung == Richtung.SUEDEN) {
			if (oben == true)
				auto.setRichtung(Richtung.NORDEN);
		} else if (nextRichtung == Richtung.OSTEN) {
			if (rechts != true) {
				auto.setRichtung(Richtung.WESTEN);
			}
		} else if (nextRichtung == Richtung.WESTEN) {
			if (rechts == true) {
				auto.setRichtung(Richtung.OSTEN);
			}
		}
		
		return new Point( x,y );
	}
	
	/*
	 * Vorb.: auto darf nicht null sein und derzeitigePosition muss einer gueltigen Position innerhalb des Spielfelds darstellen
	 * Nachb.: Liefert die naechste Position auf dem Spielfeld fuer das uebergebene Auto
	 */
	@Override
	public Point next(BeweglichesAuto auto, Point derzeitigePosition) {
		double randomVal = Math.random();
		int x = derzeitigePosition.x;
		int y = derzeitigePosition.y;
		Richtung nextRichtung = auto.getRichtung();
		boolean rechts = false , oben = false;
		
		// Fange mit rechts oben Kreis an
		if (randomVal<0.5) {
			// Kreis nach rechts
			if (x+1 < breite) {
				rechts=true;
				x++;
			}
			// Kreis nach links
			else {
				x--;
			}

			// Kreis nach oben
			if (y-1 > 0) {
				oben = true;
				y--;
			}
			// Kreis nach unten
			else { 
				y++;
			}
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
				rechts = true;
			}

			// Kreis nach unten
			if (y+1 < hoehe) {
				y++;
			}
			// Kreis nach oben
			else {
				oben = true;
				y--;			
			}
		}

		if (nextRichtung == Richtung.NORDEN) {
			if (oben == false)
				auto.setRichtung(Richtung.SUEDEN);
		} else if (nextRichtung == Richtung.SUEDEN) {
			if (oben == true)
				auto.setRichtung(Richtung.NORDEN);
		} else if (nextRichtung == Richtung.OSTEN) {
			if (rechts != true) {
				auto.setRichtung(Richtung.WESTEN);
			}
		} else if (nextRichtung == Richtung.WESTEN) {
			if (rechts == true) {
				auto.setRichtung(Richtung.OSTEN);
			}
		}
		
		return new Point( x,y );
	}
}
