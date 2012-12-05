import java.awt.Point;

/*
 * Untertyp Schnelles Auto
 * Untertyp wird benoetigt fuer dynamisches binden mit Strategie
 */
public class SchnellesAuto extends AbstractAuto {
	public SchnellesAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( name, geschwindigkeit, richtung, strategie );
	}
	
	@Override
	protected Point getNextPosition( Point derzeitigePosition ) {
		return this.strategie.next( this, derzeitigePosition );
	}
}
