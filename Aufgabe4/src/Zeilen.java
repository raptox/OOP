/*
 * Wird verwendet um Information ueber String Objekte zu speichern
 */

public class Zeilen {
	private String zeilen; // hier sind alle Zeilen gespeichert
	private int zeilenLaenge; // laenge der Zeilen
	private int zeilenAnz; // Anzahl der Zeilen
	private int nextLine; // aktuelle Zeile

	// zeilen != null
	public Zeilen(String zeilen) {
		this.zeilen = zeilen;
		this.zeilenLaenge = countZeile();
		this.zeilenAnz = countZeilenAnzahl();
		this.nextLine = 0;
	}

	// gibt Anzahl der Zeilen zurueck
	private int countZeilenAnzahl() {
		int counter = 1;
		//StringBuffer sb = new StringBuffer( new StringReader( this.zeilen ) );
		
		for (int i=0; i<zeilen.length(); i++) {
			if ( (i+1) < zeilen.length() && zeilen.charAt(i) == '\n') {
				counter++;
			}
		}
		
		return counter > 1 ? counter : 1;
	}
	
	public int getAnzZeilen() {
		return zeilenAnz;
	}
	
	// gibt naechste Zeile zurueck
	public String getNextLine() {
		String line="";
		int lineCounter=0;
		
		if (nextLine == zeilenAnz)
			return "";
		
		for (int i=0; i<zeilen.length(); i++) {
			if (zeilen.charAt(i) == '\n') {
				if (lineCounter == nextLine) {
					nextLine++;
					return line;
				}
				lineCounter++;
			} else if (lineCounter == nextLine) {
				line = line.concat(zeilen.charAt(i)+"");
			}
		}
		
		nextLine++;
		
		return line;
	}
	
	// zaehlt alle Zeilen
	private int countZeile() {
		// berechnet Zeilenlaenge (alle Zeilen sind gleich lang)

		int counter = 0;

		for (int i=0; i<zeilen.length(); i++) {
			if (zeilen.charAt(i) == '\n')
				break;

			counter++;
		}

		return counter;
	}

	public String getZeilen () {
		return zeilen;
	}

	public int getZeilenLaenge() {
		return zeilenLaenge;
	}

	public void setZeilenLaenge(int n) {
		zeilenLaenge = n;
	}
}
