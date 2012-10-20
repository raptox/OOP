package notification;

import java.util.Vector;
import models.Member;

public class Announcement {
	private String announcement;
	private Vector<Decision> decisions;
	
	public Announcement( String announcement ) {
		this.decisions = new Vector<Decision>();
		this.announcement = announcement;
	}
	
	public void accept( String reason, Member member ) {
		this.decisions.add( new Decision( true, reason, member ) );
	}
	
	public void reject( String reason, Member member ) {
		this.decisions.add( new Decision( false, reason, member ) );
	}
	
	public String getMessage() {
		return this.announcement;
	}
	
	public Vector<Decision> getDecisions() {
		return this.decisions;
	}
}