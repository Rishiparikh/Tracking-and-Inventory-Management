import java.util.ArrayList;
 /**
   * Shippable Interface
   * Contains outilne for Warehouse class
   */
public interface Shippable{
  public int[] getLocation();
  //public ArrayList<Item> getInv;
  public void addInv(Item a);
  public boolean hasUpdate();
  public int checkYellowAlert();
  public int checkRedAlert();
}
