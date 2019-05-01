import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class Square extends Rectangle {

   Square() {
      this(1);
   }
 
   Square(double s, Point p, Color line, Color fill) {
     super (s,s);
     super.setLocation(p);
     super.setLineColor(line);
     super.setFillColor(fill);
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
   
   public void drawMe(Graphics g) {
     Point topLeft = super.getLocation();
     int ul = (int) topLeft.getX();
     int ur = (int) topLeft.getY();
     int side = (int) super.getWidth();
/*     
     g.drawLine(ul, ur, ul + side, ur);
     g.drawLine(ul, ur, ul, ur + side);
     g.drawLine(ul+side, ur+side, ul, ur+side);
     g.drawLine(ul+side, ur+side, ul + side, ur);
     */
     
     Color penColor = super.getLineColor();
     Color fillColor = super.getFillColor();
     
     if (penColor == null) penColor = Color.BLUE;
     if (fillColor == null) fillColor = Color.GREEN;
     
     if (fillColor == null) {
       g.setColor(penColor);        
       g.drawRect(ul, ur, side, side);
       }
     else {
       g.setColor(fillColor);
       g.fillRect(ul, ur, side, side);
     } 
   }
      
   public String toString() {
      return String.format("%s: side: %.2f, area: %2f, perimeter: %.2f", 
                              super.getType(), super.getLength(), area(), perimeter());
    
   }
 
}