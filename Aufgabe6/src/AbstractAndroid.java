import java.util.ArrayList;

public abstract class AbstractAndroid {
	private int seriennummer;
	private AbstractSoftware software;
	private AbstractSkin skin;
	private ArrayList<AbstractSensor> sensoren;
	
	
	public AbstractAndroid(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		this.seriennummer = seriennummer;
		this.software = software;
		this.skin = skin;
		this.sensoren = sensoren;
	}
}
