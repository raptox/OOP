
public class SchnellesAuto extends AbstractAuto {
	public SchnellesAuto( String name, long geschwindigkeit, Richtung richtung, AbstractStrategie strategie ) {
		super( name, geschwindigkeit, richtung, strategie );
	}
	
	public void run() {System.out.println( "Schnelles" );
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
	
	public String toString() {
		return this.name;
	}
}
