package models;
import java.io.Serializable;
import java.util.ArrayList;

public class LocationManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Location> locations;
	
	public LocationManager(){
		this.locations = new ArrayList<Location>();
	}
	
	public void addLocation(Location l){
		locations.add(l);
	}
	
	public void removeLocation(Location l){
		locations.remove(l);
	}
	
	public ArrayList<Location> getLocations(){
		return locations;
	}
	
	public ArrayList<Location> getLocations(int minSize){
		ArrayList<Location> minSizeLocation = new ArrayList<Location>();
		for(Location l: locations){
			if(l.getSize() >= minSize){
				minSizeLocation.add(l);
			}
		}
		return minSizeLocation;
	}
}
