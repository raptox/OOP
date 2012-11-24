import java.util.ArrayList;

public abstract class AbstractAndroid {
	private int seriennummer;
	private AbstractSoftware software;
	protected AbstractSkin skin;
	private ArrayList<AbstractSensor> sensoren;
	
	public AbstractAndroid(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		this.seriennummer = seriennummer;
		this.software = software;
		this.skin = skin;
		this.sensoren = sensoren;
	}

	public int getSeriennummer() {
		return seriennummer;
	}

	public void setSeriennummer(int seriennummer) {
		this.seriennummer = seriennummer;
	}

	public AbstractSoftware getSoftware() {
		return software;
	}

	public void setSoftware(AbstractSoftware software) {
		this.software = software;
	}

	public AbstractSkin getSkin() {
		return skin;
	}

	public ArrayList<AbstractSensor> getSensoren() {
		return sensoren;
	}

	public void setSensoren(ArrayList<AbstractSensor> sensoren) {
		this.sensoren = sensoren;
	}
}
