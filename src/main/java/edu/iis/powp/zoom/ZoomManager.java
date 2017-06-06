package edu.iis.powp.zoom;

import edu.iis.powp.observer.Publisher;

public class ZoomManager {
	private int zoom = 0;
	private Publisher changePublisher = new Publisher(); 
	public Publisher getChangePublisher() {
		return changePublisher;
	}

	public int getCurrentZoom() {
		return zoom;
	}

	public void setCurrentZoom(int zoom) {
		this.zoom = zoom;
		changePublisher.notifyObservers();
	}
}
