
import java.awt.Point;
import java.util.Iterator;
import java.util.Set;


public abstract class AbstractAuto implements Runnable {
	private int punkte;
	protected long geschwindigkeit;
	private AbstractStrategie strategie;
	private Richtung richtung;
	
	private Feld feld;
	
	public AbstractAuto( long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		this.geschwindigkeit = geschwindigkeit;
		this.richtung = richtung;
		this.strategie = strategie;
		this.punkte = 0;
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
	
	protected void fahre() {
		Point position = Fahrbahn.getPosition( this );
		Set<AbstractAuto> autos;
		Iterator<AbstractAuto> iteratorAuto;
		AbstractAuto current;
		
		// bestimme die naechste Position fuer das Auto anhand der Strategie
		position = strategie.next( position );
		
		// das Auto wird auf die neue Position gesetzt
		Fahrbahn.setPosition( this, position );	
		
		System.out.println( (this instanceof SchnellesAuto == true ? "Schnelles" : "Bewegliches") + " Auto fährt nach (" + position.x + "/" + position.y + ")" );
		
		if ( Fahrbahn.crash( this ) ) {
			// hohl alle autos die auf dem selben Feld stehen
			autos = this.feld.getAutos();
			iteratorAuto = autos.iterator();
			
			// iteriere alle Autos durch
			while( iteratorAuto.hasNext() ) {
				current = iteratorAuto.next();
				
				// wenn current nicht das Taeter Auto ist; Taeter Auto BEKOMMT Punkte falls er vorne hineinfaehrt
				if ( current != this && current.getRichtung().getGegengesetzteRichtung() == this.getRichtung() ) {
					this.erhoehePunkte();
					current.verringerePunkte();
					
					System.out.println( "Crash - x: " + position.x + ", y: " + position.y + ", Punkte Täter: " + this.getPunkte() + ", Punkte Opfer: " + current.getPunkte() );
				}
				
				
			}

			
		}
		
	}
}
