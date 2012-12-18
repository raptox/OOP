public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EinfachKeksBackmaschine b = new EinfachKeksBackmaschine( Form.MOND, Teigart.ZIMTSTERNTEIG );
		Keks k = b.backe();
		
		System.out.println( k );
		
		b.setTeig( Teigart.SCHOKOLADENTEIG );
		
		System.out.println( b.backe() );
		
		//DoppelKeksBackmaschine doppelBackmaschine = new DoppelKeksBackmaschine( k, Fuellung.MARMELADE );
		System.out.println( doppelBackmaschine.backe() );
	}
}
