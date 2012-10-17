package notification;

import java.util.Vector;


public class Notification implements Subject {
	private Vector<Observer> observers;
	
	public Notification() {
		this.observers = new Vector<Observer>();
	}
	
	@Override
	public void register(Observer o) {
		this.observers.add( o );
	}

	@Override
	public void unregister(Observer o) {
		this.observers.remove( o );
	}

	@Override
	public void announce( Announcement announcement ) {
		for ( Observer o : this.observers ) {
			o.update( announcement );
		}
	}
	
}
