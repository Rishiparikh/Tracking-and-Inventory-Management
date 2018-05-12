import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
/**
 * Class to run our Shipping program
 */
public class Run {
	private static boolean isRunning;
	/**
	 * Main method that creates our storage centers and ships products
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException {
		ArrayList<Item> a = new ArrayList<Item>();
		a.add(new Item("food", 50));
		a.add(new Item("water", 30));
		a.add(new Item("stuff", 20));
		ArrayList<Item> a2 = new ArrayList<Item>();
		a2.add(new Item("food", 50));
		a2.add(new Item("water", 35));
		a2.add(new Item("stuff", 45));
		ArrayList<Item> a3 = new ArrayList<Item>();
		a3.add(new Item("food", 52));
		a3.add(new Item("water", 30));
		a3.add(new Item("stuff", 17));
		ArrayList<Item> a1 = new ArrayList<Item>();
		a1.add(new Item("food", 1000));
		a1.add(new Item("water", 1000));
		a1.add(new Item("stuff", 1000));
		ArrayList<Item> a4 = new ArrayList<Item>();
		a4.add(new Item("food", 30));
		a4.add(new Item("water", 35));
		a4.add(new Item("stuff", 57));
		Storage b = new Storage(a2, Constants.loc1[0], Constants.loc1[1], Constants.redAlert, Constants.yellowAlert, Constants.smallStorageMax);
		Storage c = new Storage(a3, Constants.loc2[0], Constants.loc2[1], Constants.redAlert, Constants.yellowAlert, Constants.smallStorageMax);
		Storage d = new Storage(a, Constants.loc3[0], Constants.loc3[1], Constants.redAlert, Constants.yellowAlert, Constants.smallStorageMax);
		Storage e = new Storage(a4, Constants.loc4[0], Constants.loc4[1], Constants.redAlert, Constants.yellowAlert, Constants.smallStorageMax);
		ArrayList<Storage> ware = new ArrayList<Storage>();
		ware.add(b);
		ware.add(c);
		ware.add(d);
		ware.add(e);
		WareHouse test = new WareHouse(ware, a1, Constants.loc0[0], Constants.loc0[1], Constants.redAlertLarge, Constants.yellowAlertLarge, Constants.largeStorageMax);
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
			if(store == -1) {
				System.out.println("done");
				isRunning = false;
			}
			else {
			String name = sc.next();
			int amt = sc.nextInt();
			Item temp = new Item(name, amt);
			int recieveItemNumber = test.search(test.hubs().get(store).myInv(), temp);
			test.hubs().get(store).myInv().get(recieveItemNumber).setQuantity(test.hubs().get(store).myInv().get(recieveItemNumber).getQuantity() + amt);
			}
		}
		gui1.update(test);
	}
}
