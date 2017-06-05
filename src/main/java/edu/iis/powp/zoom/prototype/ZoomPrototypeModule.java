package edu.iis.powp.zoom.prototype;

import java.util.ArrayList;
import java.util.List;

public class ZoomPrototypeModule {
	// 2. "registry" of prototypical objs
    private static List<ZoomPrototype> prototypes = new ArrayList<>();

    // Adds a feature to the Prototype attribute of the PrototypesModule class
    // obj  The feature to be added to the Prototype attribute
    public static void addPrototype(ZoomPrototype p) {
        prototypes.add(p);
    }

    public static ZoomPrototype createPrototype(String name) {
        // 4. The "virtual ctor"
        for (ZoomPrototype p : prototypes) {
            if (p.getName().equals(name)) {
                return p.clone();
            }
        }
        System.out.println(name + ": doesn't exist");
        return null;
    }
}
