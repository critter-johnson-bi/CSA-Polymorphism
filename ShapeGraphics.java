import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseAdapter;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Container;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
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
   
   private int collisions;
   private Label lblCollisions;
   
   ShapeGraphics () {  // create the Graphics Window and add "this" to it
      objects = new DrawingObjectTester();
      createFrame();           
      setupActionListeners();  
      addClickListeners(); 
   }
   
   private void createFrame() {
      JFrame frame = new JFrame("Our Shapes");  // Creates the window
      frame.setSize(WIDTH, HEIGHT);
      frame.setLocationRelativeTo(null); // sets the window in the center
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
      Container canvas;                      // Gets the content of the window
      canvas = frame.getContentPane();       // and sets it up
      canvas.setLayout(new BorderLayout());  // Layouts determine how components are displayed
   
      canvas.add(headerPanel(), BorderLayout.PAGE_START);  // adds the panel
      
      canvas.setBackground(Color.YELLOW);
      canvas.add(this, BorderLayout.CENTER);    // adds the content frame
      canvas.add(footerPanel(), BorderLayout.PAGE_END);  // adds the panel
      
      frame.setVisible(true); 
   }
   
   private JPanel headerPanel() {
     
      Button b = new Button("Reset");      // Allows you to have the button to click
      b.addActionListener(this);
   
      JPanel panel = new JPanel();     // Places the panel on a button
      panel.setBackground(Color.RED);
      panel.add(b);     
   
      return panel;   
   }
     
   private JPanel footerPanel() {
     
      lblCollisions = new Label("Collisions");      // Allows you to have the button to click
      //b.addActionListener(this);
      lblCollisions.setBackground(Color.WHITE);
      JPanel panel = new JPanel();     // Places the panel on a button
      panel.setBackground(Color.BLUE);
      panel.add(lblCollisions); 
          
      return panel;
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
   
   private boolean intersects(Square s1, Square s2) {
   // if any of the corners are inside the other shape, then it intersects
      double s1Width = s1.getWidth();
      double s1Length = s1.getLength();
      Point p1 = s1.getLocation();
      Point p2 = new Point ((int) p1.getX(), (int) (p1.getY()+s1Length));
      Point p3 = new Point ((int) (p1.getX()+s1Width), (int) p1.getY());
      Point p4 = new Point ((int) (p1.getX()+s1Width), (int) (p1.getY()+s1Length));
     
      return s2.contains(p1) || s2.contains(p2) ||s2.contains(p3) || s2.contains(p4);
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
   
   private void addClickListeners() {
      addMouseListener(
         new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
               int num = 0;
               super.mouseClicked(me);
               System.out.print("Clicked ");
               for (DrawingObject object : objects) {
                  Shape s = object.getShape();
                  Square square;
                  if (s instanceof Square) {
                     square = (Square) s; 
                     if (square.contains(me.getPoint())) {
                        System.out.println(" on a " + square.getType());
                     }
                  }
                  else 
                     s =  null;
               
               }
               System.out.println(num);
            }}
         );
   }
  
   public void paintComponent(Graphics g) {  // This method is run whenever the graphics frame needs to be repainted
      drawObjects(g);
   }

   public void drawObjects(Graphics g) {     // THIS DRAWS all of the shapes in the list
      for (DrawingObject o : objects) {
         Shape s = o.getShape();
         if (s instanceof Square) {          // CURRENTLY ONLY WORKS FOR SQUARES
            Square square = (Square) s;
            if (! squareOnFrame(square)) {
            //     s.setLocation(new Point(0, (int) s.getLocation().getY()));     // starts object at left again
             //  o.setSpeed(DrawingObject.getRandomSpeed());    // changes speed
               o.setSpeed(-o.getSpeed());                      // Causes object to bounce
            }
            checkForCollisions(o, square, objects);
            square.drawMe(g);
            //TODO ... how can we add an event listener for the square???
         }
      }
   }
   
   private void checkForCollisions(DrawingObject o, Square square, List<DrawingObject> objects) {
      for (DrawingObject obj : objects) {
         if (obj.getDraw() && (obj.getShape() instanceof Square)) {
            Square s2 = (Square) obj.getShape();
            if ((square != s2) && (intersects(square, s2))) {
               collisions++;
               lblCollisions.setText("Collisions: " + collisions + "  ");
               o.setDraw(false);
               obj.setDraw(false);
            }
         } 
      }  
   
   }
         
   private int rand(int min, int max) {  // gets a random integer between min and max
      return (int) ((Math.random() * (max - min)) + min);
   }
   
   private void randomizeLocations() { // sets a random location for each shape
      for (DrawingObject o : objects)   {
         o.getShape().setLocation(rand(1,WIDTH),rand(1,HEIGHT));
         o.setDraw(true);
      }
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
}