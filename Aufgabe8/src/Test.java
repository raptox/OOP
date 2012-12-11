import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Iterator;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try{
			HashSet hoefe = new HashSet();

			Bauernhof bHof1 = new Bauernhof( "Bauernhof 1" );
			Bauernhof bHof2 = new Bauernhof( "Bauernhof 2" );
			Bauernhof bHof3 = new Bauernhof( "Bauernhof 3" );
			Bauernhof bHof4 = new Bauernhof( "Bauernhof 4" );
			Bauernhof bHof5 = new Bauernhof( "Bauernhof 5" );

			//Fuege Hoefe hinzu
			hoefe.insert(bHof1.getName(), bHof1);
			hoefe.insert(bHof2.getName(), bHof2);
			hoefe.insert(bHof3.getName(), bHof3);
			hoefe.insert(bHof4.getName(), bHof4);
			hoefe.insert(bHof5.getName(), bHof5);

			//Jedem Hof werden 5 Traktoren hinzugefuegt

			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).addTraktor( new DieselTraktor( 1, 10.0, new Duengerstreuer(500.5), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).addTraktor( new DieselTraktor( 2, 20.0, new Drillmaschine(20), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).addTraktor( new BiogasTraktor( 3, 30.0, new Duengerstreuer(600.9), 3 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).addTraktor( new BiogasTraktor( 4, 40.0, new Drillmaschine(60), 4 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).addTraktor( new BiogasTraktor( 5, 10.0, new Drillmaschine(30), 2 ) );

			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).addTraktor( new DieselTraktor( 6, 10.0, new Duengerstreuer(500.5), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).addTraktor( new DieselTraktor( 7, 20.0, new Drillmaschine(20), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).addTraktor( new BiogasTraktor( 8, 30.0, new Duengerstreuer(600.9), 3 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).addTraktor( new BiogasTraktor( 9, 40.0, new Drillmaschine(60), 4 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).addTraktor( new BiogasTraktor( 10, 10.0, new Drillmaschine(30), 2 ) );

			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).addTraktor( new DieselTraktor( 11, 10.0, new Duengerstreuer(500.5), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).addTraktor( new DieselTraktor( 12, 20.0, new Drillmaschine(20), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).addTraktor( new BiogasTraktor( 13, 30.0, new Duengerstreuer(600.9), 3 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).addTraktor( new BiogasTraktor( 14, 40.0, new Drillmaschine(60), 4 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).addTraktor( new BiogasTraktor( 15, 10.0, new Drillmaschine(30), 2 ) );

			((Bauernhof) hoefe.getValue( "Bauernhof 4" )).addTraktor( new DieselTraktor( 16, 10.0, new Duengerstreuer(500.5), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 4" )).addTraktor( new DieselTraktor( 17, 20.0, new Drillmaschine(20), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 4" )).addTraktor( new BiogasTraktor( 18, 30.0, new Duengerstreuer(600.9), 3 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 4" )).addTraktor( new BiogasTraktor( 19, 40.0, new Drillmaschine(60), 4 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 4" )).addTraktor( new BiogasTraktor( 20, 10.0, new Drillmaschine(30), 2 ) );

			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).addTraktor( new DieselTraktor( 21, 10.0, new Duengerstreuer(500.5), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).addTraktor( new DieselTraktor( 22, 20.0, new Drillmaschine(20), 5 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).addTraktor( new BiogasTraktor( 23, 30.0, new Duengerstreuer(600.9), 3 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).addTraktor( new BiogasTraktor( 24, 40.0, new Drillmaschine(60), 4 ) );
			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).addTraktor( new BiogasTraktor( 25, 10.0, new Drillmaschine(30), 2 ) );

			//Traktoren von Hoefen Aendern/Loeschen

			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).entferneTraktor(1);
			((Bauernhof) hoefe.getValue( "Bauernhof 1" )).entferneTraktor(4);

			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).entferneTraktor(6);
			((Bauernhof) hoefe.getValue( "Bauernhof 2" )).getTraktor(7).erhoeheBetriebsstunden(10);

			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).entferneTraktor(13);
			((Bauernhof) hoefe.getValue( "Bauernhof 3" )).getTraktor(14).setRolle(new Duengerstreuer(499.3));

			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).getTraktor(22).erhoeheBetriebsstunden(15);
			((Bauernhof) hoefe.getValue( "Bauernhof 5" )).getTraktor(25).erhoeheBetriebsstunden(20);

			//Alle Hoefe werden (mit ihen Traktoren) ausgeben
			System.out.println("Alle Hoefe Ausgeben:\n"+hoefe);

			//Durchschnitte ausgeben
			Iterator it = hoefe.iterator();
			while(it.hasNext()){
				Bauernhof bHof = (Bauernhof) it.next();
				System.out.println( "Durchschnittliche Betriebsstunden aller Traktoren zusammen von " + bHof.getName()+ ": " + bHof.durchschnittlicheBetriebsstunden() );
				System.out.println( "Durchschnittliche Betriebsstunden aller Drillmaschinen von " + bHof.getName()+ ": " + bHof.durchschnittlicheBetriebsstunden( Einsatzzweck.DRILLMASCHINE ) );
				System.out.println( "Durchschnittliche Betriebsstunden aller Duengerstreuer von " + bHof.getName()+ ": " + bHof.durchschnittlicheBetriebsstunden( Einsatzzweck.DUENGERSTREUER ) );
				System.out.println( "Durchschnittliche Betriebsstunden aller Dieseltraktoren von " + bHof.getName()+ ": " + bHof.durchschnittlicheBetriebsstunden( Motor.DIESELTRAKTOR ) );
				System.out.println( "Durchschnittliche Betriebsstunden aller Biogastraktoren von " + bHof.getName()+ ": " + bHof.durchschnittlicheBetriebsstunden( Motor.BIOGASTRAKTOR ) );

				System.out.println( "\nDurchschnittliche Dieselverbrauch aller Diesetraktoren von " + bHof.getName()+ ": " + bHof.durchschnittlicherDieselverbrauch() );
				System.out.println( "Durchschnittliche Dieselverbrauch aller Diesetraktoren mit Einsatzart als Drillmaschine von " + bHof.getName()+ ": " + bHof.durchschnittlicherDieselverbrauch( Einsatzzweck.DRILLMASCHINE ) );
				System.out.println( "Durchschnittliche Dieselverbrauch aller Diesetraktoren mit Einsatzart als Duengerstreuer von " + bHof.getName()+ ": " + bHof.durchschnittlicherDieselverbrauch( Einsatzzweck.DUENGERSTREUER ) );

				System.out.println( "\nDurchschnittliche Gasverbrauch aller Biogastraktoren von " + bHof.getName()+ ": " + bHof.durchschnittlicherGasverbrauch() );
				System.out.println( "Durchschnittliche Gasverbrauch aller Biogastraktoren mit Einsatzart als Drillmaschine von " + bHof.getName()+ ": " + bHof.durchschnittlicherGasverbrauch( Einsatzzweck.DRILLMASCHINE ) );
				System.out.println( "Durchschnittliche Gasverbrauch aller Biogastraktoren mit Einsatzart als Duengerstreuer von " + bHof.getName()+ ": " + bHof.durchschnittlicherGasverbrauch( Einsatzzweck.DUENGERSTREUER ) );

				System.out.println( "\nMinimale Anzahl an Saescharen insgesamt von " + bHof.getName()+ ": " + bHof.minAnzahlSaescharen() );
				System.out.println( "Minimale Anzahl an Saescharen (Dieseltraktoren) von " + bHof.getName()+ ": " + bHof.minAnzahlSaescharen( Motor.DIESELTRAKTOR ) );
				System.out.println( "Minimale Anzahl an Saescharen (Biogastraktoren) von " + bHof.getName()+ ": " + bHof.minAnzahlSaescharen( Motor.BIOGASTRAKTOR ) );

				System.out.println( "\nMaximale Anzahl an Saescharen insgesamt von " + bHof.getName()+ ": " + bHof5.maxAnzahlSaescharen() );
				System.out.println( "Maximale Anzahl an Saescharen (Dieseltraktoren) von " + bHof.getName()+ ": " + bHof.maxAnzahlSaescharen( Motor.DIESELTRAKTOR ) );
				System.out.println( "Maximale Anzahl an Saescharen (Biogastraktoren) von " + bHof.getName()+ ": " + bHof.maxAnzahlSaescharen( Motor.BIOGASTRAKTOR ) );

				System.out.println( "\nDurchschnittliche Fassungskapazität des Düngerbehälters aller Traktoren von " + bHof.getName()+ ": " + bHof.durchschnittlicherDuengerstreuerFassungskapazitaet() );
				System.out.println( "Durchschnittliche Fassungskapazität des Düngerbehälters (Dieseltraktoren) von " + bHof.getName()+ ": " + bHof.durchschnittlicherDuengerstreuerFassungskapazitaet( Motor.DIESELTRAKTOR ) );
				System.out.println( "Durchschnittliche Fassungskapazität des Düngerbehälters (Biogastraktoren) von " + bHof.getName()+ ": " + bHof.durchschnittlicherDuengerstreuerFassungskapazitaet( Motor.BIOGASTRAKTOR ) );
			}

		}
		catch(java.lang.ArithmeticException e){
			if(e != null){
				System.out.println("Error Message = " + e.getMessage());
			}
		}

		Annotation[] as = Bauernhof.class.getAnnotations(); // all
		System.out.println( as.length );
		for ( int i = 0; i < as.length; i++ ) {
			System.out.println( as[ i ] );
		}
	}
}
