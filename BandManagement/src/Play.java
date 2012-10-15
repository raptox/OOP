import java.util.Date;

public abstract class Play {
    private String location;
    private Date timeAndDate;
    private int duration;

    public Play(String location, Date timeAndDate, int duration) {
    	this.location = location;
    	this.timeAndDate = timeAndDate;
    	this.duration = duration;
    }
    
    public Date getTimeAndDate() {
    	return this.timeAndDate;
    }

    public String toString() {
    	return "Loc: "+location+" Date and Time: "+timeAndDate.toString()+", Duration(min):"+duration/60; 
    }
}
