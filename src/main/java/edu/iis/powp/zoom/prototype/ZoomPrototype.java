package edu.iis.powp.zoom.prototype;

public interface ZoomPrototype {
	ZoomPrototype clone();
    String getName();
    void execute();
}
