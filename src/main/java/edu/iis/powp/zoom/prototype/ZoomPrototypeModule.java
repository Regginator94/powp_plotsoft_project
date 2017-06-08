package edu.iis.powp.zoom.prototype;

import java.util.ArrayList;
import java.util.List;

/**
 * Module for prototypes.
 * 
 */
public class ZoomPrototypeModule {

	
    private static List<ZoomPrototype> prototypes = new ArrayList<>();

    /**
     * Add single prototype to the list.
     * 
     */
    public static void addPrototype(ZoomPrototype p) {
        prototypes.add(p);
    }

    /**
     * Create a prototype by a given name.
     * 
     */
    public static ZoomPrototype createPrototype(String name) {

        for (ZoomPrototype p : prototypes) {
            if (p.getName().equals(name)) {
                return p.clone();
            }
        }
        System.out.println(name + ": doesn't exist");
        return null;
    }
}
