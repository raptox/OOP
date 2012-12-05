// Aufzaehlung fuer alle Himmelsrichtungen, in die ein Auto schauen kann
public enum Richtung {
	NORDEN, OSTEN, SUEDEN, WESTEN;
	
	// liefert die entgegengesetzte Himmelsrichtung
	public Richtung getGegengesetzteRichtung() {
		if ( Richtung.NORDEN == this ) return Richtung.SUEDEN;
		if ( Richtung.OSTEN  == this ) return Richtung.WESTEN;
		if ( Richtung.SUEDEN == this ) return Richtung.NORDEN;
		if ( Richtung.WESTEN == this ) return Richtung.OSTEN;
		
		return null;
	}
}
