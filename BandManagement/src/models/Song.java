package models;
import java.util.Date;


public class Song {
	private String name;
	private int duration;
	private Date addDate;
	private Date removeDate;
	
	public Song(String name, int duration, Date addDate){
		this.name = name;
		this.duration = duration;
		this.addDate = addDate;
		this.removeDate = null;
	}
	
	public Date getAddDate(){
		return addDate;
	}
	
	public Date getRemoveDate(){
		return removeDate;
	}
	
	public void setRemoveDate(Date removeDate){
		this.removeDate = removeDate;
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
