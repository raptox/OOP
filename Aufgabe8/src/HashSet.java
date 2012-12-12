import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Diese Klasse bildet ein HashSet ab. Als Datenspeicherung wird eine einfach verlinkte Liste verwendet
 */
@Programmierer(autoren="Alexander Tornoreanu")
public class HashSet {
	protected LinkedList list;
	
	/**
	 *  Die Innere Klasse Item stellt einen einzelnen "Knoten" in der LinkedList dar
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	class Item {
		Object key;
		CollectionItem value;
		Item next;
		
		/**
		 * Konstruktor
		 * 
		 * NB: liefert neues Item Object
		 */
		@Programmierer(autoren="Alexander Tornoreanu")
		public Item( Object key, CollectionItem value ) {
			this.key = key;
			this.value = value;
			this.next  = null;
		}
	}
	
	/**
	 * Die Innere Klasse LinkedList stellt eine einfach verketette Liste von Item Objekten dar
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	class LinkedList {
		Item root;
		
		/**
		 * Konstruktor
		 * 
		 * NB: liefert neues LinkedList Objekt
		 */
		@Programmierer(autoren="Alexander Tornoreanu")
		public LinkedList() {
			this.root = null;
		}
		
		/**
		 * Fuegt neues Item in die Liste ein, mit einem beliebigen Key
		 * 
		 * VB: key != null, element != null
		 * NB: true falls erfolgreich, false wenn nicht erfolgreich
		 */
		@Programmierer(autoren="Alexander Tornoreanu")
		public boolean add( Object key, CollectionItem element ) {
			Item current = this.root;
			
			// noch keine Element in der Liste, initialisiere root Element
			if ( this.root == null ) {
				this.root = new Item( key, element );
			}
			// mehrere Elemente in der Liste vorhanden
			else {
				while ( current.next != null ) {
					// wenn identisches Objekt bereits in Liste vorhanden ist, nichts einfuegen
					if ( current.value == element ) {
						return false;
					}
					current = current.next;
				}
				// nochmal ueberpruefen ob ein identisches Objekt bereits in Liste vorhanden ist, dann nichts einfuegen
				if ( current.value == element ) {
					return false;
				}
				
				// Zeiger auf naechstes Element setzen
				current.next = new Item( key, element );
			}
			
			return true;
		}
	}
	
	/**
	 * Konstruktor
	 * 
	 * NB: liefert neues HashSet Objekt zurueck
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public HashSet() {
		this.list = new LinkedList();
	}
	
	/**
	 * Fuegt neues Element ein mit beliebigem Objekt als Key
	 * 
	 * VB: key != null, element != null
	 * NB: liefert true bei Erfolg, false bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean insert( Object key, CollectionItem element ) {
		return this.list.add( key, element );
	}
	
	/**
	 * Loescht Objekt aus dem Set mithilfe eines Keys
	 * 
	 * VB: key != null
	 * NB: liefert true bei Erfolg, false bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean removeValue( Object key ) {
		Item help = list.root;
		Item before = help;
		
		if (key == null)
			return false;
		
		while (help != null) {
			if (help.key.toString().equals(key.toString())) {
				// remove root objekt
				if (help == before) {
					this.list.root = help.next;
					help = null;
				}
				else {
					// remove object
					before.next = help.next;
				}
				return true;
			}
			
			if (help != null) {
				before = help;
				help = help.next;
			}
		}
		
		return false;
	}
	
	/**
	 * Sucht ein Item anhand des Keys und liefert es zurueck
	 * 
	 * VB: key != null
	 * NB: liefert CollectionItem bei Erfolg, leifert null bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public CollectionItem getValue( Object key ) {
		Item help = list.root;
		
		while (help != null) {
			if (help.key.toString().equals(key.toString())) {
				return help.value;
			}
			help = help.next;
		}
		
		return null;	
	}
	
	/**
	 * Schaut nach ob dieser Key schon vorhanden ist
	 * 
	 * VB: key != null
	 * NB: liefert true bei Erfolg, false bei nicht Erfolg
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public boolean hasKey(Object key) {
		Item help = list.root;
		
		if (key == null)
			return false;
		
		while (help != null) {
			if (help.key.toString().equals(key.toString())) {
				return true;
			}
			help = help.next;
		}
		
		return false;
	}
	
	/**
	 * Gibt das Objekt als String aus
	 * 
	 * NB: liefert Objekt als String zurueck
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public String toString() {
		Item c = this.list.root;
		String output = "";
		
		while( c != null ) {
			output += c.value + "\n";
			c = c.next;
		}
		
		return output;
	}
	
	/**
	 * erzeugt einen Iterator fuer das Set
	 * 
	 * NB: liefert Iterator des HashSets zurueck
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	public Iterator iterator() {
		return new SetIterator( this.list );
	}
	
	/**
	 * Diese Innere Klasse soll einen Iterator simulieren
	 */
	@Programmierer(autoren="Alexander Tornoreanu")
	private class SetIterator implements Iterator {
		private Item current;
		private Item lastValue;
		private LinkedList list;
		
		/**
		 * Konstruktor
		 * 
		 * VB: list != null
		 * NB: liefert neues SetIterator Objekt zurueck
		 */
		@Programmierer(autoren="Alexander Tornoreanu")
		public SetIterator( LinkedList list ) {
			this.list    = list;
			this.current = this.list.root;
			this.lastValue = null;
		}
		
		/**
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

		/**
		 * Liefert das naechste Element aus der Liste
		 * 
		 * NB: liefert naechstes Element in der Liste
		 */
		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public CollectionItem next() {
			CollectionItem value = this.current.value;
			
			if ( this.current == null ) { 
				throw new NoSuchElementException();
			}
			this.lastValue = this.current;
			this.current = this.current.next;
			
			return value;
		}

		/**
		 * Entfernt das aktuelle Element welches durchiteriert wird
		 * 
		 * NB: Entfernt ein Element
		 */
		@Override
		@Programmierer(autoren="Alexander Tornoreanu")
		public void remove() {
			Item help = this.list.root;
			Item before = help;
			
			while (help != null) {
				if (help == this.lastValue) {
					if (help == before) {
						// Element am Listenanfang
						this.list.root = help.next;
						help = null; // aus Schleife raus
					} else {
						before.next = help.next;
						help = null; // aus Schleife raus
					}
				}
				
				if (help != null) {
					before = help;
					help = help.next;
				}
			}
		}
	}
}
