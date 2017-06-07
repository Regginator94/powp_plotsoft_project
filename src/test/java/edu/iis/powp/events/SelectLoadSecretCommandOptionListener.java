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
import edu.iis.powp.history.PlotterStateHistory;

public class SelectLoadSecretCommandOptionListener implements ActionListener {

	private PlotterStateHistory history;
	
	public SelectLoadSecretCommandOptionListener(PlotterStateHistory history) {
		this.history = history;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!FeaturesManager.getPlotterCommandManager().getCurrentCommandString().equals("TopSecretCommand")) {
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
		    history.addCommandOriginalState("TopSecretCommand", commands);
		}
	}
}