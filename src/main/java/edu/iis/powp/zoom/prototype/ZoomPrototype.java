package edu.iis.powp.zoom.prototype;

/**
 * Interface used by all prototypes.
 * 
 */
public interface ZoomPrototype {
	ZoomPrototype clone();
    String getName();
    void execute();
}
