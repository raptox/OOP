package management;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;

import models.*;

/*
 * UserNotFund ist die Exception Klasse wenn der Benutzer nicht gefunden wird
 */
class UserNotFound extends Exception {
	public UserNotFound() {
		super("ERROR: User not found!");
	}
}

/*
 * NoRights ist die Exception Klasse wenn der Benutzer keine Rechte hat
 */
class NoRights extends Exception {
	public NoRights() {
		super("ERROR: User has no rights for this band");
	}
}

/*
 * This class manages all the bands and all the users who have access to them
 */
public class BandManagement implements Serializable {
	private static final long serialVersionUID = 1L;
	private ArrayList<Band> bands;
	private String activeUser;
	
	/*
	 * Konstruktor
	 */
	public BandManagement() {
		bands = new ArrayList<Band>();
		activeUser = "";
	}
	
	
	/*
	 * hasRights, ueberprueft ob activeUser Zugriff auf die Band hat
	 * Vorb.: myband != null
	 * Nachb.: true = Benutzer hat Rechte, false = Benutzer hat keine Rechte
	 */
	private boolean hasRights(Band myband) {
		if (activeUser.equals("")) {
			return false;
		}
		
		if (myband.getMember(activeUser) != null) {
			return true;
		}
		
		return false;
	}
	
	/*
	 * setActiveUser, log in funktion fuer einen Benutzer, liefert eingeloggten Benutzer zurueck
	 * Vorb.: name != null && pass != null
	 */
	public Member setActiveUser(String name, String pass) throws UserNotFound {
		if (name.equals("admin") && pass.equals("adminpass")) {
			activeUser = "admin";
			System.out.println("LOGGED IN: "+activeUser);	
			return new Member("admin");
		}
		
		/*
		 * Check every band until you find member
		 */
		Iterator<Band> it = bands.iterator();
		while (it.hasNext()) {
			Band help = it.next();
			Member help_mem = help.getMember(name);
			
			if (help_mem != null && help_mem.getPassword().equals(pass) && help_mem.getLeaveDate() == null) {
				activeUser = name;
				System.out.println("LOGGED IN: "+activeUser);
				return help_mem;
			}
		}
		
		// Member not found, so cannot log in
		throw new UserNotFound();
	}
	
	/*
	 *  addBand, fuegt eine neue Band hinzu
	 *  Vorb.: name != null
	 */
	public void addBand(String name) throws NoRights {
		// Only admin can add new bands
		
		if (activeUser.equals("admin"))
			bands.add(new Band(name));
		else
			throw new NoRights();
	}
	
	/*
	 * getBand, liefert eine Band zurueck, falls der User berechtigt ist
	 * Vorb.: name != null
	 */
	public Band getBand(String name) throws NoRights {
		Iterator<Band> it = bands.iterator();
		
		while (it.hasNext()) {
			Band help = it.next();
			if (help.getBandName().equals(name)) {
				// Only band member or admin gets access to band
				if (activeUser.equals("admin") || hasRights(help))
					return help; // found band
				else 
					throw new NoRights();
			}
		}
		
		return null; // didn't find band
	}
	
	/*
	 * removeBand, loescht eine Band, wenn der User berechtigt ist
	 * Vorb.: name != null
	 */
	public void removeBand(String name) throws NoRights {
		// only admin can remove bands
		if (!activeUser.equals("admin"))
			throw new NoRights();
		
		Iterator<Band> it = bands.iterator();
		Calendar cal = Calendar.getInstance();
				
		while (it.hasNext()) {
			Band help = it.next();
			if (help.getBandName().equals(name)) {
				help.removeBand(cal.getTime());
			}
		}		
	}
}
