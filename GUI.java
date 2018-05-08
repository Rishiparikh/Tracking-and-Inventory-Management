import gpdraw.DrawingTool;
import gpdraw.SketchPad;
import java.awt.Color;
public class GUI{
	private Color RED = Color.red, BLUE = Color.blue, BLACK = Color.black,
			GRAY = Color.gray, YELLOW = Color.yellow, PINK = Color.pink,
			ORANGE = Color.orange, GREEN = Color.green,
			MAGENTA = Color.magenta, WHITE = Color.white;
	private DrawingTool pencil;
	private SketchPad canvas;

	public GUI(SketchPad map, DrawingTool pen) {
		canvas = map;
		pencil = pen;
	}

	public void draw() {
		// Draw circle
		pencil.up();
		pencil.move(150, 0);
		pencil.down();
		pencil.setColor(RED);
		pencil.setWidth(15);
		pencil.fillCircle(100);
	}

	public void inventory11() {
		pencil.up();
		pencil.move(0, 300);
		pencil.down();
		pencil.setColor(RED);
		pencil.setWidth(15);
		pencil.fillCircle(100);
	}

	public static void main(String argv[]) {
		SquareAndCircle c = new SquareAndCircle();
		c.draw();
		c.inventory11();
	}
	public void drawStorage(Storage a){
		pencil.up();
		pencil.move(a.getLocation[0], a.getLocation[2]);
		pencil.down();
		pencil.setColor(GREEN);
		if(a.redAlert){
			pencil.setColor(RED);
		}
		else if(a.yellowAlert){
			pencil.setColor(YELLOW);
		}
		pencil.fillCircle(a.maxCapacity/2);
	}
}
