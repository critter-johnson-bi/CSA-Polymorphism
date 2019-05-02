/*
   Author: Jack Eastman
   Date: 5/2/19
   Purpose: isoceles triangle class
*/

public class IsocelesTriangle extends Triangle
{

   //FIELDS
   public static final TYPE = "Isoceles Triangle";
   
   //CONSTRUCTORS
   
   public IsocelesTriangle()
   {
      super(1, 1, 2);
   }
   
   public IsocelesTriangle(double twoSides, double otherside)
   {
      super(twoSides, twoSides, otherSide);
   }
   
   //METHODS
   public double area()
   {
      double height = Math.sqrt(getA() * getA() - getC() * getC());
      return 0.5 * getC() * height;
   }

}