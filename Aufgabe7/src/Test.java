import java.awt.Point;



public class Test {
	public static void main(String[] args) {
		Fahrbahn fahrbahn = new Fahrbahn( 10, 10 );
		
		// Autos erstellen
		SchnellesAuto s1 = new SchnellesAuto( "A", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s2 = new SchnellesAuto( "B", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s3 = new SchnellesAuto( "C", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s4 = new SchnellesAuto( "D", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s5 = new SchnellesAuto( "E", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s6 = new SchnellesAuto( "F", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s7 = new SchnellesAuto( "G", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s8 = new SchnellesAuto( "H", 200l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		
		BeweglichesAuto b1 = new BeweglichesAuto( "AntonSchnecki", 200l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		BeweglichesAuto b2 = new BeweglichesAuto( "Gary", 200l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		
		
		// Autos zur Simulation hinzufügen
		
		//fahrbahn.addAuto( b1, new Point(9, 0) );
		fahrbahn.addAuto( s1, new Point(0, 0) );
		//fahrbahn.addAuto( b2, new Point(8, 0) );
		fahrbahn.addAuto( s2, new Point(0, 1) );
		fahrbahn.addAuto( s3, new Point(4, 0) );
		fahrbahn.addAuto( s4, new Point(3, 6) );
		fahrbahn.addAuto( s5, new Point(1, 1) );
		fahrbahn.addAuto( s6, new Point(2, 1) );
		fahrbahn.addAuto( s7, new Point(3, 1) );
		fahrbahn.addAuto( s8, new Point(5, 1) );
		//fahrbahn.addAuto( b1, new Point(10, 0) );
		//fahrbahn.addAuto( b2, new Point(20, 0) );
		
		// Simulation starten
		fahrbahn.start();
		
	}
}
