
public class Beruehrungssensitiv extends AbstractSkin {
	public Beruehrungssensitiv() {
		this.beschreibung = "Beruehrungssensitiver Skin installiert!";
	}
	
	@Override
	public AbstractSkin setHilfskraftSkin(Hilfskraft hilfskraft) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setGesellschafterSkin(Gesellschafter gesellschafter) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setBauarbeiterSkin(Bauarbeiter bauarbeiter) {
		return null;
	}

	@Override
	public AbstractSkin setServiceTechnikerSkin(ServiceTechniker serviceTechniker) {
		return null;
	}

	@Override
	public AbstractSkin setTransportarbeiterSkin(Transportarbeiter transportarbeiter) {
		return null;
	}

	@Override
	public AbstractSkin setObjektbewacherSkin(Objektbewacher objektbewacher) {
		return null;
	}

	@Override
	public AbstractSkin setLeibwaechterSkin(Leibwaechter leibwaechter) {
		return null;
	}

	@Override
	public AbstractSkin setKaempferSkin(Kaempfer kaempfer) {
		return null;
	}

	public String toString() {
		return "Beruehrungsintensiver Skin";
	}
}
