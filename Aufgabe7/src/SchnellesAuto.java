import java.awt.Point;


public class SchnellesAuto extends AbstractAuto {
	public SchnellesAuto( int geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( geschwindigkeit, richtung, strategie );
	}

	public void fahre() {
		Point position = Fahrbahn.getPosition( this );
		
		position = new Point( position.x + 1, position.y );
		
		Fahrbahn.setPosition( this, position );	
		AbstractAuto opfer;
		

		System.out.println( "Schnelles Auto fährt nach (" + position.x + "/" + position.y + ")" );
		
		if ( ( opfer = Fahrbahn.crash( this ) ) != null ) {
			opfer.verringerePunkte();
			this.erhoehePunkte();System.out.println( "Crash - x: " + position.x + ", y: " + position.y );
		}
	}
}
