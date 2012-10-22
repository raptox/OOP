package models;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Date;

public class CreditsFilter {
	public CreditsFilter(){
	}
	

	public ArrayList<Credits> filter(Band b, Date start, Date end, String[] filterOperations){
		ArrayList<Credits> credits = new ArrayList<Credits>();
		HashMap<String,ArrayList<Credits>> correctInput = new HashMap<String,ArrayList<Credits>>();
		
		correctInput.put("Practices", b.getCreditsPractices(start, end));
		correctInput.put("Gigs", b.getCreditsGigs(start, end));
		correctInput.put("Equipments", b.getCreditsEquipments(start, end));
		
		
		if(b != null){
			if(filterOperations != null){
				for(String s: filterOperations){
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
						credits.add(c);
					}
				}
			}
		}
		
		return credits;
	}
	
	public double getCredits(ArrayList<Credits> credits){
		double totalCredits=0;
		for(Credits c:credits){
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
