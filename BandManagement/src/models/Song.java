package models;
import java.io.Serializable;
import java.util.Date;


public class Song implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int duration;
	private Date addDate;
	private Date removeDate;
	
	/*
	 * Konstruktor
	 * Vorb.:name!=null,duration!=null,duration>0,addDate!=null
	 */
	public Song(String name, int duration, Date addDate){
		this.name = name;
		this.duration = duration;
		this.addDate = addDate;
		this.removeDate = null;
	}
	/*
	 * Liefert das Datum des hinzufuegens zurueck
	 */
	public Date getAddDate(){
		return addDate;
	}
	/*
	 * Liefert das Datum des "Entfernens" hinzu
	 */
	public Date getRemoveDate(){
		return removeDate;
	}
	
	/*
	 * Setzt das removeDate
	 * Vorb.: removeDate!=null 
	 */
	public void setRemoveDate(Date removeDate){
		this.removeDate = removeDate;
	}
	
	/*
	 * Gibt einen gut lesbaren String zurueck in dem der Name sowie die Dauer(Minuten und Sekunden)
	 * des Songs enthalten sind
	 * 
	 */
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
