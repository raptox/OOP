package management;



import java.io.File;
import java.text.SimpleDateFormat;

import serialization.Reader;
import serialization.Writer;

import models.*;
import notification.*;



public class Test {
	public static void main( String args[] ) {
		try {	
			System.out.println("BAND MANAGEMENT SYSTEM");
			System.out.println("======================");
			
			BandManagement bands;
			Band slipknot;
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			
			
			// Loading bands if data.ser file exists
			if ( (new File( "data.ser" )).exists() ) {
				System.out.println("READ DATA FROM FILE data.ser");
				Reader rd = new Reader( "data" );
				bands = rd.read();
			}
			else {
				// Add some bands
				bands = new BandManagement();
				System.out.println("<<Log in with admin so we can add bands and members>>");
				bands.setActiveUser("admin", "adminpass");
				
				bands.addBand("Slipknot");
				bands.addBand("Sum41");
				bands.addBand("Simple Plan");
				bands.addBand("Hitch Hikers");
	
				slipknot = bands.getBand("Slipknot");
				
	
				//add some Member
				Member coreyTailor = new Member( "Corey Tailor", "06646214689", "Gitarre", sdf.parse("2012-08-22") );
				Member chrisFehn = new Member( "Chris Fehn", "06646214234", "Schlagzeug", sdf.parse("2012-08-22") );
				Member mickThomson = new Member( "Mick Thomson", "06646214123", "DJ", sdf.parse("2012-08-22") );
				Member sidWilson = new Member( "Sid Wilson", "06646214457", "Gitarre", sdf.parse("2012-09-12") );
				
				// set password for Members
				coreyTailor.setPassword("abc");
				chrisFehn.setPassword("def");
				mickThomson.setPassword("ghi");
				sidWilson.setPassword("jkl");
				
				slipknot.addMember( coreyTailor );
				slipknot.addMember( chrisFehn );
				slipknot.addMember( mickThomson );
				slipknot.addMember( sidWilson );
				
				System.out.println("<<Users and bands added>>");
				
				bands.setActiveUser("Mick Thomson", "ghi");
				
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
				
				System.out.println("<<print all Songs>>");
				System.out.println(slipknot.listSongs(sdf.parse("2012-11-11")));
				slipknot.removeSong(eyeless, sdf.parse("2012-11-11"));
				System.out.println("<<print all Songs after \"eyeless\" removal>>");
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
				
				
				//print all Locations > 2000
				System.out.println("<<print all locations>>");
				System.out.println(lM.getLocations());
				System.out.println("<<print all locations > 2000m^2>>");
				System.out.println(lM.getLocations(2000));
				System.out.println();
				
				// print all gigs
				System.out.println("<<print all Gigs (2012-14-04  -  2012-12-08>>");
				System.out.println( slipknot.listGigs( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
				System.out.println();
				
				// print all practice sessions
				System.out.println("<<print all practice sessions (2012-11-04  -  2012-12-08>>");
				System.out.println( slipknot.listPractice( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
				System.out.println();
				
				// print different Credits-specifications (null selects all)
				System.out.println("print all Equipments: "+cF.getCredits(slipknot.getCreditsEquipments(null,null)));
				System.out.println("print all Credits: "+cF.getCredits(cF.filter(slipknot, null, null, null)));
				System.out.println("print all Credits from practices and gigs(big bang  -  2012-01-01): "
						+cF.getCredits(cF.filter(slipknot,null, sdf.parse( "2012-01-01" ), practicesAndGigs)));
				System.out.println("print all Credits (2012-01-01  - apocalypse): "
						+cF.getCredits(cF.filter(slipknot, sdf.parse( "2012-01-01" ),null, null)));
				System.out.println("print all Credits from gigs and equipments: "+cF.getCredits(cF.filter(slipknot, null, null, gigsAndEquipments)));
				System.out.println("print all Credits from equipments(2010-01-01  -  2012-01-01): " +
						cF.getCredits(slipknot.getCreditsEquipments(sdf.parse( "2010-01-01" ), sdf.parse( "2012-01-01" ))));
				System.out.println();
	
				// postpone the "novarock" gig
				Announcement postponedGig = novarock.postpone( sdf.parse("2013-09-08"), "Dieses Jahr faellt unser Auftritt am Novarock aus!" );
				slipknot.addAnnouncement( postponedGig );
	
				// cancel the "novarock" gig
				Announcement canceledGig = novarock.cancel( "Leider hat uns der Verantalter von Novarock unseren Gig abgesagt!" );
				slipknot.addAnnouncement( canceledGig );
			}
			
			// login as user "Corey Tailor"
			Member currentMember = bands.setActiveUser("Chris Fehn","def");
			slipknot = bands.getBand("Slipknot");
			//System.out.println( slipknot.listGigs( sdf.parse( "2012-12-04" ), sdf.parse( "2014-12-08" ) ) );
			
			// login as user "Corey Tailor"
			System.out.println("Try to log in as Corey Tailor (user left the band)");
			try {
				currentMember = bands.setActiveUser("Corey Tailor","abc");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			currentMember = bands.setActiveUser("Mick Thomson", "ghi");
			
			
			System.out.println("<<show announcements>>");
			// show all unread announcements for corey tailor
			for ( Announcement a : currentMember.listUnreadAnnouncements() ) {
				System.out.println( a.getMessage() );
			}
			
			System.out.println("WRITE DATA TO FILE data.ser");
			// save data to disk
			Writer wr = new Writer( "data" );
			wr.write( bands );
			
			/*
			 * 
			 * lustig
			//add some Songs
			Song duality = new Song( "Duality", 250, sdf.parse("2012-01-01") );
			Song eyeless = new Song( "Eyeless", 420, sdf.parse("2012-01-01") );
			Song surfacing = new Song( "Surfacing", 320, sdf.parse("2012-01-01") );
			Song scissors = new Song( "Scissors", 350, sdf.parse("2014-01-01") );

			slipknot.addSong( duality );
			slipknot.addSong( eyeless );
			slipknot.addSong( surfacing );
			slipknot.addSong( scissors );
			System.out.println(slipknot.listSongs(sdf.parse("2012-11-11")));
			slipknot.removeSong(eyeless, sdf.parse("2012-11-11"));
			System.out.println(slipknot.listSongs(sdf.parse("2012-11-11")));

			// Add some gigs
			Gig novarock = new Gig( "Pannonia Fields", sdf.parse("2012-09-08"), 120*60, 9999.99);
			Gig wacken = new Gig( "Wacken", sdf.parse("2012-10-25"), 170*60, 19999.99);
			Gig wiesen = new Gig( "Wiesen", sdf.parse("2012-11-04"), 110*60, 29999.99);

			slipknot.addPlay( novarock );
			slipknot.addPlay( wacken );
			slipknot.addPlay( wiesen );

			// Add some practice sessions
			Practice p1 = new Practice( "Uebung1", sdf.parse("2012-09-08"), 120*60, 500);
			Practice p2 = new Practice( "Uebung2", sdf.parse("2012-10-25"), 170*60, 200);
			Practice p3 = new Practice( "Uebung3", sdf.parse("2012-11-04"), 110*60, 300);

			slipknot.addPlay( p1 );
			slipknot.addPlay( p2 );
			slipknot.addPlay( p3 );

			// print all gigs
			System.out.println( slipknot.listGigs( sdf.parse( "2012-09-04" ), sdf.parse( "2012-12-08" ) ) );

			// print all practice sessions
			System.out.println( slipknot.listPractice( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );

			// print total income
			System.out.println( "Einkommen: " + slipknot.getCostsAll( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );

			// print all earnings from gigs
			System.out.println( "Einnahmen durch Gigs: " + slipknot.getCostsGigs( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );

			// print all rental costs for practice sessions
			System.out.println( "Ausgaben durch Proben: " + slipknot.getCostsPractices( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );

			// postpone the "novarock" gig
			Announcement postponedGig = novarock.postpone( sdf.parse("2013-09-08"), "Dieses Jahr f�llt unser Auftritt am Novarock aus!" );

			// output all the decisions from the band members concerning the postponement of the novarock gig
			for ( Decision d  : postponedGig.getDecisions() ) {
				System.out.println( "Von: " + d.getMember().getName() + ", Entscheidung: " + d.getDecision() + ", Begr�ndung: " + d.getReason() );
			}

			System.out.println();
			System.out.println( slipknot.listGigs( sdf.parse( "2013-01-04" ), sdf.parse( "2013-12-08" ) ) );


			// cancel the "novarock" gig
			Announcement canceledGig = novarock.cancel( "Leider hat uns der Verantalter von Novarock unseren Gig abgesagt!" );

			// output all the decisions from the band members concerning the postponement of the novarock gig
			for ( Decision d  : canceledGig.getDecisions() ) {
				System.out.println( "Von: " + d.getMember().getName() + ", Entscheidung: " + d.getDecision() + ", Begr�ndung: " + d.getReason() );
			}

			System.out.println( "\nList of all Gigs after canceling the novarock gig: ");
			System.out.println( slipknot.listGigs( sdf.parse( "2011-01-04" ), sdf.parse( "2013-12-08" ) ) );
*/

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}
}
