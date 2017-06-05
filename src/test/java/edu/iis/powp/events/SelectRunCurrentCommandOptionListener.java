package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.observer.Subscriber;
import edu.iis.powp.zoom.ZoomManager;

public class SelectRunCurrentCommandOptionListener implements ActionListener, Subscriber {
	int zoom = 1; 
	@Override
	public void actionPerformed(ActionEvent e) {
		IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
		command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
		
		
	}

	@Override
	public void update() {
		this.zoom = FeaturesManager.getZoomManager().getCurrentZoom();
		
	}
}