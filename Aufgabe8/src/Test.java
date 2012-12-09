import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bauernhof bHof = new Bauernhof( "Bauernhof 1" );
		
		DieselTraktor dieselT = new DieselTraktor( 1, 0.0, new Duengerstreuer(500.5), 0 );
		
		if ( dieselT.getRolle().getEinsatzzweck().equals( Einsatzzweck.DRILLMASCHINE ) ) {
			System.out.print( "Drillmaschine - Anzahl Saeschare: " );
		}
		else {
			System.out.print( "Duengerstreuer - Kapazitaet: " );
		}
		
		System.out.println( dieselT.getRolle().getValue() );
		
		dieselT.setRolle( new Drillmaschine( 99 ) );
		
		if ( dieselT.getRolle().getEinsatzzweck().equals( Einsatzzweck.DRILLMASCHINE ) ) {
			System.out.print( "Drillmaschine - Anzahl Saeschare: " );
		}
		else {
			System.out.print( "Duengerstreuer - Kapazitaet: " );
		}
		
		System.out.print( dieselT.getRolle().getValue() );
		
		
		/*Annotation[] as = Bauernhof.class.getAnnotations(); // all
		System.out.println( as.length );
		for ( int i = 0; i < as.length; i++ ) {
			System.out.println( as[ i ] );
		}*/
	}
}
