import java.util.ArrayList;
public class WareHouse extends Storage implements Shippable{
  public ArrayList<Storage> hubs = new ArrayList<Storage>();
  private int size = Constants.largeStorageMax;
  public WareHouse(ArrayList<Storage> a, ArrayList<Item> b, int xCord, int yCord, int red, int yellow, int max){
    super(b, xCord, yCord, red, yellow, max);
    hubs = a;
  }
  public boolean hasUpdate(){
    for(int i = 0; i < hubs.size(); i++){
      if(hubs.get(i).hasUpdate()){
        return true;
      }
    }
    return false;
  }

  public void addLocation(Storage a){
    hubs.add(a);
  }

  public void getStatus(){

  }

}
