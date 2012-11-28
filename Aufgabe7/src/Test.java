import java.awt.Point;


public class Test {
	public static void main(String[] args) {
		Fahrbahn fahrbahn = new Fahrbahn( 100, 20 );
		
		// Autos erstellen
		SchnellesAuto s1 = new SchnellesAuto( 100, Richtung.OSTEN, new KreisStrategie( 100, 20 ) );
		//SchnellesAuto s2 = new SchnellesAuto( 200, Richtung.NORDEN, new KreisStrategie( 100, 20 ) );
		
		//BeweglichesAuto b1 = new BeweglichesAuto( 500, Richtung.OSTEN, new KreisStrategie( 100, 20 ) );
		BeweglichesAuto b2 = new BeweglichesAuto( 500, Richtung.OSTEN, new KreisStrategie( 100, 20 ) );
		
		
		// Autos zur Simulation hinzufügen
		fahrbahn.addAuto( s1, new Point(0, 0) );
		fahrbahn.addAuto( b2, new Point(9, 0) );
		//fahrbahn.addAuto( b1, new Point(10, 0) );
		//fahrbahn.addAuto( b2, new Point(20, 0) );
		
		// Simulation starten
		fahrbahn.start();
	}
}
