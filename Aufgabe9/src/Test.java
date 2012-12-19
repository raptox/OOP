import java.util.ArrayList;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Position> positionen1 = new ArrayList<Position>();
		positionen1.add(new Position(5,Form.MOND,Teigart.MUERBTEIG));
		positionen1.add(new Position(3,Form.RUND,Teigart.SCHOKOLADENTEIG));
		positionen1.add(new Position(4,Form.WEIHNACHTSMANN,Teigart.ZIMTSTERNTEIG));
		positionen1.add(new Position(2,Form.MOND,Teigart.MUERBTEIG,Fuellung.MARMELADE));
		
		ArrayList<Position> positionen2 = new ArrayList<Position>();
		positionen2.add(new Position(3,Form.MOND,Teigart.MUERBTEIG));
		positionen2.add(new Position(3,Form.RUND,Teigart.SCHOKOLADENTEIG));
		positionen2.add(new Position(5,Form.WEIHNACHTSMANN,Teigart.ZIMTSTERNTEIG,Fuellung.SCHOKOLADE));
		positionen2.add(new Position(4,Form.WEIHNACHTSMANN,Teigart.ZIMTSTERNTEIG));
		positionen2.add(new Position(10,Form.MOND,Teigart.MUERBTEIG,Fuellung.MARMELADE));
		
		ArrayList<Position> positionen3 = new ArrayList<Position>();
		positionen3.add(new Position(10,Form.RUND,Teigart.ZIMTSTERNTEIG));
		positionen3.add(new Position(5,Form.MOND,Teigart.ZIMTSTERNTEIG));
		positionen3.add(new Position(2,Form.WEIHNACHTSMANN,Teigart.ZIMTSTERNTEIG,Fuellung.MARMELADE));
		positionen3.add(new Position(5,Form.MOND,Teigart.ZIMTSTERNTEIG));
		positionen3.add(new Position(10,Form.RUND,Teigart.MUERBTEIG,Fuellung.MARMELADE));
		
		Bestellung bestellung1 = new Bestellung(positionen1);
		Bestellung bestellung2 = new Bestellung(positionen2);
		Bestellung bestellung3 = new Bestellung(positionen3);
		
		// Ausgeben der Bestellungen und deren Positionen
		System.out.println(bestellung1.drucke());
		System.out.println(bestellung2.drucke());
		System.out.println(bestellung3.drucke());
		
		Baeckerei b = new Baeckerei("Haubis");
		
		// erste Bestellung backen und Kecksdose ausgeben
		b.neueBestellung(bestellung1);
		System.out.println(b.liefereBestellungen().inhalt());
		
		// zweite Bestellung backen und Kecksdose ausgeben
		b.neueBestellung(bestellung2);
		System.out.println(b.liefereBestellungen().inhalt());
		
		// dritte Bestellung backen und Kecksdose ausgeben
		b.neueBestellung(bestellung3);
		System.out.println(b.liefereBestellungen().inhalt());
	}
}
