/*
*  Author: Critter Johnson
*/

public class RightTriangle extends Triangle
{
   public RightTriangle(double sideA, double sideB)
   {
      super(sideA, sideB, Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2)));
   }

   public double area()
   {
      return .5 * getA() * getB();
   }
}
