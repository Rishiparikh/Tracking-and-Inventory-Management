import java.util.ArrayList;

public class WareHouse extends Storage implements Shippable{
	  private ArrayList<Storage> hubs = new ArrayList<Storage>();
      private int size = Constants.largeStorageMax;
  
  public WareHouse(ArrayList<Storage> ports, ArrayList<Item> wareHouseItems, int xCord, int yCord, int red, int yellow, int max){
    super(wareHouseItems, xCord, yCord, red, yellow, max);
    //ArrayList <Storage> mainInventory = new ArrayList<Storage>();
    hubs = ports; 
  }
  
  public boolean hasUpdate(){
    for(int i = 0; i < hubs.size(); i++){
      if(hubs.get(i).hasUpdate()){
        return true;
      }
    }
    return false;
  }
  
  public void refillHub(int i)
  {
	  //////////////////////// this method is incomplete it will check which items needs to refilled in hubs and refil them
	  hubs.get(i)......
  }
  // returns : 0 for normal status, 1 : for yellow flag and 2 : for red flag
  public int hasUpdate(int i)
  {
	    if(hubs.get(i).checkRedAlert() >= 0 )
	    	return 2;
	    else if(hubs.get(i).checkYellowAlert() >= 0 )
	    	return 1;
	    else return 0;
  }

  public boolean shipItem(String name, int amount, int xCord, int yCord)
  {
	  int nearest = -1;
	  int distance=-1;
	  
	  // first check if the warehouse has the item sotred and what is the distance
	  
	  int [] wareLoc=super.getLocation();
	  int wareHouse_distance = (wareLoc[0]-xCord)* (wareLoc[0]-xCord) + (wareLoc[1]-yCord)* (wareLoc[1]-yCord);
	  if(super.hasItemQuantity())
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
					  distance=temp_distance;
				      nearest=i;
			  }
		  }
		 
	  }
	  
	  if(nearest==-1)
		  return false;
	  else if (nearest==-2)
	  {
		  super.shipItem(name,amount);
		  return true;
	  }
	  else
	  {
		  hubs.get(nearest).shipItem(name,amount);
		  return true;
	  }
  
}
