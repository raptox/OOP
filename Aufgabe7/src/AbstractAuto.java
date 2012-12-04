
import java.awt.Point;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;


public abstract class AbstractAuto implements Runnable {
	private int punkte;
	private long geschwindigkeit;
	private Richtung richtung;
	private int feldwechsel;
	private Feld feld;
	
	private volatile boolean stop = false;
	
	private final int MAXPUNKTE = 10;
	private final int MAXFELDWECHSEL = 800;
	
	// Attribute die vererbt werden
	protected AbstractStrategie strategie;
	protected String name;
	
	public AbstractAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		this.geschwindigkeit = geschwindigkeit;
		this.richtung = richtung;
		this.strategie = strategie;
		this.punkte = 0;
		this.feldwechsel = 0;
		this.name = name;
	}
	
	// multi methoden (Visitor Pattern) fuer Strategien verwendet
	protected abstract Point getNextPosition( Point derzeitigePosition );
	
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
	
	protected void setRichtung( Richtung richtung ) {
		this.richtung = richtung;
	}
	
	protected void setFeld( Feld feld ) {
		this.feld = feld;
	}
	
	public Feld getFeld() {
		return this.feld;
	}
	
	public void run() {
		// solange das auto noch nicht 10 punkte hat, lass es weiterfahren
		while( !stop && this.punkte < this.MAXPUNKTE && this.feldwechsel < this.MAXFELDWECHSEL ) {
			try {
				Thread.sleep( this.geschwindigkeit );
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			this.fahre();
		}
		
		if ( this.punkte >= this.MAXPUNKTE ) {
			Fahrbahn.stop();
		}
		
		System.out.println( this + " Auto gestoppt, Punkte: " + this.punkte + ", Anzahl Feldwechsel: " + this.feldwechsel );

		// wenn auto 10 punkte erreicht hat, beende simulation
		
	}
	
	protected void requestStop() {
		stop = true;
	}
	
	private void fahre() {
		Point position = Fahrbahn.getPosition( this );
		ConcurrentHashMap<AbstractAuto, AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		AbstractAuto current;
		
		// bestimme die naechste Position fuer das Auto anhand der Strategie
		position = this.getNextPosition( position );
		
		// das Auto wird auf die neue Position gesetzt
		Fahrbahn.setPosition( this, position );	
		
		this.feldwechsel++;
			
		
		/* NUR TESTING */
		//System.out.println( this + " Auto fährt nach (" + position.x + "/" + position.y + ") in Richtung " + this.getRichtung() );
		/*System.out.println( "Autos auf Feld: " );
		autos = this.feld.getAutos();
		
		iteratorAuto = autos.values().iterator();
		
		// iteriere alle Autos durch
		while( iteratorAuto.hasNext() ) {
			System.out.println( iteratorAuto.next() );
		}System.out.println();
		*/
		/* ENDE */
		
		//System.out.println( Fahrbahn.output() );
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
					this.erhoehePunkte();
					current.verringerePunkte();
					
					System.out.println( "UNFALL! " + this + " crasht in " + current + ", Position: (" + position.x + "/" + position.y + ")" );
					System.out.println( "Punkte von " + this + ": " + this.getPunkte() );
					System.out.println( "Punkte von " + current + ": " + current.getPunkte() );
				}
				else if ( current != this ){
					//System.out.println( "UNFALL SEITLICH! " + this + " crasht in " + current + ", Position: (" + position.x + "/" + position.y + ")" );
					this.erhoehePunkte();
					current.verringerePunkte();
				}
			}
		}
	}
}
