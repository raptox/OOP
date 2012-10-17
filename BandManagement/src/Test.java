import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Test {
	public static void main( String args[] ) {
		Band slipknot = new Band( "Slipknot" );
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		Member coreyTailor = null;
		Member chrisFehn = null;
		Member mickThomson = null;
		Member sidWilson = null;
		
		try {
			coreyTailor = new Member( "Corey Tailor", "06646214689", "Gitarre", sdf.parse("2012-08-22") );
			chrisFehn = new Member( "Chris Fehn", "06646214234", "Schlagzeug", sdf.parse("2012-08-22") );
			mickThomson = new Member( "Mick Thomson", "06646214123", "DJ", sdf.parse("2012-08-22") );;
			sidWilson = new Member( "Sid Wilson", "06646214457", "Gitarre", sdf.parse("2012-09-12") );
		
		
		slipknot.addMember( coreyTailor );
		slipknot.addMember( chrisFehn );
		slipknot.addMember( mickThomson );
		slipknot.addMember( sidWilson );
		

		System.out.println( slipknot.listMembers( sdf.parse("2012-09-08") ) );

		// Add some gigs
		Gig novarock = new Gig( "Pannonia Fields", sdf.parse("2012-09-08"), 120*60, 9999.99);
		Gig wacken = new Gig( "Wacken", sdf.parse("2012-10-25"), 170*60, 19999.99);
		Gig wiesen = new Gig( "Wiesen", sdf.parse("2012-11-04"), 110*60, 29999.99);
		
		slipknot.addPlay( novarock );
		slipknot.addPlay( wacken );
		slipknot.addPlay( wiesen );
		
		// Add some practice sessions
		Practice p1 = new Practice( "�bung1", sdf.parse("2012-09-08"), 120*60, 500);
		Practice p2 = new Practice( "�bung2", sdf.parse("2012-10-25"), 170*60, 200);
		Practice p3 = new Practice( "�bung3", sdf.parse("2012-11-04"), 110*60, 300);
		
		slipknot.addPlay( p1 );
		slipknot.addPlay( p2 );
		slipknot.addPlay( p3 );
		
		// print all gigs
		System.out.println( slipknot.listGigs( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		
		// print all practice sessions
		System.out.println( slipknot.listPractice( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		
		// print total income
		System.out.println( "Einkommen: " + slipknot.getCostsAll( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		
		// print all earnings from gigs
		System.out.println( "Einnahmen durch Gigs: " + slipknot.getCostsGigs( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		
		// print all rental costs for practice sessions
		System.out.println( "Ausgaben durch Proben: " + slipknot.getCostsPractices( sdf.parse( "2012-11-04" ), sdf.parse( "2012-12-08" ) ) );
		
		
		
		Song duality = new Song( "Duality", 250, sdf.parse("2012-08-08") );
		Song eyeless = new Song( "Eyeless", 420, sdf.parse("2012-09-12") );
		Song surfacing = new Song( "Surfacing", 320, sdf.parse("2012-09-16") );
		Song scissors = new Song( "Scissors", 350, sdf.parse("2012-10-08") );
		
		slipknot.addSong( duality );
		slipknot.addSong( eyeless );
		slipknot.addSong( surfacing );
		slipknot.addSong( scissors );
		
		System.out.println( slipknot.listSongs( sdf.parse( "2012-11-04" ) ) );
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
