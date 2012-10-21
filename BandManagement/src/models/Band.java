package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import notification.*;


public class Band {
	private ArrayList<Practice> practiceSessions;
	private ArrayList<Gig> gigs;
	private ArrayList<Member> members;
	private ArrayList<Song> songs;
	private Notification notificationList;
	private Date bandRemoveDate; 
	
	private String name;
	
	public Band( String name ) {
		this.practiceSessions = new ArrayList<Practice>();
		this.gigs = new ArrayList<Gig>();
		this.members = new ArrayList<Member>();
		this.songs = new ArrayList<Song>();
		this.notificationList = new Notification();
		
		this.name = name;
		bandRemoveDate = null;
	}
	
	public Member getMember(String name) {
		Iterator<Member> it = members.iterator();
		
		while (it.hasNext()) {
			Member help = it.next();
			
			if (help.getName().equals(name))
				return help;
		}
		
		return null;
	}
	
	public void removeBand(Date remDate) {
		if (bandRemoveDate == null)
			bandRemoveDate = remDate;
	}
	
	public String getBandName() {
		return this.name;
	}
	
	public void addMember( Member m ) { 
		this.members.add( m );
		this.notificationList.register( m );
	}
	
	public void removeMember( Member m, Date time ) {
		m.setLeaveDate(time);
		
		// remove member from notification list
		this.notificationList.unregister( m );
	}
	
	public ArrayList<Member> listMembers() {
		return this.listMembers( new Date() );
	}
	
	public ArrayList<Member> listMembers( Date time ) {
		ArrayList<Member> members = new ArrayList<Member>();
		
		for ( Member m : this.members ) {
			if ( m.getLeaveDate() == null && m.getJoinDate().compareTo( time ) <= 0 ) {
				members.add( m );
			}
			else if ( m.getLeaveDate() != null && m.getLeaveDate().compareTo( time ) > 0 ) {
				members.add( m );
			}
		}
		
		return members;
	}
	
	public void addSong( Song s ) {
		this.songs.add( s );
	}
	
	public void removeSong( Song s, Date time ) {
		s.setRemoveDate(time);
	}
	
	public ArrayList<Song> listSongs( Date time ) {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		for ( Song s : this.songs ) {
			if ( s.getRemoveDate() == null && s.getAddDate().compareTo( time ) <= 0 ) {
				songs.add( s );
			}
			else if ( s.getRemoveDate() != null && s.getRemoveDate().compareTo( time ) > 0 ) {
				songs.add( s );
			}
		}
		
		return songs;
	}
	
	public void addPlay( Play p ) {
		// save band reference to play object for later useage
		p.setBand( this );
		
		if ( p instanceof Practice ) {
			this.practiceSessions.add( (Practice) p );
		}
		else if ( p instanceof Gig ) {
			this.gigs.add( (Gig) p );
		}
	}
	
	public ArrayList<Practice> listPractice( Date start, Date end ) {
		ArrayList<Practice> practiceSessions = new ArrayList<Practice>();
		
		for ( Practice p : this.practiceSessions ) {
			if ( p.getTimeAndDate() != null && p.getTimeAndDate().compareTo( start ) >= 0 && p.getTimeAndDate().compareTo( end ) <= 0 ) {
				practiceSessions.add( p );
			}
		}
		
		return practiceSessions;
	}
	
	public ArrayList<Gig> listGigs( Date start, Date end ) {
		ArrayList<Gig> gigs = new ArrayList<Gig>();
		
		for ( Gig g : this.gigs ) {
			if ( g.getTimeAndDate() != null && g.getTimeAndDate().compareTo( start ) >= 0 && g.getTimeAndDate().compareTo( end ) <= 0 ) {
				gigs.add( g );
			}
		}
		
		return gigs;
	}
	
	public ArrayList<Play> listAllAppearances( Date start, Date end ) {
		ArrayList<Play> plays = new ArrayList<Play>();
		
		plays.addAll( this.listPractice( start, end ) );
		plays.addAll( this.listGigs( start, end ) );
		
		return plays;
	}

	public double getCostsGigs( Date start, Date end ) {
		double costs = 0;
		
		for ( Gig g : this.listGigs( start, end ) ) {
			costs += g.getCredit();
		}
		
		return costs;
	}
	
	public double getCostsPractices( Date start, Date end ) {
		double costs = 0;
		
		for ( Practice p : this.listPractice(start, end) ) {
			costs += p.getRent();
		}
		
		return costs;
	}
	
	public double getCostsAll( Date start, Date end ) {
		return this.getCostsGigs( start, end ) - this.getCostsPractices( start, end );
	}
	
	public Notification getNotificationList() {
		return this.notificationList;
	}
}
