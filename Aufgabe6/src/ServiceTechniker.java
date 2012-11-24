import java.util.ArrayList;


public class ServiceTechniker extends AbstractSchwerarbeiter {
	public ServiceTechniker(int seriennummer) {
		super(seriennummer);
	}
	
	public ServiceTechniker(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer);
		
		this.skin = skin.setSkin(this);
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
