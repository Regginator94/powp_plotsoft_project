package edu.iis.powp.zoom.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.observer.Subscriber;
import edu.iis.powp.zoom.prototype.ZoomInPrototypeX2;
import edu.iis.powp.zoom.prototype.ZoomInPrototypeX3;
import edu.iis.powp.zoom.prototype.ZoomOutPrototypeX2;
import edu.iis.powp.zoom.prototype.ZoomOutPrototypeX3;
import edu.iis.powp.zoom.prototype.ZoomPrototype;
import edu.iis.powp.zoom.prototype.ZoomPrototypeModule;

/**
 * Class responsible for performing zoom operations.
 * 
 */
public class ZoomListener implements ActionListener, Subscriber {
	
	private int zoom; 
	private ZoomPrototype prototype;

    List<ZoomPrototype> prototypes = new ArrayList<>();
    IPlotterCommand command;

	@Override
	public void actionPerformed(ActionEvent e) {
		performZooming();
	}
	
	public void performZooming(){
		initializePrototypes();
		
		if (FeaturesManager.getPlotterCommandManager().getCurrentCommand() == null) {
			return;
		}
		
		switch(zoom) {
			case 1:
				Map <String, List<IPlotterCommand>> map = FeaturesManager.history().getCommandOriginalState();
				FeaturesManager.drawerController().clearPanel();
				for (String key : map.keySet()) {
					PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
				    manager.setCurrentCommand((List<IPlotterCommand>)map.get(key), key);
				    IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
					command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
					FeaturesManager.history().updateCommandCurrentState(key, (List<IPlotterCommand>)map.get(key));
				}
				FeaturesManager.history().setAbsoluteZoomValue(1);
				break;
			default:
				prototype = ZoomPrototypeModule.createPrototype("ZoomX" + String.valueOf(zoom));
				prototypes.add(prototype);
				FeaturesManager.drawerController().clearPanel();
				prototype.execute();
				double currentAbsoluteZoomValue = zoom > 0 ? FeaturesManager.history().getAbsoluteZoomValue() * (double)zoom : FeaturesManager.history().getAbsoluteZoomValue() / (double)Math.abs(zoom);
				FeaturesManager.history().setAbsoluteZoomValue(currentAbsoluteZoomValue);
				break;			
		}
	}
	
	/**
	 * Add prototypes to their module.
	 * 
	 */
	 public static void initializePrototypes() {
        ZoomPrototypeModule.addPrototype(new ZoomInPrototypeX2());
        ZoomPrototypeModule.addPrototype(new ZoomInPrototypeX3());
        ZoomPrototypeModule.addPrototype(new ZoomOutPrototypeX2());
        ZoomPrototypeModule.addPrototype(new ZoomOutPrototypeX3());
    }
	
	 /**
	 * Check last used zoom.
	 * 
	 */	 
	@Override
	public void update() {
		this.zoom = FeaturesManager.getZoomManager().getCurrentZoom();
	}
}