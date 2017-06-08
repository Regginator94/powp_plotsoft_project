package edu.iis.powp.zoom;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.app.Application;
import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;
import edu.iis.powp.zoom.gui.ZoomListener;

public class TestPlotterStateHistory {

	public static void specialCommand() {
		List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>();
	    
	    // original size
	    commands.add(new SetPositionCommand(0, 0));
		commands.add(new DrawToCommand(0, 0));
		commands.add(new DrawToCommand(20, 0));
		commands.add(new DrawToCommand(20, 20));
		commands.add(new DrawToCommand(20, 40));
		commands.add(new DrawToCommand(40, 40));
		commands.add(new DrawToCommand(0, 0));
		
		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
	    manager.setCurrentCommand(commands, "TopSpecialCommand");

	    FeaturesManager.history().addCommandOriginalState("TopSpecialCommand", commands);
	    FeaturesManager.history().updateCommandCurrentState("TopSpecialCommand", commands);
		
	    IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
		command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
	}
	
	public static void main(String[] args) {

		Application app = new Application();
		FeaturesManager.expandApplication(app);
		FeaturesManager.setupPlotterStateHistory();
		FeaturesManager.setupZoomManager();
		FeaturesManager.setupCommandManager();
		
		specialCommand();
		ZoomListener zoomListener = new ZoomListener();
		
		FeaturesManager.getZoomManager().setCurrentZoom(2);
		zoomListener.update();
		zoomListener.performZooming();
		
		FeaturesManager.getZoomManager().setCurrentZoom(3);
		zoomListener.update();
		zoomListener.performZooming();
		
		System.out.println("Zoom bezwzględny po ZoomIn 2x i ZoomIn 3x: " 
				+ FeaturesManager.history().getAbsoluteZoomValue());
		
	}
}
