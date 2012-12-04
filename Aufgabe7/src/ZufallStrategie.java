
import java.awt.Point;


public class ZufallStrategie extends AbstractStrategie {
	public ZufallStrategie( int breite, int hoehe ) {
		super( breite, hoehe );
	}
	
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

	@Override
	public Point next(BeweglichesAuto auto, Point derzeitigePosition) {
		System.out.println( "Zufall fuer Bewegliches Auto" );
		// TODO Auto-generated method stub
		return new Point( derzeitigePosition.x - 1, derzeitigePosition.y );
	}
}
