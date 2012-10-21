package models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import notification.*;


public class Member implements Observer, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String telNumber;
	private String instrument;
	private String password;
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
		this.password = "";
	}
	
	// only used for admin
	public Member( String name ) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String pass) {
		password = pass;
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
	}
	
	public ArrayList<Announcement> listAllAnnouncements() {
		return this.announcementList;
	}
	
	public ArrayList<Announcement> listUnreadAnnouncements() {
		ArrayList<Announcement> announcements = new ArrayList<Announcement>();
		
		for ( Announcement a : this.announcementList ) {
			Vector<Decision> decisions = a.getDecisions();
			
			// if no decisions are made until now for this announcement, just add the unread announcement
			if ( decisions.isEmpty() ) {
				announcements.add( a );
			}
			else {
				for ( Decision d : decisions ) {
					if ( !d.getMember().equals( this ) ) {
						announcements.add( a );
					}
				}
			}
		}
		
		return announcements;
	}
	
	public boolean equals( Member m ) {
		return this.name.equals( m.getName() );
	}
}
