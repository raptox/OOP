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
			
			/*
			 * Auslesen aus Datei deaktiviert
			 * 
			// Loading bands if data.ser file exists
			if ( (new File( "data.ser" )).exists() ) {
				Reader rd = new Reader( "data" );
				bands = rd.read();
			}
			else {*/
				// Add some bands
				bands = new BandManagement();
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
				
				
				
				
				//add some Songs
				Song duality = new Song( "Duality", 250, sdf.parse("2012-01-01") );
				Song eyeless = new Song( "Eyeless", 420, sdf.parse("2012-01-01") );
				Song surfacing = new Song( "Surfacing", 320, sdf.parse("2012-01-01") );
				Song scissors = new Song( "Scissors", 350, sdf.parse("2014-01-01") );
	
				slipknot.addSong( duality );
				slipknot.addSong( eyeless );
				slipknot.addSong( surfacing );
				slipknot.addSong( scissors );
				
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
	
				// postpone the "novarock" gig
				Announcement postponedGig = novarock.postpone( sdf.parse("2013-09-08"), "Dieses Jahr fŠllt unser Auftritt am Novarock aus!" );
				slipknot.addAnnouncement( postponedGig );
	
				// cancel the "novarock" gig
				Announcement canceledGig = novarock.cancel( "Leider hat uns der Verantalter von Novarock unseren Gig abgesagt!" );
				slipknot.addAnnouncement( canceledGig );
			//}
			
			// login as user "Corey Tailor"
			Member currentMember = bands.setActiveUser("admin","adminpass");
			slipknot = bands.getBand("Slipknot");
			//System.out.println( slipknot.listGigs( sdf.parse( "2012-12-04" ), sdf.parse( "2014-12-08" ) ) );
			
			// login as user "Corey Tailor"
			currentMember = bands.setActiveUser("Corey Tailor","abc");
			
			// show all unread announcements for corey tailor
			for ( Announcement a : currentMember.listUnreadAnnouncements() ) {
				System.out.println( a.getMessage() );
			}
			
			// save data to disk
			Writer wr = new Writer( "data" );
			wr.write( bands );
			
			/*
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
			Announcement postponedGig = novarock.postpone( sdf.parse("2013-09-08"), "Dieses Jahr fï¿½llt unser Auftritt am Novarock aus!" );

			// output all the decisions from the band members concerning the postponement of the novarock gig
			for ( Decision d  : postponedGig.getDecisions() ) {
				System.out.println( "Von: " + d.getMember().getName() + ", Entscheidung: " + d.getDecision() + ", Begrï¿½ndung: " + d.getReason() );
			}

			System.out.println();
			System.out.println( slipknot.listGigs( sdf.parse( "2013-01-04" ), sdf.parse( "2013-12-08" ) ) );


			// cancel the "novarock" gig
			Announcement canceledGig = novarock.cancel( "Leider hat uns der Verantalter von Novarock unseren Gig abgesagt!" );

			// output all the decisions from the band members concerning the postponement of the novarock gig
			for ( Decision d  : canceledGig.getDecisions() ) {
				System.out.println( "Von: " + d.getMember().getName() + ", Entscheidung: " + d.getDecision() + ", Begrï¿½ndung: " + d.getReason() );
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
