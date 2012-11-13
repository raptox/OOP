public class Zeilen {
	private String zeilen; // hier sind alle Zeilen gespeichert
	private int zeilenLaenge; // laenge der Zeilen
	private int zeilenAnz; // Anzahl der Zeilen
	private int nextLine; // aktuelle Zeile

	public Zeilen(String zeilen) {
		this.zeilen = zeilen;
		this.zeilenLaenge = countZeile();
		this.zeilenAnz = countZeilenAnzahl();
		this.nextLine = 0;
	}

	private int countZeilenAnzahl() {
		int counter = 0;
		
		for (int i=0; i<zeilen.length(); i++) {
			if (zeilen.charAt(i) == '\n')
				counter++;
		}
		
		return counter;
	}
	
	public int getAnzZeilen() {
		return zeilenAnz;
	}
	
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
	
		return line;
	}
	
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
