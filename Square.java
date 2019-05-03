import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;


public class Square extends Rectangle {

   Square() {
      this(1);
   }
 
   Square(double s, Point p, Color line, Color fill) {
      super (s,s);
      setLocation(p);
      setLineColor(line);
      setFillColor(fill);
      setType("Square");
   }
   
   Square(double s) {
      this(s, new Point(50, 50), Color.BLUE, Color.GREEN);      
   }
 
   public double getSide() {
      return super.getLength();
   }
   
   public void setSide(double s) {
      super.setLength(s);
      super.setWidth(s);
   }
   
   public double perimeter() {
      return 4 * super.getLength();
   }
   
   public void slide (double x, double y) {
     Point oldPoint = getLocation();
     double oldX = oldPoint.getX();
     double oldY = oldPoint.getY();
     double newX = oldX + x;
     double newY = oldY + y;
     
     Point newLocation = new Point((int)newX, (int)newY);
     setLocation(newLocation);
   }
   
   public boolean contains(Point p) {      // THIS METHOD BELONGS IN RECTANGLE
     double px = p.getX();
     double py = p.getY();
 
     Point location = super.getLocation();
     double startX = location.getX();
     double startY = location.getY();
     double endX = startX + super.getWidth();
     double endY = startY + super.getLength();
     
     return px >= startX && px <= endX && py >= startY && py <= endY;    
   }
     
   
   public void drawMe(Graphics g) {
   
      Point topLeft = super.getLocation();
      int ul = (int) topLeft.getX();
      int ur = (int) topLeft.getY();
      int side = (int) super.getWidth();
      Color penColor = super.getLineColor();
      Color fillColor = super.getFillColor();
       
      if (penColor == null && fillColor == null) {
         g.setColor(Color.BLACK);        
         g.drawRect(ul, ur, side, side);
      }
      else {
         if (penColor != null) {
            g.setColor(penColor);
            g.drawRect(ul, ur, side, side);
         }
        if (fillColor != null) {
            g.setColor(fillColor);
            g.fillRect(ul, ur, side, side);
         }
      } 
   }
      
   public String toString() {
      return String.format("%s: side: %,.2f, area: %,.2f, perimeter: %,.2f", 
                              super.getType(), super.getLength(), getArea(), getPerimeter());
    
   }
 
}