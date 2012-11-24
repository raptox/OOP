import java.util.ArrayList;


public class ServiceTechniker extends AbstractSchwerarbeiter {
	public ServiceTechniker(int seriennummer, AbstractSoftware software, AbstractSkin skin, ArrayList<AbstractSensor> sensoren) {
		super(seriennummer, software, skin, sensoren);
	}
}
