package models;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import notification.*;


public class Band {
	private ArrayList<Practice> practiceSessions;
	private ArrayList<Gig> gigs;
	private ArrayList<Member> members;
	private ArrayList<Song> songs;
	private ArrayList<Equipment> equipments;
	
	
	
	private String name;
	
	public Band( String name ) {
		this.practiceSessions = new ArrayList<Practice>();
		this.gigs = new ArrayList<Gig>();
		this.members = new ArrayList<Member>();
		this.songs = new ArrayList<Song>();
		this.equipments = new ArrayList<Equipment>();
		this.name = name;
		
	}
	
	public ArrayList<Credits> getCreditsPractices(Date start, Date end){
		ArrayList<Credits> creditsPractice = new ArrayList<Credits>();
		for(Practice p: listPractice(start,end)){
			creditsPractice.add(p);
		}
		return creditsPractice;
	}
	
	public ArrayList<Credits> getCreditsGigs(Date start, Date end){
		ArrayList<Credits> creditsGigs = new ArrayList<Credits>();
		for(Gig g: listGigs(start,end)){
			creditsGigs.add(g);
		}
		return creditsGigs;
	}
	
	public ArrayList<Credits> getCreditsEquipments(Date start,Date end){
		ArrayList<Credits> creditsEquipment = new ArrayList<Credits>();
		for(Equipment e: listEquipments(start,end)){
			creditsEquipment.add(e);
		}
		return creditsEquipment;
	}
	
	public void addEquipment(Equipment e){
		this.equipments.add(e);
	}
	public void addMember( Member m ) { 
		this.members.add( m );
	}
	
	public void changeGigDate() {
		Notification n = new Notification();
		
		for ( Member m : this.members ) {
			n.register( m );
		}
		Announcement posponedGig = new Announcement( "Das Datum von unserem Auftritt hat sich auf Morgen verschoben!" );
		
		n.announce( posponedGig );
		
		for ( Decision d  :posponedGig.getDecisions() ) {
			System.out.println( "Von: " + d.getMember().getName() + ", Entscheidung: " + d.getDecision() + ", Begründung: " + d.getReason() );
		}
	}
	
	public void removeMember( Member m, Date time ) {
		m.setLeaveDate(time);
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
		if ( p instanceof Practice ) {
			this.practiceSessions.add( (Practice) p );
		}
		else if ( p instanceof Gig ) {
			this.gigs.add( (Gig) p );
		}
	}
	
	public ArrayList<Practice> listPractice( Date start, Date end ) {
		ArrayList<Practice> practiceSessions = new ArrayList<Practice>();
		if(start != null && end != null){
			for ( Practice p : this.practiceSessions ) {
				if ( p.getTimeAndDate().compareTo( start ) >= 0 && p.getTimeAndDate().compareTo( end ) <= 0 ) {
					practiceSessions.add( p );
				}
			}
		}
		else if(start == null && end != null){
			for(Practice p: this.practiceSessions){
				if(p.getTimeAndDate().compareTo( end ) <= 0){
					practiceSessions.add(p);
				}
			}
		}
		else if(end == null && start != null){
			for(Practice p: this.practiceSessions){
				if(p.getTimeAndDate().compareTo( start ) >= 0){
					practiceSessions.add(p);
				}
			}
		}
		else {
			return this.practiceSessions;
		}
		
		return practiceSessions;
	}
	public ArrayList<Equipment> listEquipments(Date start,Date end){
		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
		if(start != null && end != null){
			for ( Equipment e : this.equipments ) {
				if ( e.getBuyDate().compareTo( start ) >= 0 && e.getBuyDate().compareTo( end ) <= 0 ) {
					equipList.add( e );
				}
			}
		}
		else if(start == null && end !=null){
			for(Equipment e: this.equipments){
				if(e.getBuyDate().compareTo( end ) <= 0){
					equipList.add(e);
				}
			}
		}
		else if(end == null && start !=null){
			for(Equipment e: this.equipments){
				if(e.getBuyDate().compareTo( start ) >= 0){
					equipList.add(e);
				}
			}
		}
		else {
			return this.equipments;
		}
		
		return equipList;
	}
	public ArrayList<Gig> listGigs( Date start, Date end ) {
		ArrayList<Gig> gigs = new ArrayList<Gig>();
		if(start != null && end != null){
			for ( Gig p : this.gigs ) {
				if ( p.getTimeAndDate().compareTo( start ) >= 0 && p.getTimeAndDate().compareTo( end ) <= 0 ) {
					gigs.add( p );
				}
			}
		}
		else if(start == null && end != null){
			for(Gig p: this.gigs){
				if(p.getTimeAndDate().compareTo( end ) <= 0){
					gigs.add(p);
				}
			}
		}
		else if(end == null && start != null){
			for(Gig p: this.gigs){
				if(p.getTimeAndDate().compareTo( start ) >= 0){
					gigs.add(p);
				}
			}
		}
		else {
			return this.gigs;
		}
		
		return gigs;
	}
	
	public ArrayList<Play> listAllAppearances( Date start, Date end ) {
		ArrayList<Play> plays = new ArrayList<Play>();
		
		plays.addAll( this.listPractice( start, end ) );
		plays.addAll( this.listGigs( start, end ) );
		
		return plays;
	}
	
}
