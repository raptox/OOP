package models;
import java.io.Serializable;
import java.util.Date;
import notification.Announcement;
import notification.Notification;

/*
 * Klasse Play stellt ein Treffen der Band dar
 */
public abstract class Play implements Serializable, Credits {

    private Location location;
    private Date timeAndDate;
    private int duration;
    private double credits;
	private static final long serialVersionUID = 1L;
    private Band band;

    /*
	 * Leerer Konstruktor 
	 */
    public Play() {
    	
    }

    /*
     * Konstruktor
     * Vorb.: location != null && timeAndDate != null && duration > 0 && credits > 0
     */
    public Play(Location location, Date timeAndDate, int duration, double credits) {
    	this.location = location;
    	this.timeAndDate = timeAndDate;
    	this.duration = duration;
    	this.credits = credits;
    }
    
    /*
     * getter fuer credits
     */
    public double getCredits(){
    	return credits;
    }
    
    /*
     * getter fuer timeAndDate
     */
    public Date getTimeAndDate() {
    	return this.timeAndDate;
    }
    
    /* 
     * Verschiebt einen Gig/Practice Session und liefert die Ankündigung zurück.
     * 
     * Vorb.: d != null && message != null
     */
    public Announcement postpone( Date d, String message ) {
    	Announcement postponedGig = new Announcement( message );
    	Notification notificationList = this.band.getNotificationList();
    	
    	this.timeAndDate = d;
    	
    	notificationList.announce( postponedGig );
    	
    	return postponedGig;
    }
    
    /*
     * Sagt einen Gig/Practice Session ab und liefert die Ankündigung zurück.
     * Vorb.: message != null
     */
    public Announcement cancel( String message ) {
    	return this.postpone( null, message );
    }
    
    /*
     * setter fuer band
     */
    public void setBand( Band b ) {
    	this.band = b;
    }
    
    /*
     * getter fuer band
     */
    public Band getBand() {
    	return this.band;
    }
    
    /*
     * Liefert schoenen String der ganzen Infos
     */
    public String toString() {
    	return ""+location+" Date and Time: "+timeAndDate.toString()+", Duration(min):"+duration/60; 
    }
}
