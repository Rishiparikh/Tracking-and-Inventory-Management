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

  public boolean shipItem(String name, int amount, int xCord, int yCord)
  {
	  int nearest = 0;
	  int distance=0;
	  for (int i = 0; i < hubs.size(); i++) 
	  {
		  int [] loc = hubs.get(i).getLocation();
		  int temp_distance = (loc[0]-xCord)* (loc[0]-xCord) + (loc[1]-yCord)* (loc[1]-yCord);
		  if(i==0)
			  distance=temp_distance;
		  else
		  {
			  
		  }
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
  
}
