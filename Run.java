import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import gpdraw.DrawingTool;
import gpdraw.SketchPad;
public class Run{
  private boolean isRunning;
  public static void main(String[] args) throws InterruptedException {
	    SketchPad map = new SketchPad(1000,1000);
	    DrawingTool pen = new DrawingTool(map);
	    GUI g = new GUI(map, pen);
	    ArrayList<Item> a = new ArrayList<Item>();
	    a.add(new Item("food", 50, 0));
	    a.add(new Item("water", 50, 0));
	    a.add(new Item("stuff", 30, 0));
	    Storage b = new Storage(a, 0, 0, 10, 15, 100);
	    Storage d = new Storage(a, 360, 360, 10, 45, 75);
	    Storage c = new Storage(a, 150, 150, 40, 45, 50);
	    g.drawStorage(b);
	    g.drawStorage(c);
	    g.drawStorage(d);
	    isRunning = true;
	    while(isRunning){

	    	TimeUnit.SECONDS.sleep(1);
	    }
  }
}
