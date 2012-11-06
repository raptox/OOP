package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import notification.*;

/**
 * Die Klasse Band stellt eine Musikgruppe dar, bestehend aus mehreren Mitgliedern, Songs, Gigs, Proben usw.
 */
public class Band implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Practice> practiceSessions;
	private ArrayList<Gig> gigs;
	private ArrayList<Member> members;
	private ArrayList<Song> songs;
	private ArrayList<Equipment> equipments;
	private Notification notificationList;
	private Date bandRemoveDate; 
	private ArrayList<Announcement> announcementList;
	
	private String name;
	
	/**
	 * Vorb.: name != ""
	 */
	public Band( String name ) {
		this.practiceSessions = new ArrayList<Practice>();
		this.gigs = new ArrayList<Gig>();
		this.members = new ArrayList<Member>();
		this.songs = new ArrayList<Song>();
		this.equipments = new ArrayList<Equipment>();
		this.name = name;
		
		this.notificationList = new Notification();
		this.announcementList = new ArrayList<Announcement>();
		
		this.name = name;
		bandRemoveDate = null;		
	}
	
	/**
	 * Liefert eine Liste von Credits-Objekten aller Practices zurueck 
	 */
	public ArrayList<Credits> getCreditsPractices(Date start, Date end){
		ArrayList<Credits> creditsPractice = new ArrayList<Credits>();
		for(Practice p: listPractice(start,end)){
			creditsPractice.add(p);
		}
		return creditsPractice;
	}
	
	/**
	 * Liefert eine Liste von Credits-Objekten aller Gigs zurueck 
	 */
	public ArrayList<Credits> getCreditsGigs(Date start, Date end){
		ArrayList<Credits> creditsGigs = new ArrayList<Credits>();
		for(Gig g: listGigs(start,end)){
			creditsGigs.add(g);
		}
		return creditsGigs;
	}
	
	/**
	 * Liefert eine Liste von Credits-Objekten aller Equipments zurueck 
	 */
	public ArrayList<Credits> getCreditsEquipments(Date start,Date end){
		ArrayList<Credits> creditsEquipment = new ArrayList<Credits>();
		for(Equipment e: listEquipments(start,end)){
			creditsEquipment.add(e);
		}
		return creditsEquipment;
	}
	
	/*
	 * Fï¿½gt ein neues Equipment zur Band hinzu.
	 * 
	 * Vorb.: e != null
	 */
	public void addEquipment(Equipment e){
		this.equipments.add(e);
	}
	
	/*
	 * Liefert ein Bandmitglied anhand von dem ï¿½bergebenen Mitgliedsnamen.
	 * 
	 * Vorb.: name != "" 
	 */
	public Member getMember(String name) {
		Iterator<Member> it = members.iterator();
		
		while (it.hasNext()) {
			Member help = it.next();
			
			if (help.getName().equals(name))
				return help;
		}
		
		return null;
	}
	
	/*
	 * Lï¿½scht die Band.
	 * 
	 * Vorb.: remDate != null
	 */
	public void removeBand(Date remDate) {
		if (bandRemoveDate == null)
			bandRemoveDate = remDate;
	}
	
	/*
	 * Liefert den Namen der Band.
	 */
	public String getBandName() {
		return this.name;
	}
	
	/*
	 * Fï¿½gt einen neuen Benutzer zur Band hinzu.
	 * 
	 * Vorb.: m != null & m instanceof Member
	 */
	public void addMember( Member m ) { 
		this.members.add( m );
		this.notificationList.register( m );
	}
	
	/*
	 * Lï¿½scht ein Bandmitglied der Band
	 * 
	 * Vorb.: m != null && time != null
	 */
	public void removeMember( Member m, Date time ) {
		m.setLeaveDate(time);
		
		// remove member from notification list
		this.notificationList.unregister( m );
	}
	
	/*
	 * Liefert alle aktuellen Mitglieder der Band
	 */
	public ArrayList<Member> listMembers() {
		return this.listMembers( new Date() );
	}
	
	/*
	 * Liefert alle Mitglieder der Band bis zu einem gewissen Datum
	 * 
	 * Vorb.: time != null
	 */
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
	
	/*
	 * Fï¿½gt einen neuen Song zur Band hinzu.
	 * 
	 * Vorb.: s != null
	 */
	public void addSong( Song s ) {
		this.songs.add( s );
	}
	
	/*
	 * Entfernt einen Song.
	 * 
	 * Vorb.: s != null && time != null
	 */
	public void removeSong( Song s, Date time ) {
		s.setRemoveDate(time);
	}
	
	/*
	 * Liefert alle Songs bis zu einem ï¿½bergebenen Datum zurï¿½ck.
	 * 
	 * Vorb.: time != null
	 */
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
	
	/*
	 * Fï¿½gt einen neuen Auftritt bzw. eine neue Probe hinzu.
	 * 
	 * Vorb.: p != null
	 * 
	 * SCHLECHT: Hier kšnnte man auf 2 verschiedene Listen (practiceSessions & gigs) verzichten
	 *  		 und einfach Play Objekte in einer Liste speichern und beim spŠteren
	 *  		 durchiterieren einfach ŸberprŸfen, welcher Typ das Objekt wirklich ist.
	 */
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
	
	/*
	 * Liefert alle Proben in einem ï¿½bergebenen Zeitintervall.
	 * SCHLECHT: listPractice/listEquipments/listGigs enthalten sehr aenlichen Code
	 *           Verbesserung: Durch speichern in einer gemeinsamen Datenstruktur und durch
	 *                         implementierung einer gemeinsamen getDate Methode die Uebersicht,
	 *                         Wartung und Codewiederverwendung verbessern
	 *           Warum ist das passiert?: Zu Beginn der Programmentwicklung wurden unterschiedliche
	 *                         getDate-Methoden entwickelt und die abstraktion wurde vernachlaessigt
	 */
	public ArrayList<Practice> listPractice( Date start, Date end ) {
		ArrayList<Practice> practiceSessions = new ArrayList<Practice>();
		
		if(start != null && end != null){
			for ( Practice p : this.practiceSessions ) {
				//Invariante: p!=null
				if ( p.getTimeAndDate().compareTo( start ) >= 0 && p.getTimeAndDate().compareTo( end ) <= 0 ) {
					practiceSessions.add( p );
				}
			}
		}
		else if(start == null && end != null){
			for(Practice p: this.practiceSessions){
				//Invariante: p!=null
				if(p.getTimeAndDate().compareTo( end ) <= 0){
					practiceSessions.add(p);
				}
			}
		}
		else if(end == null && start != null){
			for(Practice p: this.practiceSessions){
				//Invariante: p!=null
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
	
	/*
	 * Liefert alle Equipments der Band in einem gegebenen Zeitintervall.
	 * 
	 */
	public ArrayList<Equipment> listEquipments(Date start,Date end){
		ArrayList<Equipment> equipList = new ArrayList<Equipment>();
		if(start != null && end != null){
			for ( Equipment e : this.equipments ) {
				//Invariante: e!=null
				if ( e.getBuyDate().compareTo( start ) >= 0 && e.getBuyDate().compareTo( end ) <= 0 ) {
					equipList.add( e );
				}
			}
		}
		else if(start == null && end !=null){
			for(Equipment e: this.equipments){
				//Invariante: e!=null
				if(e.getBuyDate().compareTo( end ) <= 0){
					equipList.add(e);
				}
			}
		}
		else if(end == null && start !=null){
			for(Equipment e: this.equipments){
				//Invariante: e!=null
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
	
	/*
	 * Liefert alle Auftritte der Band in einem gegebenen Zeitintervall.
	 * 
	 */
	public ArrayList<Gig> listGigs( Date start, Date end ) {
		ArrayList<Gig> gigs = new ArrayList<Gig>();

		if(start != null && end != null){
			for ( Gig p : this.gigs ) {
				//Invariante: p!=null
				if ( p.getTimeAndDate().compareTo( start ) >= 0 && p.getTimeAndDate().compareTo( end ) <= 0 ) {
					gigs.add( p );
				}
			}
		}
		else if(start == null && end != null){
			for(Gig p: this.gigs){
				//Invariante: p!=null
				if(p.getTimeAndDate().compareTo( end ) <= 0){
					gigs.add(p);
				}
			}
		}
		else if(end == null && start != null){
			for(Gig p: this.gigs){
				//Invariante: p!=null
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
	
	/*
	 * Liefert alle Auftritte UND Proben der Band in einem gegebenen Zeitintervall.
	 * 
	 * Vorb.: start != null && end != null && end > start
	 */
	public ArrayList<Play> listAllAppearances( Date start, Date end ) {
		ArrayList<Play> plays = new ArrayList<Play>();
		
		plays.addAll( this.listPractice( start, end ) );
		plays.addAll( this.listGigs( start, end ) );
		
		return plays;
	}
	
	/*
	 * Liefert das Notification Objekt der Band in dem alle zu benachrichtigenden Mitglieder enthalten sind.
	 */
	public Notification getNotificationList() {
		return this.notificationList;
	}
	
	/*
	 * Fï¿½gt eine neue Bekanntmachung der Band hinzu.
	 * 
	 * Vorb.: a != null
	 */
	public void addAnnouncement( Announcement a ) {
		this.announcementList.add( a );
	}
	
	/*
	 * Liefert alle Bekanntmachungen der Band.
	 */
	public ArrayList<Announcement> listAnnouncements() {
		return this.announcementList;
	}
}
