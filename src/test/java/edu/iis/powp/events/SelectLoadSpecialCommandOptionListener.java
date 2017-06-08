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

public class SelectLoadSpecialCommandOptionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!FeaturesManager.history().getCommandOriginalState().containsKey("TopSpecialCommand")) {
		    List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>();
		    double zoom = FeaturesManager.history().getAbsoluteZoomValue();
		    commands.add(new SetPositionCommand((int)zoom*0, (int)zoom*0));
			commands.add(new DrawToCommand((int)zoom*0, (int)zoom*0));
			commands.add(new DrawToCommand((int)zoom*20, (int)zoom*0));
			commands.add(new DrawToCommand((int)zoom*20, (int)zoom*20));
			commands.add(new DrawToCommand((int)zoom*20, (int)zoom*40));
			commands.add(new DrawToCommand((int)zoom*40, (int)zoom*40));
			commands.add(new DrawToCommand((int)zoom*0, (int)zoom*0));
			
		    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		    manager.setCurrentCommand(commands, "TopSpecialCommand");
		    FeaturesManager.history().addCommandOriginalState("TopSpecialCommand", commands);
		    FeaturesManager.history().updateCommandCurrentState("TopSpecialCommand", commands);
		}
	}
}