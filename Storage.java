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
    int itemNumber = search(myInv, a);
    myInv.get(itemNumber).setNumItems(myInv.get(itemNumber).getNumItems() - numItems);
    int recieveItemNumber = search(destination.myInv, a);
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
}
