import java.awt.Point;



public class Test {
	public static void main(String[] args) {
		Fahrbahn fahrbahn = new Fahrbahn( 10, 2 );
		
		// Autos erstellen
		SchnellesAuto s1 = new SchnellesAuto( "Speedy", 200l, Richtung.OSTEN, new KreisStrategie( 10, 2 ) );
		SchnellesAuto s2 = new SchnellesAuto( "Fasty", 200l, Richtung.OSTEN, new KreisStrategie( 10, 2 ) );
		
		BeweglichesAuto b1 = new BeweglichesAuto( "AntonSchnecki", 1000l, Richtung.WESTEN, new ZufallStrategie( 10, 2 ) );
		BeweglichesAuto b2 = new BeweglichesAuto( "Gary", 1000l, Richtung.WESTEN, new ZufallStrategie( 10, 2 ) );
		
		
		// Autos zur Simulation hinzufügen
		
		fahrbahn.addAuto( b1, new Point(9, 0) );
		fahrbahn.addAuto( s1, new Point(0, 0) );
		fahrbahn.addAuto( b2, new Point(8, 0) );
		fahrbahn.addAuto( s2, new Point(0, 1) );
		//fahrbahn.addAuto( b1, new Point(10, 0) );
		//fahrbahn.addAuto( b2, new Point(20, 0) );
		
		// Simulation starten
		fahrbahn.start();
	}
}
