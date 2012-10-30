package models;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class CreditsFilter implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CreditsFilter(){
	}
	
	
	/*
	 * Liefert eine Liste von Credits-Objekten zurueck ,die die Filter-kriterien erfuellen
	 */
	public ArrayList<Credits> filter(Band b, Date start, Date end, String[] filterOperations){
		ArrayList<Credits> credits = new ArrayList<Credits>();
		HashMap<String,ArrayList<Credits>> correctInput = new HashMap<String,ArrayList<Credits>>();
		
		correctInput.put("Practices", b.getCreditsPractices(start, end));
		correctInput.put("Gigs", b.getCreditsGigs(start, end));
		correctInput.put("Equipments", b.getCreditsEquipments(start, end));
		
		
		if(b != null){
			if(filterOperations != null){
				for(String s: filterOperations){
					//Invariante: s!=null
					if(correctInput.containsKey(s)){
						for(Credits c:correctInput.get(s)){
							credits.add(c);
						}
					}
				}
			}
			else{
				for(String key:correctInput.keySet()){
					for(Credits c:correctInput.get(key)){
						//Invariante: c!=null
						credits.add(c);
					}
				}
			}
		}
		
		return credits;
	}
	
	/*
	 * Liefer zu einer Credits Liste deren Umsatz
	 * Vorb.: credits != null
	 */
	public double getCredits(ArrayList<Credits> credits){
		double totalCredits=0;
		for(Credits c:credits){
			//Invariante: c!=null
			if(c instanceof Revenues){
				totalCredits+=c.getCredits();
			}
			else if(c instanceof Costs){
				totalCredits-=c.getCredits();
			}
		}
		return totalCredits;
	}

}
