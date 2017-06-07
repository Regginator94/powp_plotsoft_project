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
		if (!FeaturesManager.getPlotterCommandManager().getCurrentCommandString().equals("TopSpecialCommand")) {
		    List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>();
		    commands.add(new SetPositionCommand(0, 0));
			commands.add(new DrawToCommand(0, 0));
			commands.add(new DrawToCommand(20, 0));
			commands.add(new DrawToCommand(20, 20));
			commands.add(new DrawToCommand(20, 40));
			commands.add(new DrawToCommand(40, 40));
			commands.add(new DrawToCommand(0, 0));
			
		    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		    manager.setCurrentCommand(commands, "TopSpecialCommand");
		}
	}
}