import java.awt.Point;



public class Test {
	public static void main(String[] args) {
		// Zeitmessung
		long zstVorher;
		long zstNachher;
		zstVorher = System.currentTimeMillis();

		System.out.println("\n\nTestfall 1 - 10 Autos, Zufallsstrategie+Schlangenlinienstrategie\n\n");
		Fahrbahn fahrbahn = new Fahrbahn( 10, 10 );

		// Autos erstellen
		SchnellesAuto s1 = new SchnellesAuto( "s1 ZS", 2l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s2 = new SchnellesAuto( "s2 SL", 3l, Richtung.OSTEN, new SchlangenLinieStrategie( 10, 10 ) );
		SchnellesAuto s3 = new SchnellesAuto( "s3 ZS", 1l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s4 = new SchnellesAuto( "s4 SL", 7l, Richtung.OSTEN, new SchlangenLinieStrategie( 10, 10 ) );
		SchnellesAuto s5 = new SchnellesAuto( "s5 ZS", 6l, Richtung.SUEDEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s6 = new SchnellesAuto( "s6 SL", 9l, Richtung.OSTEN, new SchlangenLinieStrategie( 10, 10 ) );
		SchnellesAuto s7 = new SchnellesAuto( "s7 ZS", 4l, Richtung.OSTEN, new ZufallStrategie( 10, 10 ) );
		SchnellesAuto s8 = new SchnellesAuto( "s8 SL", 8l, Richtung.OSTEN, new SchlangenLinieStrategie( 10, 10 ) );

		BeweglichesAuto b1 = new BeweglichesAuto( "b9 ZS", 20l, Richtung.WESTEN, new ZufallStrategie( 10, 10 ) );
		BeweglichesAuto b2 = new BeweglichesAuto( "b10 SL", 25l, Richtung.WESTEN, new SchlangenLinieStrategie( 10, 10 ) );


		// Autos zur Simulation hinzufuegen
		fahrbahn.addAuto( s1, new Point(0, 0) );
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
		fahrbahn.start();

		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		System.out.println("\n\nTestfall 2 - Schlangenlinien, ZufallsStrategie, 4 Autos\n\n");
		Fahrbahn game = new Fahrbahn(5,5);
		SchnellesAuto ss1 = new SchnellesAuto( "ss1 SL", 5l, Richtung.OSTEN, new SchlangenLinieStrategie(5,5) );
		SchnellesAuto ss2 = new SchnellesAuto( "ss2 ZS", 3l, Richtung.SUEDEN, new ZufallStrategie(5,5) );		
		BeweglichesAuto bb1 = new BeweglichesAuto( "bb1 SL", 12l, Richtung.WESTEN, new SchlangenLinieStrategie(5,5) );
		BeweglichesAuto bb2 = new BeweglichesAuto( "bb2 ZS", 15l, Richtung.NORDEN, new ZufallStrategie(5,5) );	
		game.addAuto(ss1, new Point(0,0));
		game.addAuto(ss2, new Point(4,0));
		game.addAuto(bb1, new Point(0,4));
		game.addAuto(bb2, new Point(4,4));
		game.start();

		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("\n\nTestfall 3 - Schlangenlinien, ZufallsStrategie 2 Autos\n\n");
		Fahrbahn game2 = new Fahrbahn(5,5);
		SchnellesAuto sss2 = new SchnellesAuto( "ss2 ZS", 3l, Richtung.SUEDEN, new ZufallStrategie(5,5) );		
		BeweglichesAuto bbb1 = new BeweglichesAuto( "bb1 SL", 12l, Richtung.WESTEN, new SchlangenLinieStrategie(5,5) );
		game2.addAuto(sss2, new Point(0,0));
		game2.addAuto(bbb1, new Point(0,4));
		game2.start();

		try {
			Thread.sleep(1000*3);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		zstNachher = System.currentTimeMillis();
		System.out.println("Zeit benoetigt: " + ((zstNachher - zstVorher)/1000) + " sec");
	}
}
