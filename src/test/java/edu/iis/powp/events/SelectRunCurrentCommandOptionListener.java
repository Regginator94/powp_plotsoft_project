package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;
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
	ZoomPrototype prototype;
	@Override
	public void actionPerformed(ActionEvent e) {
		initializePrototypes();
        List<ZoomPrototype> prototypes = new ArrayList<>();
		switch(zoom) {
		case 1:
			createCancer();
			IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			break;
		default:
			prototype = ZoomPrototypeModule.createPrototype("ZoomX" + String.valueOf(zoom));
			prototypes.add(prototype);
			prototype.execute();
			break;	
		}
		
		
	}
	
	public void createCancer() {
		List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		commands.add(new SetPositionCommand(-20, -50));
		commands.add(new DrawToCommand(-20, -50));
		commands.add(new SetPositionCommand(-20, -40));
		commands.add(new DrawToCommand(-20, 50));
		commands.add(new SetPositionCommand(0, -50));
		commands.add(new DrawToCommand(0, -50));
		commands.add(new SetPositionCommand(0, -40));
		commands.add(new DrawToCommand(0, 50));
		commands.add(new SetPositionCommand(70, -50));
		commands.add(new DrawToCommand(20, -50));
		commands.add(new DrawToCommand(20, 0));
		commands.add(new DrawToCommand(70, 0));
		commands.add(new DrawToCommand(70, 50));
		commands.add(new DrawToCommand(20, 50));
		
	    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
	    manager.setCurrentCommand(commands, "TopSecretCommand");
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