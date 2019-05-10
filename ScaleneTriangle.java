/*
*  Author: Critter Johnson
*  Date: 5/6/19
*/

public class ScaleneTriangle extends Triangle
{
   public ScaleneTriangle(double a, double b, double c)
   {
      setType("Scalene Triangle");
   }

   public double getArea()
   {
      double s = (getA() + getB() + getC()) / 2;
      return Math.sqrt(s * (s - getA()) * (s - getB()) * (s - getC()));
   }
   
   public double getHeight()
   {
      return 2 * (getArea() / getB());
   }
}
