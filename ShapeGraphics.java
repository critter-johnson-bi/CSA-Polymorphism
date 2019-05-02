import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Container;
import java.util.List;
import java.util.ArrayList;

public class ShapeGraphics extends JComponent {

   private static Color[] colors = {Color.BLUE, Color.GREEN, Color.BLACK, Color.CYAN, Color.MAGENTA, Color.GRAY,
                                    Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.LIGHT_GRAY, Color.DARK_GRAY};
   
   private ShapeTesterTK shapes;
   
   public Graphics graphic;

   ShapeGraphics () {
      Container canvas;
      JFrame frame = new JFrame("Our Shapes");
      frame.setSize(700, 800);
      frame.setLocationRelativeTo(null); // sets the window in the center
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   
      canvas = frame.getContentPane();
      canvas.setBackground(Color.YELLOW);
      canvas.add(this);    // this, because we extend JComponent, is of type JComponent
      shapes = new ShapeTesterTK();
      }
  
   public void paintComponent(Graphics g) {
      graphic = g;
      g.setColor(Color.BLUE);
      drawShapes(g, shapes);
   }

   public void drawShapes(Graphics g, List<Shape> shapes) {
      for (Shape s : shapes) {
         if (s instanceof Square) { // Once all classes have the drawMe method this won't be necessary
            System.out.println("Drawing: " + s);
           //  s.drawMe(g); // will work when the Shape abstract class has the abstract drawMe method
            Square square = (Square) s;
            square.drawMe(g);
         }
      }    
   }
   
   private int rand(int min, int max) {
     return (int) ((Math.random() * (max - min)) + min);
   }
   
   private void randomizeLocations() {
     for (Shape s : shapes)   
         s.setLocation(rand(1,500),rand(1,500));
   }
   
   private Color randomColor() {
     return colors[rand(0,colors.length)];
   }
   private void randomizeColors() {
     for (Shape s : shapes) {
      s.setLineColor(randomColor());
      s.setLineColor(Color.BLACK);
      s.setFillColor(randomColor());
     }
   }
   
   public static void main(String[] args) {
      ShapeGraphics s = new ShapeGraphics();
      s.randomizeLocations(); 
      s.randomizeColors();
      }
}