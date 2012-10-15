import java.util.ArrayList;
import java.util.Date;


public class Band {
	private ArrayList<Practice> practiceSessions;
	private ArrayList<Gig> gigs;
	private ArrayList<Member> members;
	private ArrayList<Song> songs;
	
	private String name;
	
	public Band( String name ) {
		this.practiceSessions = new ArrayList<Practice>();
		this.gigs = new ArrayList<Gig>();
		this.members = new ArrayList<Member>();
		this.songs = new ArrayList<Song>();
		
		this.name = name;
	}
	
	public void addMember( Member m ) { 
		this.members.add( m );
	}
	
	public void removeMember( Member m ) {
		this.members.remove( m );
	}
	
	public ArrayList<Member> listMembers( Date time ) {
		ArrayList<Member> members = new ArrayList<Member>();
		
		for ( Member m : this.members ) {
			if ( m.getLeaveDate() == null && m.getJoinDate().compareTo( time ) <= 0 ) {
				members.add( m );
			}
			else if ( m.getLeaveDate() != null && m.getLeaveDate().compareTo( time ) <= 0 ) {
				members.add( m );
			}
		}
		
		return members;
	}
	
	public void addSong( Song s ) {
		this.songs.add( s );
	}
	
	public void removeSong( Song s ) {
		this.songs.remove( s );
	}
	
	public ArrayList<Song> listSongs( Date time ) {
		ArrayList<Song> songs = new ArrayList<Song>();
		
		for ( Song s : this.songs ) {
			if ( s.getRemDate() == null && s.getAddDate().compareTo( time ) <= 0 ) {
				songs.add( s );
			}
			else if ( s.getRemDate() != null && s.getRemDate().compareTo( time ) <= 0 ) {
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
		
		for ( Practice p : this.practiceSessions ) {
			if ( p.getTimeAndDate().compareTo( start ) >= 0 && p.getTimeAndDate().compareTo( end ) <= 0 ) {
				practiceSessions.add( p );
			}
		}
		
		return practiceSessions;
	}
	
	public ArrayList<Gig> listGigs( Date start, Date end ) {
		ArrayList<Gig> gigs = new ArrayList<Gig>();
		
		for ( Gig g : this.gigs ) {
			if ( g.getTimeAndDate().compareTo( start ) >= 0 && g.getTimeAndDate().compareTo( end ) <= 0 ) {
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
	
}
