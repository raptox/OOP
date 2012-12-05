import java.awt.Point;


public class BeweglichesAuto extends AbstractAuto {
	public BeweglichesAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( name, geschwindigkeit, richtung, strategie );
	}

	@Override
	protected Point getNextPosition( Point derzeitigePosition ) {
		return this.strategie.next( this, derzeitigePosition );
	}
}
