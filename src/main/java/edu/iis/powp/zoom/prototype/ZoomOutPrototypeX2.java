package edu.iis.powp.zoom.prototype;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class ZoomOutPrototypeX2 implements ZoomPrototype {

	private String name = "ZoomX-2";
	
	@Override
	public ZoomPrototype clone() {
		return new ZoomOutPrototypeX2();
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public void execute() {
		Map <String, List<IPlotterCommand>> map = FeaturesManager.history().getCommandCurrentStates();
		for (String key : map.keySet()) {
			List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		   	List<IPlotterCommand> commandsRef = (List<IPlotterCommand>)map.get(key); 
		   	for(int i = 0; i < commandsRef.size(); i++) {
				if(commandsRef.get(i) instanceof SetPositionCommand) {
					commands.add(new SetPositionCommand(((SetPositionCommand) commandsRef.get(i)).getPosX()/2, ((SetPositionCommand) commandsRef.get(i)).getPosY()/2));
				} else if(commandsRef.get(i) instanceof DrawToCommand) {
					commands.add(new DrawToCommand(((DrawToCommand) commandsRef.get(i)).getPosX()/2, ((DrawToCommand) commandsRef.get(i)).getPosY()/2));
				}
		   	}
		   
		    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		    manager.setCurrentCommand(commands, key);
		    IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
			FeaturesManager.history().updateCommandCurrentState(command.toString(), commands);
		}

	}

}
