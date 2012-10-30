package notification;

import java.io.Serializable;
import java.util.Vector;

/*
 * Diese Klasse ist auf dem Prizip von Publisher/Abonnent aufgebaut und ist f�r die Verwaltung
 * der Abonnenten von Benachrichtigungen verantwortlich.
 */
public class Notification implements Subject, Serializable {
	private static final long serialVersionUID = 1L;
	private Vector<Observer> observers;
	
	/*
	 * Konstruktor f�r eine Notification
	 */
	public Notification() {
		this.observers = new Vector<Observer>();
	}
	
	/*
	 * F�gt einen neuen Subscriber/Abbonnent zu der Benachrichtigung hinzu um sp�ter
	 * auch bei neuen Mitteilungen benachrichtigt zu werden.
	 */
	@Override
	public void register(Observer o) {
		this.observers.add( o );
	}

	/*
	 * L�scht einen Abbonent aus der Liste der zu Benachrichtigenden Mitglieder.
	 */
	@Override
	public void unregister(Observer o) {
		this.observers.remove( o );
	}

	/*
	 * Sendet eine Benachrichtigung an alle Abonennten.
	 */
	@Override
	public void announce( Announcement announcement ) {
		for ( Observer o : this.observers ) {
			o.update( announcement );
		}
	}
	
}
