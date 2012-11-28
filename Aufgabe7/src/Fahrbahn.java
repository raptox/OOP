import java.awt.Point;
import java.util.HashMap;


public class Fahrbahn {
	private int breite;
	private int hoehe;

	private static HashMap<AbstractAuto, Point> autos;
	
	public Fahrbahn( int breite, int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
		autos = new HashMap<AbstractAuto, Point>();
	}
	
	public void addAuto( AbstractAuto auto, Point position ) {
		autos.put( auto, position );
	}
	
	protected static Point getPosition( AbstractAuto auto ) {
		return autos.get( auto );
	}
	
	protected static void setPosition( AbstractAuto auto, Point position ) {
		autos.put( auto, position );
	}
	
	protected static AbstractAuto crash( AbstractAuto taeterAuto ) {
		Point positionTaeterAuto = autos.get( taeterAuto );
		
		// alle autos durchlaufen und schauen ob ein crash entstanden ist
		for( AbstractAuto current : autos.keySet() ) {
			if ( current != taeterAuto ) {
				// pruefen ob sich zwei Autos auf dem selben Feld befinden
				if ( getPosition( current ).equals( positionTaeterAuto ) ) {
					return current;
				}
			}
	    }
		
		return null;
	}
	
	public void start() {
		for( AbstractAuto current : autos.keySet() ) {
			new Thread( current ).start();
	    }
	}
}
