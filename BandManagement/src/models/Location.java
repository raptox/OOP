package models;

import java.io.Serializable;

public class Location implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private int size;
	
	public Location(String name,int size){
		this.name = name;
		this.size = size;
	}
	
	public int getSize(){
		return size;
	}
	
	public String toString(){
		return "Location:"+name+" Size:"+size+"m^2"; 
	}
}
