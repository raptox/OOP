import java.awt.Point;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;

import sun.tools.tree.ThisExpression;


public class Fahrbahn {
	private int breite;
	private int hoehe;
	
	private static Feld[][] felder;
	
	public Fahrbahn( int breite, int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
		
		felder = new Feld[ this.breite ][ this.hoehe ];
		
		// felder hinzufügen
		for ( int x = 0; x < felder.length; x++ ) {
			for ( int y = 0; y < felder[ 0 ].length; y++ ) {
				felder[ x ][ y ] = new Feld( new Point( x, y ) );
			}
		}
	}
	
	public void addAuto( AbstractAuto auto, Point position ) {
		// auto zu feld hinzufuegen
		felder[ position.x ][ position.y ].addAuto( auto );
		
		// dem auto das feld zuweisen auf dem es gerade steht
		auto.setFeld( felder[ position.x ][ position.y ] );
	}
	
	protected static Point getPosition( AbstractAuto auto ) {
		return auto.getFeld().getPosition();
	}
	
	// setzt ein Auto vom alten Feld auf ein neues Feld mit der uebergebenen Position
	protected static void setPosition( AbstractAuto auto, Point position ) {
		Feld feldVorher = auto.getFeld();
		Feld feldNeu    = felder[ position.x ][ position.y ];
		
		// auto von alten Feld entfernen
		feldVorher.removeAuto( auto );
		
		// auto auf neues Feld setzen
		feldNeu.addAuto( auto );
		
		// dem auto das neue Feld auch zuweisen
		auto.setFeld( feldNeu );
	}
	
	// wenn sich auch andere autos auf dem feld befinden -> crash
	protected static boolean crash( AbstractAuto taeterAuto ) {
		return taeterAuto.getFeld().getAutos().size() > 1;
	}
	
	public void start() {
		Set<AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		AbstractAuto current;
		
		// alle felder und deren Autos durchlaufen -> starten
		for ( int x = 0; x < felder.length; x++ ) {
			for ( int y = 0; y < felder[ 0 ].length; y++ ) {
				autos = felder[ x ][ y ].getAutos();
				
				if ( autos.size() > 0 ) {
					iteratorAuto = autos.iterator();
					
					while( iteratorAuto.hasNext() ) {
						new Thread( iteratorAuto.next() ).start();
					}
				}
			}
		}
	}
}
