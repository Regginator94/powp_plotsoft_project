package edu.iis.powp.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.command.IPlotterCommand;
import edu.iis.powp.history.PlotterStateHistory;

public class SelectRunCurrentCommandOptionListener implements ActionListener {
	
	private PlotterStateHistory history;

	public SelectRunCurrentCommandOptionListener(PlotterStateHistory history) {
		this.history = history;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IPlotterCommand command = FeaturesManager.getPlotterCommandManager().getCurrentCommand();
		if (history.getAbsoluteZoomValue()==1) {
			command.execute(FeaturesManager.getDriverManager().getCurrentPlotter());
		}
	}
}