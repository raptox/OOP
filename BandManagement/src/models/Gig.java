package models;
import java.util.Date;

/*
 * Klasse Gig stellt ein Konzert einer Band dar
 */
// GUT: dynamisches Binden, Revenues, es gibt nur eine Methode getCredits und zwar in Credits
public class Gig extends Play implements Revenues {
	private static final long serialVersionUID = 1L;
	
	/*
	 * leerer Konstruktor
	 */
	public Gig() {
		super();
	}

	/*
	 * Konstruktor, initialisiert gig objekt
	 * Vorb.: location != null && timeAndDate != null && duration > 0 && credits > 0
	 */
	public Gig(Location location, Date timeAndDate, int duration, double credits) {
    	super(location, timeAndDate, duration, credits);
    }	
	
	/*
	 * toString, liefert schoene Darstellung des Gigs als String
	 */
    public String toString() {
    	return super.toString()+", Revenues: "+this.getCredits();
    }
}
