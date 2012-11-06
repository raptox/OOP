package notification;

/*
 * Das Interface Subject stellt die Methoden zur Verfuegung um Benachtichtigungen an Abonnenten zu versenden.
 */
public abstract class Subject {
	/*
	 * Fuegt einen neuen Subscriber/Abonnent hinzu.
	 */
	public void register( Observer o ) {
	}
	
	/*
	 * Loescht einen bestehenden Subscriber/Abonnent.
	 */
	public void unregister( Observer o ) {
	}
	
	/*
	 * Benachrichtigt alle Subscriber/Abonnenten.
	 */
	public void announce( Announcement announcement ) {
	}
}
