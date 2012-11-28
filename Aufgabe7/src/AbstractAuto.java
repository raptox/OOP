import java.awt.Point;


public abstract class AbstractAuto implements Runnable {
	private int punkte;
	private int geschwindigkeit;
	private AbstractStrategie strategie;
	private Richtung richtung;
	
	public AbstractAuto( int geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
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
	
	public void run() {
		for( int i = 0; i < 5; i++ ) {
			this.fahre();
		}
	}
	
	public abstract void fahre();
}
