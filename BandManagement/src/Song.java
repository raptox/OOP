import java.util.Date;


public class Song {
	private String name;
	private int duration;
	private Date addDate;
	private Date remDate;
	
	public Song(String name, int duration, Date addDate){
		this.name = name;
		this.duration = duration;
		this.addDate = addDate;
		this.remDate = null;
	}
	
	public Date getAddDate(){
		return addDate;
	}
	
	public Date getRemDate(){
		return remDate;
	}
	
	public void setRemDate(Date remDate){
		this.remDate = remDate;
	}
	
	public String toString(){
		int min = 0;
		int sec = duration;
		while(sec >= 60){
			min++;
			sec-=60;
		}
		return name+" ["+min+"m"+sec+"s]";
	}
}
