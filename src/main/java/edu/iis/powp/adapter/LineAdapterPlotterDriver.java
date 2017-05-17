package edu.iis.powp.adapter;

import edu.iis.client.plottermagic.IPlotter;
import edu.kis.powp.drawer.panel.DrawPanelController;
import edu.kis.powp.drawer.shape.ILine;


/**
 * Line adapter - IPlotter with DrawPanelController object.
 */
public class LineAdapterPlotterDriver implements IPlotter
{
	private ILine line; 
	private int startX = 0, startY = 0;
	private String name;
	
    private DrawPanelController drawController;
    
    public LineAdapterPlotterDriver(DrawPanelController drawController, ILine line, String name) {
		super();
		this.drawController = drawController;
		this.line = line;
		this.name = name;
	}
    
	@Override
    public void setPosition(int x, int y)
    {
        this.startX = x;
        this.startY = y;
    }

    @Override
    public void drawTo(int x, int y)
    {
        line.setStartCoordinates(this.startX, this.startY);
        this.setPosition(x, y);
        line.setEndCoordinates(x, y);

		drawController.drawLine(line);
    }

    @Override
    public String toString()
    {
        return "Plotter Simulator - " + name;
    }

	public ILine getLine() {
		return line;
	}

	public void setLine(ILine line) {
		this.line = line;
	}

	public int getStartX() {
		return startX;
	}

	public void setStartX(int startX) {
		this.startX = startX;
	}

	public int getStartY() {
		return startY;
	}

	public void setStartY(int startY) {
		this.startY = startY;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DrawPanelController getDrawController() {
		return drawController;
	}

	public void setDrawController(DrawPanelController drawController) {
		this.drawController = drawController;
	}
    
    
}
