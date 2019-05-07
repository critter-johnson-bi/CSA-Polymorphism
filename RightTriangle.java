/*
*  Author: Critter Johnson
*/

public class RightTriangle extends Triangle
{
   public RightTriangle(double sideA, double sideB)
   {
      super(sideA, sideB, Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2)));
      setType("Right Triangle");
   }
   
   public RightTriangle(double sideA, double sideB, double sideC)
   {
      super(sideA, sideB, sideC);
      if (Math.pow(sideC, 2) != Math.pow(sideB, 2) + Math.pow(sideC, 2))
         throw new IllegalArgumentException("Not a right triangle!");
   }

   public double getArea()
   {
      return .5 * getA() * getB();
   }
}
