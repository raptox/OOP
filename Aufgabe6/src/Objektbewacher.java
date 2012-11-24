import java.util.ArrayList;


public class Objektbewacher extends AbstractBeschuetzer {
	public Objektbewacher(int seriennummer) {
		super(seriennummer);
	}

	public void setSoftware(AbstractSoftware software, Security1 sec) {
		// TODO Auto-generated method stub
		software.setSN(this.seriennummer);
		this.software = software.setSoftware(this,sec);
	}
	
	public void setSoftware(AbstractSoftware software, Security2 sec) {
		// TODO Auto-generated method stub
		software.setSN(this.seriennummer);
		this.software = software.setSoftware(this,sec);
	}
	
	public void setSoftware(AbstractSoftware software, Security3 sec) {
		// TODO Auto-generated method stub
		software.setSN(this.seriennummer);
		this.software = software.setSoftware(this,sec);
	}
	
	public void setSoftware(AbstractSoftware software, Security4 sec) {
		// TODO Auto-generated method stub
		software.setSN(this.seriennummer);
		this.software = software.setSoftware(this,sec);
	}
	
	public void setSoftware(AbstractSoftware software, Security5 sec) {
		// TODO Auto-generated method stub
		software.setSN(this.seriennummer);
		this.software = software.setSoftware(this,sec);
	}

	@Override
	public void setSkin(AbstractSkin skin) {
		// TODO Auto-generated method stub
		skin.setSN(this.seriennummer);
		this.skin = skin.setSkin(this);
	}

	@Override
	public void setSensoren(ArrayList<AbstractSensor> sensoren) {
		// TODO Auto-generated method stub
		
	}
}
