
import java.awt.Point;

/*
 * Untertyp ZufallStrategie, dynamisches binden mit Autos
 */
// ZufallStrategie berechnet die naechste Position (zufaellig) von einem Auto innerhalb des Spielfelds.
public class ZufallStrategie extends AbstractStrategie {
	public ZufallStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}
	
	/*
	 * Vorb.: auto darf nicht null sein und derzeitigePosition muss einer gueltigen Position innerhalb des Spielfelds darstellen
	 * Nachb.: Liefert die naechste Position auf dem Spielfeld fuer das uebergebene Auto
	 */
	@Override
	public Point next( SchnellesAuto auto, Point derzeitigePosition ) {
		double randomVal;

		Richtung nextRichtung = auto.getRichtung();

		int x = -1;
		int y = -1;

		while( x >= breite || x < 0 || y >= hoehe || y < 0 ) {
			x = derzeitigePosition.x;
			y = derzeitigePosition.y;

			nextRichtung = auto.getRichtung();
			randomVal =  Math.random();

			switch( auto.getRichtung() ) {
			case NORDEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.33 ) {
					x--;
					y--;
					nextRichtung = Richtung.WESTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x < 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.66 ) {
					y--;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y < 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal <= 1 ) {
					x++;
					y--;
					nextRichtung = Richtung.OSTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x >= breite - 1) {
						x = -1;
					}
				}

				break;
			case OSTEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.33 ) {
					x++;
					y--;
					nextRichtung = Richtung.NORDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y <= 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal >= 0.33 && randomVal < 0.66 ) {
					x++;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x >= breite - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal >= 0.66 && randomVal <= 1 ) {
					x++;
					y++;
					nextRichtung = Richtung.SUEDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y >= hoehe - 1 ) {
						x = -1;
						break;
					}
				}

				break;
			case SUEDEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.33 ) {
					x++;
					y++;
					nextRichtung = Richtung.OSTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x >= breite - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.66 ) {
					y++;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y >= hoehe - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal <= 1 ) {
					x--;
					y++;
					nextRichtung = Richtung.WESTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x <= 1 ) {
						x = -1;
						break;
					}
				}

				break;
			case WESTEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.33 ) {
					x--;
					y++;
					nextRichtung = Richtung.SUEDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y >= hoehe - 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.66 ) {
					x--;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x < 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal <= 1 ) {
					x--;
					y--;
					nextRichtung = Richtung.NORDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y < 1 ) {
						x = -1;
					}
				}
			}
		}

		auto.setRichtung( nextRichtung );

		return new Point( x, y );
	}
	
	/*
	 * Vorb.: auto darf nicht null sein und derzeitigePosition muss einer gueltigen Position innerhalb des Spielfelds darstellen
	 * Nachb.: Liefert die naechste Position auf dem Spielfeld fuer das uebergebene Auto
	 */
	@Override
	public Point next(BeweglichesAuto auto, Point derzeitigePosition) {
		double randomVal;

		Richtung nextRichtung = auto.getRichtung();

		int x = -1;
		int y = -1;

		while( x >= breite || x < 0 || y >= hoehe || y < 0 ) {
			x = derzeitigePosition.x;
			y = derzeitigePosition.y;

			nextRichtung = auto.getRichtung();
			randomVal =  Math.random();

			switch( auto.getRichtung() ) {
			case NORDEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.20 ) {
					x--;
					y--;
					nextRichtung = Richtung.WESTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x < 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.40 ) {
					y--;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y < 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal < 0.60 ) {
					x++;
					y--;
					nextRichtung = Richtung.OSTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x >= breite - 1) {
						x = -1;
					}
				}
				// fahre nach links
				else if (randomVal < 0.80) {
					x--;
					nextRichtung = Richtung.WESTEN;
					if (x<1) {
						x = -1;
					}
				}
				// fahre nach rechts
				else if (randomVal <= 1) {
					x++;
					nextRichtung = Richtung.OSTEN;
					if (x>breite)
						x = -1;
				}

				break;
			case OSTEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.20 ) {
					x++;
					y--;
					nextRichtung = Richtung.NORDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y <= 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.40 ) {
					x++;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x >= breite - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal < 0.60) {
					x++;
					y++;
					nextRichtung = Richtung.SUEDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y >= hoehe - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach links
				else if (randomVal < 0.80) {
					y--;
					nextRichtung = Richtung.NORDEN;
					if (y<1) {
						y = -1;
					}
				}
				// fahre nach rechts
				else if (randomVal <= 1) {
					y++;
					nextRichtung = Richtung.SUEDEN;
					if (y>hoehe)
						y=-1;
				}

				break;
			case SUEDEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.20 ) {
					x++;
					y++;
					nextRichtung = Richtung.OSTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x >= breite - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.40 ) {
					y++;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y >= hoehe - 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal < 0.6 ) {
					x--;
					y++;
					nextRichtung = Richtung.WESTEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x <= 1 ) {
						x = -1;
						break;
					}
				}
				// fahre nach links
				else if (randomVal < 0.8) {
					x++;
					nextRichtung = Richtung.OSTEN;
					
					if (x>breite)
						x=-1;
				}
				// fahre nach rechts
				else if (randomVal <= 1) {
					x--;
					nextRichtung = Richtung.WESTEN;
				
					if (x<1)
						x=-1;
				}

				break;
			case WESTEN : 
				// fahre nach vorne links inkl. 90 grad wendung nach links
				if ( randomVal < 0.2 ) {
					x--;
					y++;
					nextRichtung = Richtung.SUEDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y >= hoehe - 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne in gleicher Richtung
				else if ( randomVal < 0.4 ) {
					x--;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( x < 1 ) {
						x = -1;
					}
				}
				// fahre nach vorne rechts inkl. 90 grad wendung nach rechts
				else if ( randomVal < 0.6 ) {
					x--;
					y--;
					nextRichtung = Richtung.NORDEN;

					// pruefe ob auto eh nicht in die enge getrieben wird
					if ( y < 1 ) {
						x = -1;
					}
				}
				// fahre nach links
				else if (randomVal < 0.8) {
					y--;
					nextRichtung = Richtung.SUEDEN;
					if (y<1)
						y=-1;
				}
				// fahre nach rechts
				else if (randomVal <= 1) {
					y++;
					nextRichtung = Richtung.NORDEN;
					if (y>hoehe)
						y=-1;
				}
			}
		}

		auto.setRichtung( nextRichtung );

		return new Point( x, y );
	}
}
