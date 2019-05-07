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
