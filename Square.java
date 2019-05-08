import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;


public class Square extends Rectangle {

   Square() {
      this(1);
   }
 
   Square(double s) {
      super (s,s);
      setType("Square");
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
   
   public String toString() {
      return String.format("%s: side: %,.2f, area: %,.2f, perimeter: %,.2f", 
                              getType(), super.getLength(), getArea(), getPerimeter());
    
   }
 
}