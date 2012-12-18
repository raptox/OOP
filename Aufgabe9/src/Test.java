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
		
		Bestellung bestellung1 = new Bestellung(positionen1);
		System.out.println(bestellung1.drucke());
		
		Baeckerei b = new Baeckerei("Haubis");
		b.neueBestellung(bestellung1);
		
		System.out.println(b.liefereBestellungen().listeInhalt());
		
		
		
	}
}
