package edu.iis.powp.history;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.iis.powp.command.IPlotterCommand;

/**
 * Class responsible for keeping the history of using the plotter (currently run commands and zoom values).
 * 
 */
public class PlotterStateHistory {
	
	private double absoluteZoomValue;
	private Map<String, List<IPlotterCommand>> commandOriginalStates;
	private Map<String, List<IPlotterCommand>> commandCurrentStates;
	
	public PlotterStateHistory() {
		absoluteZoomValue = 1;
		commandOriginalStates = new HashMap<String, List<IPlotterCommand>>();
		commandCurrentStates = new HashMap<String, List<IPlotterCommand>>();
	}
	
	
	/**
	 * Clear the history when drawing panel is also clear.
	 * 
	 */
	public void clear() {
		absoluteZoomValue = 1;
		commandOriginalStates.clear();
		commandCurrentStates.clear();
	}
	
	/**
	 * Add original size (list of commands) of the figure.
	 * 
	 */
	public void addCommandOriginalState(String name, List<IPlotterCommand> commands) {
		commandOriginalStates.put(name, commands);
	}

	
	/**
	 * Get zoom value since start of the program.
	 * 
	 */
	public double getAbsoluteZoomValue() {
		return absoluteZoomValue;
	}

	public void setAbsoluteZoomValue(double absoluteZoomValue) {
		this.absoluteZoomValue = absoluteZoomValue;
	}

	/**
	 * Get current size (list of commands) of the figure.
	 * 
	 */
	public Map<String, List<IPlotterCommand>> getCommandOriginalState() {
		return commandOriginalStates;
	}

	public void setCommandOriginalState(Map<String, List<IPlotterCommand>> commandOriginalState) {
		this.commandOriginalStates = commandOriginalState;
	}

	public Map<String, List<IPlotterCommand>> getCommandCurrentStates() {
		return commandCurrentStates;
	}
	
	public void setCommandCurrentStates(Map<String, List<IPlotterCommand>> commandCurrentStates) {
		this.commandCurrentStates = commandCurrentStates;
	}

	/**
	 * Update current size (list of commands) of the figure.
	 * 
	 */
	public void updateCommandCurrentState(String name, List<IPlotterCommand> commands) {
		commandCurrentStates.put(name, commands);
	}
	
}
