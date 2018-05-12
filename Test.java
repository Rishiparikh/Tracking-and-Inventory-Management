import java.util.ArrayList;
import java.util.Scanner;
/**
 * Test class
 * Creates our JFrame and runs the GUI shipping program
 */
public class Test {
	public static void main(String args[]) throws InterruptedException {

		ArrayList<Item> a = new ArrayList<Item>();
		a.add(new Item("food", 50, 0));
		a.add(new Item("water", 30, 0));
		a.add(new Item("stuff", 40, 0));
		ArrayList<Item> a2 = new ArrayList<Item>();
		a2.add(new Item("food", 50, 0));
		a2.add(new Item("water", 30, 0));
		a2.add(new Item("stuff", 40, 0));
		ArrayList<Item> a3 = new ArrayList<Item>();
		a3.add(new Item("food", 50, 0));
		a3.add(new Item("water", 30, 0));
		a3.add(new Item("stuff", 40, 0));
		ArrayList<Item> a1 = new ArrayList<Item>();
		a1.add(new Item("food", 50, 0));
		a1.add(new Item("water", 40, 0));
		a1.add(new Item("stuff", 40, 0));
		Storage b = new Storage(a2, 500, 500, 25, 40, 100);
		Storage d = new Storage(a, 450, 200, 10, 45, 75);
		Storage c = new Storage(a3, 350, 350, 40, 45, 50);
		ArrayList<Storage> ware = new ArrayList<Storage>();
		ware.add(b);
		ware.add(c);
		ware.add(d);
		WareHouse test = new WareHouse(ware, a1, 150, 150, 40, 140, 150);
		MapGUI gui1 = new MapGUI(test);
		gui1.create(test);
		gui1.update(test);
		
		
		while(test.hasUpdate()) {
			for(int i = 0; i < test.hubs.size(); i++) {
				int itmNum = test.hubs.get(i).checkRedAlert();
				while(itmNum != -1) {
					System.out.println(itmNum);
					gui1.transport(test,test.hubs.get(i).myInv.get(itmNum), 10, test.hubs.get(i));
					itmNum = test.hubs.get(i).checkRedAlert();
					gui1.update(test);
					if(itmNum == -1) {
						break;
					}
				}
			}
			for(int i = 0; i < test.hubs.size(); i++) {
				int itmNum = test.hubs.get(i).checkYellowAlert();
				while(itmNum != -1) {
					System.out.println("fewo" + itmNum);
					gui1.transport(test,test.hubs.get(i).myInv.get(itmNum), 20, test.hubs.get(i));
					itmNum = test.hubs.get(i).checkYellowAlert();
					gui1.update(test);


					if(itmNum == -1) {
						break;
					}
				}
			}
			
		}
		gui1.update(test);
		System.out.println(test.hubs.get(1).checkRedAlert());

	}
}
