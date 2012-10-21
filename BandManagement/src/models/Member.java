package models;
import java.util.Date;

import notification.*;


public class Member implements Observer {
	private String name;
	private String telNumber;
	private String instrument;
	private String password;
	private Date joinDate;
	private Date leaveDate;
	
	public Member( String name, String telNumber, String instrument, Date joinDate) {
		this.name = name;
		this.telNumber = telNumber;
		this.instrument = instrument;
		this.joinDate = joinDate;
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
		if ( this.name.equals( "Corey Tailor" ) ) {
			announcement.accept( "Ja find ich eh besser!", this );
		}
		else if ( this.name.equals( "Mick Thomson" ) ) {
			announcement.reject( "Oh! Das passt mir gar nicht!", this );
		}
		System.out.println( this.name + ": " + announcement.getMessage() );
	}
}
