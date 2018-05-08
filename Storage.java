import java.util.ArrayList;

public class Storage implements Shippable{
  int maxCapacity;
  boolean redAlert;
  boolean yellowAlert;
  boolean isLarge;
  int x,y;
  int redLine;
  int yellowLine;
  ArrayList<Item> myInv = new ArrayList<Item>();
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
  public void transportItem(Item a, int numItems, Storage destination){
    int itemNumber = bsearch(myInv, a);
    myInv.get(itemNumber).setNumItems(myInv.get(itemNumber).getNumItems() - numItems);
    int recieveItemNumber = bsearch(destination.myInv, a);
    destination.myInv.get(itemNumber).setNumItems(destination.myInv.get(itemNumber).getNumItems() + numItems);
  }
  public int checkRedAlert(){
    for(int i = 0; i < myInv.size(); i++){
      if(myInv.get(i).getNumItems() < redLine){
        return i;
      }
    }
    return -1;
  }
  public int checkYellowAlert(){
    if(redAlert){
      return -1;
    }
    for(int i = 0; i < myInv.size(); i++){
      if(myInv.get(i).getNumItems() < yellowLine){
        return i;
      }
    }
    return -1;
  }
  public boolean hasUpdate(){
    if(redAlert || yellowAlert){
      return true;
    }
    return false;
  }
  public void addInv(Item a){
    myInv.add(a);
  }
  public int[] getLocation(){
    int[] a = new int[2];
    a[0] = x;
    a[1] = y;
    return a; 
  }
  
  private int bsearch(Item idToSearch, int first, int last){ 
  	if (first < last) {
  		int mid = (first + last)/2;
  		//if (mid == (myStore.size()-2)) {
  		//	mid++;
  		//}
          int comparedId = idToSearch.compareTo(myInv.get(mid));

          if (comparedId < 0) {
              return bsearch(idToSearch, first, mid);
               
          } 
          else if (comparedId > 0) {
          	if ((mid+1) == last) {
          		comparedId = idToSearch.compareTo(myInv.get(mid+1));
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
