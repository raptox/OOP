
public abstract class AbstractSoftware {
	protected int seriennummer;
	protected String beschreibung;
	
	public void setSN(int seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void setBeschreibung(String besch) {
		this.beschreibung = besch;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	// Hilfskraftsoftware
	public abstract AbstractSoftware setSoftware(Hilfskraft hilfskraft, Security1 sec);
	public abstract AbstractSoftware setSoftware(Hilfskraft hilfskraft, Security2 sec);
	public abstract AbstractSoftware setSoftware(Hilfskraft hilfskraft, Security3 sec);
	public abstract AbstractSoftware setSoftware(Hilfskraft hilfskraft, Security4 sec);
	public abstract AbstractSoftware setSoftware(Hilfskraft hilfskraft, Security5 sec);

	// GesellschafterSoftware
	public abstract AbstractSoftware setSoftware(Gesellschafter gesellschafter, Security1 sec);
	public abstract AbstractSoftware setSoftware(Gesellschafter gesellschafter, Security2 sec);
	public abstract AbstractSoftware setSoftware(Gesellschafter gesellschafter, Security3 sec);
	public abstract AbstractSoftware setSoftware(Gesellschafter gesellschafter, Security4 sec);
	public abstract AbstractSoftware setSoftware(Gesellschafter gesellschafter, Security5 sec);	

	// BauarbeiterSoftware
	public abstract AbstractSoftware setSoftware(Bauarbeiter bauarbeiter, Security1 sec);
	public abstract AbstractSoftware setSoftware(Bauarbeiter bauarbeiter, Security2 sec);
	public abstract AbstractSoftware setSoftware(Bauarbeiter bauarbeiter, Security3 sec);
	public abstract AbstractSoftware setSoftware(Bauarbeiter bauarbeiter, Security4 sec);
	public abstract AbstractSoftware setSoftware(Bauarbeiter bauarbeiter, Security5 sec);

	// ServiceTechnikerSoftware
	public abstract AbstractSoftware setSoftware(ServiceTechniker servicetechniker, Security1 sec);
	public abstract AbstractSoftware setSoftware(ServiceTechniker servicetechniker, Security2 sec);
	public abstract AbstractSoftware setSoftware(ServiceTechniker servicetechniker, Security3 sec);
	public abstract AbstractSoftware setSoftware(ServiceTechniker servicetechniker, Security4 sec);
	public abstract AbstractSoftware setSoftware(ServiceTechniker servicetechniker, Security5 sec);
	
	// TransportarbeiterSoftware
	public abstract AbstractSoftware setSoftware(Transportarbeiter transportarbeiter, Security1 sec);
	public abstract AbstractSoftware setSoftware(Transportarbeiter transportarbeiter, Security2 sec);
	public abstract AbstractSoftware setSoftware(Transportarbeiter transportarbeiter, Security3 sec);
	public abstract AbstractSoftware setSoftware(Transportarbeiter transportarbeiter, Security4 sec);
	public abstract AbstractSoftware setSoftware(Transportarbeiter transportarbeiter, Security5 sec);

	// ObjektbewacherSoftware
	public abstract AbstractSoftware setSoftware(Objektbewacher objektwacher, Security1 sec);
	public abstract AbstractSoftware setSoftware(Objektbewacher objektwacher, Security2 sec);
	public abstract AbstractSoftware setSoftware(Objektbewacher objektwacher, Security3 sec);
	public abstract AbstractSoftware setSoftware(Objektbewacher objektwacher, Security4 sec);
	public abstract AbstractSoftware setSoftware(Objektbewacher objektwacher, Security5 sec);	

	// LeibwaechterSoftware
	public abstract AbstractSoftware setSoftware(Leibwaechter leibwaechter, Security1 sec);
	public abstract AbstractSoftware setSoftware(Leibwaechter leibwaechter, Security2 sec);
	public abstract AbstractSoftware setSoftware(Leibwaechter leibwaechter, Security3 sec);
	public abstract AbstractSoftware setSoftware(Leibwaechter leibwaechter, Security4 sec);
	public abstract AbstractSoftware setSoftware(Leibwaechter leibwaechter, Security5 sec);

	// KaempferSoftware
	public abstract AbstractSoftware setSoftware(Kaempfer kaempfer, Security1 sec);
	public abstract AbstractSoftware setSoftware(Kaempfer kaempfer, Security2 sec);
	public abstract AbstractSoftware setSoftware(Kaempfer kaempfer, Security3 sec);
	public abstract AbstractSoftware setSoftware(Kaempfer kaempfer, Security4 sec);
	public abstract AbstractSoftware setSoftware(Kaempfer kaempfer, Security5 sec);
	
	public String toString() {
		return beschreibung;
	}
}
