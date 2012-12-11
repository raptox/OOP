import java.util.Iterator;
import java.util.NoSuchElementException;

/*
 * Diese Klasse bildet ein HashSet ab. Als Datenspeicherung wird eine LinkedList verwendet
 */
@Programmierer(autoren="Alexander Tornoreanu")
public class HashSet {
	protected LinkedList list;
	
	/*
	 * Konstruktor
	 * 
	 * NB: liefert neues HashSet Objekt zurueck
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public HashSet() {
		this.list = new LinkedList();
	}
	
	/*
	 * Fuegt neues Element ein mit beliebigem Objekt als Key
	 * 
	 * VB: key != null, element != null
	 * NB: liefert true bei Erfolg, false bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean insert( Object key, CollectionItem element ) {
		return this.list.add( key, element );
	}
	
	/*
	 * Loescht Objekt aus dem Set mithilfe eines Keys
	 * 
	 * VB: key != null
	 * NB: liefert true bei Erfolg, false bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean removeValue( Object key ) {
		Item help = list.getRoot();
		Item before = help;
		
		if (key == null)
			return false;
		
		while (help != null) {
			if (help.getKey().toString().equals(key.toString())) {
				// remove root objekt
				if (help == before) {
					this.list.setRoot(help.getNext());
					help = null;
				}
				else {
					// remove object
					before.setNext(help.getNext());
				}
				return true;
			}
			
			if (help != null) {
				before = help;
				help = help.getNext();
			}
		}
		
		return false;
	}
	
	/*
	 * Sucht ein Item anhand des Keys und liefert es zurueck
	 * 
	 * VB: key != null
	 * NB: liefert CollectionItem bei Erfolg, leifert null bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public CollectionItem getValue( Object key ) {
		Item help = list.getRoot();
		
		while (help != null) {
			if (help.getKey().toString().equals(key.toString())) {
				return help.getValue();
			}
			help = help.getNext();
		}
		
		return null;	
	}
	
	/*
	 * Schaut nach ob dieser Key schon vorhanden ist
	 * 
	 * VB: key != null
	 * NB: liefert true bei Erfolg, false bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean hasKey(Object key) {
		Item help = list.getRoot();
		
		if (key == null)
			return false;
		
		while (help != null) {
			if (help.getKey().toString().equals(key.toString())) {
				return true;
			}
			help = help.getNext();
		}
		
		return false;
	}
	
	/*
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public String toString() {
		Item c = this.list.getRoot();
		String output = "";
		
		while( c != null ) {
			output += c.getValue() + "\n";
			c = c.getNext();
		}
		
		return output;
	}
	
	/*
	 * erzeugt einen Iterator fuer das Set
	 * 
	 * NB: liefert Iterator des HashSets zurueck
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Iterator iterator() {
		return new SetIterator( this.list );
	}
	
	/*
	 * Diese Klasse soll einen Iterator simulieren
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	private class SetIterator implements Iterator {
		private Item current;
		private Item lastValue;
		private LinkedList list;
		
		/*
		 * Konstruktor
		 * 
		 * VB: list != null
		 * NB: liefert neues SetIterator Objekt zurueck
		 */
		@Programmierer(autoren="Alexander Tornoreanu")
		public SetIterator( LinkedList list ) {
			this.list    = list;
			this.current = this.list.getRoot();
			this.lastValue = null;
		}
		
		/*
		 * schaut ob es noch Elemente gibt in der Liste zum durchiterieren
		 * 
		 * NB: liefert true bei Erfolg, false bei Misserfolg 
		 */
		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public boolean hasNext() {
			if ( this.current != null ) {
				return true;
			}
			
			return false;
		}

		/*
		 * Liefert das naechste Element aus der Liste
		 * 
		 * NB: liefert naechstes Element in der Liste
		 */
		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public CollectionItem next() {
			CollectionItem value = this.current.getValue();
			
			if ( this.current == null ) { 
				throw new NoSuchElementException();
			}
			this.lastValue = this.current;
			this.current = this.current.getNext();
			
			return value;
		}

		/*
		 * Entfernt das aktuelle Element welches durchiteriert wird
		 * 
		 * NB: Entfernt ein Element
		 */
		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public void remove() {
			Item help = this.list.getRoot();
			Item before = help;
			
			while (help != null) {
				if (help == this.lastValue) {
					if (help == before) {
						// Element am Listenanfang
						this.list.setRoot(help.getNext());
						help = null; // aus Schleife raus
					} else {
						before.setNext(help.getNext());
						help = null; // aus Schleife raus
					}
				}
				
				if (help != null) {
					before = help;
					help = help.getNext();
				}
			}
		}
	}
}
