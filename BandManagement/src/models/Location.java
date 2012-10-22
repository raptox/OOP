package models;

public class Location {
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
		return "Location:"+name+" Size:"+size+"m²"; 
	}
}
