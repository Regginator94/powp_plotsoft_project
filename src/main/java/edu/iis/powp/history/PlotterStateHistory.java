package edu.iis.powp.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iis.powp.command.IPlotterCommand;

public class PlotterStateHistory {
	
	private double absoluteZoomValue;
	private Map<String, List<IPlotterCommand>> commandOriginalStates;
	
	public PlotterStateHistory() {
		absoluteZoomValue = 1;
		commandOriginalStates = new HashMap<String, List<IPlotterCommand>>();
	}
	
	public void clear() {
		absoluteZoomValue = 1;
		commandOriginalStates.clear();
	}
	
	public void addCommandOriginalState(String name, List<IPlotterCommand> commands) {
		commandOriginalStates.put(name, commands);
	}

	public double getAbsoluteZoomValue() {
		return absoluteZoomValue;
	}

	public void setAbsoluteZoomValue(double absoluteZoomValue) {
		this.absoluteZoomValue = absoluteZoomValue;
	}

	public Map<String, List<IPlotterCommand>> getCommandOriginalState() {
		return commandOriginalStates;
	}

	public void setCommandOriginalState(Map<String, List<IPlotterCommand>> commandOriginalState) {
		this.commandOriginalStates = commandOriginalState;
	}
	
}
