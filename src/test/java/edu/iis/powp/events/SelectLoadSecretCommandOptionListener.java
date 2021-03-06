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

public class SelectLoadSecretCommandOptionListener implements ActionListener {


	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (!FeaturesManager.history().getCommandOriginalState().containsKey("TopSecretCommand")) {
		    List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		    double zoom = FeaturesManager.history().getAbsoluteZoomValue();
		    
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
		    FeaturesManager.history().addCommandOriginalState("TopSecretCommand", commands);
		    commands.clear();
		    
		    // size after zooming
			commands.add(new SetPositionCommand((int)zoom*-20, (int)zoom*-50));
			commands.add(new DrawToCommand((int)zoom*-20, (int)zoom*-50));
			commands.add(new SetPositionCommand((int)zoom*-20, (int)zoom*-40));
			commands.add(new DrawToCommand((int)zoom*-20, (int)zoom*50));
			commands.add(new SetPositionCommand((int)zoom*0, (int)zoom*-50));
			commands.add(new DrawToCommand((int)zoom*0, (int)zoom*-50));
			commands.add(new SetPositionCommand((int)zoom*0, (int)zoom*-40));
			commands.add(new DrawToCommand((int)zoom*0, (int)zoom*50));
			commands.add(new SetPositionCommand((int)zoom*70, (int)zoom*-50));
			commands.add(new DrawToCommand((int)zoom*20, (int)zoom*-50));
			commands.add(new DrawToCommand((int)zoom*20, (int)zoom*0));
			commands.add(new DrawToCommand((int)zoom*70, (int)zoom*0));
			commands.add(new DrawToCommand((int)zoom*70, (int)zoom*50));
			commands.add(new DrawToCommand((int)zoom*20, (int)zoom*50));
			
		    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
		    manager.setCurrentCommand(commands, "TopSecretCommand");
		    FeaturesManager.history().updateCommandCurrentState("TopSecretCommand", commands);
		}
	}
}