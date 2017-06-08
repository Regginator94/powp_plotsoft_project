package edu.iis.powp.zoom.gui;

import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import edu.iis.powp.appext.FeaturesManager;
import edu.iis.powp.window.WindowComponent;
import edu.iis.powp.zoom.ZoomManager;

/**
 * Window with buttons being used for zooming.
 * 
 */

public class ZoomManagerWindow extends JFrame implements WindowComponent{

	private JTextArea observerListField;
	private ZoomManager zoomManager;

	private static final long serialVersionUID = 9204679248304669948L;

	public ZoomManagerWindow(ZoomManager zoomManager) {
		this.setTitle("Zoom Manager");
		this.setSize(400, 400);
		Container content = this.getContentPane();
		content.setLayout(new GridBagLayout());
		this.zoomManager = zoomManager;
		ZoomListener zoomListener = new ZoomListener();
		GridBagConstraints c = new GridBagConstraints();
		FeaturesManager.getZoomManager().getChangePublisher().addSubscriber(zoomListener);
		observerListField = new JTextArea("");
		observerListField.setEditable(false);

		JButton btnZoom1 = new JButton("Original size");
		btnZoom1.addActionListener((ActionEvent e) -> {this.zoomManager.setCurrentZoom(1); zoomListener.performZooming();});
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnZoom1, c);
		
		JButton btnZoom2 = new JButton("Zoom In 2x");
		btnZoom2.addActionListener((ActionEvent e) -> {this.zoomManager.setCurrentZoom(2); zoomListener.performZooming();});
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnZoom2, c);

		JButton btnZoom3 = new JButton("Zoom In 3x");
		btnZoom3.addActionListener((ActionEvent e) -> {this.zoomManager.setCurrentZoom(3); zoomListener.performZooming();});
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnZoom3, c);
		
		JButton btnZoom02 = new JButton("Zoom Out 2x");
		btnZoom02.addActionListener((ActionEvent e) -> {this.zoomManager.setCurrentZoom(-2); zoomListener.performZooming();});
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnZoom02, c);
		
		JButton btnZoom03 = new JButton("Zoom Out 3x");
		btnZoom03.addActionListener((ActionEvent e) -> {this.zoomManager.setCurrentZoom(-3); zoomListener.performZooming();});
		c.fill = GridBagConstraints.BOTH;
		c.weightx = 1;
		c.gridx = 0;
		c.weighty = 1;
		content.add(btnZoom03, c);
	}

	@Override
	public void HideIfVisibleAndShowIfHidden() {
		if (this.isVisible()) {
			this.setVisible(false);
		} else {
			this.setVisible(true);
		}
	}

}
