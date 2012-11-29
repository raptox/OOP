
import java.awt.Point;
import java.io.Console;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;


public abstract class AbstractAuto implements Runnable {
	private int punkte;
	protected long geschwindigkeit;
	private AbstractStrategie strategie;
	private Richtung richtung;
	protected String name;
	
	private Feld feld;
	
	public AbstractAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		this.geschwindigkeit = geschwindigkeit;
		this.richtung = richtung;
		this.strategie = strategie;
		this.punkte = 0;
		this.name = name;
	}
	
	protected void erhoehePunkte() {
		this.punkte++;
	}
	
	protected void verringerePunkte() {
		this.punkte--;
	}
	
	public int getPunkte() {
		return this.punkte;
	}
	
	public Richtung getRichtung() {
		return this.richtung;
	}
	
	protected void setFeld( Feld feld ) {
		this.feld = feld;
	}
	
	public Feld getFeld() {
		return this.feld;
	}
	
	public void run() {
		for( int i = 0; i < 5; i++ ) {
			try {
				Thread.sleep( this.geschwindigkeit );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.fahre();
		}
	}
	
	protected void fahre() {
		Point position = Fahrbahn.getPosition( this );
		ConcurrentHashMap<AbstractAuto, AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		AbstractAuto current;
		
		// bestimme die naechste Position fuer das Auto anhand der Strategie
		position = strategie.next( position );
		
		// das Auto wird auf die neue Position gesetzt
		Fahrbahn.setPosition( this, position );	
		
		/* NUR TESTING */
		//System.out.println( this + " Auto fährt nach (" + position.x + "/" + position.y + ")" );
		/*System.out.println( "Autos auf Feld: " );
		autos = this.feld.getAutos();
		
		iteratorAuto = autos.values().iterator();
		
		// iteriere alle Autos durch
		while( iteratorAuto.hasNext() ) {
			System.out.println( iteratorAuto.next() );
		}System.out.println();
		*/
		/* ENDE */
		
		System.out.println( Fahrbahn.output() );
		// wenn sich auch andere autos auf dem feld befinden -> crash
		if ( ( autos = this.feld.getAutos() ).size() > 1 ) {
			// hohl alle autos die auf dem selben Feld stehen
			iteratorAuto = autos.values().iterator();
			
			// iteriere alle Autos durch
			while( iteratorAuto.hasNext() ) {
				current = iteratorAuto.next();

				// wenn current nicht das Taeter Auto ist; Taeter Auto BEKOMMT Punkte falls er vorne hineinfaehrt
				if ( current != this && current.getRichtung().getGegengesetzteRichtung() == this.getRichtung() ) {
					this.erhoehePunkte();
					current.verringerePunkte();
					
					System.out.println( "UNFALL! " + this + " crasht in " + current + ", Position: (" + position.x + "/" + position.y + ")" );
					System.out.println( "Punkte von " + this + ": " + this.getPunkte() );
					System.out.println( "Punkte von " + current + ": " + current.getPunkte() );
				}
				else if ( current != this ){
					System.out.println( "UNFALL SEITLICH! " + this + " crasht in " + current + ", Position: (" + position.x + "/" + position.y + ")" );
				}
			}
		}
		
	}
}
