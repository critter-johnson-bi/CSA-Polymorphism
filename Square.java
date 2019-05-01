public class Square extends Rectangle {

public static final String type = "Square";

Square() {
  super(1, 1);
 }
 
 Square(double s) {
   super(s,s);
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
     return String.format("%s: side: %.2f, area: %2f, perimeter: %.2f", 
                              type, super.getLength(), area(), perimeter());
    
   }
 
}