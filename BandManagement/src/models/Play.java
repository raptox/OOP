package models;
import java.util.Date;

public abstract class Play implements Credits{
    private Location location;
    private Date timeAndDate;
    private int duration;
    private double credits;

    public Play(Location location, Date timeAndDate, int duration, double credits) {
    	this.location = location;
    	this.timeAndDate = timeAndDate;
    	this.duration = duration;
    	this.credits = credits;
    }
    
    public double getCredits(){
    	return credits;
    }
    
    public Date getTimeAndDate() {
    	return this.timeAndDate;
    }

    public String toString() {
    	return ""+location+" Date and Time: "+timeAndDate.toString()+", Duration(min):"+duration/60; 
    }
}
