public class Circle extends Shape
{
   //fields
   public static final String type = "Circle";
   private double circumference, diameter;

   //constructors
   public Circle() //when to write a default constructor of a subclass?
   {
      circumference = 1;
      diameter = 1;
   }
   
   public Circle(double d)
   {
      diameter = d;
      circumference = Math.PI * diameter;
   }
   
   //getters
   public double getCircum()
   {
      return circumference;
   }
   
   public double getDiameter()
   {
      return diameter;
   }
   
   public double area()
   {
      return Math.PI * Math.pow((diameter / 2), 2);
   }
   
   //setters
   public void setCircum(double c) { circumference = c; diameter = circumference / Math.PI; }
   
   public void setDiameter(double d) { diameter = d; circumference = Math.PI * diameter; }
   
   //toString method
   public String toString()
   {
      return type + "Radius: %.2f" + diameter / 2 + ", Circumference: %.2f" + circumference + ", with Area: %.2f" + area();
   }
}