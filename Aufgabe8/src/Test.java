import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Bauernhof bHof = new Bauernhof( "Bauernhof 1" );
		
		bHof.addTraktor( new DieselTraktor( 1, 10.0, new Duengerstreuer(500.5), 5 ) );
		bHof.addTraktor( new DieselTraktor( 2, 20.0, new Drillmaschine(20), 5 ) );
		bHof.addTraktor( new BiogasTraktor( 3, 30.0, new Duengerstreuer(600.9), 3 ) );
		bHof.addTraktor( new BiogasTraktor( 4, 40.0, new Drillmaschine(60), 4 ) );
		bHof.addTraktor( new BiogasTraktor( 5, 10.0, new Drillmaschine(30), 2 ) );
		
		System.out.println( "Durchschnittliche Betriebsstunden aller Traktoren zusammen: " + bHof.durchschnittlicheBetriebsstunden() );
		System.out.println( "Durchschnittliche Betriebsstunden aller Drillmaschinen: " + bHof.durchschnittlicheBetriebsstunden( Einsatzzweck.DRILLMASCHINE ) );
		System.out.println( "Durchschnittliche Betriebsstunden aller Duengerstreuer: " + bHof.durchschnittlicheBetriebsstunden( Einsatzzweck.DUENGERSTREUER ) );
		System.out.println( "Durchschnittliche Betriebsstunden aller Dieseltraktoren: " + bHof.durchschnittlicheBetriebsstunden( Motor.DIESELTRAKTOR ) );
		System.out.println( "Durchschnittliche Betriebsstunden aller Biogastraktoren: " + bHof.durchschnittlicheBetriebsstunden( Motor.BIOGASTRAKTOR ) );
		
		System.out.println( "\nDurchschnittliche Dieselverbrauch aller Diesetraktoren: " + bHof.durchschnittlicherDieselverbrauch() );
		System.out.println( "Durchschnittliche Dieselverbrauch aller Diesetraktoren mit Einsatzart als Drillmaschine: " + bHof.durchschnittlicherDieselverbrauch( Einsatzzweck.DRILLMASCHINE ) );
		System.out.println( "Durchschnittliche Dieselverbrauch aller Diesetraktoren mit Einsatzart als Duengerstreuer: " + bHof.durchschnittlicherDieselverbrauch( Einsatzzweck.DUENGERSTREUER ) );
		
		System.out.println( "\nDurchschnittliche Gasverbrauch aller Biogastraktoren: " + bHof.durchschnittlicherGasverbrauch() );
		System.out.println( "Durchschnittliche Gasverbrauch aller Biogastraktoren mit Einsatzart als Drillmaschine: " + bHof.durchschnittlicherGasverbrauch( Einsatzzweck.DRILLMASCHINE ) );
		System.out.println( "Durchschnittliche Gasverbrauch aller Biogastraktoren mit Einsatzart als Duengerstreuer: " + bHof.durchschnittlicherGasverbrauch( Einsatzzweck.DUENGERSTREUER ) );
		
		System.out.println( "\nMinimale Anzahl an Saescharen insgesamt: " + bHof.minAnzahlSaescharen() );
		System.out.println( "Minimale Anzahl an Saescharen (Dieseltraktoren): " + bHof.minAnzahlSaescharen( Motor.DIESELTRAKTOR ) );
		System.out.println( "Minimale Anzahl an Saescharen (Biogastraktoren): " + bHof.minAnzahlSaescharen( Motor.BIOGASTRAKTOR ) );
		
		System.out.println( "\nMaximale Anzahl an Saescharen insgesamt: " + bHof.maxAnzahlSaescharen() );
		System.out.println( "Maximale Anzahl an Saescharen (Dieseltraktoren): " + bHof.maxAnzahlSaescharen( Motor.DIESELTRAKTOR ) );
		System.out.println( "Maximale Anzahl an Saescharen (Biogastraktoren): " + bHof.maxAnzahlSaescharen( Motor.BIOGASTRAKTOR ) );
		
		System.out.println( "\nDurchschnittliche Fassungskapazität des Düngerbehälters aller Traktoren: " + bHof.durchschnittlicherDuengerstreuerFassungskapazitaet() );
		System.out.println( "Durchschnittliche Fassungskapazität des Düngerbehälters (Dieseltraktoren): " + bHof.durchschnittlicherDuengerstreuerFassungskapazitaet( Motor.DIESELTRAKTOR ) );
		System.out.println( "Durchschnittliche Fassungskapazität des Düngerbehälters (Biogastraktoren): " + bHof.durchschnittlicherDuengerstreuerFassungskapazitaet( Motor.BIOGASTRAKTOR ) );

		
		
		
		/*Annotation[] as = Bauernhof.class.getAnnotations(); // all
		System.out.println( as.length );
		for ( int i = 0; i < as.length; i++ ) {
			System.out.println( as[ i ] );
		}*/
	}
}
