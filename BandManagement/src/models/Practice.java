package models;
import java.util.Date;

public class Practice extends Play implements Costs{
    public Practice(Location location, Date timeAndDate, int duration, double costs) {
    	super(location, timeAndDate, duration, costs);
    }

    public String toString() {
    	return super.toString()+", Rent: "+this.getCredits();
    }
}
