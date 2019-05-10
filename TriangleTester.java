/*
*  Author: Critter Johnson
*  Purpose: Testing the triangle and drawable triangle classes
*/

public class TriangleTester
{
   public static void main(String[] args)
   {
      // tests right triangles
      Triangle rt = new RightTriangle(3, 4);
      RightTriangle rt2 = new RightTriangle(5, 12);
      
      System.out.println(rt.getArea());
      System.out.println(rt2.getArea());
   }
}
