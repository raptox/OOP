
public class SchnellesAuto extends AbstractAuto {
	public SchnellesAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( name, geschwindigkeit, richtung, strategie );
	}
	
	public String toString() {
		return this.name;
	}
}
