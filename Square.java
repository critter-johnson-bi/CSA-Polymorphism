import java.awt.Graphics;
import java.awt.Point;

public class Square extends Rectangle {

   Square() {
      this(1);
   }
 
   Square(double s) {
      super(s,s);
   //   super.location = new Point();
      super.setLocation(50, 50);
      
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
     
     g.drawLine(ul, ur, ul + side, ur);
     g.drawLine(ul, ur, ul, ur + side);
     g.drawLine(ul+side, ur+side, ul, ur+side);
     g.drawLine(ul+side, ur+side, ul + side, ur);
     
   }
      
   public String toString() {
      return String.format("%s: side: %.2f, area: %2f, perimeter: %.2f", 
                              super.getType(), super.getLength(), area(), perimeter());
    
   }
 
}