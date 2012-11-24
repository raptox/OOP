
public class Test {
	public static void main(String[] args) {
		AndroidList androids = new AndroidList();
		
		
		// Test Androiden anelgen
		System.out.println("<<Androiden anlegen, Skins installieren, Software installieren>>");
		Hilfskraft h1 = new Hilfskraft(1);
		h1.setSkin(new Gepanzert());
		h1.setSoftware(new HilfskraftSoftware(),new Security1());
		System.out.println( "H1: "+getSkinInstallationMessage( h1.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(h1.getSoftware()) );
		
		Hilfskraft h2 = new Hilfskraft(2);
		h2.setSkin(new Beruehrungssensitiv());
		h2.setSoftware(new HilfskraftSoftware(),new Security5());
		System.out.println( "H2: "+getSkinInstallationMessage( h2.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(h2.getSoftware()) );
		
		Kaempfer b1 = new Kaempfer(3);
		b1.setSkin(new Gepanzert());
		b1.setSoftware(new BauarbeiterSoftware(),new Security2());
		System.out.println( "B1: "+getSkinInstallationMessage( b1.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(b1.getSoftware()) );
		
		Kaempfer b2 = new Kaempfer(3);
		b2.setSkin(new Hochfest());
		b2.setSoftware(new KaempferSoftware(),new Security5());
		System.out.println( "B2: "+getSkinInstallationMessage( b2.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(b2.getSoftware()) );
	}
	
	public static String getSkinInstallationMessage( AbstractSkin skin ) {
		if ( skin == null ) {
			return "Skin konnte nicht installiert werden!";
		}
		
		return skin.getBeschreibung();
	}
	
	public static String getSoftwareInstallationMessage( AbstractSoftware software ) {
		if ( software == null ) {
			return "Software konnte nicht installiert werden!";
		}
		
		return software.getBeschreibung();
	}
}
