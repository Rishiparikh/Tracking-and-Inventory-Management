/**
 * @author Shaheryar Asad
 * Period: 3
 */
import java.util.ArrayList;
/*
 * Storage Class
 * Class to store items and keep track of quantity of items
 */
public class Storage implements Shippable{
  private int maxCapacity;
  private boolean redAlert;
  private boolean yellowAlert;
  private int x,y;
  private int redLine;
  private int yellowLine;
  private ArrayList<Item> myInv = new ArrayList<Item>();
  /*
   * Constructor method for Storage class
   * @param a = array list of items that will be shipped
   * @param xCord = x coordinate of the location of our item
   * @param yCord = y coordinate of the location of our item
   * @param red = red shipping line 
   * @param yellow = yellow shipping line
   * @param max = max number of items storage can hold
   */
  public Storage(ArrayList<Item> a, int xCord, int yCord, int red, int yellow, int max){
    myInv = a;
    x = xCord;
    y = yCord;
    redLine = red;
    yellowLine = yellow;
    redAlert = checkRedAlert() != -1;
    yellowAlert = checkYellowAlert() != -1;
    maxCapacity = max;
  }
  
  public String getItemName(int i)
  {
	  return myInv.get(i).getName();
  }
  public void refilItem(String name, int amount)
  {
	  
	  for (int i = 0; i < myInv.size(); i++) 
	  {
		  String itemName = myInv.get(i).getName();
		  if(itemName.equals(name))
		  {
			  myInv.get(i).refill(amount);
			  int rflag= checkRedAlert();
				 if(rflag > 0)
				   		redAlert=true;
				 else
					 redAlert=false;
					 
				if(redAlert)	 
					yellowAlert=true;
				else
				{
					 int yflag= checkYellowAlert();
					 if(yflag > 0)
					   		yellowAlert=true;
					 else
						 yellowAlert=false;
				}
				  
		  }
	  }		  
 }
  
  public boolean hasItemQuantity(String name, int amount)
  {
	  for (int i = 0; i < myInv.size(); i++) 
	  {
		  String itemName = myInv.get(i).getName();
		  if(itemName.equals(name))
		  {
			  int availableQuantity =  myInv.get(i).getQuantity();
			  if(availableQuantity>=amount)
			  {
				return true;  
			  }
		  }
	  }
	  return false;
  }
  
  //remove this for-loop and string comparison if statement once sort and search algorithms
  //are used.
  public boolean shipItem(String name, int amount)
  {
	  for (int i = 0; i < myInv.size(); i++) 
	  {
		  String itemName = myInv.get(i).getName();
		  if(itemName.equals(name))
		  {
			  int availableQuantity =  myInv.get(i).getQuantity();
			  if(availableQuantity>=amount)
			  {
				  myInv.get(i).updateQuantity(amount);
				  
				 int rflag= checkRedAlert();
				 if(rflag > 0)
				   		redAlert=true;
				 else
					 redAlert=false;
					 
				if(redAlert)	 
					yellowAlert=true;
				else
				{
					 int yflag= checkYellowAlert();
					 if(yflag > 0)
					   		yellowAlert=true;
					 else
						 yellowAlert=false;
				}
			  return true;		   
			  }
			  else
				  return false;
		  }
		
	}
  return false;
  }
  /*
   * method to check if there are items that need to be shipped immediately
   */
  public int checkRedAlert(){
    for(int i = 0; i < myInv.size(); i++){
      if(myInv.get(i).getQuantity() < redLine){
        return i;
      }
    }
    return -1;
  }
  /*
   * Method to check if there items that need to be shipped on a yellow line
   */
  public int checkYellowAlert(){
    if(redAlert){
      return -1;
    }
    for(int i = 0; i < myInv.size(); i++){
      if(myInv.get(i).getQuantity() < yellowLine){
        return i;
      }
    }
    return -1;
  }
  /*
   * Gets an update from the status of our shippable project
   */
  public boolean hasUpdate(){
    if(redAlert || yellowAlert){
      return true;
    }
    return false;
  }
  /*
   * Method to add an item into our array
   * @param a = array of items in storage
   */
  public void addInv(Item a){
    myInv.add(a);
  }
  /*
   * Method to get location of a specific item
   */
  public int[] getLocation(){
    int[] a = new int[2];
    a[0] = x;
    a[1] = y;
    return a; 
  }
}
