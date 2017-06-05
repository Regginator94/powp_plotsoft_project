package edu.iis.powp.zoom.prototype;


import java.util.ArrayList;
import java.util.List;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class ZoomInPrototypeX2 implements ZoomPrototype {
	private String name = "ZoomInX2";
	@Override
	public ZoomPrototype clone() {
		return new ZoomInPrototypeX2();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		
/*		List<IPlotterCommand> commands = FeaturesManager.getPlotterCommandManager().getPlotterCommands();
		for(IPlotterCommand command: commands) {
			if(command instanceof SetPositionCommand) {
				command = new SetPositionCommand(((SetPositionCommand) command).getPosX()*2, ((SetPositionCommand) command).getPosY()*2);
			} else if(command instanceof DrawToCommand) {
				command = new DrawToCommand(((DrawToCommand) command).getPosX()*2, ((DrawToCommand) command).getPosY()*2);
			}
		}
		PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
	    manager.setCurrentCommand(commands, "TopSecretCommand");
		
		IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
		command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());*/
		//PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		
		
		   List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		   List<IPlotterCommand> commandsRef = FeaturesManager.getPlotterCommandManager().getPlotterCommands(); 
		   for(int i = 0; i < commandsRef.size(); i++) {
				if(commandsRef.get(i) instanceof SetPositionCommand) {
					commands.add(new SetPositionCommand(((SetPositionCommand) commandsRef.get(i)).getPosX()*2, ((SetPositionCommand) commandsRef.get(i)).getPosY()*2));
				} else if(commandsRef.get(i) instanceof DrawToCommand) {
					commands.add(new DrawToCommand(((DrawToCommand) commandsRef.get(i)).getPosX()*2, ((DrawToCommand) commandsRef.get(i)).getPosY()*2));
				}
		   }
		   
		   
		    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		    manager.setCurrentCommand(commands, "TopSecretCommand");
		    IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());

	}

}
