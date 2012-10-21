package models;
import java.util.Date;

public class Gig extends Play {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double credit;
	
	public Gig() {
		super();
	}
	
    public Gig(String location, Date timeAndDate, int duration, double credit) {
    	super(location, timeAndDate, duration);
    	this.credit = credit;
    }

    public String toString() {
    	if ( this.getTimeAndDate() != null ) {
    		return super.toString()+", Credit: "+credit;
    	}
    	
    	return null;
    }

    public double getCredit() {
    	return credit;
    }
}
