import java.util.Iterator;

/*
 * @author Bernd
 */
@Programmierer(autoren="Bernd Artmueller")
public class Bauernhof {
	private String name;
	
	/**
	 * Konstruktor von Bauernhof setzt den unveraenderlichen Namen des Bauernhofes
	 * 
	 * @param name Name des Bauernhofes, kann nachtraeglich nicht mehr veraendert werden
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public Bauernhof( String name ) {
		this.name = name;
	}
	
	/**
	 * Liefert den Namen des Bauernhof
	 * 
	 * @return name
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public String getName() {
		return this.name;
	}
	
	/**
	 * Liefert die durchschnittliche Anzahl an Betriebsstunden aller Traktoren
	 *
	 * @return durchschnittliche Anzahl an Betriebsstunden
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicheBetriebsstunden() {
        return berechneDurchschnitt( new DurchschnittlicheBetriebsstundenRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return true;
            }
        });
    }
	
	/**
	 * Liefert die durchschnittliche Anzahl an Betriebsstunden aller Traktoren mit dem uebergebenden Einsatzzweck
	 * 
	 * Vorb.: einsatzzweck != null
	 * 
	 * @param einsatzzweck Einsatzzweck der Traktoren, deren durchschnittliche Betriebsstunden berechnet werden sollen
	 * @return durchschnittliche Anzahl an Betriebsstunden
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicheBetriebsstunden( final Einsatzzweck einsatzzweck ) {
        return berechneDurchschnitt( new DurchschnittlicheBetriebsstundenRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return einsatzzweck.equals( traktor.getRolle().getEinsatzzweck() );
            }
        });
    }
	
	/**
	 * Liefert die durchschnittliche Anzahl an Betriebsstunden aller Traktoren aufgeschluesselt nach der Art des Traktors (Diesel- oder Biogastraktor)
	 * 
	 * Vorb.: einsatzzweck != null
	 * 
	 * @param einsatzzweck Einsatzzweck der Traktoren, deren durchschnittliche Betriebsstunden berechnet werden sollen
	 * @return durchschnittliche Anzahl an Betriebsstunden
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicheBetriebsstunden( final Motor art ) {
        return berechneDurchschnitt( new DurchschnittlicheBetriebsstundenRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return art.equals( traktor.getMotor() );
            }
        });
    }
	
	

	/**
     * Berechnet und Liefert den Durchschnittswert
     * 
     * Vorb.: rechner != null
     */
	@Programmierer(autoren="Bernd Artmueller")
    private double berechneDurchschnitt( IRechner rechner ) {
        //Iterator<AbstractTraktor> iter = roboters.iterator();
        double summe = 0.0;
        int anzahl = 0;

       /* while (iter.hasNext()) {
            AbstractTraktor traktor = iter.next();
            
            // wenn der Traktor die Bedingung erfüllt, beziehe diesen in die Berechnung mitein
            if ( rechner.bedingung( traktor ) ) {
            	summe += rechner.wert( traktor );
                anzahl++;
            }
        }
        */
        if ( anzahl == 0 ) {
        	return 0.0;
        }
        
        return summe / anzahl;
    }
    
	/**
     * Interface für die Berechnung der Durchschnittswerte anhan einer Bedingung
     */
	@Programmierer(autoren="Bernd Artmueller")
    private interface IRechner {
		/**
	     * Diese Methode stellt eine Bedinung dar, die bei der Berechnung erfüllt werden muss um einen Traktor in die Berechnung
	     * einzubeziehen.
	     * 
	     * @param traktor Traktor, welcher ueberprueft werden soll
	     * @return Wahr, wenn der Traktor die Bedinung erfuellt, andernfall Falsch
	     */
        public boolean bedingung( AbstractTraktor traktor );
        
        /**
         * Liefert den Wert der fuer die Berechnung verwendet werden soll (Betriebsstunden, Dieselverbrauch, usw)
         *
         * @param traktor Traktor, dessen Wert verwendet werden soll
	     * @return Wert der fuer die Berechnung relevant ist
         */
        public double wert( AbstractTraktor traktor );
    }
	
    /**
     * Klasse die für die Berechnung der durchschnittlichen Anzahl der Betriebsstunden von Traktoren
     */
	@Programmierer(autoren="Bernd Artmueller")
    private abstract class DurchschnittlicheBetriebsstundenRechner implements IRechner {
        public double wert( AbstractTraktor traktor ) {
            return traktor.getBetriebsstunden();
        }
    }
}
