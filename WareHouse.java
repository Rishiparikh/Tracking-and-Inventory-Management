import java.util.ArrayList;
/**
 * Warehouse class
 *
 */
public class WareHouse extends Storage implements Shippable {
	private ArrayList<Storage> hubs = new ArrayList<Storage>();
	private final int refillQuantity;
	/**
	 * Constructor for Warehouse class
	 * @param a - array list of storage centers
	 * @param b = array list of items
	 * @param xCord = x coordinate of item
	 * @param yCord = y coordinate of item
	 * @param red = color for when storage is in need of immediate refill
	 * @param yellow = color when storage needs to be refilled
	 * @param max = max amount an item can contain
	 */
	public WareHouse(ArrayList<Storage> a, ArrayList<Item> b, int xCord, int yCord, int red, int yellow, int max) {
		super(b, xCord, yCord, red, yellow, max);
		hubs = a;
		refillQuantity = 10;
	}
	/**
	 * Checks for updates
	 * @return true if item has an update
	 */
	public boolean hasUpdate() {
		for (int i = 0; i < hubs.size(); i++) {
			hubs.get(i).checkRedAlert();
			hubs.get(i).checkYellowAlert();
			if (hubs.get(i).hasUpdate()) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Used to add a location to our storage
	 * @param a = storage 
	 */
	public void addLocation(Storage a) {
		hubs.add(a);
	}

	public void getStatus() {

	}

	@Override
	/**
	 * Statement method to print out the contents of an item
	 * @return the contents of an item
	 */
	public String statement() {
		String temp = "Warehouse: ";
		for (int i = 0; i < myInv().size(); i++) {
			temp += myInv().get(i).getName() + " ";
			temp += myInv().get(i).getQuantity() + " \n";
		}
		return temp;
	}
	/**
	 * List to store all the hubs
	 * @return the hubs
	 */
	public ArrayList<Storage> hubs() {
		return hubs;
	}
	/**
	 * Method to refill a hub
	 * @param i = amount to refill
	 */
	public void refillHub(int i) {
		if ((i >= 0) && (i < hubs.size())) {
			int flag = hubs.get(i).checkRedAlert();
			String itemName;
			if (flag >= 0) {
				itemName = hubs.get(i).getItemName(flag);
				hubs.get(i).refilItem(itemName, refillQuantity);
				super.shipItem(itemName, refillQuantity);
			}

			flag = hubs.get(i).checkYellowAlert();
			if (flag >= 0) {
				itemName = hubs.get(i).getItemName(flag);
				hubs.get(i).refilItem(itemName, refillQuantity);
				super.shipItem(itemName, refillQuantity);
			}
		}
		hubs.get(i).checkMax();
	}
}
