/*
   Author: Jack Eastman
   Date: 5/1/19
   Purpose: triangle abstract class
*/

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Color;

public abstract class Triangle extends DrawableShape
{

   //FIELDS
   private double sideA;
   private double sideB;
   private double sideC;
   private static final String type = "Triangle";

   //CONSTRUCTORS
   
   public Triangle()
   {
      this(1, 1, 1);
   }
   
   public Triangle(double a, double b, double c)
   {
      this(a, b, c, new Point(1, 1), Color.BLUE, Color.GREEN);
   }
   
   public Triangle(double a, double b, double c, Point p, Color line, Color fill)
   {
      sideA = a;
      sideB = b;
      sideC = c;
      setLocation(p);
      setLineColor(line);
      setFillColor(fill);
   }
   
   //GETTERS
   public double getA()
   { return sideA; }
   
   public double getB()
   { return sideB; }
   
   public double getC()
   { return sideC; }
   
   //SETTERS
   public void setA(double a)
   { sideA = a; }
   
   public void setB(double b)
   { sideB = b; }
   
   public void setC(double c)
   { sideC = c; }
   
   public abstract double getArea();
   
   public double getPerimeter()
   { return getA() + getB() + getC(); }
   
   public String toString()
   {
      return String.format("%s: sideA = %.2f, sideB = %.2f, sideC = %.2f, Area = %.2f, Perimeter = %.2f",
                            getType(), getA(), getB(), getC(), getArea(), getPerimeter());
   }
}