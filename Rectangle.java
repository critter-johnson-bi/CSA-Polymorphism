import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class Rectangle extends Shape {

   private double length;
   private double width;
   
   //Constructor
   public Rectangle(double l, double w, Point p, Color line, Color fill) {
      length = l;
      width = w;
      setType("Rectangle");
   }
   
   public Rectangle(double l, double w) {
      length = l;
      width = w;
     setType("Rectangle");
   }
   
   //Accessor for length field
   public double getLength() {
      return length;
   }
   
   //Accessor for width field
   public double getWidth() {
      return width;
   }
   
   //Setter fpr length field
   public void setLength(double newL) {
      length = newL;
   }
   
   //Setter for width field
   public void setWidth(double newW) {
      width = newW;
   }
   
   public double getPerimeter() {
      return length * 2 + width * 2;
   }
   
   public double getArea() {
      return length * width;
   }
      
   //Printing format
   public String toString() {
      return "side 1 is equal to " + length + " and side 2 is equal to " + width;
   }

}