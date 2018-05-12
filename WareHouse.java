/**
 * @author Shaheryar Asad
 * Period: 3
 */
import java.util.ArrayList;
 /**
   * Warehouse class
   * Contains all items and handles the shipping 
   */
public class WareHouse extends Storage implements Shippable{
	  private ArrayList<Storage> hubs = new ArrayList<Storage>();
    
   /**
   * Contructor class
   * @param ports = places where items will be shipped
   * @param xCord = x coordinate of item that is being shipped
   * @param yCord = y coordinate of item that is being shipped
   * @param red = color to represent a line that needs to be shipped immedietly
   * @param yellow = color to represent a line that needs to be shipped 
   */
  public WareHouse(ArrayList<Storage> ports, ArrayList<Item> wareHouseItems, int xCord, int yCord, int red, int yellow){
    super(wareHouseItems, xCord, yCord, red, yellow, Constants.largeStorageMax);
    //ArrayList <Storage> mainInventory = new ArrayList<Storage>();
    hubs = ports; 
  }
   /**
   * method to update the location of an item
   * @return wether or not there is an update on an item
   */
  public boolean hasUpdate(){
    for(int i = 0; i < hubs.size(); i++){
      if(hubs.get(i).hasUpdate()){
        return true;
      }
    }
    return false;
  }
   /**
   * Method to refill the hub with items that need to be shipped
   * @param i = the number of the item to refill the hub with
   */
  public void refillHub(int i)
  {
	  int flag=hubs.get(i).checkRedAlert();
	  String itemName;
	  if(flag>=0)
	  {
		  itemName= hubs.get(i).getItemName(flag);
		 hubs.get(i).refilItem(itemName, Constants.refillQuantity);
		 super.shipItem(itemName, Constants.refillQuantity);
	  }
	  
	  flag=hubs.get(i).checkYellowAlert();
	  if(flag>=0)
	  {
		  itemName= hubs.get(i).getItemName(flag);
		 hubs.get(i).refilItem(itemName, Constants.refillQuantity);
		 super.shipItem(itemName, Constants.refillQuantity);
	  }
  }
  /**
   * Method to check if there is an update on the shipping items
   * @param i = item number to check for updates
   * @return  0 for normal status, 1 : for yellow flag and 2 : for red flag
   */
  public int hasUpdate(int i)
  {
	    if(hubs.get(i).checkRedAlert() >= 0 )
	    	return 2;
	    else if(hubs.get(i).checkYellowAlert() >= 0 )
	    	return 1;
	    else return 0;
  }
  /**
   * Method to ship items from the warehouse
   * @param name = name of items to be shipped
   * @param amount = amount of items
   * @param xCord = x coordinate of the item to be shipped
   * @param yCord = y coordinate of the item to be shipped
   * @return  wether the item can be shipped
   */	
  public boolean shipItem(String name, int amount, int xCord, int yCord)
  {
	  int nearest = -1;
	  int distance=-1;
	  
	  // first check if the warehouse has the item sotred and what is the distance
	  
	  int [] wareLoc=super.getLocation();
	  int wareHouse_distance = (wareLoc[0]-xCord)* (wareLoc[0]-xCord) + (wareLoc[1]-yCord)* (wareLoc[1]-yCord);
	  if(super.hasItemQuantity(name,amount))
	  {
		  nearest=-2;
		  distance=wareHouse_distance;
	  }
	  for (int i = 0; i < hubs.size(); i++) 
	  {
		  int [] loc = hubs.get(i).getLocation();
		  int temp_distance = (loc[0]-xCord)* (loc[0]-xCord) + (loc[1]-yCord)* (loc[1]-yCord);
		  if( hubs.get(i).hasItemQuantity(name,amount))
		  {
			  if(nearest==-1)
			  {
			  distance=temp_distance;
			  nearest=i;
			  }
			  else
			  {
				  if(distance > temp_distance)
				  {
					  distance=temp_distance;
				      nearest=i;
				  }
			  }
		  }
		 
	  }
	  
	  if(nearest==-1)
		  return false;
	  else if (nearest==-2)
	  {
		  super.shipItem(name,amount);
		  System.out.println("shiping Item from : "+ "WareHouse");

		  return true;
	  }
	  else
	  {
		  hubs.get(nearest).shipItem(name,amount);
		  
		  System.out.println("shiping Item from : "+ nearest);
		  
		  return true;
	  }
  }
}
