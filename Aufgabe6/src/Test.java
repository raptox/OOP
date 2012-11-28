import java.util.Iterator;


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
		
		// Hilfskraft Android wird angelegt mit Beruehrungssensitiven Skin, Hilfskraftsoftware Level 1 einem Kit mit max. 1kW
		Hilfskraft h2 = new Hilfskraft(2);
		h2.setSkin(new Beruehrungssensitiv());
		h2.setSoftware(new HilfskraftSoftware(),new Security1());
		
		KitMax1kW kitHilfskraft = new KitMax1kW();
		kitHilfskraft.setSensors( null );  // konkrete Sensoren Klassen muessen bei Gebrauch implementiert werden, zu Testzwecken sind keine notwendig
		h2.setKit( kitHilfskraft, new Security1() );
		
		System.out.println( "H2: "+getSkinInstallationMessage( h2.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(h2.getSoftware()) + "\n" + getKitInstallationMessage(h2.getKit()) + "\n" );
		
		
		// Bauarbeiter Android wird angelegt mit Hochfestem Skin, Bauarbeitersoftware Level 4 und einem Kit mit max. 10kW
		Bauarbeiter bArbeiter = new Bauarbeiter(3);
		bArbeiter.setSkin(new Hochfest() );
		bArbeiter.setSoftware(new BauarbeiterSoftware(), new Security4());
		
		KitMax10kW kitBauarbeiter = new KitMax10kW();
		kitBauarbeiter.setSensors( null ); // konkrete Sensoren Klassen muessen bei Gebrauch implementiert werden, zu Testzwecken sind keine notwendig
		bArbeiter.setKit( kitBauarbeiter, new Security4() );
		
		System.out.println( "Bauarbeiter Android: "+getSkinInstallationMessage( bArbeiter.getSkin() )+"\n"
				  +getSoftwareInstallationMessage(bArbeiter.getSoftware()) + "\n" + getKitInstallationMessage(bArbeiter.getKit()) + "\n" );
		
		// Kaempfer Android wird angelegt mit Gepanzertem Skin, Bauarbeitersoftware Level 2
		Kaempfer b1 = new Kaempfer(4);
		b1.setSkin(new Gepanzert());
		b1.setSoftware(new BauarbeiterSoftware(),new Security2());
		
		KitMax10kW kitKaempfer = new KitMax10kW();
		kitHilfskraft.setSensors( null ); // konkrete Sensoren Klassen muessen bei Gebrauch implementiert werden, zu Testzwecken sind keine notwendig
		b1.setKit( kitKaempfer, new Security2() );
		
		System.out.println( "B1: "+getSkinInstallationMessage( b1.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(b1.getSoftware()) + "\n" + getKitInstallationMessage(b1.getKit()) );
		
		Kaempfer b2 = new Kaempfer(5);
		b2.setSkin(new Hochfest());
		b2.setSoftware(new KaempferSoftware(),new Security5());
		System.out.println( "B2: "+getSkinInstallationMessage( b2.getSkin() )+"\n"
		  +getSoftwareInstallationMessage(b2.getSoftware()) );
		
		
		androids.insert( b1 );
		androids.insert( h2 );
		androids.insert( h1 );
		androids.insert( bArbeiter );
		
		System.out.println( androids.find( 3 ) );
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
	
	public static String getKitInstallationMessage( AbstractKit kit ) {
		if ( kit == null ) {
			return "Sensor/Aktor Kit konnte nicht installiert werden!";
		}
		
		return kit.getBeschreibung();
	}
}
