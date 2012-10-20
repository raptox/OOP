package notification;

import models.Member;

public class Decision {
	private String reason;
	private Boolean decision;
	private Member member;
	
	public Decision( Boolean decision, String reason, Member member ) {
		this.reason = reason;
		this.decision = decision;
		this.member = member;
	}
	
	public String getReason() {
		return this.reason;
	}
	
	public Boolean getDecision() {
		return this.decision;
	}
	
	public Member getMember() {
		return this.member;
	}
}