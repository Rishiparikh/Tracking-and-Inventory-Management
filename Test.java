import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import gpdraw.DrawingTool;
import gpdraw.SketchPad;

public class Test {
	public static void main(String args[]) throws InterruptedException {
		 SketchPad map = new SketchPad(1000,1000);
		 DrawingTool pen = new DrawingTool(map);
		 GUI g = new GUI(map, pen);
		// ArrayList<Item> a = new ArrayList<Item>();
		// a.add(new Item("food", 50, 0));
		// a.add(new Item("water", 50, 0));
		// a.add(new Item("stuff", 30, 0));
		// Storage b = new Storage(a, -180, -180, 10, 15, 100);
		// Storage d = new Storage(a, 360, 360, 10, 45, 75);
		// Storage c = new Storage(a, 150, 150, 40, 45, 50);
		// ArrayList<Storage> ware = new ArrayList<Storage>();
		// ware.add(b);
		// ware.add(c);
		// System.out.println(c.myInv.get(1).quantity);
		// ware.add(d);
		// WareHouse test = new WareHouse(ware, a, 0, 0 , 100, 140, 150);
		// g.drawStorage(test);
		// System.out.println(test.hubs.size());
		// for(int i = 0; i < test.hubs.size(); i++) {
		// g.drawStorage(test.hubs.get(i));
		// }
		// test.transportItem(test.myInv.get(0), 15, test.hubs.get(1));
		// TimeUnit.SECONDS.sleep(1);
		// g.drawStorage(c);
		// System.out.println(c.myInv.get(0).quantity);
		ArrayList<Item> a = new ArrayList<Item>();
		a.add(new Item("food", 50, 0));
		a.add(new Item("water", 30, 0));
		a.add(new Item("stuff", 40, 0));
		ArrayList<Item> a1 = new ArrayList<Item>();
		a1.add(new Item("food", 50, 0));
		a1.add(new Item("water", 40, 0));
		a1.add(new Item("stuff", 40, 0));
		Storage b = new Storage(a, -180, -180, 10, 15, 100);
		Storage d = new Storage(a, 360, 360, 10, 45, 75);
		Storage c = new Storage(a, 150, 150, 40, 45, 50);
		ArrayList<Storage> ware = new ArrayList<Storage>();
		ware.add(b);
		ware.add(c);
		ware.add(d);
		WareHouse test = new WareHouse(ware, a1, 0, 0, 40, 140, 150);
		g.drawStorage(test);
		System.out.println(test.hubs.size());
		for (int i = 0; i < test.hubs.size(); i++) {
			g.drawStorage(test.hubs.get(i));
		}
		test.transportItem(test.myInv.get(1), 20, test.hubs.get(1));
    	TimeUnit.SECONDS.sleep(1);

//		System.out.println(test.myInv.get(1).quantity);
//		System.out.println(test.hubs.get(1).myInv.get(1).quantity);
    	TimeUnit.SECONDS.sleep(1);
		g.drawStorage(test);
		System.out.println(test.redAlert + " " +  test.myInv.get(1).quantity);
		for (int i = 0; i < test.hubs.size(); i++) {
			g.drawStorage(test.hubs.get(i));
	    	TimeUnit.SECONDS.sleep(1);

		}
	}
}
 
