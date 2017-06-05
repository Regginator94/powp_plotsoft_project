package edu.iis.powp.zoom.data;

public class DrawObjectData {
	
		   private static DrawObjectData instance = null;
		   protected DrawObjectData() {
		      // Exists only to defeat instantiation.
		   }
		   public static DrawObjectData getInstance() {
		      if(instance == null) {
		         instance = new DrawObjectData();
		      }
		      return instance;
		   }		

}
