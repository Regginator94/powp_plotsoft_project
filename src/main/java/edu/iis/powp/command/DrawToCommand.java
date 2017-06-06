package edu.iis.powp.command;

import edu.iis.client.plottermagic.IPlotter;

/**
 * Implementation of IPlotterCommand for drawTo command functionality.
 */
public class DrawToCommand implements IPlotterCommand {

	private int posX, posY;
	
	public DrawToCommand(int posX, int posY) {
		super();
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	@Override
	public void execute(IPlotter plotter) {
		plotter.drawTo(posX, posY);
	}

}
