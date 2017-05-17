package edu.iis.powp.zoom;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.adapter.LineAdapterPlotterDriver;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;

public class DrawToZoomCommand implements IPlotter {
	LineAdapterPlotterDriver lineAdapterPlotterDriver = null;
	
	public DrawToZoomCommand(DrawPanelController drawController, ILine line, String name) {
		lineAdapterPlotterDriver = new LineAdapterPlotterDriver(drawController, line, name);	
	}

    @Override
    public void drawTo(int x, int y)
    {
    	lineAdapterPlotterDriver.getLine().setStartCoordinates(x, y);
        this.setPosition(x, y);
        lineAdapterPlotterDriver.getLine().setEndCoordinates(x, y);

		lineAdapterPlotterDriver.getDrawController().drawLine(lineAdapterPlotterDriver.getLine());
    }

	@Override
    public void setPosition(int x, int y)
    {
		lineAdapterPlotterDriver.setStartX(2*x);
        lineAdapterPlotterDriver.setStartY(2*y);
    }
	
	@Override
    public String toString()
    {
        return "Plotter Simulator - " + lineAdapterPlotterDriver.getName();
    }
}

