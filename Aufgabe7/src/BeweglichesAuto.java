
public class BeweglichesAuto extends AbstractAuto {
	public BeweglichesAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( name, geschwindigkeit, richtung, strategie );
	}
	
	public String toString() {
		return this.name;
	}
}
