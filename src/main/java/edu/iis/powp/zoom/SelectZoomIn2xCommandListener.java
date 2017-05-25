package edu.iis.powp.zoom;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import edu.iis.client.plottermagic.preset.FiguresJoe;
import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.DrawToCommand;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.command.SetPositionCommand;
import edu.iis.powp.command.manager.PlotterCommandManager;

public class SelectZoomIn2xCommandListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e)
    {
        //FiguresJoe.figureScript1(FeaturesManager.getDriverManager().getCurrentPlotter());

	    List<IPlotterCommand> commands = new ArrayList<IPlotterCommand>(); 
		commands.add(new SetPositionCommand(-40, -100));
		commands.add(new DrawToCommand(-40, -100));
		commands.add(new SetPositionCommand(-40, -80));
		commands.add(new DrawToCommand(-40, 100));
		commands.add(new SetPositionCommand(0, -100));
		commands.add(new DrawToCommand(0, -100));
		commands.add(new SetPositionCommand(0, -80));
		commands.add(new DrawToCommand(0, 100));
		commands.add(new SetPositionCommand(140, -100));
		commands.add(new DrawToCommand(40, -100));
		commands.add(new DrawToCommand(40, 0));
		commands.add(new DrawToCommand(140, 0));
		commands.add(new DrawToCommand(140, 100));
		commands.add(new DrawToCommand(40, 100));
		
	    PlotterCommandManager manager = FeaturesManager.getPlotterCommandManager();
	    manager.setCurrentCommand(commands, "Zoom in 2x command");
	    FeaturesManager.drawerController().clearPanel();
	    IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
		command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
    }
}
