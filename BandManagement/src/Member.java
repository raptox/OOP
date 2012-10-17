import java.util.Date;


public class Member {
	private String name;
	private String telNumber;
	private String instrument;
	private Date joinDate;
	private Date leaveDate;
	
	public Member( String name, String telNumber, String instrument, Date joinDate) {
		this.name = name;
		this.telNumber = telNumber;
		this.instrument = instrument;
		this.joinDate = joinDate;
		this.leaveDate = null;
	}
	
	public Date getJoinDate(){
		return joinDate;
	}
	
	public Date getLeaveDate(){
		return leaveDate;
	}
	
	public void setLeaveDate(Date leaveDate){
		this.leaveDate = leaveDate;
	}
	
	public String toString() {
		return ("Name: "+name+" Telefonnummer: "+telNumber+" Instrument: "+instrument+"\n");
	}
}
