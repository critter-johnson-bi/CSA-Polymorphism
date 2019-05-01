import java.awt.Graphics;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Container;
import java.util.List;
import java.util.ArrayList;

public class ShapeGraphics extends JComponent {

   Container canvas;
   List<Shape> shapes;

   ShapeGraphics () {
      JFrame frame = new JFrame("Our Shapes");
      frame.setSize(700, 800);
      frame.setLocationRelativeTo(null); // sets the window in the center
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);
   
      canvas = frame.getContentPane();
      canvas.setBackground(Color.YELLOW);
      canvas.add(this);
      }
  


   public void paintComponent(Graphics g) {
      g.setColor(Color.BLUE);
      drawShapes(g, shapes);
   }

   public void drawShapes(Graphics g, List<Shape> shapes) {
      for (Shape s : shapes) {
         if (s instanceof Square) {
            System.out.println("Drawing: " + s);
            s.drawMe(g);
         }
      }
     
   }
   
   private int rand(int min, int max) {
     return (int) ((Math.random() * (max - min)) + min);
   }
   
   private void randomizeLocations() {
     for (Shape s : shapes) {
     
       if (s instanceof Square) {
         s.setLocation(rand(1,500),rand(1,500));
       }
     }
   }

   public static void main(String[] args) {
      ShapeTesterTK st = new ShapeTesterTK();
      ShapeGraphics s = new ShapeGraphics();
      s.shapes = st.getShapes();    
      s.randomizeLocations();

//      s.repaint();
//      s.revalidate();
      
      
   
   }


}