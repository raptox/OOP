
public abstract class AbstractSkin {
	protected String beschreibung;
	protected int seriennummer;
	
	public AbstractSkin() {
		this.beschreibung = "";
	}
	
	public void setSN(int seriennummer) {
		this.seriennummer = seriennummer;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	/*
	 * VB: der uebergebene Android darf nicht null sein
	 * NB: wenn die Androidenverordnung nicht verletzt wird so wird eine neue Skin zurueckgegeben
	 *     ansonsten wird null zurueckgeliefert
	*/
	public abstract AbstractSkin setSkin (Hilfskraft hilfskraft);
	public abstract AbstractSkin setSkin (Gesellschafter gesellschafter);
	public abstract AbstractSkin setSkin (Bauarbeiter bauarbeiter);
	public abstract AbstractSkin setSkin (ServiceTechniker serviceTechniker);
	public abstract AbstractSkin setSkin (Transportarbeiter transportarbeiter);
	public abstract AbstractSkin setSkin (Objektbewacher objektbewacher);
	public abstract AbstractSkin setSkin (Leibwaechter leibwaechter);
	public abstract AbstractSkin setSkin (Kaempfer kaempfer);
}
