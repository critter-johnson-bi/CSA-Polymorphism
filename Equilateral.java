/*
   Author: Jack Eastman
   Date: 5/1/19
   Purpose: Equilateral Triangle
*/

public class Equilateral extends Triangle
{
   //FIELDS
   public static final String type = "Equilateral Triangle";

   //CONSTRUCTORS
   public EquilateralTriangle()
   {
      super (1.0, 1.0, 1.0);
   }
   
   public EquilateralTriangle(double sideLength)
   {
      super(sideLength, sideLength, sideLength);
   }
   
   //METHODS
   public double area()
   { return (Math.sqrt(3) / 4.0) * getA() * getA(); }
   
}