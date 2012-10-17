import java.util.Date;

public class Gig extends Play {
    private double credit;

    public Gig(String location, Date timeAndDate, int duration, double credit) {
    	super(location, timeAndDate, duration);
    	this.credit = credit;
    }

    public String toString() {
    	return super.toString()+", Credit: "+credit;
    }

    public double getCredit() {
    	return credit;
    }
}
