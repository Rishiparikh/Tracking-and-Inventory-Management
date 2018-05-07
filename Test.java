import java.util.ArrayList;
public class Test{
  public static void main(String[] args){
    map = new SketchPad(1000,1000);
    pen = new DrawingTOol(map);
    GUI g = new GUI(map, pen);
    ArrayList<Item> a = new ArrayList<Item>();
    a.add(new Item("food", 50, 0));
    a.add(new Item("water", 50, 0));
    a.add(new Item("stuff", 30, 0));
    Storage b = new Storage(a, 0, 0, 40, 45, 100);
    Storage c = new Storage(a, 150, 150, 40, 45, 100);
    g.draw(b);
    g.draw(c);
  }
}
