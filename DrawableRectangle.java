import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class DrawableRectangle extends Rectangle implements DrawableShape {

   private double length;
   private double width;
   private Point location;
   private Color lineColor;
   private Color fillColor;
   private double speed;
   private boolean draw;
   
   //Constructor
   public DrawableRectangle(double l, double w, Point p, Color line, Color fill, double s) {
      super(l, w);
      setLocation(p);
      setLineColor(line);
      setFillColor(fill);
      draw = true;
      speed = s;
      super.setType("Rectangle");
   }
   
   //2 arg Constructor
   public DrawableRectangle(double l, double w) {
      super(l, w);
      setLocation(new Point());
      setLineColor(Color.BLUE);
      setFillColor(Color.RED);
      draw = true;
      setType("Rectangle");
   }
      
   public void drawMe(Graphics g) {
      Point topLeft = location;
      int ul = (int) topLeft.getX();
      int ur = (int) topLeft.getY();
      int side1 = (int) super.getLength();
      int side2 = (int) super.getWidth();

      Color penColor = lineColor;
      Color intColor = fillColor;
     
     
      if (penColor == null && intColor == null) {
         g.setColor(Color.BLACK);        
         g.drawRect(ul, ur, side1, side2);
      }
      else {
         if (penColor != null) {
            g.setColor(penColor);
            g.drawRect(ul, ur, side1, side2);
         }
        if (intColor != null) {
            g.setColor(intColor);
            g.fillRect(ul, ur, side1, side2);
         }
      } 
   }
   
  public Point getLocation() {
   return location;
  }
   
  public Color getLineColor() {
   return lineColor;
  }

  public Color getFillColor() {
   return fillColor;
  }
 
  public void setLineColor(Color c) {
   lineColor = c;
  }
  
  public void setFillColor(Color c) {
   fillColor = c;
  }
  
  public void setLocation(int x, int y) {
   location = new Point(x, y);
  }
  
  public void setLocation(Point p) {
   location = p;
  }
  
  public boolean getDraw() {
   return draw;
  }
  
  public double getSpeed() {
   return speed;
  }
  
  public void setDraw(boolean b) {
   draw = b;
  }
  
  public void setSpeed(double s) {
   speed = s;
  }
   
   //Printing format
   public String toString() {
      return "side 1 is equal to " + length + " and side 2 is equal to " + width;
   }

}