import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import java.util.List;
import java.util.ArrayList;

public class ShapeGraphics extends JComponent implements ActionListener {
                         // allowing choice of random colors
   private static Color[] colors = {Color.BLUE, Color.GREEN, Color.BLACK, Color.CYAN, Color.MAGENTA, Color.GRAY,
                                    Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.LIGHT_GRAY, Color.DARK_GRAY};
                                    
   private static int WIDTH = 700;     // Size of window 
   private static int HEIGHT = 800;
   
   private DrawingObjectTester objects;
   private Button b;
   private Timer tmrSquares;
   private Square square;
   
   ShapeGraphics () {  // create the Graphics Window and add "this" to it
      objects = new DrawingObjectTester();
      
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
      
      setupActionListeners();   
   }
   
   private boolean onFrame(Point p) {
   
      double x = p.getX();
      double y = p.getY();
     
      return (x >= 0 && x <= WIDTH && y >= 0 && y <= HEIGHT);
   }
   
   private boolean squareOnFrame(Square s) {
      Point p = s.getLocation();
      double ll = p.getX() + s.getWidth();
      double lr = p.getY() + s.getLength();
      return onFrame(new Point((int)ll, (int)lr));
   }
     
   private void moveSquare(Square square, double speed) {
      Point p = square.getLocation();
     
      square.slide(speed,0);
      this.repaint();
   }

   private void moveSquares() {
      Shape s;
      Square square;
     
      for (DrawingObject o : objects) {
         s = o.getShape();
         if (o.getDraw())
            if (s instanceof Square) {
               square = (Square) s;
               moveSquare(square, o.getSpeed()); 
            }
      }
   }
   
   private void setupActionListeners() {
    
    // First Action Listener
      ActionListener alMoveSquare = 
         new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
               moveSquares();
            }
         }; 
      tmrSquares = new Timer(5, alMoveSquare); 
      tmrSquares.start();
   // Second Action Listener
   }  
        
   public void actionPerformed(ActionEvent e) { // when the button is clicked call reset
      if (e.getActionCommand().equals("Reset"))
         reset();
   }
  
   public void paintComponent(Graphics g) {  // This method is run whenever the graphics frame needs to be repainted
      drawObjects(g);
   }

   public void drawObjects(Graphics g) {
      for (DrawingObject o : objects) {
         Shape s = o.getShape();
         if (s instanceof Square) {
            Square square = (Square) s;
            if (! squareOnFrame(square))
               s.setLocation(new Point(0, (int) s.getLocation().getY()));
            square.drawMe(g);
         }
      }
   }
         
   private int rand(int min, int max) {  // gets a random integer between min and max
      return (int) ((Math.random() * (max - min)) + min);
   }
   
   private void randomizeLocations() { // sets a random location for each shape
      for (DrawingObject o : objects)   
         o.getShape().setLocation(rand(1,WIDTH),rand(1,HEIGHT));
   }
   
   private Color randomColor() {  // returns a random color from the colors array
      return colors[rand(0,colors.length)];
   }
   
   private void randomizeColors() {  // randomly changes all of the line anfd fill colors foreach shape.
      for (DrawingObject o : objects) {
      //  s.setLineColor(randomColor()); // Really need the stroke to be bigger for this to
         o.getShape().setLineColor(Color.BLACK);    // work, but that requires Graphics2D and setStroke
         o.getShape().setFillColor(randomColor());
      }
   }
   
   private void reset() {
      randomizeLocations();                   // change the locations of all of the shapes
      randomizeColors();  
      Shape s = null;                         // change the colors for all of the shapes'
      for (DrawingObject o : objects) {
         s = o.getShape();
         if (s instanceof Square) {
            square = (Square) s;
            square.setFillColor(Color.BLACK);
            break;
         }
      }
      repaint();
   }
   
   public static void main(String[] args) {
      ShapeGraphics s = new ShapeGraphics();    // instantiate graphics test
      s.reset();                                // places all of the shapes
   }
      //TODO Add shape movement!
      //TODO Add Collisions
}