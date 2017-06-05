package edu.iis.powp.zoom.prototype;

import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class ZoomInPrototypeX3 implements ZoomPrototype {

	private String name = "ZoomX3";
	@Override
	public ZoomPrototype clone() {
		return new ZoomInPrototypeX3();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
	   List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
	   List<IPlotterCommand> commandsRef = FeaturesManager.getPlotterCommandManager().getPlotterCommands(); 
	   for(int i = 0; i < commandsRef.size(); i++) {
			if(commandsRef.get(i) instanceof SetPositionCommand) {
				commands.add(new SetPositionCommand(((SetPositionCommand) commandsRef.get(i)).getPosX()*3, ((SetPositionCommand) commandsRef.get(i)).getPosY()*3));
			} else if(commandsRef.get(i) instanceof DrawToCommand) {
				commands.add(new DrawToCommand(((DrawToCommand) commandsRef.get(i)).getPosX()*3, ((DrawToCommand) commandsRef.get(i)).getPosY()*3));
			}
	   }
	   
	   
	    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
	    manager.setCurrentCommand(commands, "TopSecretCommand");
	    IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
		command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());

	}

}
