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
	
	/*
	 * Konstrukor
	 * Vorb.: name!=null,telNumber!=null,instrument!=null,joinDate!=null
	 */
	public Member( String name, String telNumber, String instrument, Date joinDate) {
		this.name = name;
		this.telNumber = telNumber;
		this.instrument = instrument;
		this.joinDate = joinDate;
		this.announcementList = new ArrayList<Announcement>();
		
		leaveDate = null;
		this.password = "";
	}
	
	//Konstruktor nur für Admin
	public Member( String name ) {
		this.name = name;
	}
	//Liefert das Passwort zurueck
	public String getPassword() {
		return password;
	}
	
	/*
	 * Setzt das Passwort mit pass
	 * Vorb.: pass!=null
	 */
	public void setPassword(String pass) {
		password = pass;
	}
	/*
	 * Liefert den Namen eines Members zurueck
	 */
	public String getName() {
		return this.name;
	}
	/*
	 * Liefert das Eintrittsdatum eines Members zurueck
	 */
	public Date getJoinDate(){
		return joinDate;
	}
	
	/*
	 * Liefert das Datum zurueck an dem das Mitglied die Band verlassen hat
	 */
	public Date getLeaveDate(){
		return leaveDate;
	}
	/*
	 * setzt das leaveDate auf einen Zeitpunkt
	 * Vorb.: leaveDate!=null
	 */
	public void setLeaveDate(Date leaveDate){
		this.leaveDate = leaveDate;
	}
	/*
	 * Ueberschreibt die toString Methode und gibt einen gut lesbaren String eines
	 * Members zurueck in dem der Name, das Instrument und die Telefonnummer enthalten sind
	 */
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
			//Invariante: a!=null
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
	/*
	 * Vergleicht den namen eines uebergebenen Mitglieds mit dem gespeicherten
	 * Vorb.: m!=null
	 */
	public boolean equals( Member m ) {
		return this.name.equals( m.getName() );
	}
}
