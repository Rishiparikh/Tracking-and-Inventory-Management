public class Item {
  private String name;
  private int quantity;
  
  public Item(String name1, int quant){
    name = name1;
    quantity = quant;
  }
  public int compareTo(Item a){
    return name.compareTo(a.name);
  }
  public int getQuantity(){
    return quantity;
  }
  public void setQuantity(int a) {
	  
	  if(a > -1)
	  quantity = a;
  }
  
  public void updateQuantity(int a) {
	  
		 
	  quantity = quantity-a;
  } 
  public void refill(int a) {
	  
	 if(a > 0)
	  quantity = quantity+a;
  }
 
 
 public boolean checkAvailability(int amount){
	    if ( amount > quantity)
	    	return false;
	    	else
	    	 return true;
	  }
  public String getName() {
	  return name;
  }
}
