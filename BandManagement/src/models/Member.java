package models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import notification.*;


public class Member implements Observer, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String telNumber;
	private String instrument;
	private Date joinDate;
	private Date leaveDate;
	private ArrayList<Announcement> announcementList;
	
	public Member( String name, String telNumber, String instrument, Date joinDate) {
		this.name = name;
		this.telNumber = telNumber;
		this.instrument = instrument;
		this.joinDate = joinDate;
		this.announcementList = new ArrayList<Announcement>();
		
		leaveDate = null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Date getJoinDate(){
		return joinDate;
	}
	
	public Date getLeaveDate(){
		return leaveDate;
	}
	
	public void setLeaveDate(Date leaveDate){
		this.leaveDate = leaveDate;
	}
	
	public String toString() {
		return (name+"|"+instrument+"|"+telNumber);
	}

	@Override
	public void update( Announcement announcement ) {
		// add new announcement to members announcement list
		this.announcementList.add( announcement );
		
		if ( this.name.equals( "Corey Tailor" ) ) {
			announcement.accept( "Ja find ich eh besser!", this );
		}
		else if ( this.name.equals( "Mick Thomson" ) ) {
			announcement.reject( "Oh! Das passt mir gar nicht!", this );
		}
		System.out.println( this.name + ": " + announcement.getMessage() );
	}
	
	public ArrayList<Announcement> listAnnouncements() {
		return this.announcementList;
	}
}
