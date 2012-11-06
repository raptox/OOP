package models;
import java.io.Serializable;
import java.util.Date;
import notification.Announcement;
import notification.Notification;

/*
 * Klasse Play stellt ein Treffen der Band dar
 */
//GUT: dynamisches Binden, Credits, es gibt nur eine Methode getCredits und zwar in Credits
public abstract class Play extends Credits implements Serializable{

    private Location location;
    private Date timeAndDate;
    private int duration;
	private static final long serialVersionUID = 1L;
    private Band band;

    /*
	 * Leerer Konstruktor 
	 */
    public Play() {
    	super();
    }

    /*
     * Konstruktor
     * Vorb.: location != null && timeAndDate != null && duration > 0 && credits > 0
     */
    public Play(Location location, Date timeAndDate, int duration, double credits) {
    	super(credits);
    	this.location = location;
    	this.timeAndDate = timeAndDate;
    	this.duration = duration;
    }
    
    /*
     * getter fuer timeAndDate
     */
    public Date getTimeAndDate() {
    	return this.timeAndDate;
    }
    
    /* 
     * Verschiebt einen Gig/Practice Session und liefert die Ank�ndigung zur�ck.
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
     * Sagt einen Gig/Practice Session ab und liefert die Ank�ndigung zur�ck.
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
