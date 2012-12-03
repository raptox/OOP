
import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import sun.tools.tree.ThisExpression;


public class Fahrbahn {
	private int breite;
	private int hoehe;
	
	private static Feld[][] felder;
	private ArrayList<Thread> threads;
	
	public Fahrbahn( int breite, int hoehe ) {
		this.breite = breite;
		this.hoehe = hoehe;
		
		this.threads = new ArrayList<Thread>();
		
		felder = new Feld[ this.breite ][ this.hoehe ];
		
		// felder hinzufügen
		for ( int x = 0; x < felder.length; x++ ) {
			for ( int y = 0; y < felder[ 0 ].length; y++ ) {
				felder[ x ][ y ] = new Feld( new Point( x, y ) );
			}
		}
	}
	
	public synchronized void addAuto( AbstractAuto auto, Point position ) {
		// auto zu feld hinzufuegen
		felder[ position.x ][ position.y ].addAuto( auto );
		
		// dem auto das feld zuweisen auf dem es gerade steht
		auto.setFeld( felder[ position.x ][ position.y ] );
	}
	
	protected static synchronized Point getPosition( AbstractAuto auto ) {
		return auto.getFeld().getPosition();
	}
	
	// setzt ein Auto vom alten Feld auf ein neues Feld mit der uebergebenen Position
	protected static synchronized void setPosition( AbstractAuto auto, Point position ) {
		Feld feldVorher = auto.getFeld();
		Feld feldNeu    = felder[ position.x ][ position.y ];
		
		// auto von alten Feld entfernen
		feldVorher.removeAuto( auto );
		
		// auto auf neues Feld setzen
		feldNeu.addAuto( auto );
		
		// dem auto das neue Feld auch zuweisen
		auto.setFeld( feldNeu );
	}
	
	private static void stopAuto( AbstractAuto auto ) {
		auto.requestStop();
	}
	
	public static void stop() {
		ConcurrentHashMap<AbstractAuto, AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		
		// alle felder und deren Autos durchlaufen -> starten
		for ( int x = 0; x < felder.length; x++ ) {
			for ( int y = 0; y < felder[ 0 ].length; y++ ) {
				autos = felder[ x ][ y ].getAutos();
				
				if ( autos.size() > 0 ) {
					iteratorAuto = autos.values().iterator();
					
					while( iteratorAuto.hasNext() ) {
						stopAuto( iteratorAuto.next() );
					}
				}
			}
		}
	}
	
	public void start() {
		ConcurrentHashMap<AbstractAuto, AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		Thread t;
		
		// alle felder und deren Autos durchlaufen -> starten
		for ( int x = 0; x < felder.length; x++ ) {
			for ( int y = 0; y < felder[ 0 ].length; y++ ) {
				autos = felder[ x ][ y ].getAutos();
				
				if ( autos.size() > 0 ) {
					iteratorAuto = autos.values().iterator();
					
					while( iteratorAuto.hasNext() ) {
						t = new Thread( iteratorAuto.next() );
						t.start();
					}
				}
			}
		}
	}
	
	public static String output() {
		String output = "";
		ConcurrentHashMap<AbstractAuto, AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		
		for ( int y = 0; y < felder[ 0 ].length; y++ ) {
			output += "|";
			for ( int x = 0; x < felder.length; x++ ) {
				if ( felder[ x ][ y ].getAutos().size() < 1 ) {
					output += "_|";
				}
				else if ( felder[ x ][ y ].getAutos().size() >= 1 ) {
					autos = felder[ x ][ y ].getAutos();
					iteratorAuto = autos.values().iterator();

					while( iteratorAuto.hasNext() ) {
						output += iteratorAuto.next().toString().substring(0, 1);
					}
					output += "|";
				}
				
				if ( x == felder.length - 1 ) {
					output += "\n";
				}
			}
		}
		
		return output;
	}
}
