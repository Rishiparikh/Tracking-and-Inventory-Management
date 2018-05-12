import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Class to run our Shipping program
 */
public class Run {
	private static boolean isRunning;
	/**
	 * Main method that creates our storage centers and shipps products
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException {
		ArrayList<Item> a = new ArrayList<Item>();
		a.add(new Item("food", 50));
		a.add(new Item("water", 30));
		a.add(new Item("stuff", 40));
		ArrayList<Item> a2 = new ArrayList<Item>();
		a2.add(new Item("food", 50));
		a2.add(new Item("water", 30));
		a2.add(new Item("stuff", 40));
		ArrayList<Item> a3 = new ArrayList<Item>();
		a3.add(new Item("food", 50));
		a3.add(new Item("water", 40));
		a3.add(new Item("stuff", 40));
		ArrayList<Item> a1 = new ArrayList<Item>();
		a1.add(new Item("food", 1000));
		a1.add(new Item("water", 1000));
		a1.add(new Item("stuff", 1000));
		ArrayList<Item> a4 = new ArrayList<Item>();
		a4.add(new Item("food", 40));
		a4.add(new Item("water", 30));
		a4.add(new Item("stuff", 20));
		Storage b = new Storage(a2, 500, 480, 25, 40, 100);
		Storage d = new Storage(a, 800, 300, 10, 45, 100);
		Storage e = new Storage(a4, 500, 200, 25, 35, 100);
		Storage c = new Storage(a3, 350, 350, 40, 45, 100);
		ArrayList<Storage> ware = new ArrayList<Storage>();
		ware.add(b);
		ware.add(c);
		ware.add(d);
		ware.add(e);
		WareHouse test = new WareHouse(ware, a1, 150, 150, 40, 140, 500);
		MapGUI gui1 = new MapGUI(test);
		gui1.create(test);
		gui1.update(test);
		isRunning = true;
		while(isRunning) {
			
			
		while(test.hasUpdate()) {
			gui1.update(test);

			for(int i = 0; i < test.hubs().size(); i++) {
				int itmNum = test.hubs().get(i).checkRedAlert();
				while(itmNum != -1) {
					gui1.transport(test,test.hubs().get(i).myInv().get(itmNum), 25, test.hubs().get(i));
					itmNum = test.hubs().get(i).checkRedAlert();
					gui1.update(test);
					if(itmNum == -1) {
						break;
					}
				}
			}
			for(int i = 0; i < test.hubs().size(); i++) {
				int itmNum = test.hubs().get(i).checkYellowAlert();
				while(itmNum != -1) {
					gui1.transport(test,test.hubs().get(i).myInv().get(itmNum), 20, test.hubs().get(i));
					itmNum = test.hubs().get(i).checkYellowAlert();
					gui1.update(test);


					if(itmNum == -1) {
						break;
					}
				}
			}
		}
		gui1.update(test);
		periodic(test, gui1);
		gui1.update(test);
		}
	}
	/**
	 * Periodic method
	 * @param test
	 * @param gui1
	 */
	public static void periodic(WareHouse test, MapGUI gui1) {
		System.out.println("s");
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()) {
			int store = sc.nextInt()-1;
			String name = sc.next();
			int amt = sc.nextInt();
			Item temp = new Item(name, amt);
			int recieveItemNumber = test.search(test.hubs().get(store).myInv(), temp);
			test.hubs().get(store).myInv().get(recieveItemNumber).setQuantity(test.hubs().get(store).myInv().get(recieveItemNumber).getQuantity() + amt);
		}
		gui1.update(test);
	}
}
