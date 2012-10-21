package management;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Calendar;

import models.*;

/*
 * Exceptions classes
 */
class UserNotFound extends Exception {
	public UserNotFound() {
		super("User not found!");
	}
}

class NoRights extends Exception {
	public NoRights() {
		super("User has no rights for this band");
	}
}

/*
 * This class manages all the bands and all the users who have access to them
 * 
 */
public class BandManagement {
	private ArrayList<Band> bands;
	private String activeUser;
	
	
	public BandManagement() {
		bands = new ArrayList<Band>();
		activeUser = "";
	}
	
	private boolean hasRights(Band myband) {
		if (activeUser.equals("")) {
			return false;
		}
		
		if (myband.getMember(activeUser) != null) {
			return true;
		}
		
		return false;
	}
	
	public Member setActiveUser(String name, String pass) throws UserNotFound {
		if (name.equals("admin") && pass.equals("adminpass")) {
			activeUser = "admin";
			System.out.println("Active user changed to: "+activeUser);	
			return new Member("admin");
		}
		
		/*
		 * Check every band until you find member
		 */
		Iterator<Band> it = bands.iterator();
		while (it.hasNext()) {
			Band help = it.next();
			Member help_mem = help.getMember(name);
			
			if (help_mem != null && help_mem.getPassword().equals(pass)) {
				activeUser = name;
				System.out.println("Active user changed to: "+activeUser);
				return help_mem;
			}
		}
		
		// Member not found, so cannot log in
		throw new UserNotFound();
	}
	
	public void addBand(String name) throws NoRights {
		// Only admin can add new bands
		
		if (activeUser.equals("admin"))
			bands.add(new Band(name));
		else
			throw new NoRights();
	}
	
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
