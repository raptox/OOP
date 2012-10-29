package models;
import java.io.Serializable;
import java.util.Date;
import notification.Announcement;
import notification.Notification;

public abstract class Play implements Serializable, Credits {

    private Location location;
    private Date timeAndDate;
    private int duration;
    private double credits;
	private static final long serialVersionUID = 1L;
    private Band band;

    /**
	 * 
	 */
    
    public Play() {
    	
    }

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
    
    /* 
     * Method to postpone the gig/practice session to a new date in future
     */
    public Announcement postpone( Date d, String message ) {
    	Announcement postponedGig = new Announcement( message );
    	Notification notificationList = this.band.getNotificationList();
    	
    	this.timeAndDate = d;
    	
    	notificationList.announce( postponedGig );
    	
    	return postponedGig;
    }
    
    /*
     * Cancel gig/practice session
     */
    public Announcement cancel( String message ) {
    	return this.postpone( null, message );
    }
    
    public void setBand( Band b ) {
    	this.band = b;
    }
    
    public Band getBand() {
    	return this.band;
    }
    
    public String toString() {
    	return ""+location+" Date and Time: "+timeAndDate.toString()+", Duration(min):"+duration/60; 
    }
}
