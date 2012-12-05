
import java.awt.Point;
import java.util.concurrent.ConcurrentHashMap;

/*
 * Feld, ein Element der Fahrbahn, auf einem Feld koennen mehrere Autos sein
 */
public class Feld {
	private ConcurrentHashMap<AbstractAuto, AbstractAuto> autos;
	private Point position;
	
	public Feld( Point position ) {
		this.autos = new ConcurrentHashMap<AbstractAuto, AbstractAuto>();
		this.position = position;
	}
	
	public void addAuto( AbstractAuto auto ) {
		this.autos.put( auto, auto );
	}
	
	public void removeAuto( AbstractAuto auto ) {
		this.autos.remove( auto );
	}
	
	public ConcurrentHashMap<AbstractAuto, AbstractAuto> getAutos() {
		return this.autos;
	}
	
	public Point getPosition() {
		return this.position;
	}
}
