import java.util.ArrayList;

/*
 * Storage Class
 * Class to store items and keep track of quantity of items
 */
public class Storage implements Shippable {
	private int maxCapacity;
	private boolean redAlert;
	private boolean yellowAlert;
	private boolean isLarge;
	private int x, y, redLine, yellowLine;
	private ArrayList<Item> myInv = new ArrayList<Item>();

	/*
	 * Constructor method for Storage class
	 * 
	 * @param a = array list of items that will be shipped
	 * 
	 * @param xCord = x coordinate of the location of our item
	 * 
	 * @param yCord = y coordinate of the location of our item
	 * 
	 * @param red = red shipping line
	 * 
	 * @param yellow = yellow shipping line
	 * 
	 * @param max = max number of items storage can hold
	 */
	public Storage(ArrayList<Item> a, int xCord, int yCord, int red, int yellow, int max) {
		myInv = a;
		x = xCord;
		y = yCord;
		redLine = red;
		yellowLine = yellow;
		redAlert = checkRedAlert() != -1;
		yellowAlert = checkYellowAlert() != -1;
		maxCapacity = max;
		checkMax();
	}
	public void checkMax() {
//		for(int i = 0; i < myInv.size(); i++) {
//			if(myInv.get(i).getQuantity() > maxCapacity) {
//				myInv.get(i).setQuantity(maxCapacity);
//			}
//		}
	}
	/*
	 * Transport method Used to transport items from the storage unit to a specific
	 * location
	 * 
	 * @param a = Item to be shipped
	 * 
	 * @param numItems = number of items to be shipped
	 * 
	 * @param destination = desired destination for specific item
	 */
	public void transportItem(Item a, int numItems, Storage destination) {
		int itemNumber = search(myInv, a);
		int recieveItemNumber = search(destination.myInv, a);
		myInv.get(itemNumber).setQuantity(myInv.get(itemNumber).getQuantity() - numItems);
		destination.myInv.get(recieveItemNumber)
				.setQuantity(destination.myInv.get(recieveItemNumber).getQuantity() + numItems);
		destination.checkMax();
		checkMax();
	}
	/**
	 * Getter Method to get the name of the item being shipped
	 * @param i = position of item to get
	 * @return name of specific item
	 */
	public String getItemName(int i) {
		return myInv.get(i).getName();
	}
	/**
	 * Refills an item to ship again
	 * @param name = name of specific item
	 * @param amount = amount of the item that needs to be shipped
	 */
	public void refilItem(String name, int amount) {

		for (int i = 0; i < myInv.size(); i++) {
			String itemName = myInv.get(i).getName();
			if (itemName.equals(name)) {
				myInv.get(i).refill(amount);
				int rflag = checkRedAlert();
				if (rflag > 0)
					redAlert = true;
				else
					redAlert = false;

				if (redAlert)
					yellowAlert = true;
				else {
					int yflag = checkYellowAlert();
					if (yflag > 0)
						yellowAlert = true;
					else
						yellowAlert = false;
				}

			}
		}
		checkMax();
	}
	/**
	 * Checks how much quantity an object contains after the shipment
	 * @param name = name of item to check for quantity
	 * @param amount = amount needed to check
	 * @return whether or not the item has a quantity
	 */
	public boolean hasItemQuantity(String name, int amount) {
		for (int i = 0; i < myInv.size(); i++) {
			String itemName = myInv.get(i).getName();
			if (itemName.equals(name)) {
				int availableQuantity = myInv.get(i).getQuantity();
				if (availableQuantity >= amount) {
					return true;
				}
			}
		}
		return false;
	}
	/**
	 * Checks if an item needs to be shipped again
	 * @param name = name of item
	 * @param amount = amount to check if the item has to be shipped again
	 * @return whether or not the item can be shipped
	 */
	public boolean shipItem(String name, int amount) {
		for (int i = 0; i < myInv.size(); i++) {
			String itemName = myInv.get(i).getName();
			if (itemName.equals(name)) {
				int availableQuantity = myInv.get(i).getQuantity();
				if (availableQuantity >= amount) {
					myInv.get(i).updateQuantity(amount);

					int rflag = checkRedAlert();
					if (rflag > 0)
						redAlert = true;
					else
						redAlert = false;

					if (redAlert)
						yellowAlert = true;
					else {
						int yflag = checkYellowAlert();
						if (yflag > 0)
							yellowAlert = true;
						else
							yellowAlert = false;
					}
					return true;
				} else
					return false;
			}

		}
		return false;
	}
	/**
	 * Method to check if an item is in the array and returns the position
	 * @param myInv2 = list of items
	 * @param a = item to check 
	 * @return the position of the item in the array or 0 if it is not there
	 */
	public int search(ArrayList<Item> myInv2, Item a) {
		for (int i = 0; i < myInv2.size(); i++) {
			if (myInv2.get(i).compareTo(a) == 0) {
				return i;
			}
		}
		return 0;
	}

	/*
	 * method to check if there are items that need to be shipped immediately
	 * @return the red alert
	 */
	public int checkRedAlert() {
		for (int i = 0; i < myInv.size(); i++) {
			if (myInv.get(i).getQuantity() < redLine) {
				redAlert = true;
				return i;
			}
		}
		redAlert = false;

		return -1;
	}

	/*
	 * Method to check if there items that need to be shipped on a yellow line
	 * @return the yellow alert
	 */
	public int checkYellowAlert() {
		if (redAlert) {
			return -1;
		}
		for (int i = 0; i < myInv.size(); i++) {
			if (myInv.get(i).getQuantity() < yellowLine) {
				yellowAlert = true;
				return i;
			}
		}
		yellowAlert = false;

		return -1;
	}

	/*
	 * Gets an update from the status of our shippable project
	 * @return if there is an update of red alerts or yellow alerts of the status
	 */
	public boolean hasUpdate() {
		if (redAlert || yellowAlert) {
			return true;
		}
		return false;
	}

	/*
	 * Method to add an item into our array
	 * 
	 * @param a = array of items in storage
	 */
	public void addInv(Item a) {
		myInv.add(a);
	}

	/*
	 * Method to get location of a specific item
	 * @return location in x direction
	 */
	public int x() {
		return x;
	}
	/*
	 * Method to get location of a specific item
	 * @return location in y direction
	 */
	public int y() {
		return y;
	}
	/**
	 * Method to get make a statement of the item name and quantities it contains
	 * @return the statement it makes
	 */
	public String statement() {
		String temp = "Storage: ";
		for (int i = 0; i < myInv.size(); i++) {
			temp += myInv.get(i).getName() + " ";
			temp += myInv.get(i).getQuantity() + " \n";
		}
		return temp;
	}
	/**
	 * Method to get a list of all items
	 * @return the list of items
	 */
	public ArrayList<Item> myInv() {
		return myInv;
	}
	/**
	 * Method to check for a red alert
	 * @return the red alert
	 */
	public boolean redAlert() {
		return redAlert;
	}
	/**
	 * Method to check for a yellow alert
	 * @return the yellow alert
	 */
	public boolean yellowAlert() {
		return yellowAlert;
	}

}
