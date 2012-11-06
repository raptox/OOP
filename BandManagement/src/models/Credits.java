package models;

// GUT: Credits wird fuer alle Kosten verwenden, und vererbt die Methode getCredits weiter (also keine redundanz)
public abstract class Credits {
	protected double credits;
	
	public Credits(){
		this.credits=0;
	}
	
	public Credits(double credits){
		this.credits=credits;
	}
	public double getCredits(){
		return credits;
	}
}
