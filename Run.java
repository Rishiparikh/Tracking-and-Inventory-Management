import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import gpdraw.DrawingTool;
import gpdraw.SketchPad;

public class Run {
	static SketchPad map = new SketchPad(1000, 1000);
	static DrawingTool pen = new DrawingTool(map);
	static GUI g = new GUI(map, pen);
	public static WareHouse test;
	private static boolean isRunning;

	public static void main(String[] args) throws InterruptedException {

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
		test = new WareHouse(ware, a1, 0, 0, 40, 140, 150);
		isRunning = true;
		while (isRunning) {
			if (test.hasUpdate()) {

			}
			updateMap();
			TimeUnit.SECONDS.sleep(1);
		}
	}

	public static void updateMap() {
		g.drawStorage(test);
		for (int i = 0; i < test.hubs.size(); i++) {
			g.drawStorage(test.hubs.get(i));
		}
	}
}
