import java.awt.Point;


public class SchnellesAuto extends AbstractAuto {
	public SchnellesAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( name, geschwindigkeit, richtung, strategie );
	}
	
	public String toString() {
		return this.name;
	}
	
	@Override
	protected Point getNextPosition( Point derzeitigePosition ) {
		return this.strategie.next( this, derzeitigePosition );
	}
}
