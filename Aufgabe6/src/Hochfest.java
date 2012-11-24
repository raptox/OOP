
public class Hochfest extends AbstractSkin {

	public Hochfest() {
		super();
		this.beschreibung = "Hochfester Skin installiert!";
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
		return new Hochfest();
	}

	@Override
	public AbstractSkin setSkin(ServiceTechniker serviceTechniker) {
		// TODO Auto-generated method stub
		return new Hochfest();
	}

	@Override
	public AbstractSkin setSkin(Transportarbeiter transportarbeiter) {
		// TODO Auto-generated method stub
		return new Hochfest();
	}

	@Override
	public AbstractSkin setSkin(Objektbewacher objektbewacher) {
		// TODO Auto-generated method stub
		return new Hochfest();
	}

	@Override
	public AbstractSkin setSkin(Leibwaechter leibwaechter) {
		// TODO Auto-generated method stub
		return new Hochfest();
	}

	@Override
	public AbstractSkin setSkin(Kaempfer kaempfer) {
		// TODO Auto-generated method stub
		return new Hochfest();
	}

	

}
