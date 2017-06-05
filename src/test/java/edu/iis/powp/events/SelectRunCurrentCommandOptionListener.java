package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.observer.Subscriber;
import edu.iis.powp.zoom.ZoomManager;
import edu.iis.powp.zoom.prototype.ZoomInPrototypeX2;
import edu.iis.powp.zoom.prototype.ZoomInPrototypeX3;
import edu.iis.powp.zoom.prototype.ZoomOutPrototypeX2;
import edu.iis.powp.zoom.prototype.ZoomOutPrototypeX3;
import edu.iis.powp.zoom.prototype.ZoomPrototype;
import edu.iis.powp.zoom.prototype.ZoomPrototypeModule;

public class SelectRunCurrentCommandOptionListener implements ActionListener, Subscriber {
	int zoom = 1; 
	@Override
	public void actionPerformed(ActionEvent e) {
		initializePrototypes();
        List<ZoomPrototype> prototypes = new ArrayList<>();
		switch(zoom) {
		case 1:
			IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			break;
		case 2:
			ZoomPrototype prototype = ZoomPrototypeModule.createPrototype("ZoomInX" + String.valueOf(zoom));
			prototypes.add(prototype);
			prototype.execute();
		case -2:
			
		}
		
		
	}
	
	 public static void initializePrototypes() {
	        ZoomPrototypeModule.addPrototype(new ZoomInPrototypeX2());
	        ZoomPrototypeModule.addPrototype(new ZoomInPrototypeX3());
	        ZoomPrototypeModule.addPrototype(new ZoomOutPrototypeX2());
	        ZoomPrototypeModule.addPrototype(new ZoomOutPrototypeX3());
	    }
	

	@Override
	public void update() {
		this.zoom = FeaturesManager.getZoomManager().getCurrentZoom();

		
	}
}