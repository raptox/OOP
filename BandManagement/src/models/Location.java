package models;

import java.io.Serializable;

public class Location implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int size;
	
	/*
	 * Konstruktor
	 * Vorb.:name!=null,size!=null,size>0
	 */
	public Location(String name,int size){
		this.name = name;
		this.size = size;
	}
	/*
	 * Liefert die groesse einer Location zurueck
	 */
	public int getSize(){
		return size;
	}
	
	/*
	 * Ueberschreibt die toString Methode und gibt einen gut lesbaren String
	 * der Location zurueck in dem Name und Groesse gut ersichtlich sind
	 */
	public String toString(){
		return "Location:"+name+" Size:"+size+"m^2"; 
	}
}
