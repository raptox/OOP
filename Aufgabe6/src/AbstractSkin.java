
public abstract class AbstractSkin {
	protected String beschreibung;
	
	public abstract AbstractSkin setHilfskraftSkin (Hilfskraft hilfskraft);
	public abstract AbstractSkin setGesellschafterSkin (Gesellschafter gesellschafter);
	public abstract AbstractSkin setBauarbeiterSkin (Bauarbeiter bauarbeiter);
	public abstract AbstractSkin setServiceTechnikerSkin (ServiceTechniker serviceTechniker);
	public abstract AbstractSkin setTransportarbeiterSkin (Transportarbeiter transportarbeiter);
	public abstract AbstractSkin setObjektbewacherSkin (Objektbewacher objektbewacher);
	public abstract AbstractSkin setLeibwaechterSkin (Leibwaechter leibwaechter);
	public abstract AbstractSkin setKaempferSkin (Kaempfer kaempfer);
}
