import java.util.Date;

public class Practice extends Play {
    private double rent;

    public Practice(String location, Date timeAndDate, int duration, double rent) {
    	super(location, timeAndDate, duration);
    	this.rent = rent;
    }

    public String toString() {
    	return super.toString()+", Rent: "+rent;
    }

    public double getRent() {
    	return rent;
    }
}
