import java.awt.Point;



public class Test {
	public static void main(String[] args) {
		/*Fahrbahn fahrbahn = new Fahrbahn( 10, 10 );
		
		// Autos erstellen
		SchnellesAuto s1 = new SchnellesAuto( "A", 20l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s2 = new SchnellesAuto( "B", 30l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s3 = new SchnellesAuto( "C", 10l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s4 = new SchnellesAuto( "D", 15l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s5 = new SchnellesAuto( "E", 20l, Richtung.SUEDEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s6 = new SchnellesAuto( "F", 30l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s7 = new SchnellesAuto( "G", 40l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s8 = new SchnellesAuto( "H", 50l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		
		BeweglichesAuto b1 = new BeweglichesAuto( "X", 200l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		BeweglichesAuto b2 = new BeweglichesAuto( "Y", 200l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		
		
		// Autos zur Simulation hinzufuegen
		
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
		fahrbahn.addAuto( b1, new Point(9, 9) );
		fahrbahn.addAuto( b2, new Point(5, 5) );
				
		// Simulation starten
		fahrbahn.start();*/
		
		Fahrbahn game = new Fahrbahn(5,5);
		SchnellesAuto s1 = new SchnellesAuto( "S1", 20l, Richtung.OSTEN, new SchlangenLinieStrategie(5,5) );
		SchnellesAuto s2 = new SchnellesAuto( "S2", 30l, Richtung.SUEDEN, new SchlangenLinieStrategie(5,5) );		
		BeweglichesAuto b1 = new BeweglichesAuto( "B1", 200l, Richtung.WESTEN, new SchlangenLinieStrategie(5,5) );
		BeweglichesAuto b2 = new BeweglichesAuto( "B2", 200l, Richtung.NORDEN, new SchlangenLinieStrategie(5,5) );	
		game.addAuto(s1, new Point(0,0));
		game.addAuto(s2, new Point(4,0));
		game.addAuto(b1, new Point(0,4));
		game.addAuto(b2, new Point(4,4));
		game.start();
		
	}
}
