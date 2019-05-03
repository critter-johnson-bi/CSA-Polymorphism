/*
   Author: Jack Eastman
   Date: 5/2/19
   Purpose: isoceles triangle class
*/

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public class IsocelesTriangle extends Triangle
{
   public IsocelesTriangle()
   {
      super(1, 1, 2);
      setType("Triangle");
   }
   
   public IsocelesTriangle(double twoSides, double otherSide)
   {
      super(twoSides, twoSides, otherSide);
   }
   
   //METHODS
   public double getArea()
   {
      double height = Math.sqrt(getA() * getA() - getC() * getC());
      return 0.5 * getC() * height;
   }
   
   public void drawMe(Graphics g)
   {
      
   }

}