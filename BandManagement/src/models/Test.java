package models;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Test {
	public static void main( String args[] ) {
		try {
			Band slipknot = new Band( "Slipknot" );
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			//add some Member
			Member coreyTailor = new Member( "Corey Tailor", "06646214689", "Gitarre", sdf.parse("2012-08-22") );
			Member chrisFehn = new Member( "Chris Fehn", "06646214234", "Schlagzeug", sdf.parse("2012-08-22") );
			Member mickThomson = new Member( "Mick Thomson", "06646214123", "DJ", sdf.parse("2012-08-22") );
			Member sidWilson = new Member( "Sid Wilson", "06646214457", "Gitarre", sdf.parse("2012-09-12") );
			
			slipknot.addMember( coreyTailor );
			slipknot.addMember( chrisFehn );
			slipknot.addMember( mickThomson );
			slipknot.addMember( sidWilson );
			
			
			System.out.println("print all Members(2010-08-23 -> emty band)");
			System.out.println(slipknot.listMembers(sdf.parse("2010-08-23")));
			System.out.println("print all Members(2014-08-23 -> list all)");
			System.out.println(slipknot.listMembers(sdf.parse("2014-08-23")));
			slipknot.removeMember(coreyTailor, sdf.parse("2013-01-01"));
			System.out.println("print all Members(2014-08-23 -> list all members after Corey Tailor leaved the band)");
			System.out.println(slipknot.listMembers(sdf.parse("2014-08-23")));
			System.out.println("print all Members(2012-08-23 -> at this time Corey Tailor is still in the band");
			System.out.println(slipknot.listMembers(sdf.parse("2012-10-23")));
			System.out.println();
			
			//add some Songs
			Song duality = new Song( "Duality", 250, sdf.parse("2012-01-01") );
			Song eyeless = new Song( "Eyeless", 420, sdf.parse("2012-01-01") );
			Song surfacing = new Song( "Surfacing", 320, sdf.parse("2012-01-01") );
			Song scissors = new Song( "Scissors", 350, sdf.parse("2014-01-01") );
			
			slipknot.addSong( duality );
			slipknot.addSong( eyeless );
			slipknot.addSong( surfacing );
			slipknot.addSong( scissors );
			
			System.out.println("print all Songs");
			System.out.println(slipknot.listSongs(sdf.parse("2012-11-11")));
			slipknot.removeSong(eyeless, sdf.parse("2012-11-11"));
			System.out.println("print all Songs after \"eyeless\" removal");
			System.out.println(slipknot.listSongs(sdf.parse("2012-11-11")));
			System.out.println();
			
			//add some Equipment
			Equipment guitar = new Equipment("Guitar",sdf.parse("2010-01-01"),300);
			Equipment keyboard = new Equipment("Keyboard",sdf.parse("2011-01-01"),300);
			Equipment micro = new Equipment("Micro",sdf.parse("2011-03-01"),100);
			Equipment box = new Equipment("Box",sdf.parse("2012-05-01"),600);
			
			slipknot.addEquipment(guitar);
			slipknot.addEquipment(keyboard);
			slipknot.addEquipment(micro);
			slipknot.addEquipment(box);
			
			
			
			//Add some Locations
			LocationManager lM = new LocationManager();
			Location pannoniaFieldsLoc = new Location("Pannonia Fields",2500);
			Location wackenLoc = new Location("Wacken",3000);
			Location wiesenLoc = new Location("Wiesen",1000);
			Location smallLoc1 = new Location("Practice Room 1",20);
			Location smallLoc2 = new Location("Practice Room 2",15);
			
			lM.addLocation(pannoniaFieldsLoc);
			lM.addLocation(wackenLoc);
			lM.addLocation(wiesenLoc);
			lM.addLocation(smallLoc1);
			lM.addLocation(smallLoc2);

		// Add some gigs
		Gig novarock = new Gig( pannoniaFieldsLoc, sdf.parse("2011-06-08"), 120*60, 9999.99);
		Gig wacken = new Gig( wackenLoc, sdf.parse("2012-10-25"), 170*60, 19999.99);
		Gig wiesen = new Gig( wiesenLoc, sdf.parse("2012-11-04"), 110*60, 29999.99);
		
		slipknot.addPlay( novarock );
		slipknot.addPlay( wacken );
		slipknot.addPlay( wiesen );
		
		// Add some practice sessions
		Practice p1 = new Practice( smallLoc1, sdf.parse("2012-09-08"), 120*60, 500);
		Practice p2 = new Practice( smallLoc2, sdf.parse("2012-10-25"), 170*60, 200);
		Practice p3 = new Practice( smallLoc2, sdf.parse("2012-11-04"), 110*60, 200);
		
		slipknot.addPlay( p1 );
		slipknot.addPlay( p2 );
		slipknot.addPlay( p3 );
		
		//add a CreditFilter
		CreditsFilter cF = new CreditsFilter();
		//and some String Arrays to filter by
		String[] practicesAndGigs = {"Practices","Gigs"};
		String[] gigsAndEquipments = {"Gigs","Equipments"};
		
		System.out.println(cF.getCredits(slipknot.getCreditsEquipments(null,null)));
		
		//print all Locations > 2000
		System.out.println("print all locations");
		System.out.println(lM.getLocations());
		System.out.println("print all locations > 2000m²");
		System.out.println(lM.getLocations(2000));
		System.out.println();
		
		// print all gigs
		System.out.println("print all Gigs (2012-14-04  -  2012-12-08");
		System.out.println( slipknot.listGigs( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		System.out.println();
		
		// print all practice sessions
		System.out.println("print all practice sessions (2012-11-04  -  2012-12-08");
		System.out.println( slipknot.listPractice( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		System.out.println();
		
		// print different Credits-specifications (null selects all)
		System.out.println("print all Credits: "+cF.getCredits(cF.filter(slipknot, null, null, null)));
		System.out.println("print all Credits from practices and gigs(big bang  -  2012-01-01): "
				+cF.getCredits(cF.filter(slipknot,null, sdf.parse( "2012-01-01" ), practicesAndGigs)));
		System.out.println("print all Credits (2012-01-01  - apocalypse): "
				+cF.getCredits(cF.filter(slipknot, sdf.parse( "2012-01-01" ),null, null)));
		System.out.println("print all Credits from gigs and equipments: "+cF.getCredits(cF.filter(slipknot, null, null, gigsAndEquipments)));
		System.out.println("print all Credits from equipments: "+cF.getCredits(slipknot.getCreditsEquipments(sdf.parse( "2010-01-01" ), sdf.parse( "2012-01-01" ))));
		System.out.println();
		
		
		
		slipknot.changeGigDate();
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
