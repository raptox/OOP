
public class Gepanzert extends AbstractSkin {
	public Gepanzert() {
		super();
		this.beschreibung = "Gepanzerter Skin installiert!";
	}

	@Override
	public AbstractSkin setSkin(Hilfskraft hilfskraft) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSkin setSkin(Gesellschafter gesellschafter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSkin setSkin(Bauarbeiter bauarbeiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSkin setSkin(ServiceTechniker serviceTechniker) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSkin setSkin(Transportarbeiter transportarbeiter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractSkin setSkin(Objektbewacher objektbewacher) {
		// TODO Auto-generated method stub
		return new Gepanzert();
	}

	@Override
	public AbstractSkin setSkin(Leibwaechter leibwaechter) {
		// TODO Auto-generated method stub
		return new Gepanzert();
	}

	@Override
	public AbstractSkin setSkin(Kaempfer kaempfer) {
		// TODO Auto-generated method stub
		return new Gepanzert();
	}
}
