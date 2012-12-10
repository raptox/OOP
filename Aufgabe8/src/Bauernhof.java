import java.util.Iterator;

/*
 * @author Bernd
 */
@Programmierer(autoren="Bernd Artmueller")
public class Bauernhof implements CollectionItem {
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
	 * Vorb.: art != null
	 * 
	 * @param art Art des Traktors (Diesel- oder Biogastraktor)
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
	 * Liefert den durchschnittlichen Dieselverbrauch aller Traktoren
	 * 
	 * @return durchschnittlicher Dieselverbrauch aller Traktoren
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicherDieselverbrauch() {
        return berechneDurchschnitt( new DurchschnittlicherDieselverbrauchRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return traktor instanceof DieselTraktor;
            }
        });
    }
	
	/**
	 * Liefert den durchschnittlichen Dieselverbrauch aller Traktoren aufgeschluesselt nach dem Einsatzzweck der Traktoren (Drill- oder Duengemaschine)
	 * 
	 * Vorb.: einsatzzweck != null
	 * 
	 * @param einsatzzweck Einsatzzweck der Traktoren, deren durchschnittlicher Dieselverbrauch berechnet werden sollen
	 * @return durchschnittlicher Dieselverbrauch aller Traktoren
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicherDieselverbrauch( final Einsatzzweck einsatzzweck ) {
        return berechneDurchschnitt( new DurchschnittlicherDieselverbrauchRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return traktor instanceof DieselTraktor && einsatzzweck.equals( traktor.getRolle().getEinsatzzweck() );
            }
        });
    }
	
	/**
	 * Liefert den durchschnittlichen Gasverbrauch aller Traktoren
	 * 
	 * @return durchschnittlicher Dieselverbrauch aller Traktoren
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicherGasverbrauch() {
        return berechneDurchschnitt( new DurchschnittlicherGasverbrauchRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return traktor instanceof DieselTraktor;
            }
        });
    }
	
	/**
	 * Liefert den durchschnittlichen Gasverbrauch aller Traktoren aufgeschluesselt nach dem Einsatzzweck der Traktoren (Drill- oder Duengemaschine)
	 * 
	 * Vorb.: einsatzzweck != null
	 * 
	 * @param einsatzzweck Einsatzzweck der Traktoren, deren durchschnittlicher Gasverbrauch berechnet werden sollen
	 * @return durchschnittlicher Gasverbrauch
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicherGasverbrauch( final Einsatzzweck einsatzzweck ) {
        return berechneDurchschnitt( new DurchschnittlicherGasverbrauchRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return traktor instanceof BiogasTraktor && einsatzzweck.equals( traktor.getRolle().getEinsatzzweck() );
            }
        });
    }
	
	/**
	 * Liefert die maximale Anzahl an Saescharen aller Duengerstreuer Traktoren
	 * 
	 * @return maximale Anzahl an Saescharen
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double maxAnzahlSaescharen() {
        return this.berechneMax( new RollenRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return traktor.getRolle().equals( Einsatzzweck.DRILLMASCHINE );
            }
        });
    }
	
	/**
	 * Liefert die maximale Anzahl an Saescharen aller Duengerstreuer Traktoren aufgeschluesselt nach der Art des Traktors (Diesel- oder Biogastraktor)
	 * 
	 * Vorb.: art != null
	 * 
	 * @param art Art des Traktors (Diesel- oder Biogastraktor)
	 * @return maximale Anzahl an Saescharen
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double maxAnzahlSaescharen( final Motor art ) {
        return this.berechneMax( 
        	new RollenRechner() {
        		public boolean bedingung( AbstractTraktor traktor ) {
        			return traktor.getRolle().equals( Einsatzzweck.DRILLMASCHINE ) && art.equals( traktor.getMotor() );
        		}
        	}
        );
    }
	
	/**
	 * Liefert die minimale Anzahl an Saescharen aller Duengerstreuer Traktoren
	 * 
	 * @return minimale Anzahl an Saescharen
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double minAnzahlSaescharen() {
        return this.berechneMin( new RollenRechner() {
            public boolean bedingung( AbstractTraktor traktor ) {
            	return traktor.getRolle().equals( Einsatzzweck.DRILLMASCHINE );
            }
        });
    }
	
	/**
	 * Liefert die minimale Anzahl an Saescharen aller Duengerstreuer Traktoren aufgeschluesselt nach der Art des Traktors (Diesel- oder Biogastraktor)
	 * 
	 * Vorb.: art != null
	 * 
	 * @param art Art des Traktors (Diesel- oder Biogastraktor)
	 * @return minimale Anzahl an Saescharen
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double minAnzahlSaescharen( final Motor art ) {
        return this.berechneMin( 
        	new RollenRechner() {
        		public boolean bedingung( AbstractTraktor traktor ) {
        			return traktor.getRolle().equals( Einsatzzweck.DRILLMASCHINE ) && art.equals( traktor.getMotor() );
        		}
        	}
        );
    }
	
	/**
	 * Liefert die durchschnittliche Fassungskapazitaet des Duengebehaelters aller Traktoren insgesamt
	 * 
	 * @return durchschnittliche Fassungskapazitaet des Duengebehaelters
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicherDuengerstreuerFassungskapazitaet() {
        return berechneDurchschnitt( 
        	new RollenRechner() {
        		public boolean bedingung( AbstractTraktor traktor ) {
        			return traktor.getRolle().equals( Einsatzzweck.DUENGERSTREUER );
            	}
        	}
        );
    }
	
	/**
	 * Liefert die durchschnittliche Fassungskapazitaet des Duengebehaelters aller Traktoren aufgeschluesselt nach der Art des Traktors (Diesel- oder Biogastraktor)
	 * 
	 * Vorb.: art != null
	 * 
	 * @param art Art des Traktors (Diesel- oder Biogastraktor)
	 * @return durchschnittliche Fassungskapazitaet des Duengebehaelters
	 */
	@Programmierer(autoren="Bernd Artmueller")
	public double durchschnittlicherDuengerstreuerFassungskapazitaet( final Motor art ) {
        return berechneDurchschnitt( 
        	new RollenRechner() {
        		public boolean bedingung( AbstractTraktor traktor ) {
            		return traktor.getRolle().equals( Einsatzzweck.DUENGERSTREUER ) && art.equals( traktor.getMotor() );
            	}
        	}
        );
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
     * Berechnet und Liefert den Maximalen Wert
     * 
     * Vorb.: rechner != null
     */
	@Programmierer(autoren="Bernd Artmueller")
	private double berechneMax( IRechner rechner ) {
		//Iterator<AbstractTraktor> iter = roboters.iterator();
        double max = 0;

       /* while (iter.hasNext()) {
            AbstractTraktor traktor = iter.next();
            
            // wenn der Traktor die Bedingung erfüllt, beziehe diesen in die Berechnung ein
            if ( rechner.bedingung( traktor ) ) {
            	if ( rechner.wert( traktor ) > max ) {
            		max = rechner.wert( traktor );
            	}
            }
        }
        */
        
        return max;
	}
	
	/**
     * Berechnet und Liefert den Minimale Wert
     * 
     * Vorb.: rechner != null
     */
	@Programmierer(autoren="Bernd Artmueller")
	private double berechneMin( IRechner rechner ) {
		//Iterator<AbstractTraktor> iter = roboters.iterator();
        double min = Double.MAX_VALUE;

       /* while (iter.hasNext()) {
            AbstractTraktor traktor = iter.next();
            
            // wenn der Traktor die Bedingung erfüllt, beziehe diesen in die Berechnung ein
            if ( rechner.bedingung( traktor ) ) {
            	if ( rechner.wert( traktor ) < min ) {
            		min = rechner.wert( traktor );
            	}
            }
        }
        */
        
        return min;
	}
    
	/**
     * Interface für die Berechnung der Durchschnittswerte anhand einer Bedingung
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
     * Klasse die für die Berechnung der durchschnittlichen Anzahl der Betriebsstunden von Traktoren verwendet wird
     */
	@Programmierer(autoren="Bernd Artmueller")
    private abstract class DurchschnittlicheBetriebsstundenRechner implements IRechner {
        public double wert( AbstractTraktor traktor ) {
            return traktor.getBetriebsstunden();
        }
    }
	
	/**
     * Klasse die für die Berechnung des Durchschnitts Dieselverbrauch von Dieseltraktoren verwendet wird
     */
	@Programmierer(autoren="Bernd Artmueller")
    private abstract class DurchschnittlicherDieselverbrauchRechner implements IRechner {
        public double wert( AbstractTraktor traktor ) {
            return ( ( DieselTraktor ) traktor ).getVerbrauchteLiterDiesel();
        }
    }
	
	/**
     * Klasse die für die Berechnung des Durchschnitts Gasverbrauch von Biogastraktoren verwendet wird
     */
	@Programmierer(autoren="Bernd Artmueller")
    private abstract class DurchschnittlicherGasverbrauchRechner implements IRechner {
        public double wert( AbstractTraktor traktor ) {
            return ( ( BiogasTraktor ) traktor ).getVerbrauchtesGas();
        }
    }
	
	/**
     * Klasse die für die Min, Max und Durchschnitts Berechnungen der Rollen Werte (Anzahl Saescharen und Kapazitaet) verwendet wird
     */
	@Programmierer(autoren="Bernd Artmueller")
    private abstract class RollenRechner implements IRechner {
        public double wert( AbstractTraktor traktor ) {
            return traktor.getRolle().getValue();
        }
    }
}
