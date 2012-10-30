package notification;

import java.io.Serializable;

import models.Member;

/*
 * Klasse Decision stellt eine Entscheidung bezüglich einer Mitteilung zu einer 
 * verschobenen/abgesagten/neuen Probe bzw. Auftritt dar. Das Bandmitglied
 * kann entweder ablehnen oder zusagen mit einer Begründung.
 */
public class Decision implements Serializable {
	private static final long serialVersionUID = 1L;
	private String reason;
	private Boolean decision;
	private Member member;
	
	/*
	 * Konstruktor, der eine Decision mit den übergebenen Parametern initialisiert.
	 * 
	 * @param decicision Entweder true oder false, je nachdem ob Entscheidung
	 * 					 vom Bandmitglied abgelehnt oder zugesagt wurde
	 * @param reason Begründung für die Entscheidung
	 * @param member Das Mitglied das die Entscheidung gefallen hat
	 * 
	 * Vorb.: decision != null, member != null
	 */
	public Decision( Boolean decision, String reason, Member member ) {
		this.reason = reason;
		this.decision = decision;
		this.member = member;
	}
	
	/*
	 * Liefert die zugehörige Begründung zu der Entscheidung.
	 * 
	 * Vorb.: reason != ""
	 */
	public String getReason() {
		return this.reason;
	}
	
	/*
	 * Liefert einen Wahrheitswert ob die Entscheidung angenommen oder abgelehnt wurde.
	 * 
	 * Vorb.: decision != null
	 */
	public Boolean getDecision() {
		return this.decision;
	}
	
	/*
	 * Liefert das zugehörige Mitglied zur Entscheidung.
	 * 
	 * Vorb.: member != null
	 */
	public Member getMember() {
		return this.member;
	}
}
