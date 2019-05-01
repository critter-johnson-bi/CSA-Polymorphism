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
      System.out.println("paint Component");
      g.setColor(Color.BLUE);
      drawShapes(g, shapes);
   }

   public void drawShapes(Graphics g, List<Shape> shapes) {
      for (Shape s : shapes) {
            System.out.println("Drawing: " + s);
         if (s instanceof Square) {
            s.drawMe(g);
         }
      }
     
   }

   public static void main(String[] args) {
      ShapeTesterTK st = new ShapeTesterTK();
      ShapeGraphics s = new ShapeGraphics();
   
      s.shapes = st.getShapes();    
//      s.repaint();
//      s.revalidate();
      
      
   
   }


}