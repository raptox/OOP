package models;
import java.util.Date;

public class Gig extends Play implements Revenues {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double credit;
	
	public Gig() {
		super();
	}

	public Gig(Location location, Date timeAndDate, int duration, double credits) {
    	super(location, timeAndDate, duration, credits);
    	this.credit = credit;
    }	
	

    public String toString() {
    	return super.toString()+", Revenues: "+this.getCredits();
    }

    public double getCredit() {
    	return credit;
    }
}
