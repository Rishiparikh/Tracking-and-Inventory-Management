/**
 * 
 * @author Shaheryar Asad
 * 
 *         Item class Contains the items to be shipped
 */
public class Item {
	private String name;
	private int quantity;

	/**
	 * Constructor
	 * 
	 * @param name1
	 *            = name of an item
	 * @param quant
	 *            = quantity of a specific item
	 */
	public Item(String name1, int quant) {
		name = name1;
		quantity = quant;
	}

	/**
	 * compare to method Compares the items
	 * 
	 * @param a
	 *            = object of type Item to be compared
	 * @return the compared item
	 */
	public int compareTo(Item a) {
		return name.compareTo(a.name);
	}

	/**
	 * Getter Method to get the quantity of an item
	 * 
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Setter method to set the quantity of a particular item
	 * 
	 * @param a
	 *            = number that will be set to the quantity of the item
	 */
	public void setQuantity(int a) {

		if (a > -1)
			quantity = a;
		else {
			System.out.println("Quantity cannot be below 0.");
		}
	}

	/**
	 * Method to update the quantity of an item after being shipped to a location
	 * 
	 * @param a
	 *            = the quantity number to be updated
	 */
	public void updateQuantity(int a) {
		quantity = quantity - a;
	}

	/**
	 * Method to refill an item with a quantity
	 * 
	 * @param a
	 *            = the quantity to be refilled
	 */
	public void refill(int a) {

		if (a > 0)
			quantity = quantity + a;
	}

	/**
	 * Method to check the availability of an item
	 * 
	 * @param amount
	 *            = check the amount of an item we have
	 * @return wether we have space
	 */

	public boolean checkAvailability(int amount) {
		if (amount > quantity)
			return false;
		else
			return true;
	}

	/**
	 * Getter method for the name of an item
	 * 
	 * @return the name of an item
	 */
	public String getName() {
		return name;
	}
}
