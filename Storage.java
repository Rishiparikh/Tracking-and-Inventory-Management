import java.util.ArrayList;
/*
 * Storage Class
 * Class to store items and keep track of quantity of items
 */
public class Storage implements Shippable{
  private int maxCapacity;
  private boolean redAlert;
  private boolean yellowAlert;
  private boolean isLarge;
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
				 
			  }
			  
		  return true;		  
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
  
  /**
	 * Takes in entire vector, but will merge the following sections together:
	 * Left sublist from a[first]..a[mid], right sublist from a[mid+1]..a[last].
	 * Precondition: each sublist is already in ascending order
	 *
	 * @param a
	 *            reference to an array of integers to be sorted
	 * @param first
	 *            starting index of range of values to be sorted
	 * @param mid
	 *            midpoint index of range of values to be sorted
	 * @param last
	 *            last index of range of values to be sorted
	 */
	private void merge(ArrayList <Comparable> a, int first, int mid, int last){
	ArrayList<Comparable> leftList = new ArrayList<Comparable>(a.subList(first, mid+1));
	ArrayList<Comparable> rightList = new ArrayList<Comparable>(a.subList(mid+1, last+1));
	
	int leftIndex = 0;
	int rightIndex = 0;
	int mainIndex = first;
	
	while (leftIndex <  leftList.size() && rightIndex <  rightList.size()) {
	      if (leftList.get(leftIndex).compareTo( rightList.get(rightIndex)) < 0) {
	        a.set(mainIndex++, leftList.get(leftIndex++));
	      } else {
	        a.set(mainIndex++, rightList.get(rightIndex++));
	      }
	}
  while (leftIndex <  leftList.size()) {
  	a.set(mainIndex++, leftList.get(leftIndex++));
	}
	while (rightIndex < rightList.size()) {
		a.set(mainIndex++, rightList.get(rightIndex++));
 }
}


	/**
	 *  Recursive mergesort of an array of integers
	 *
	 * @param  a      reference to an array of integers to be sorted
	 * @param  first  starting index of range of values to be sorted
	 * @param  last   ending index of range of values to be sorted
	 */
	private void mergeSort(ArrayList <Comparable> a, int first, int last){
		if ( last - first < 1) 
			return;
		
		int mid = first + (last-first)/2 ;
	
		mergeSort(a,first,mid);
		mergeSort(a,mid+1,last);
		merge(a, first , mid , last);
	}
	
	private int bsearch(Item idToSearch, int first, int last){ 
    	if (first < last) {
    		int mid = (first + last)/2;

            int comparedId = idToSearch.getName().compareTo(idToSearch.get(mid).getName());
            
            if (comparedId < 0) {
                return bsearch(idToSearch, first, mid);
                 
            } 
            else if (comparedId > 0) {
            	if ((mid+1) == last) {
            		comparedId = idToSearch.getString().compareTo(myWordCount.get(mid+1).getString());
            		if (comparedId == 0) {
            			return mid+1;
            		}
                }
                return bsearch(idToSearch, mid+1, last);
                 
            } else {
                return mid;   
            }
        }
    	return -1;
    } 
}
