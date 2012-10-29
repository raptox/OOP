package notification;

import java.io.Serializable;
import java.util.Vector;
import models.Member;

/**
 * Announcement stellt eine einzelne Mitteilung dar, die abgelehnt oder angenommen werden kann
 */
public class Announcement implements Serializable {
	private static final long serialVersionUID = 1L;
	private String announcement;
	private Vector<Decision> decisions;
	
	/*
	 * Konstruktor, der der Mitteilung eine Nachricht zuordnet
	 * 
	 * Vorb.: announcement != ""
	 */
	public Announcement( String announcement ) {
		this.decisions = new Vector<Decision>();
		this.announcement = announcement;
	}
	
	/*
	 * Damit kann eine Mitteilung als "angenommen" markiert werden mit einer BegrŸndung
	 */
	public void accept( String reason, Member member ) {
		this.decisions.add( new Decision( true, reason, member ) );
	}
	
	/*
	 * Damit kann eine Mitteilung als "abgelehnt" markiert werden mit einer BegrŸndung
	 */
	public void reject( String reason, Member member ) {
		this.decisions.add( new Decision( false, reason, member ) );
	}
	
	/*
	 * Liefert die Mitteilungsnachricht
	 * 
	 * Vorb.: announcement != ""
	 */
	public String getMessage() {
		return this.announcement;
	}
	
	/*
	 * Liefert alle Zusagen/Absagen von den Band Mitgliedern
	 * 
	 * Vorb.: decisions.size > 0
	 */
	public Vector<Decision> getDecisions() {
		return this.decisions;
	}
}
