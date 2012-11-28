
public abstract class AbstractKit {
	protected int seriennummer;
	protected String beschreibung;
	protected AbstractSensor[] sensors;
	
	public void setSN(int seriennummer) {
		this.seriennummer = seriennummer;
	}

	public void setBeschreibung(String besch) {
		this.beschreibung = besch;
	}
	
	public String getBeschreibung() {
		return beschreibung;
	}
	
	public void setSensors( AbstractSensor[] sensors ) {
		this.sensors = sensors;
	}
	
	// Hilfskraftsoftware
	public abstract AbstractKit setKit(Hilfskraft hilfskraft, Security1 sec);
	public abstract AbstractKit setKit(Hilfskraft hilfskraft, Security2 sec);
	public abstract AbstractKit setKit(Hilfskraft hilfskraft, Security3 sec);
	public abstract AbstractKit setKit(Hilfskraft hilfskraft, Security4 sec);
	public abstract AbstractKit setKit(Hilfskraft hilfskraft, Security5 sec);

	// GesellschafterSoftware
	public abstract AbstractKit setKit(Gesellschafter gesellschafter, Security1 sec);
	public abstract AbstractKit setKit(Gesellschafter gesellschafter, Security2 sec);
	public abstract AbstractKit setKit(Gesellschafter gesellschafter, Security3 sec);
	public abstract AbstractKit setKit(Gesellschafter gesellschafter, Security4 sec);
	public abstract AbstractKit setKit(Gesellschafter gesellschafter, Security5 sec);	

	// BauarbeiterSoftware
	public abstract AbstractKit setKit(Bauarbeiter bauarbeiter, Security1 sec);
	public abstract AbstractKit setKit(Bauarbeiter bauarbeiter, Security2 sec);
	public abstract AbstractKit setKit(Bauarbeiter bauarbeiter, Security3 sec);
	public abstract AbstractKit setKit(Bauarbeiter bauarbeiter, Security4 sec);
	public abstract AbstractKit setKit(Bauarbeiter bauarbeiter, Security5 sec);

	// ServiceTechnikerSoftware
	public abstract AbstractKit setKit(ServiceTechniker servicetechniker, Security1 sec);
	public abstract AbstractKit setKit(ServiceTechniker servicetechniker, Security2 sec);
	public abstract AbstractKit setKit(ServiceTechniker servicetechniker, Security3 sec);
	public abstract AbstractKit setKit(ServiceTechniker servicetechniker, Security4 sec);
	public abstract AbstractKit setKit(ServiceTechniker servicetechniker, Security5 sec);
	
	// TransportarbeiterSoftware
	public abstract AbstractKit setKit(Transportarbeiter transportarbeiter, Security1 sec);
	public abstract AbstractKit setKit(Transportarbeiter transportarbeiter, Security2 sec);
	public abstract AbstractKit setKit(Transportarbeiter transportarbeiter, Security3 sec);
	public abstract AbstractKit setKit(Transportarbeiter transportarbeiter, Security4 sec);
	public abstract AbstractKit setKit(Transportarbeiter transportarbeiter, Security5 sec);

	// ObjektbewacherSoftware
	public abstract AbstractKit setKit(Objektbewacher objektwacher, Security1 sec);
	public abstract AbstractKit setKit(Objektbewacher objektwacher, Security2 sec);
	public abstract AbstractKit setKit(Objektbewacher objektwacher, Security3 sec);
	public abstract AbstractKit setKit(Objektbewacher objektwacher, Security4 sec);
	public abstract AbstractKit setKit(Objektbewacher objektwacher, Security5 sec);	

	// LeibwaechterSoftware
	public abstract AbstractKit setKit(Leibwaechter leibwaechter, Security1 sec);
	public abstract AbstractKit setKit(Leibwaechter leibwaechter, Security2 sec);
	public abstract AbstractKit setKit(Leibwaechter leibwaechter, Security3 sec);
	public abstract AbstractKit setKit(Leibwaechter leibwaechter, Security4 sec);
	public abstract AbstractKit setKit(Leibwaechter leibwaechter, Security5 sec);

	// KaempferSoftware
	public abstract AbstractKit setKit(Kaempfer kaempfer, Security1 sec);
	public abstract AbstractKit setKit(Kaempfer kaempfer, Security2 sec);
	public abstract AbstractKit setKit(Kaempfer kaempfer, Security3 sec);
	public abstract AbstractKit setKit(Kaempfer kaempfer, Security4 sec);
	public abstract AbstractKit setKit(Kaempfer kaempfer, Security5 sec);
}
