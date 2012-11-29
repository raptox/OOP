
import java.awt.Point;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


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
