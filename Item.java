public class Item{
  public String name;
  public int quantity;
  public int goodAmt;
  public Item(String name1, int quant, int goodAmt){
    name = name1;
    quantity = quant;
  }
  public int compareTo(Item a){
    return name.compareTo(a.name);
  }
  public int getNumItems(){
    return quantity;
  }
  public int getQuantityNeeded(){
    return quantity - goodAmt;
  }
}
