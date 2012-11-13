/*
 * gibt Objekte nebeneinander aus bzw. skaliert nebeneinander aus
 */
public class Repeated<P> implements Pict {
	protected P[][] elements;
	protected int width, height;
	protected double swidth, sheight;

	// elements != null
	public Repeated( P[][] elements ) {
		this.elements = elements;
		width = elements.length;
		height = elements[0].length;
		swidth = width;
		sheight = height;
	}

	// 0.1 <= factor <= 10.0; resize the picture
	public void scale( double factor ) {
		swidth = swidth*factor;
		sheight = sheight*factor;
	}

	/*
	 * gibt Objekte nebeneinander aus
	 * 
	 */
	public String toString() {
		int iswidth = (int)Math.ceil(swidth);
		int isheight = (int)Math.ceil(sheight);
		
		
		Zeilen[][] helper = new Zeilen[(int)iswidth][(int)isheight];
		int maxWidth = 0;
		int maxHeight = 0;
		String returnString = "";
		
		P[][] newElements = (P[][]) new Object[iswidth][isheight];
		
		for (int i=0; i<iswidth; i++) {
			for (int y=0; y<isheight; y++) {
				newElements[i][y] = elements[i%width][y%height]; 	
			}
		}
		
		// helper mit den toStrings fuellen, berchnet auch die Zeilenlaenge
		// und laengste Zeile suchen, damit wir wissen wie viel wir auffuellen
		for (int i=0; i<iswidth; i++) {
			for (int y=0; y<isheight; y++) {
				helper[i][y] = new Zeilen(newElements[i][y].toString());
				
				// laengste Zeile ausfindig machen
				if (helper[i][y].getZeilenLaenge() > maxWidth)
					maxWidth = helper[i][y].getZeilenLaenge();

				// maxHeight bestimmen
				if (helper[i][y].getAnzZeilen() > maxHeight)
					maxHeight = helper[i][y].getAnzZeilen();
			}
		}
		
		// Objekte ausgeben und auffuellen
		for (int i=0; i<iswidth; i++) {
			for (int h=0; h<maxHeight; h++) {
				for (int y=0; y<isheight; y++) {
					String nextLine = helper[i][y].getNextLine();
					returnString = returnString.concat(nextLine);
					//System.out.println("i: "+i+" y: "+y+" nextLine: "+nextLine);

					int lineLength = helper[i][y].getZeilenLaenge();
					int stringHeight = helper[i][y].getAnzZeilen();
					
					if (lineLength < maxWidth) {
						if (nextLine.equals("")) {
							for (int z=0; z<maxWidth; z++) {
								returnString=returnString.concat(" ");
							}
						} else {
							for (int z=0; z<maxWidth-lineLength; z++) {
								returnString=returnString.concat(" ");
							}							
						}
					} else if (nextLine.equals("") && stringHeight < maxHeight) {
						for (int z=0; z<maxWidth; z++)
							returnString=returnString.concat(" ");
					}
				}
				//System.out.println("i: "+i+" line: "+returnString);
				returnString=returnString.concat("\n");
			}
			//returnString.concat("\n");
		}



		return returnString;
	}
}
