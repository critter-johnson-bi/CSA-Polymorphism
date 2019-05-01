public class Square extends Rectangle {


Square() {
  super(1, 1);
 }
 
 public double getSide() {
   return super.getLength();
   }
   
   public void setSide(double s) {
     super.setLength(s);
     super.setWidth(s);
   }
   }
 
