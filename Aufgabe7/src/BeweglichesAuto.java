import java.awt.Point;


public class BeweglichesAuto extends AbstractAuto {
	public BeweglichesAuto( int geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( geschwindigkeit, richtung, strategie );
	}

	public void fahre() {
		Point position = Fahrbahn.getPosition( this );
		
		position = new Point( position.x - 1, position.y );
		
		Fahrbahn.setPosition( this, position );	
		
		AbstractAuto opfer;
		
		System.out.println( "Bewegliches Auto fährt nach (" + position.x + "/" + position.y + ")" );
		
		if ( ( opfer = Fahrbahn.crash( this ) ) != null ) {System.out.println( "crashasdf" );
			opfer.verringerePunkte();
			this.erhoehePunkte();
		}
	}
}
