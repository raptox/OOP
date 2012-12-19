import java.util.ArrayList;

/*
 * diese Klasse nimmt Bestellungen auf und erzeugt Kekse wenn die Bestellungen geliefert werden
 */
public class Baeckerei {
	private String name;
	private ArrayList<Bestellung> bestellungen;

	/*
	 * Konstruktor
	 * VB: name != null
	 */
	public Baeckerei(String name) {
		this.name = name;
		bestellungen = new ArrayList<Bestellung>();
	}

	/*
	 * Fuegt neue Bestellung hinzu
	 * VB: a != null
	 */
	public void neueBestellung(Bestellung a) {
		bestellungen.add(a);
	}

	/*
	 * Zeigt alle Bestellungen an
	 * NB: liefert String mit allen Bestellungen
	 */
	public String zeigeBestellungen() {
		String best = "";

		for (int i=0; i<bestellungen.size(); i++) {
			best = best + (i+1) + ". Bestellung " + ":\n" + bestellungen.get(i) + "\n";
		}

		return best;
	}

	/*
	 * Liefert die bestellten Kekse in einer Keksdose zurueck. Alle Bestellungen werden abgearbeitet und bei Fertigstellung gelöscht.
	 * NB: liefert Objekt Kecksdose mit den Keksen
	 */
	public Keksdose liefereBestellungen() {
		Keksdose kekse = new Keksdose("Geliefert von "+name);
		Backmaschine ms;

		for (int x=0; x<bestellungen.size(); x++) {
			ArrayList<Position> akt_best = bestellungen.get(x).getPositionen();

			for (int y=0; y<akt_best.size(); y++) {
				Position aktuel = akt_best.get(y);

				for (int i=0; i<aktuel.getAnzahl(); i++) {
					if (aktuel.getFuellung() == null) {
						ms = new EinfachKeksBackmaschine(aktuel.getForm(), aktuel.getTeigart());
					} else {
						ms = new DoppelKeksBackmaschine(new EinfachKeks(aktuel.getForm(), aktuel.getTeigart()), aktuel.getFuellung());
					}

					kekse.addKeks(ms.backe());
				}
			}
		}
		
		this.bestellungen.clear();

		return kekse;
	}
}
