import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.List;
import java.util.ArrayList;

public class ShapeGraphics extends JComponent implements ActionListener {
                         // allowing choice of random colors
   private static Color[] colors = {Color.BLUE, Color.GREEN, Color.BLACK, Color.CYAN, Color.MAGENTA, Color.GRAY,
                                    Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.LIGHT_GRAY, Color.DARK_GRAY};
                                    
   private static int WIDTH = 700;     // Size of window 
   private static int HEIGHT = 800;
   
   private ShapeTesterTK shapes;  // uses the shape tester, which is an array list
   private Button b;
   
   ShapeGraphics () {  // create the Graphics Window and add "this" to it
     shapes = new ShapeTesterTK();  // Use the shape tester to get a list of random shapes    
 
      b = new Button("Reset");      // Allows you to have the button to click
      b.addActionListener(this);
   
      JPanel p1 = new JPanel();     // Places the panel on a button
      p1.add(b);     
   
      JFrame frame = new JFrame("Our Shapes");  // Creates the window
      frame.setSize(WIDTH, HEIGHT);
      frame.setLocationRelativeTo(null); // sets the window in the center
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      Container canvas;                      // Gets the content of the window
      canvas = frame.getContentPane();       // and sets it up
      canvas.setLayout(new BorderLayout());  // Layouts determine how components are displayed

      canvas.add(p1, BorderLayout.PAGE_START);  // adds the panel
      
      canvas.setBackground(Color.YELLOW);
      canvas.add(this, BorderLayout.CENTER);    // adds the content frame
   
      frame.setVisible(true);      
      
   }
      
   public void actionPerformed(ActionEvent e) { // when the button is clicked call reset
      reset();
   }
  
   public void paintComponent(Graphics g) {  // This method is run whenever the graphics frame needs to be repainted
      drawShapes(g);
   }

   public void drawShapes(Graphics g) {  // uses each shapes draw method to add them to the graphics window
      for (Shape s : shapes) {
         if (s instanceof Square) { // Once all classes have the drawMe method this won't be necessary
           // System.out.println("Drawing: " + s); // DEBUG STATEMENT
           //  s.drawMe(g); // will work when the Shape abstract class has the abstract drawMe method
            Square square = (Square) s;
            square.drawMe(g);
         }
      }    
   }
   
   private int rand(int min, int max) {  // gets a random integer between min and max
      return (int) ((Math.random() * (max - min)) + min);
   }
   
   private void randomizeLocations() { // sets a random location for each shape
      for (Shape s : shapes)   
         s.setLocation(rand(1,WIDTH),rand(1,HEIGHT));
   }
   
   private Color randomColor() {  // returns a random color from the colors array
      return colors[rand(0,colors.length)];
   }
   
   private void randomizeColors() {  // randomly changes all of the line anfd fill colors foreach shape.
      for (Shape s : shapes) {
      //  s.setLineColor(randomColor()); // Really need the stroke to be bigger for this to
         s.setLineColor(Color.BLACK);    // work, but that requires Graphics2D and setStroke
         s.setFillColor(randomColor());
      }
   }
   
   private void reset() {
      randomizeLocations();                   // change the locations of all of the shapes
      randomizeColors();                      // change the colors for all of the shapes'
      repaint();
}
   public static void main(String[] args) {
      ShapeGraphics s = new ShapeGraphics();    // instantiate graphics test
      s.reset();                                // places all of the shapes
      }
      //TODO Add shape movement!
      //TODO Add Collisions
}