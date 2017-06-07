package edu.iis.powp.zoom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.history.PlotterStateHistory;
import edu.iis.powp.observer.Subscriber;
import edu.iis.powp.zoom.prototype.ZoomInPrototypeX2;
import edu.iis.powp.zoom.prototype.ZoomInPrototypeX3;
import edu.iis.powp.zoom.prototype.ZoomOutPrototypeX2;
import edu.iis.powp.zoom.prototype.ZoomOutPrototypeX3;
import edu.iis.powp.zoom.prototype.ZoomPrototype;
import edu.iis.powp.zoom.prototype.ZoomPrototypeModule;

public class ZoomListener implements ActionListener, Subscriber {
	
	private int zoom; 
	private ZoomPrototype prototype;

    List<ZoomPrototype> prototypes = new ArrayList<>();
    IPlotterCommand command;
	private PlotterStateHistory history;
    
	public ZoomListener(PlotterStateHistory history) {
		this.history = history;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		performZooming();
	}
	
	public void performZooming(){
		initializePrototypes();
		System.out.println("ZOOM"+zoom);
		
		if (FeaturesManager.getPlotterCommandManager().getCurrentCommand() == null) {
			return;
		}
		
		switch(zoom) {
			case 1:
				FeaturesManager.drawerController().clearPanel();
				IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
				PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
			    manager.setCurrentCommand(history.getCommandOriginalState().get(command.toString()), command.toString());
				command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
				break;
			default:
				prototype = ZoomPrototypeModule.createPrototype("ZoomX" + String.valueOf(zoom));
				prototypes.add(prototype);
				FeaturesManager.drawerController().clearPanel();
				prototype.execute();
				break;			
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