package edu.iis.powp.zoom;

import edu.iis.client.plottermagic.IPlotter;
import edu.iis.powp.command.SetPositionCommand;

public class SetZoomPositionCommand {
	SetPositionCommand setPositionCommand = null;
	
	public SetZoomPositionCommand(int posX, int posY) {
		setPositionCommand = new SetPositionCommand(posX, posY);
	}

	public void execute(IPlotter plotter) {
		setPositionCommand.execute(plotter);
	}

}
