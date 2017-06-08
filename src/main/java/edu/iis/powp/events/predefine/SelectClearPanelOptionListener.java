package edu.iis.powp.events.predefine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.iis.powp.appext.FeaturesManager;


public class SelectClearPanelOptionListener implements ActionListener
{
	@Override
    public void actionPerformed(ActionEvent e)
    {
        FeaturesManager.drawerController().clearPanel();
        FeaturesManager.history().clear();
    }
}
