import java.io.File;
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
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String args[]) throws InterruptedException {
		System.out.println();
		WareHouse test = input("text.txt");
		for(int i = 0; i < test.hubs().size(); i++) {
			MergeSort merge = new MergeSort(test.hubs().get(i).myInv());
			merge.sort();
		}
		MapGUI gui1 = new MapGUI(test);
		gui1.create(test);
		gui1.update(test);
		isRunning = true;
		while (isRunning) {

			while (test.hasUpdate()) {
				gui1.update(test);

				for (int i = 0; i < test.hubs().size(); i++) {
					int itmNum = test.hubs().get(i).checkRedAlert();
					while (itmNum != -1) {
						gui1.transport(test, test.hubs().get(i).myInv().get(itmNum), 25, test.hubs().get(i));
						itmNum = test.hubs().get(i).checkRedAlert();
						gui1.update(test);
						if (itmNum == -1) {
							break;
						}
					}
				}
				for (int i = 0; i < test.hubs().size(); i++) {
					int itmNum = test.hubs().get(i).checkYellowAlert();
					while (itmNum != -1) {
						gui1.transport(test, test.hubs().get(i).myInv().get(itmNum), 20, test.hubs().get(i));
						itmNum = test.hubs().get(i).checkYellowAlert();
						gui1.update(test);

						if (itmNum == -1) {
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
	 * 
	 * @param test
	 * @param gui1
	 */
	public static void periodic(WareHouse test, MapGUI gui1) {
		Scanner sc = new Scanner(System.in);

		if (sc.hasNext()) {
			int store = sc.nextInt() - 1;
			if (store == -1) {
				System.out.println("done");
				isRunning = false;
			} else {
				String name = sc.next();
				int amt = sc.nextInt();
				Item temp = new Item(name, amt);
				int recieveItemNumber = test.search(test.hubs().get(store).myInv(), temp);
				test.hubs().get(store).myInv().get(recieveItemNumber)
						.setQuantity(test.hubs().get(store).myInv().get(recieveItemNumber).getQuantity() + amt);
			}
		}
		gui1.update(test);
	}

	public static WareHouse input(String fileName) {
		ArrayList<Storage> temp = new ArrayList<Storage>();
		try {
			Scanner sc = new Scanner(new File(fileName));
			int numStorages = sc.nextInt();
			for (int i = 0; i < numStorages; i++) {
				int numItems = sc.nextInt();
				ArrayList<Item> inv = new ArrayList<Item>();
				for (int j = 0; j < numItems; j++) {
					inv.add(new Item(sc.next(), sc.nextInt()));
				}
				temp.add(new Storage(inv, sc.nextInt(), sc.nextInt(), Constants.redAlert, Constants.yellowAlert,
						Constants.smallStorageMax));
			}
			int numItems = sc.nextInt();
			ArrayList<Item> inv = new ArrayList<Item>();
			for (int j = 0; j < numItems; j++) {
				inv.add(new Item(sc.next(), sc.nextInt()));
			}
			WareHouse house = new WareHouse(temp, inv, Constants.loc0[0], Constants.loc0[1], Constants.redAlertLarge,
					Constants.yellowAlertLarge, Constants.largeStorageMax);
			return house;

		} catch (Exception e) {
			e.getMessage();
		}
		return null;
	}
}
