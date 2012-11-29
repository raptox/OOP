import java.awt.Point;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class Feld {
	private Set<AbstractAuto> autos;
	private Point position;
	
	public Feld( Point position ) {
		this.autos = Collections.synchronizedSet( new HashSet<AbstractAuto>() );
		this.position = position;
	}
	
	public void addAuto( AbstractAuto auto ) {
		this.autos.add( auto );
	}
	
	public void removeAuto( AbstractAuto auto ) {
		this.autos.remove( auto );
	}
	
	public Set<AbstractAuto> getAutos() {
		return this.autos;
	}
	
	public Point getPosition() {
		return this.position;
	}
}
