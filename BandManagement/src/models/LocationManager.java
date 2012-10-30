package models;
import java.io.Serializable;
import java.util.ArrayList;

public class LocationManager implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<Location> locations;
	
	/*
	 * Konstruktor
	 */
	public LocationManager(){
		this.locations = new ArrayList<Location>();
	}
	
	/*
	 * Fuegt der Liste von Locations eine neue Location hinzu
	 * Vorb.: l!=null
	 */
	public void addLocation(Location l){
		locations.add(l);
	}
	
	/*
	 * Loescht ein Element l aus der Liste Locations
	 * Vorb.: l!=null, l element von ArrayList<Location> locations
	 */
	public void removeLocation(Location l){
		locations.remove(l);
	}
	
	/*
	 * Liefert eine Liste von Locations zurueck
	 */
	public ArrayList<Location> getLocations(){
		return locations;
	}
	
	/*
	 * Liefert eine Liste von Locations zurueck die groeßer als minSize sind
	 * Vorb.: minSize > 0
	 */
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
