import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class Circle extends Shape
{
   //fields
   public static final String type = "Circle";
   private double radius;

   //constructors
   public Circle() //when to write a default constructor of a subclass?
   {
      radius = 1;
   }
   
   public Circle(double r)
   {
      setRadius(r);
   }
   
   //getters
   public double getRadius() { return radius; }
   
   public double getPerimeter()
   {
      return this.getCircumference();
   }
   
   public double getCircumference() 
   {
      return 2 * Math.PI * radius;
   }
   
   public double getDiameter()
   {
      return 2 * radius;
   }
   
   public double getArea() { return Math.PI * Math.pow((radius), 2); }
   
   //setters
   public void setRadius(double r) { radius = r; }
   
   //toString method
   public String toString()
   {
      return type + "Radius: %.2f" + radius + ", Circumference: %.2f" + getCircumference() + ", with Area: %.2f" + getArea();
   }
   
   
   
}