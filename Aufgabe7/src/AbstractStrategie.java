
import java.awt.Point;

public abstract class AbstractStrategie {
	protected int breite;
	protected int hoehe;
	
	public AbstractStrategie( int breite, int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
	}
	
	public abstract Point next( Point derzeitigePosition );
}
