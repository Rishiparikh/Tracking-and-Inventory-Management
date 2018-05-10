import java.util.ArrayList;
import java.util.Scanner;

public class Run {
	private static boolean isRunning;
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
		a3.add(new Item("water", 35, 0));
		a3.add(new Item("stuff", 40, 0));
		ArrayList<Item> a1 = new ArrayList<Item>();
		a1.add(new Item("food", 1000, 0));
		a1.add(new Item("water", 1000, 0));
		a1.add(new Item("stuff", 1000, 0));
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
		isRunning = true;
		while(isRunning) {
			System.out.println("cycled");
			System.out.println(test.hasUpdate());
			
		while(test.hasUpdate()) {
			for(int i = 0; i < test.hubs.size(); i++) {
				int itmNum = test.hubs.get(i).checkRedAlert();
				while(itmNum != -1) {
					System.out.println(itmNum);
					gui1.transport(test,test.hubs.get(i).myInv.get(itmNum), 25, test.hubs.get(i));
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
		periodic(test, gui1);
		}
	}
	
	public static void periodic(WareHouse test, MapGUI gui1) {
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()) {
			int store = sc.nextInt()-1;
			String name = sc.next();
			int amt = sc.nextInt();
			Item temp = new Item(name, amt, 0);
			int recieveItemNumber = test.search(test.hubs.get(store).myInv, temp);
			test.hubs.get(store).myInv.get(recieveItemNumber).setNumItems(test.hubs.get(store).myInv.get(recieveItemNumber).getNumItems() + amt);
			gui1.update(test);
		}
		System.out.println("it has ran");
	}
}
