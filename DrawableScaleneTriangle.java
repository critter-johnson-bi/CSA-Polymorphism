/*
*  Author: Critter Johnosn
*  Date: 5/6/19
*/

import java.awt.Point;
import java.awt.Graphics;
import java.awt.Color;

public class DrawableScaleneTriangle extends ScaleneTriangle implements DrawableShape
{
   private Point location;
   private Color lineColor;
   private Color fillColor;
   private boolean draw;
   private double speed;
   
   public DrawableScaleneTriangle(double a, double b, double c, Color lineColor, Color fillColor)
   {
      super(a, b, c);
      this.lineColor = lineColor;
      this.fillColor = fillColor;
   }
   
   public void drawMe(Graphics g)
   {
      Point loc = getLocation();
      int x = (int) loc.getX();
      int y = (int) loc.getY();
      int[] xPoints = new int[3];
      int[] yPoints = new int[3];
      int a = (int) getA();
      int b = (int) getB();
      int c = (int) getC();
      
      // gets the height and shifts y down to the bottom left
      int h = (int) (2 * (getArea() / b));
      y += h;
      // adds the bottom left point
      xPoints[0] = x;
      yPoints[0] = y;
      
      // d is the distance between the bottom left and the highest point
      int d = (int) (Math.pow(a, 2) - Math.pow(h, 2));
      // adds the top point
      xPoints[1] = x + d;
      yPoints[1] = y - h;
      
      // adds the far right point
      xPoints[2] = x + b;
      yPoints[2] = y;
      
      g.drawPolygon(xPoints, yPoints, 3);
   }
   
   public Point getLocation()
   {
      return location;
   }
    
   public Color getLineColor()
   {
      return lineColor;
   }

   public Color getFillColor()
   {
      return fillColor;
   }
  
   public void setLineColor(Color c)
   {
      this.lineColor = c;
   }
   
   public void setFillColor(Color c)
   {
      this.fillColor = c;
   }
   
   public void setLocation(int x, int y)
   {
      this.location = new Point(x, y);
   }
   
   public void setLocation(Point p)
   {
      this.location = p;
   }
   
   public boolean getDraw()
   {
      return draw;
   }
   
   public double getSpeed()
   {
      return speed;
   }
   
   public void setDraw(boolean b)
   {
      this.draw = b;
   }
   
   public void setSpeed(double s)
   {
      this.speed = s;
   }
}
