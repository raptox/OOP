
public class Beruehrungssensitiv extends AbstractSkin {
	public Beruehrungssensitiv() {
		super();
		this.beschreibung = "Beruehrungssensitiver Skin installiert!";
	}
	
	@Override
	public AbstractSkin setSkin(Hilfskraft hilfskraft) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(Gesellschafter gesellschafter) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(Bauarbeiter bauarbeiter) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(ServiceTechniker serviceTechniker) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(Transportarbeiter transportarbeiter) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(Objektbewacher objektbewacher) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(Leibwaechter leibwaechter) {
		return new Beruehrungssensitiv();
	}

	@Override
	public AbstractSkin setSkin(Kaempfer kaempfer) {
		return new Beruehrungssensitiv();
	}

	public String toString() {
		return "Beruehrungsintensiver Skin";
	}
}
